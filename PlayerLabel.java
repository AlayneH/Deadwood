import java.awt.*;
import javax.swing.*;
import javax.swing.ImageIcon;
import javax.imageio.ImageIO;
import java.awt.event.*;
import javax.swing.JOptionPane;

public class PlayerLabel extends JLabel{
  public PlayerLabel(char color, int rank, int location){
    ImageIcon icon = new ImageIcon("images/dice/" + color + rank + ".png");
    setIcon(icon);
    setBounds(10*location + 1041, 298, 40, 40);
  }
}
