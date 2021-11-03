import java.util.*;
import org.w3c.dom.Document;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Deadwood {
  public static void main(String arg[]) {
    StartGame.get().setBoard();
    StartGame.get().promptPlayerCount();
    while (Controller.get().totalPlayers == 0) {
      System.out.print("");
    }
    StartGame.get().promptPlayerNames();
    Controller.get().callView("daysLeft");
    Controller.get().updateScoreView();
    Controller.get().buttonsStartTurn();
  }
}

class View {
  private static View userDisplay = new View();
  JLabel playerStats = new JLabel();
  JLabel dayCounter = new JLabel();

  public View() {

  }

  public void display(String action){
    switch(action){
      case "daysLeft":
        dayCounter.setText("Days left: " + Controller.get().daysLeft);
        dayCounter.setBounds(1210, 5, 200, 20);
        Controller.get().myBoard.pane.add(dayCounter, new Integer(2));
        break;
      case "playerCount":
        JFrame frame = new JFrame("Deadwood");
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel promptNumPlayers = new JLabel("How many players?");
        String[] count = {"2", "3", "4", "5", "6", "7", "8"};
        JComboBox countOptions = new JComboBox(count);
          ActionListener countListener = new ActionListener(){
            public void actionPerformed(ActionEvent e){
              String s = (String) countOptions.getSelectedItem();
              Controller.get().totalPlayers = Integer.parseInt(s);
              frame.setVisible(false);
              // Set player based on number of players
              switch("" + Controller.get().totalPlayers){
                case "2":
                case "3":
                case "4":
                  Controller.get().setPlayers(1, 0, 0);
                  break;
                case "5":
                  Controller.get().setPlayers(1, 0, 2);
                  break;
                case "6":
                  Controller.get().setPlayers(1, 0, 4);
                  break;
                case "7":
                case "8":
                  Controller.get().setPlayers(2, 0, 0);
              }

              // Set days
              if(Controller.get().totalPlayers == 2 || Controller.get().totalPlayers == 3)
                Controller.get().daysLeft = 3;
              else
                Controller.get().daysLeft = 4;
            }
          };
        countOptions.addActionListener(countListener);

        panel.add(promptNumPlayers);
        panel.add(countOptions);
        frame.add(panel);
        frame.setSize(500, 500);
        frame.setVisible(true);
        break;
      case "getName":
        JFrame nameFrame = new JFrame("Enter player " + (Controller.get().whosTurn + 1) + "'s name");
        JPanel namePanel = new JPanel();
        JTextField input = new JTextField(15);
        JButton submit = new JButton("Submit");

        submit.setBackground(Color.white);
        submit.setBounds(200, 50, 100, 30);
        submit.addMouseListener(new MouseAdapter(){
          public void mousePressed(MouseEvent e){
            if(input.getText().equals(""))
              Controller.get().turnOrder[Controller.get().whosTurn].name = "Player " + (Controller.get().whosTurn + 1);
            else
              Controller.get().turnOrder[Controller.get().whosTurn].name = input.getText();
            nameFrame.setVisible(false);
          }
        });

        namePanel.add(input);
        namePanel.add(submit);
        nameFrame.add(namePanel);
        nameFrame.setSize(500, 500);
        nameFrame.setVisible(true);
        break;
      case "startTakeRole":
        Controller.get().myBoard.buildRoleOptions(Controller.get().turnOrder[Controller.get().whosTurn].currentLocation);
        break;
      case "success":
        if (Controller.get().turnOrder[Controller.get().whosTurn].currentLocation.shotsLeft == 1)
          Controller.get().myBoard.placeShotCounter(Controller.get().turnOrder[Controller.get().whosTurn].currentLocation.shotCount1_x, Controller.get().turnOrder[Controller.get().whosTurn].currentLocation.shotCount1_y);
        else if (Controller.get().turnOrder[Controller.get().whosTurn].currentLocation.shotsLeft == 2)
          Controller.get().myBoard.placeShotCounter(Controller.get().turnOrder[Controller.get().whosTurn].currentLocation.shotCount2_x, Controller.get().turnOrder[Controller.get().whosTurn].currentLocation.shotCount2_y);
        else if (Controller.get().turnOrder[Controller.get().whosTurn].currentLocation.shotsLeft == 3)
          Controller.get().myBoard.placeShotCounter(Controller.get().turnOrder[Controller.get().whosTurn].currentLocation.shotCount3_x, Controller.get().turnOrder[Controller.get().whosTurn].currentLocation.shotCount3_y);
        break;
    }
  }

