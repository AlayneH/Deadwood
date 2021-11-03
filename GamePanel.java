import java.awt.*;
import javax.swing.*;
import javax.swing.ImageIcon;
import javax.imageio.ImageIO;
import java.awt.event.*;
import javax.swing.JOptionPane;

public class GamePanel extends JLabel{
  public GamePanel(){
    ImageIcon icon = new ImageIcon("images/board.jpg");
    setIcon(icon);
    setBounds(0, 0, 1200, 900);
  }
}
