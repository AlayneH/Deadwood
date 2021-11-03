import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ActionButtons extends JButton{

  public ActionButtons(String title, int locationX, int locationY){
    setText(title);
    setBackground(Color.white);
    setBounds(locationX, locationY, 200, 30);

    addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        Controller.get().promptAction(title);
      }
    });
  }
}