  public void upgradeError(String error){
    JOptionPane message = new JOptionPane();
    JOptionPane.showMessageDialog(null, "You don't have enough " + error + ". Try again");
  }

  public void displayPlayer(){
    playerStats.setText("<html>It's " + Controller.get().turnOrder[Controller.get().whosTurn].name + "'s turn<br>Dollars: " + Controller.get().turnOrder[Controller.get().whosTurn].dollars + "<br>Credits: " + Controller.get().turnOrder[Controller.get().whosTurn].credits + "<br>Rank: " + Controller.get().turnOrder[Controller.get().whosTurn].rank + "<br> Rehearsal Chips: " + Controller.get().turnOrder[Controller.get().whosTurn].currentRole.rehearsalCount + "</html>");
    playerStats.setBounds(1210, 10, 150, 100);
    Controller.get().myBoard.pane.add(playerStats, new Integer(2));
  }

  public void displayScore(String score){
    JOptionPane display = new JOptionPane();
    JOptionPane.showMessageDialog(null, score);
  }

  public static View get() {
    return userDisplay;
  }
}

class Controller {
  Board myBoard;
  int totalPlayers;
  Player turnOrder[];
  int daysLeft;
  int whosTurn;
  ArrayList<Location> sets;
  ArrayList<Scene> scenes;
  private static Controller gamePlay = new Controller();

  public Controller() {

  }

  public void promptAction(String action){
    if(action.equals("Move"))
      turnOrder[whosTurn].move();
    else if(action.equals("Take Role")) {
      turnOrder[whosTurn].takeRole();
      myBoard.bTakeRole.setEnabled(false);
    } else if (action.equals("Act")){
      turnOrder[whosTurn].act();
    } else if (action.equals("Rehearse")) {
      turnOrder[whosTurn].rehearse();
    } else if(action.equals("Upgrade")) {
      turnOrder[whosTurn].upgrade();
    } else if(action.equals("End Turn"))
      endTurn();
    else
      turnOrder[whosTurn].updateLocation(action);
  }

  public void setPlayers(int baseRank, int baseDollars, int baseCredits){
    turnOrder = new Player[totalPlayers];
    char[] colors = {'b', 'c', 'g', 'o', 'p', 'r', 'v', 'w', 'y'};
    for(int i = 0; i < totalPlayers; i++){
      turnOrder[i] = new Player();
      turnOrder[i].credits = baseCredits;
      turnOrder[i].rank = baseRank;
      turnOrder[i].dollars = baseDollars;
      turnOrder[i].currentLocation = GameBoard.get().board[1];
      turnOrder[i].currentRole = new Role("none", 0, false, "", 0, 0);
      turnOrder[i].color = colors[i];
      myBoard.createPlayers(turnOrder[i], i);
    }
  }

  public void callView(String action){
    View.get().display(action);
  }

  public static Controller get(){
    return gamePlay;
  }

  public void updateScoreView(){
    View.get().displayPlayer();
  }

  public void endTurn() {
    if(whosTurn < totalPlayers - 1)
      whosTurn++;
    else
      whosTurn = 0;

    Controller.get().allMoveDisabled();
    myBoard.roleOptions.setVisible(false);
    updateScoreView();
    buttonsStartTurn();
  }

  public void buttonsStartTurn() {
    allButtonsDisabled();

    // if player is working on a role
      // Enable only act, rehearse, end turn
    // else check location
    if (!turnOrder[whosTurn].currentRole.name.equals("none")) {
      myBoard.bAct.setEnabled(true);
      if(turnOrder[whosTurn].currentRole.rehearsalCount < turnOrder[whosTurn].currentLocation.todaysScene.budget)
        myBoard.bRehearse.setEnabled(true);
      myBoard.bEndTurn.setEnabled(true);
    }
    // If castingOffice
      // Enable upgrade, move, end turn
    else if (turnOrder[whosTurn].currentLocation.name.equals("office")) {
      myBoard.bUpgrade.setEnabled(true);
      myBoard.bMove.setEnabled(true);
      myBoard.bEndTurn.setEnabled(true);
    }
    // else if trailer
      // enable move, end turn
    else if (turnOrder[whosTurn].currentLocation.name.equals("trailer")) {
      myBoard.bMove.setEnabled(true);
      myBoard.bEndTurn.setEnabled(true);
    }
    // else
      // enable move, take Role, and end turn
    else {
      myBoard.bMove.setEnabled(true);
      myBoard.bEndTurn.setEnabled(true);
      if (turnOrder[whosTurn].currentLocation.shotsLeft > 0) {
        myBoard.bTakeRole.setEnabled(true);
      }
    }
  }

