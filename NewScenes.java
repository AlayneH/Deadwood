import java.awt.*;
import javax.swing.*;
import javax.swing.ImageIcon;
import javax.imageio.ImageIO;
import java.awt.event.*;
import javax.swing.JOptionPane;

/* NewScenes
 * Displays the scenes face down in every location
 * Used during the new day
 */

public class NewScenes extends JLabel{

  public NewScenes(int locationX, int locationY, String file){
    ImageIcon card = new ImageIcon(file);
    setIcon(card);
    setBounds(locationX, locationY, 205, 115);
  }
}
