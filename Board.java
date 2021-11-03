import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.ImageIcon;
import javax.imageio.ImageIO;
import java.awt.event.*;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Board extends JFrame{
  // Change the name its not a panel
  GamePanel myGamePanel;
  NewScenes dealScenes;
  NewScenes sceneIcon;

  ActionButtons bMove;
  ActionButtons bAct;
  ActionButtons bRehearse;
  ActionButtons bTakeRole;
  ActionButtons bUpgrade;
  ActionButtons bEndTurn;

  ActionButtons trainStation;
  ActionButtons secretHideout;
  ActionButtons church;
  ActionButtons hotel;
  ActionButtons mainStreet;
  ActionButtons jail;
  ActionButtons generalStore;
  ActionButtons ranch;
  ActionButtons bank;
  ActionButtons saloon;
  ActionButtons trailer;
  ActionButtons office;

  JLayeredPane pane;
  JLabel playerIcon;
  JLabel shotCounter;
  JComboBox roleOptions = new JComboBox();

  ArrayList<JLabel> shots = new ArrayList<JLabel>();
  ArrayList<JLabel> playerImages = new ArrayList<JLabel>();
  ArrayList<NewScenes> flippedScene = new ArrayList<NewScenes>();

  public Board(){
    super("Deadwood");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    start();
  }

  public void start(){
    setSize(1500, 950);
    setVisible(true);
    pane = getLayeredPane();
    pane.setLayout(null);
    buildGUI();
  }

  private void buildButtons(){
    bMove = new ActionButtons("Move", 1210, 100);
    pane.add(bMove, new Integer(2));
    bMove.setEnabled(false);

    bAct = new ActionButtons("Act", 1210, 140);
    pane.add(bAct, new Integer(2));
    bAct.setEnabled(false);

    bRehearse = new ActionButtons("Rehearse", 1210, 180);
    pane.add(bRehearse, new Integer(2));
    bRehearse.setEnabled(false);

    bTakeRole = new ActionButtons("Take Role", 1210, 220);
    pane.add(bTakeRole, new Integer(2));
    bTakeRole.setEnabled(false);

    bUpgrade = new ActionButtons("Upgrade", 1210, 260);
    pane.add(bUpgrade, new Integer(2));
    bUpgrade.setEnabled(false);

    bEndTurn = new ActionButtons("End Turn", 1210, 300);
    pane.add(bEndTurn, new Integer(2));
    bEndTurn.setEnabled(false);

    trainStation = new ActionButtons("Train Station", 20, 190);
    trainStation.setOpaque(false);
    trainStation.setContentAreaFilled(false);
    trainStation.setVisible(false);
    trainStation.setForeground(new Color(0, 0, 0, 0));
    pane.add(trainStation, new Integer(2));

    secretHideout = new ActionButtons("Secret Hideout", 25, 850);
    secretHideout.setOpaque(false);
    secretHideout.setContentAreaFilled(false);
    secretHideout.setVisible(false);
    secretHideout.setForeground(new Color(0, 0, 0, 0));
    pane.add(secretHideout, new Integer(2));

    church = new ActionButtons("Church", 630, 862);
    church.setOpaque(false);
    church.setContentAreaFilled(false);
    church.setVisible(false);
    church.setForeground(new Color(0, 0, 0, 0));
    pane.add(church, new Integer(2));

    hotel = new ActionButtons("Hotel", 972, 865);
    hotel.setOpaque(false);
    hotel.setContentAreaFilled(false);
    hotel.setVisible(false);
    hotel.setForeground(new Color(0, 0, 0, 0));
    pane.add(hotel, new Integer(2));

    mainStreet = new ActionButtons("Main Street", 970, 150);
    mainStreet.setOpaque(false);
    mainStreet.setContentAreaFilled(false);
    mainStreet.setVisible(false);
    mainStreet.setForeground(new Color(0, 0, 0, 0));
    pane.add(mainStreet, new Integer(2));

    jail = new ActionButtons("Jail", 280, 150);
    jail.setOpaque(false);
    jail.setContentAreaFilled(false);
    jail.setVisible(false);
    jail.setForeground(new Color(0, 0, 0, 0));
    pane.add(jail, new Integer(2));

    generalStore = new ActionButtons("General Store", 375, 403);
    generalStore.setOpaque(false);
    generalStore.setContentAreaFilled(false);
    generalStore.setVisible(false);
    generalStore.setForeground(new Color(0, 0, 0, 0));
    pane.add(generalStore, new Integer(2));

    ranch = new ActionButtons("Ranch", 250, 600);
    ranch.setOpaque(false);
    ranch.setContentAreaFilled(false);
    ranch.setVisible(false);
    ranch.setForeground(new Color(0, 0, 0, 0));
    pane.add(ranch, new Integer(2));

    bank = new ActionButtons("Bank", 630, 597);
    bank.setOpaque(false);
    bank.setContentAreaFilled(false);
    bank.setVisible(false);
    bank.setForeground(new Color(0, 0, 0, 0));
    pane.add(bank, new Integer(2));

    saloon = new ActionButtons("Saloon", 635, 405);
    saloon.setOpaque(false);
    saloon.setContentAreaFilled(false);
    saloon.setVisible(false);
    saloon.setForeground(new Color(0, 0, 0, 0));
    pane.add(saloon, new Integer(2));

    trailer = new ActionButtons("Trailer", 990, 277);
    trailer.setOpaque(false);
    trailer.setContentAreaFilled(false);
    trailer.setVisible(false);
    trailer.setForeground(new Color(0, 0, 0, 0));
    pane.add(trailer, new Integer(2));

    office = new ActionButtons("Office", 20, 500);
    office.setOpaque(false);
    office.setContentAreaFilled(false);
    office.setVisible(false);
    office.setForeground(new Color(0, 0, 0, 0));
    pane.add(office, new Integer(2));
  }

  private void buildGUI(){
    myGamePanel = new GamePanel();
    pane.add(myGamePanel, new Integer(0));
    newScenes();
    buildButtons();
  }

  // Places the face down scene card at each location
  private void newScenes(){
    dealScenes = new NewScenes(21, 69, "images/CardBack.jpg");
    pane.add(dealScenes, new Integer(1));
    dealScenes = new NewScenes(27, 732, "images/CardBack.jpg");
    pane.add(dealScenes, new Integer(1));
    dealScenes = new NewScenes(623, 734, "images/CardBack.jpg");
    pane.add(dealScenes, new Integer(1));
    dealScenes = new NewScenes(969, 740, "images/CardBack.jpg");
    pane.add(dealScenes, new Integer(1));
    dealScenes = new NewScenes(969, 28, "images/CardBack.jpg");
    pane.add(dealScenes, new Integer(1));
    dealScenes = new NewScenes(281, 27, "images/CardBack.jpg");
    pane.add(dealScenes, new Integer(1));
    dealScenes = new NewScenes(370, 282, "images/CardBack.jpg");
    pane.add(dealScenes, new Integer(1));
    dealScenes = new NewScenes(252, 478, "images/CardBack.jpg");
    pane.add(dealScenes, new Integer(1));
    dealScenes = new NewScenes(623, 475, "images/CardBack.jpg");
    pane.add(dealScenes, new Integer(1));
    dealScenes = new NewScenes(632, 280, "images/CardBack.jpg");
    pane.add(dealScenes, new Integer(1));
  }

  public void flipCard(Location L){
    sceneIcon = new NewScenes(L.area_x, L.area_y, L.todaysScene.sceneFile);
    pane.add(sceneIcon, new Integer(3));
    flippedScene.add(sceneIcon);
  }

  public void createPlayers(Player P, int location){
    playerIcon = new PlayerLabel(P.color, P.rank, location);
    pane.add(playerIcon, new Integer(4));
    playerImages.add(playerIcon);
  }

  public void updatePlayerIcon(int playerIndex, int newRank){
    playerImages.get(playerIndex).setIcon(new ImageIcon("images/dice/" + Controller.get().turnOrder[playerIndex].color + newRank + ".png"));
  }

  public void placeShotCounter(int x, int y) {
    shotCounter = new JLabel();
    shotCounter.setBounds(x, y, 47, 47);
    ImageIcon icon = new ImageIcon("images/shot.png");
    shotCounter.setIcon(icon);
    pane.add(shotCounter, new Integer(5));
    shots.add(shotCounter);
  }
  
  public void placeWrappedMarker(int x, int y) {
    wrappedMarker = new JLabel("Wrapped!");
    wrappedMarker.setBounds(x, y + 90, 100, 30);
    wrappedMarker.setForeground(Color.red);
    pane.add(wrappedMarker, new Integer(5));
  }

  public void buildRoleOptions(Location playerLocation){
    ArrayList<String> roles = new ArrayList<String>();
    for(int i = 0; i < playerLocation.offCardRoles.size(); i++){
      if(Controller.get().turnOrder[Controller.get().whosTurn].rank >= playerLocation.offCardRoles.get(i).rankRequirement){
        if(!playerLocation.offCardRoles.get(i).isTaken)
          roles.add(playerLocation.offCardRoles.get(i).name);
      }
    }

    for(int j = 0; j < playerLocation.todaysScene.onCardRoles.size(); j++){
      if(Controller.get().turnOrder[Controller.get().whosTurn].rank >= playerLocation.todaysScene.onCardRoles.get(j).rankRequirement){
        if(!playerLocation.todaysScene.onCardRoles.get(j).isTaken)
          roles.add(playerLocation.todaysScene.onCardRoles.get(j).name);
      }
    }

    String[] finalRoles = roles.toArray(new String[roles.size()]);
    roleOptions = new JComboBox(finalRoles);

    ActionListener roleListener = new ActionListener(){
      public void actionPerformed(ActionEvent e){
        String selectedRole = (String) roleOptions.getSelectedItem();
        for(int k = 0; k < playerLocation.offCardRoles.size(); k++){
          if(playerLocation.offCardRoles.get(k).name.equals(selectedRole)){
            Controller.get().turnOrder[Controller.get().whosTurn].currentRole = playerLocation.offCardRoles.get(k);
            Controller.get().turnOrder[Controller.get().whosTurn].currentRole.isTaken = true;
          }
        }

        for(int l = 0; l < playerLocation.todaysScene.onCardRoles.size(); l++){
          if(playerLocation.todaysScene.onCardRoles.get(l).name.equals(selectedRole)){
            Controller.get().turnOrder[Controller.get().whosTurn].currentRole = playerLocation.todaysScene.onCardRoles.get(l);
            Controller.get().turnOrder[Controller.get().whosTurn].currentRole.isTaken = true;
          }
        }
        playerImages.get(Controller.get().whosTurn).setBounds(Controller.get().turnOrder[Controller.get().whosTurn].currentRole.area_x, Controller.get().turnOrder[Controller.get().whosTurn].currentRole.area_y, 40, 40);
        roleOptions.setVisible(false);
        bMove.setEnabled(false);
      }
    };
    roleOptions.addActionListener(roleListener);

    roleOptions.setBounds(1210, 340, 200, 30);
    pane.add(roleOptions, new Integer(6));
  }
}