  public void allButtonsDisabled() {
    myBoard.bMove.setEnabled(false);
    myBoard.bAct.setEnabled(false);
    myBoard.bRehearse.setEnabled(false);
    myBoard.bTakeRole.setEnabled(false);
    myBoard.bUpgrade.setEnabled(false);
    myBoard.bEndTurn.setEnabled(false);
  }

  public void allMoveDisabled(){
    Controller.get().myBoard.trainStation.setVisible(false);
    Controller.get().myBoard.secretHideout.setVisible(false);
    Controller.get().myBoard.church.setVisible(false);
    Controller.get().myBoard.hotel.setVisible(false);
    Controller.get().myBoard.mainStreet.setVisible(false);
    Controller.get().myBoard.jail.setVisible(false);
    Controller.get().myBoard.generalStore.setVisible(false);
    Controller.get().myBoard.ranch.setVisible(false);
    Controller.get().myBoard.bank.setVisible(false);
    Controller.get().myBoard.saloon.setVisible(false);
    Controller.get().myBoard.trailer.setVisible(false);
    Controller.get().myBoard.office.setVisible(false);
  }
}

class StartGame {
  private static StartGame start = new StartGame();

  public static StartGame get(){
    return start;
  }

  // Gets player count and creates the player objects
  public void promptPlayerCount(){
    Controller.get().callView("playerCount");
  }

  public void promptPlayerNames(){
    for(Controller.get().whosTurn = 0; Controller.get().whosTurn < Controller.get().totalPlayers; Controller.get().whosTurn++){
      Controller.get().callView("getName");
      while(Controller.get().turnOrder[Controller.get().whosTurn].name == null){
        System.out.print("");
      }
    }
    Controller.get().whosTurn = 0;
  }

  public void setBoard(){
    Controller.get().myBoard = new Board();
    // Set locations into board
    GameBoard.get().setBoard();
  }
}

class EndGame {
  private static EndGame stop = new EndGame();

  public void calcScores(){
    String scores = "<html>";
    for (int i = 0; i < Controller.get().totalPlayers; i++) {
      Player current = Controller.get().turnOrder[i];
      current.score = current.dollars + current.credits + (5 * current.rank);
      scores += current.name + " has " + current.score + " points.<br>";
    }
    calcWinner(scores);
  }

  public void calcWinner(String scores){
    Player winner = Controller.get().turnOrder[0];
    for (int i = 1; i < Controller.get().totalPlayers; i++) {
      Player current = Controller.get().turnOrder[i];
      if (winner.score < current.score) {
        winner = current;
      }
    }
    scores = scores + "<br>Winner: " + winner.name + "</html>";
    View.get().displayScore(scores);
  }

  public static EndGame get() {
    return stop;
  }
}

class Player {
  String name;
  Role currentRole;
  Location currentLocation;
  int rank;
  int dollars;
  int credits;
  int score;
  char color;

  void move(){
    Controller.get().myBoard.roleOptions.setVisible(false);

    if(Controller.get().turnOrder[Controller.get().whosTurn].currentLocation.name.equals("Train Station")){
      Controller.get().myBoard.jail.setVisible(true);
      Controller.get().myBoard.generalStore.setVisible(true);
      Controller.get().myBoard.office.setVisible(true);
    }
    else if(Controller.get().turnOrder[Controller.get().whosTurn].currentLocation.name.equals("Secret Hideout")){
      Controller.get().myBoard.ranch.setVisible(true);
      Controller.get().myBoard.church.setVisible(true);
      Controller.get().myBoard.office.setVisible(true);
    }
    else if(Controller.get().turnOrder[Controller.get().whosTurn].currentLocation.name.equals("Church")){
      Controller.get().myBoard.secretHideout.setVisible(true);
      Controller.get().myBoard.bank.setVisible(true);
      Controller.get().myBoard.hotel.setVisible(true);
    }
    else if(Controller.get().turnOrder[Controller.get().whosTurn].currentLocation.name.equals("Hotel")){
      Controller.get().myBoard.trailer.setVisible(true);
      Controller.get().myBoard.bank.setVisible(true);
      Controller.get().myBoard.church.setVisible(true);
    }
    else if(Controller.get().turnOrder[Controller.get().whosTurn].currentLocation.name.equals("Main Street")){
      Controller.get().myBoard.jail.setVisible(true);
      Controller.get().myBoard.trailer.setVisible(true);
      Controller.get().myBoard.saloon.setVisible(true);
    }
    else if(Controller.get().turnOrder[Controller.get().whosTurn].currentLocation.name.equals("Jail")){
      Controller.get().myBoard.mainStreet.setVisible(true);
      Controller.get().myBoard.generalStore.setVisible(true);
      Controller.get().myBoard.trainStation.setVisible(true);
    }
    else if(Controller.get().turnOrder[Controller.get().whosTurn].currentLocation.name.equals("General Store")){
      Controller.get().myBoard.ranch.setVisible(true);
      Controller.get().myBoard.trainStation.setVisible(true);
      Controller.get().myBoard.jail.setVisible(true);
      Controller.get().myBoard.saloon.setVisible(true);
    }
    else if(Controller.get().turnOrder[Controller.get().whosTurn].currentLocation.name.equals("Ranch")){
      Controller.get().myBoard.office.setVisible(true);
      Controller.get().myBoard.generalStore.setVisible(true);
      Controller.get().myBoard.secretHideout.setVisible(true);
      Controller.get().myBoard.bank.setVisible(true);
    }
    else if(Controller.get().turnOrder[Controller.get().whosTurn].currentLocation.name.equals("Bank")){
      Controller.get().myBoard.saloon.setVisible(true);
      Controller.get().myBoard.church.setVisible(true);
      Controller.get().myBoard.ranch.setVisible(true);
      Controller.get().myBoard.hotel.setVisible(true);
    }
    else if(Controller.get().turnOrder[Controller.get().whosTurn].currentLocation.name.equals("Saloon")){
      Controller.get().myBoard.mainStreet.setVisible(true);
      Controller.get().myBoard.generalStore.setVisible(true);
      Controller.get().myBoard.bank.setVisible(true);
      Controller.get().myBoard.trailer.setVisible(true);
    }
    else if(Controller.get().turnOrder[Controller.get().whosTurn].currentLocation.name.equals("trailer")){
      Controller.get().myBoard.mainStreet.setVisible(true);
      Controller.get().myBoard.hotel.setVisible(true);
      Controller.get().myBoard.saloon.setVisible(true);
    }
    else if(Controller.get().turnOrder[Controller.get().whosTurn].currentLocation.name.equals("office")){
      Controller.get().myBoard.trainStation.setVisible(true);
      Controller.get().myBoard.ranch.setVisible(true);
      Controller.get().myBoard.secretHideout.setVisible(true);
    }
  }

  public void updateLocation(String newLocation) {
    Controller.get().myBoard.bTakeRole.setEnabled(true);
    Controller.get().myBoard.bMove.setEnabled(false);
    Controller.get().myBoard.bUpgrade.setEnabled(false);

    Controller.get().allMoveDisabled();

    if (newLocation.equals("Train Station")) {
       currentLocation = GameBoard.get().board[11];
       Controller.get().myBoard.playerImages.get(Controller.get().whosTurn).setLocation(5 + (10 * Controller.get().whosTurn), 405);
       Controller.get().myBoard.flipCard(Controller.get().turnOrder[Controller.get().whosTurn].currentLocation);
    }
    else if (newLocation.equals("Secret Hideout")) {
       currentLocation = GameBoard.get().board[10];
       Controller.get().myBoard.playerImages.get(Controller.get().whosTurn).setLocation(27 + (10 * Controller.get().whosTurn), 732);
       Controller.get().myBoard.flipCard(Controller.get().turnOrder[Controller.get().whosTurn].currentLocation);
    }
    else if (newLocation.equals("Church")) {
       currentLocation = GameBoard.get().board[9];
       Controller.get().myBoard.playerImages.get(Controller.get().whosTurn).setLocation(607 + (10 * Controller.get().whosTurn), 860);
       Controller.get().myBoard.flipCard(Controller.get().turnOrder[Controller.get().whosTurn].currentLocation);
    }
    else if (newLocation.equals("Hotel")) {
       currentLocation = GameBoard.get().board[8];
       Controller.get().myBoard.playerImages.get(Controller.get().whosTurn).setLocation(940 + (10 * Controller.get().whosTurn), 852);
       Controller.get().myBoard.flipCard(Controller.get().turnOrder[Controller.get().whosTurn].currentLocation);
    }
    else if(newLocation.equals("Main Street")){
      currentLocation = GameBoard.get().board[7];
      Controller.get().myBoard.playerImages.get(Controller.get().whosTurn).setLocation(887 + (10 * Controller.get().whosTurn), 155);
      Controller.get().myBoard.flipCard(Controller.get().turnOrder[Controller.get().whosTurn].currentLocation);
    }
    else if (newLocation.equals("Jail")) {
       currentLocation = GameBoard.get().board[6];
       Controller.get().myBoard.playerImages.get(Controller.get().whosTurn).setLocation(275 + (10 * Controller.get().whosTurn), 178);
       Controller.get().myBoard.flipCard(Controller.get().turnOrder[Controller.get().whosTurn].currentLocation);
    }
    else if (newLocation.equals("General Store")) {
       currentLocation = GameBoard.get().board[5];
       Controller.get().myBoard.playerImages.get(Controller.get().whosTurn).setLocation(200 + (10 * Controller.get().whosTurn), 405);
       Controller.get().myBoard.flipCard(Controller.get().turnOrder[Controller.get().whosTurn].currentLocation);
    }
    else if (newLocation.equals("Ranch")) {
       currentLocation = GameBoard.get().board[4];
       Controller.get().myBoard.playerImages.get(Controller.get().whosTurn).setLocation(250 + (10 * Controller.get().whosTurn), 500);
       Controller.get().myBoard.flipCard(Controller.get().turnOrder[Controller.get().whosTurn].currentLocation);
    }
    else if (newLocation.equals("Bank")) {
       currentLocation = GameBoard.get().board[3];
       Controller.get().myBoard.playerImages.get(Controller.get().whosTurn).setLocation(607 + (10 * Controller.get().whosTurn), 605);
       Controller.get().myBoard.flipCard(Controller.get().turnOrder[Controller.get().whosTurn].currentLocation);
    }
    else if (newLocation.equals("Saloon")) {
       currentLocation = GameBoard.get().board[2];
       Controller.get().myBoard.playerImages.get(Controller.get().whosTurn).setLocation(607 + (10 * Controller.get().whosTurn), 405);
       Controller.get().myBoard.flipCard(Controller.get().turnOrder[Controller.get().whosTurn].currentLocation);
    }
    else if (newLocation.equals("Trailer")) {
       currentLocation = GameBoard.get().board[1];
       Controller.get().myBoard.playerImages.get(Controller.get().whosTurn).setLocation(1041 + (10 * Controller.get().whosTurn), 298);
       Controller.get().myBoard.bTakeRole.setEnabled(false);
    }
    else if (newLocation.equals("Office")) {
      currentLocation = GameBoard.get().board[0];
      Controller.get().myBoard.playerImages.get(Controller.get().whosTurn).setLocation(10 + (10 * Controller.get().whosTurn), 500);
      Controller.get().myBoard.bUpgrade.setEnabled(true);
      Controller.get().myBoard.bTakeRole.setEnabled(false);
    }
    Controller.get().myBoard.bEndTurn.setEnabled(true);
  }

  public void takeRole(){
    Controller.get().allMoveDisabled();
    Controller.get().callView("startTakeRole");
  }

  public void act(){
    Controller.get().myBoard.bAct.setEnabled(false);
    Controller.get().myBoard.bRehearse.setEnabled(false);

    Dice.get().totalDice = 1;
    int result[] = Dice.get().rollDice();
    // Add modifiers
    result[0] = result[0] + Controller.get().turnOrder[Controller.get().whosTurn].currentRole.rehearsalCount;

    // Assume they fail
    boolean success = false;

    if (result[0] >= Controller.get().turnOrder[Controller.get().whosTurn].currentLocation.todaysScene.budget) {
	     success = true;
    }

    if(success){
      Controller.get().callView("success");
      int check = 0;
      // reward player
      for(int j = 0; j < 12; j++){
        if(GameBoard.get().board[j].name.equals(Controller.get().turnOrder[Controller.get().whosTurn].currentLocation.name)){
          GameBoard.get().board[j].shotsLeft = GameBoard.get().board[j].shotsLeft - 1;
          check = j;
        }
      }
      if(GameBoard.get().board[check].shotsLeft == 0){
        GameBoard.get().board[check].wrap();
      }
    }
    else
      Controller.get().callView("fail");

    // give out reward
    if(currentRole.onCard){
      if(success)
        credits = credits + 2;
    }
    else{
      if(success){
        dollars = dollars + 1;
        credits = credits + 1;
      }
      else
        dollars = dollars + 1;
    }


  }

  public void rehearse(){
    Controller.get().myBoard.bAct.setEnabled(false);
    Controller.get().myBoard.bRehearse.setEnabled(false);

    Controller.get().turnOrder[Controller.get().whosTurn].currentRole.rehearsalCount = Controller.get().turnOrder[Controller.get().whosTurn].currentRole.rehearsalCount + 1;
    return;
  }


  public void upgrade(){
      CastingOffice.get().set();
      String input;
      boolean badInput = true;

      // Display rank costs
      Controller.get().callView("playerInfo");
      Controller.get().callView("upgradeCosts");

      String[] dollarPayment = {"4 dollars", "10 dollars", "18 dollars", "28 dollars", "40 dollars"};
      JComboBox dollarOptions = new JComboBox(dollarPayment);
      String[] creditPayment = {"5 credits", "10 credits", "15 credits", "20 credits", "25 credits"};
      JComboBox creditOptions = new JComboBox(creditPayment);

      Controller.get().myBoard.pane.add(dollarOptions, new Integer(2));
      Controller.get().myBoard.pane.add(creditOptions, new Integer(2));

      dollarOptions.setBounds(1210, 340, 200, 30);
      creditOptions.setBounds(1210, 380, 200, 30);

      ActionListener upgradeListener = new ActionListener(){
        public void actionPerformed(ActionEvent e){
          int paymentAmount = 0;
          String paymentType = "";
          if (e.getSource().equals(dollarOptions)) {
            String selections = (String) dollarOptions.getSelectedItem();
            String[] selectArr = selections.split(" ");

            paymentAmount = Integer.parseInt(selectArr[0]);
            paymentType = selectArr[1];

            dollarOptions.setVisible(false);
            creditOptions.setVisible(false);

            int rankChoice = 0;
            int total = 0;

            for (int i = 2; i < 7; i++) {
              total += (i*2);
              if (total == paymentAmount) {
                rankChoice = i;
              }
            }

            CastingOffice.get().validateUpgrade(rankChoice, paymentType);

          } else if (e.getSource().equals(creditOptions)) {
            String selections = (String) creditOptions.getSelectedItem();
            String[] selectArr = selections.split(" ");

            paymentAmount = Integer.parseInt(selectArr[0]);
            paymentType = selectArr[1];

            dollarOptions.setVisible(false);
            creditOptions.setVisible(false);

            int rankChoice = (paymentAmount/5) + 1;

            CastingOffice.get().validateUpgrade(rankChoice, paymentType);

          }
        }
      };

      dollarOptions.addActionListener(upgradeListener);
      creditOptions.addActionListener(upgradeListener);
  }
}

class GameBoard {
  Location board[] = new Location[12];
  int sceneCount;
  private static GameBoard map = new GameBoard();

  public void setBoard() {
   // load Locations
   sceneCount = 10;
   board = new Location[12];
   sceneCount = 10;
   GameSets.loadSets();
   for(int i = 0; i < 12; i++){
     board[i] = GameSets.setList.get(11 - i);
   }
   GameScenes.loadScenes();
   dealScenes(0);
  }

 public void dealScenes(int day){
   // Load todays scenes
   Random r = new Random();
   int index = 0;
   for(int j = 2; j < 12; j++){
     index = r.nextInt(40 - (day*10) - j);
     GameBoard.get().board[j].todaysScene = GameScenes.sceneList.get(index);
     for(int k = 0; k < GameBoard.get().board[j].todaysScene.onCardRoles.size(); k++){
       GameBoard.get().board[j].todaysScene.onCardRoles.get(k).area_x = GameBoard.get().board[j].todaysScene.onCardRoles.get(k).area_x + GameBoard.get().board[j].area_x;
       GameBoard.get().board[j].todaysScene.onCardRoles.get(k).area_y = GameBoard.get().board[j].todaysScene.onCardRoles.get(k).area_y + GameBoard.get().board[j].area_y;
     }
     GameScenes.sceneList.remove(index);
   }
   sceneCount = 10;
 }

  public void endDay(){
    if (Controller.get().daysLeft > 1) {
      Controller.get().daysLeft = Controller.get().daysLeft - 1;
      Controller.get().callView("daysLeft");
      // Deal scenes
      if(Controller.get().totalPlayers < 4)
        GameBoard.get().dealScenes(3-Controller.get().daysLeft);
      else
        GameBoard.get().dealScenes(4-Controller.get().daysLeft);
      // Set player roles to none
      for(int j = 0; j < Controller.get().totalPlayers; j++){
        Controller.get().turnOrder[Controller.get().whosTurn].currentRole = new Role("none");
      }
      // put players back in trailers
      for(int i = 0; i < Controller.get().turnOrder.length; i++){
        Controller.get().turnOrder[i].currentLocation = GameBoard.get().board[1];
        Controller.get().myBoard.playerImages.get(i).setLocation(1041 + (10 * i), 298);
      }
      // Remove shot counters and flip scenes
      for(int a = 0; a < Controller.get().myBoard.shots.size(); a++)
        Controller.get().myBoard.pane.remove(Controller.get().myBoard.shots.get(a));
      for(int b = 0; b < Controller.get().myBoard.flippedScene.size(); b++)
        Controller.get().myBoard.pane.remove(Controller.get().myBoard.flippedScene.get(b));
      for(int c = 0; c < Controller.get().myBoard.wrappedIcons.size(); c++)
        Controller.get().myBoard.pane.remove(Controller.get().myBoard.wrappedIcons.get(c));
      Controller.get().myBoard.pane.repaint();
      Controller.get().myBoard.pane.revalidate();
    } else {
      EndGame.get().calcScores();
    }
  }

  public void replaceSet(){
    // Get random set and remove from GameSets.sceneList
  }

  public static GameBoard get(){
    return map;
  }
}

class Dice {
  //  int maxRoll;
  //  int minRoll;
  int totalDice;
  int outcomes[];
  private static Dice d = new Dice();

  public static Dice get(){
    return d;
  }

  // The class that calls this must set totalDice
  public int[] rollDice(){
    outcomes = new int[totalDice];
    for(int i = 0; i < totalDice; i++){
      Random r = new Random();
      outcomes[i] = r.nextInt(7) + 1;
    }
    return outcomes;
  }
}

class Location {
  String name;
  Scene todaysScene;
  ArrayList<String> neighborLocations = new ArrayList<String>();
  ArrayList<Role> offCardRoles = new ArrayList<Role>();
  int shotsLeft;
  int area_x;
  int area_y;
  int area_h;
  int area_w;

  int shotCount1_x;
  int shotCount1_y;
  int shotCount2_x;
  int shotCount2_y;
  int shotCount3_x;
  int shotCount3_y;

  int shotCount_h = 42;
  int shotCount_w = 42;


  public Location() {

  }

  public Location(String locName, int shots, int x, int y) {
    name = locName;
    shotsLeft = shots;
    area_x = x;
    area_y = y;
  }

  public void setShotCounters(int x1, int y1, int x2, int y2, int x3, int y3) {
    shotCount1_x = x1;
    shotCount1_y = y1;
    shotCount2_x = x2;
    shotCount2_y = y2;
    shotCount3_x = x3;
    shotCount3_y = y3;

  }

  public void wrap(){

   Controller.get().myBoard.placeWrappedMarker(area_x, area_y);
    Dice.get().totalDice = todaysScene.budget;
    int[] results = Dice.get().rollDice();
    Arrays.sort(results);

    // Stores the rankRequirement value for all on card actors
    // Off card actors are stored as the value 100
    int[] onCardActors = new int[Controller.get().totalPlayers];

    // loop through players
    for (int i = 0; i < Controller.get().totalPlayers; i++) {
	     // if player is at wrapped location, set their role to none
	     // distribute bonus
	     if (Controller.get().turnOrder[i].currentLocation.name.equals(name) && !Controller.get().turnOrder[i].currentRole.name.equals("none")) {
	     // check if role is on card (for bonus payout)
	       if (Controller.get().turnOrder[i].currentRole.onCard) {
	          onCardActors[i] = Controller.get().turnOrder[i].currentRole.rankRequirement;
	       } else {
           onCardActors[i] = 100;
           Controller.get().turnOrder[i].dollars = Controller.get().turnOrder[i].dollars + Controller.get().turnOrder[i].currentRole.rankRequirement;
           Controller.get().turnOrder[i].currentRole = new Role("none");
	       }
      }
      else
        onCardActors[i] = 100;
   }

   Arrays.sort(onCardActors);

   int onCardIndex = 0;
   for(int i = 0; i < onCardActors.length; i++) {
     if (onCardActors[i] == 100) {
       onCardIndex = i;
       break;
     }
   }

   int d = results.length;
   int c = onCardIndex;
   int diceIndex = 0;
   if (onCardIndex > 0) {
     for (int j = 0; j < (d/c); j++) {
       for (int k = 0; k < onCardIndex; k++) {
         for(int b = 0; b < Controller.get().totalPlayers; b++){
           if(onCardActors[k] == Controller.get().turnOrder[b].currentRole.rankRequirement && diceIndex < d){
            Controller.get().turnOrder[b].dollars += results[diceIndex];
            diceIndex++;
           }
         }
       }
     }

     for (int l = 0; l < (d%c); l++) {
       for(int b = 0; b < Controller.get().totalPlayers; b++){
         if(onCardActors[l] == Controller.get().turnOrder[b].currentRole.rankRequirement && diceIndex < d){
          Controller.get().turnOrder[b].dollars += results[diceIndex];
          diceIndex++;
         }
       }
     }

     for (int i = 0; i < Controller.get().totalPlayers; i++) {
        // if player is at wrapped location, set their role to none
        if (Controller.get().turnOrder[i].currentLocation.name.equals(name)){
          Controller.get().turnOrder[i].currentRole = new Role("none");
        }
      }
    }


    todaysScene = new Scene("Wrapped Scene");
    GameBoard.get().sceneCount = GameBoard.get().sceneCount - 1;
    if(GameBoard.get().sceneCount == 1){
      GameBoard.get().endDay();
    }

  }
}

class Scene extends Location {
  String name;
  int budget;
  ArrayList<Role> onCardRoles = new ArrayList<Role>();
  boolean isFaceDown;
  String description;
  String sceneFile;
  private static Scene parts = new Scene();

  public static Scene get(){
    return parts;
  }

  public Scene(){

  }

  public Scene(String sceneName) {
    name = sceneName;
  }

  public Scene(String sceneName, int sceneBudget, String sceneDescription, String filePath) {
    name = sceneName;
    budget = sceneBudget;
    isFaceDown = true;
    description = sceneDescription;
    sceneFile = filePath;
  }

  public void giveBonuses(){}


}

class CastingOffice extends Location {
  private static CastingOffice co = new CastingOffice();
  int[][] cost = new int[6][2];

  public static CastingOffice get(){
    return co;
  }

  // Must call set once before using upgrade (Probably in startGame)
  public void set(){
    cost[0][0] = 4;
    cost[0][1] = 5;
    cost[1][0] = 10;
    cost[1][1] = 10;
    cost[2][0] = 18;
    cost[2][1] = 15;
    cost[3][0] = 28;
    cost[3][1] = 20;
    cost[4][0] = 40;
    cost[4][1] = 25;
  }

  public void validateUpgrade(int desiredRank, String paymentType){
    if(paymentType.equalsIgnoreCase("dollars")){
      if(Controller.get().turnOrder[Controller.get().whosTurn].dollars >= cost[desiredRank-2][0]){
        Controller.get().turnOrder[Controller.get().whosTurn].rank = desiredRank;
        Controller.get().turnOrder[Controller.get().whosTurn].dollars = Controller.get().turnOrder[Controller.get().whosTurn].dollars - cost[desiredRank-2][0];
        Controller.get().myBoard.updatePlayerIcon(Controller.get().whosTurn, desiredRank);
        Controller.get().updateScoreView();
      }
      else{
        Controller.get().turnOrder[Controller.get().whosTurn].upgrade();
        View.get().upgradeError("dollars");
      }
    }
    else{
      if(Controller.get().turnOrder[Controller.get().whosTurn].credits >= cost[desiredRank-2][1]){
        Controller.get().turnOrder[Controller.get().whosTurn].rank = desiredRank;
        Controller.get().turnOrder[Controller.get().whosTurn].credits = Controller.get().turnOrder[Controller.get().whosTurn].credits - cost[desiredRank-2][0];
        Controller.get().updateScoreView();
      }
      else{
        Controller.get().turnOrder[Controller.get().whosTurn].upgrade();
        View.get().upgradeError("credits");
      }
    }
  }
}

class Role{
  String name;
  int rankRequirement;
  boolean onCard;
  boolean isTaken = false;
  int rehearsalCount;
  String line;

  int area_x;
  int area_y;
  int area_h;
  int area_w;

  private static Role part = new Role();

  public Role() {

  }

  public Role(String roleName) {
    name = roleName;
  }

  public Role(String roleName, int rank, boolean isOnCard, String catchphrase, int x, int y) {
    name = roleName;
    rankRequirement = rank;
    onCard = isOnCard;
    line = catchphrase;
    area_x = x;
    area_y = y;
  }

  public static Role get(){
    return part;
  }

  public void giveReward(boolean success, boolean onCard){

  }
}
