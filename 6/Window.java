import static java.lang.System.nanoTime;
import static javax.swing.GroupLayout.Alignment;
import static javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable; 
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import org.nlogo.lite.InterfaceComponent;

public final class Window extends JFrame {
    public static HashMap<String, Weapon> weapons;
    public InterfaceComponent timeToKillGraph;
    public JButton compareButton;
    public JComboBox themeComboBox;
    public JComboBox weapon1ComboBox;
    public JComboBox weapon1PrimaryAttachmentComboBox;
    public JComboBox weapon1SecondaryAttachmentComboBox;
    public JComboBox weapon2ComboBox;
    public JComboBox weapon2PrimaryAttachmentComboBox;
    public JComboBox weapon2SecondaryAttachmentComboBox;
    public JLabel instructionsLabel;
    public JLabel themeLabel;
    public JLabel notesLabel;
    public JLabel weapon1Image;
    public JLabel weapon2Image;
    public JLabel vsLabel;
    public JSeparator separator1;
    public JSeparator separator2;
    public JSeparator separator3;
    public JTable table; 
	
    public Window() {
	weapons = new HashMap<String, Weapon>(63, 1); //62 weapons but 63 slots, to avoid rehashing with loading factor 1.
	weapons.put(".44 Magnum", new Weapon(".44 Magnum", 60, 30, 12, 50, 160, 460, 15, 2, 0.2, 0.2, 1, 4, 0.3, 0.3, 0.3, 0.3, 0.3, 0.3, 1, 1, 1, 2, 1, 1, 0.3, 15, false, null, null, null, null, -1, -1, null));
	weapons.put("93R", new Weapon("93R", 20, 12.5, 8, 40, 900, 380, 7, 0.5, 0.2, 0.2, 1.5, 30, 0.8, 0.8, 0.8, 0.8, 0.8, 0.8, 1.5, 1, 1, 2, 1.5, 1.5, 0.2, 15, false, null, null, null, null, -1, -1, null));
	weapons.put("A-91", new Weapon("A-91", 25, 14.3, 8, 50, 800, 420, 7, 0.2, 0.5, 0.5, 3, 18, 0.4, 0.4, 0.4, 0.8, 0.8, 0.8, 1.5, 1, 1, 2, 1.5, 1.5, 0.1, 15, false, null, new double[] {0.75, 1.33}, new double[] {1, 0.8, 1.25}, new double[] {75, 560, 1.15, 0.25, 1.33}, 0.5, -1, new double[] {4, 35, 280, 0.9, 0.75, 1.67})); //Apparently, there's data for the A-91 bipod, despite being unavailable for use in-game.
	weapons.put("ACW-R", new Weapon("ACW-R", 20, 16.7, 8, 50, 850, 500, 7, 0.2, 0.1, 0.3, 2.5, 18, 0.3, 0.3, 0.3, 0.9, 0.9, 1, 2.25, 2, 1.5, 2.75, 2.5, 1.75, 0.1, 15, false, new double[] {0.25, 0.67, 0.5, 0.5}, new double[] {0.75, 1.23}, new double[] {1, 0.67, 1.34}, new double[] {75, 650, 1.18, 0.35, 1.3}, 0.5, -1, new double[] {4, 35, 300, 0.85, 0.75, 1.34}));
	weapons.put("AEK-971", new Weapon("AEK-971", 25, 18.4, 8, 50, 900, 580, 7, 0.2, 0.5, 0.3, 3, 18, 0.3, 0.3, 0.3, 1, 1, 1, 2.5, 2, 1.5, 3, 2.5, 2, 0.1, 15, false, new double[] {0.25, 0.5, 0.25, 0.134}, new double[] {0.75, 1.2}, new double[] {1, 0.75, 1.34}, new double[] {65, -1, 1.15, 0.25, 1.2}, 0.5, -1, new double[] {4, 35, 320, 0.9, 0.75, 1.4}));
	weapons.put("AK-74M", new Weapon("AK-74M", 25, 18.4, 8, 50, 650, 600, 7, 0.28, 0.2, 0.3, 1.5, 18, 0.2, 0.2, 0.2, 1, 1, 1, 2.5, 2, 1.5, 3, 2.5, 2, 0.1, 15, false, new double[] {0.25, 0.5, 0.25, 0.123}, new double[] {0.82, 1.2}, new double[] {1, 0.66, 1.5}, new double[] {65, -1, 1.07, 0.25, 1.2}, 0.5, -1, new double[] {4, 35, 330, 0.9, 0.75, 1.4}));
	weapons.put("AKS-74U", new Weapon("AKS-74U", 25, 14.3, 8, 50, 650, 440, 7, 0.28, 0.2, 0.3, 1.5, 18, 0.4, 0.4, 0.4, 0.8, 0.8, 0.8, 2, 1.5, 1, 2.5, 2, 1.5, 0.1, 15, false, null, new double[] {0.82, 1.25}, new double[] {1, 0.67, 1.25}, new double[] {75, 590, 1.07, 0.25, 1.25}, 0.5, -1, new double[] {4, 35, 290, 0.9, 0.75, 1.5}));
	weapons.put("AN-94", new Weapon("AN-94", 25, 18.4, 8, 50, 600, 600, 7, 0.3, 0.2, 0.3, 1.5, 18, 0.2, 0.2, 0.2, 1, 1, 1, 2.5, 2, 1.5, 3, 2.5, 2, 0.1, 15, false, new double[] {0.25, 0.5, 0.25, 0.134}, new double[] {0.83, 1.2}, new double[] {1, 0.66, 1.5}, new double[] {65, -1, 1.1, 0.25, 1.2}, 0.5, -1, new double[] {4, 35, 330, 0.9, 0.75, 1.4}));
	weapons.put("AS Val", new Weapon("AS Val", 20, 18.4, 6, 40, 900, 333, 7, 0.4, 0.2, 0.3, 0.5, 18, 0, 0, 0, 1.5, 1.5, 1.5, 2.5, 2, 1.5, 3, 2.5, 2, 0.1, 15, false, null, null, null, null, -1, 0.5, null));
	weapons.put("AUG A3", new Weapon("AUG A3", 25, 18.4, 8, 50, 700, 670, 7, 0.2, 0.3, 0.4, 2.6, 18, 0.2, 0.2, 0.2, 1, 1, 1, 2, 1.5, 1, 2.5, 2, 1.5, 0.1, 15, false, new double[] {0.25, 0.5, 0.25, 0.123}, new double[] {0.75, 1.25}, new double[] {1, 0.75, 1.5}, new double[] {65, -1, 1.15, 0.25, 1.3}, 0.5, -1, new double[] {4, 35, 340, 0.9, 0.75, 1.5}));
	weapons.put("F2000", new Weapon("F2000", 25, 18.4, 8, 50, 850, 600, 7, 0.26, 0.5, 0.4, 3, 18, 0.4, 0.4, 0.4, 0.7, 0.7, 0.7, 2, 1.5, 1, 2.5, 2, 1.5, 0.1, 15, false, new double[] {0.2, 0.5, 0.25, 0.15}, new double[] {0.8, 1.25}, new double[] {1, 0.75, 1.25}, new double[] {65, -1, 1.15, 0.25, 1.25}, 0.5, -1, new double[] {4, 35, 380, 0.9, 0.75, 1.5}));
	weapons.put("FAMAS", new Weapon("FAMAS", 25, 18.4, 8, 50, 1000, 630, 7, 0.35, 0.35, 0.55, 2.6, 18, 0.4, 0.4, 0.4, 1, 1, 1, 2.5, 2, 1.5, 3, 2.5, 2, 0.1, 15, false, new double[] {0.2, 0.35, 0.25, 0.15}, new double[] {0.84, 1.2}, new double[] {1, 0.71, 1.25}, new double[] {65, -1, 1.09, 0.25, 1.3}, 0.5, -1, new double[] {4, 35, 380, 0.9, 0.75, 1.4}));
	weapons.put("G17C", new Weapon("G17C", 25, 13.75, 12, 50, 400, 375, 7, 0.7, 0.1, 0.1, 1, 20, 0.5, 0.5, 0.5, 0.5, 0.5, 0.5, 1, 1, 1, 1.5, 1.5, 1.5, 0.2, 15, false, null, null, null, null, -1, 0.67, new double[] {6, 40, -1, 0.9, 0.75, 1.5}));
	weapons.put("G18", new Weapon("G18", 20, 12.5, 8, 40, 900, 375, 7, 0.7, 0.4, 0.4, 2.4, 30, 0.8, 0.8, 0.8, 0.8, 0.8, 0.8, 1.5, 1, 1, 2, 1.5, 1.5, 0.5, 15, false, null, null, null, null, -1, -1, new double[] {6, 30, -1, 0.9, 0.75, 1.5}));
	weapons.put("G36C", new Weapon("G36C", 25, 14.3, 8, 50, 750, 500, 7, 0.28, 0.3, 0.3, 1.8, 18, 0.4, 0.4, 0.4, 0.8, 0.8, 0.8, 2, 1.5, 1, 2.5, 2, 1.5, 0.1, 15, false, new double[] {0.25, 0.5, 0.25, 0.15}, new double[] {0.83, 1.25}, new double[] {1, 0.67, 1.25}, new double[] {75, 600, 1.1, 0.25, 1.25}, 0.5, -1, new double[] {4, 35, 320, 0.9, 0.75, 1.5}));
	weapons.put("G3A3", new Weapon("G3A3", 34, 22, 8, 60, 550, 500, 10, 0.45, 0.2, 0.2, 1.4, 15, 0.1, 0.1, 0.1, 1.5, 1.5, 1.5, 3.5, 3, 2.5, 4, 3.5, 3, 0.12, 15, false, new double[] {0.15, 0.5, 0.25, 0.094}, new double[] {0.725, 1.143}, new double[] {1, 0.5, 2}, new double[] {90, 650, 1.067, 0.25, 1.143}, 0.5, -1, new double[] {4, 35, 300, 0.9, 0.75, 1.285}));
	weapons.put("G53", new Weapon("G53", 25, 14.3, 8, 50, 750, 450, 7, 0.24, 0.2, 0.35, 2.5, 18, 0.4, 0.4, 0.4, 0.8, 0.8, 0.8, 2, 1.5, 1, 2.5, 2, 1.5, 0.1, 15, false, null, new double[] {0.82, 1.25}, new double[] {1, 0.67, 1.25}, new double[] {75, 600, 1.107, 0.25, 1.25}, 0.5, -1, new double[] {4, 35, 320, 0.9, 0.75, 1.5}));
	weapons.put("JNG-90", new Weapon("JNG-90", 80, 59, 15, 100, 46.2, 560, 35, 2, 0, 0, 1.5, 15, 0, 0, 0, 1.5, 1, 1, 5, 4, 3, 6, 5, 4, 1.2, 15, true, new double[] {0.25, 1, 0.25, 0.085}, null, null, null, 0.5, -1, new double[] {-1, -1, 310, 0.9, 1, 1.2})); //Strangely, the JNG-90, a bolt-action sniper rifle, has a first shot multiplier of 1.5x. Every other single-shot weapon has a FSM of 1x. In addition, the suppressor does not seem to have an effect on damage drop-off ranges of sniper rifles.
	weapons.put("KH2002", new Weapon("KH2002", 25, 18.4, 8, 50, 800, 650, 7, 0.2, 0.4, 0.4, 1.5, 18, 0.2, 0.2, 0.2, 1, 1, 1, 2, 1.5, 1, 2.5, 2, 1.5, 0.1, 15, false, new double[] {0.25, 0.5, 0.25, 0.134}, new double[] {0.75, 1.25}, new double[] {1, 0.75, 1.5}, new double[] {65, -1, 1.1, 0.25, 1.25}, 0.5, -1, new double[] {4, 35, 380, 0.9, 0.75, 1.5}));
	weapons.put("L85A2", new Weapon("L85A2", 25, 18.4, 8, 50, 650, 600, 7, 0.2, 0.28, 0.28, 2.5, 18, 0.2, 0.2, 0.2, 0.7, 0.7, 0.7, 2, 1.5, 1, 2.5, 2, 1.5, 0.1, 15, false, new double[] {0.25, 0.5, 0.25, 0.138}, new double[] {0.75, 1.25}, new double[] {1, 0.67, 1.5}, new double[] {65, -1, 1.15, 0.25, 1.25}, 0.5, -1, new double[] {4, 35, 380, 0.9, 0.75, 1.5}));
	weapons.put("L86A2", new Weapon("L86A2", 25, 18.4, 8, 50, 750, 640, 7, 0.32, 0.15, 0.25, 2, 13, 0.4, 0.4, 0.2, 1.5, 1, 1, 3, 3, 2.5, 4, 4, 3.5, 0.1, 15, false, new double[] {0.2, 0.67, 0.25, 0.042}, new double[] {0.85, 1.15}, new double[] {0.9, 0.67, 1.25}, new double[] {65, -1, 1.1, 0.45, 1.17}, 0.5, -1, new double[] {4, 35, 340, 0.9, 0.75, 1.34}));
	weapons.put("L96", new Weapon("L96", 80, 59, 15, 100, 43.5, 540, 35, 2, 0, 0, 1, 15, 0, 0, 0, 1.5, 1, 1, 5, 4, 3, 6, 5, 4, 1.2, 15, true, new double[] {0.2, 1, 0.3, 0.085}, null, null, null, 0.5, -1, new double[] {-1, -1, 310, 1, 1}));
	weapons.put("LSAT", new Weapon("LSAT", 25, 18.4, 8, 50, 650, 620, 7, 0.4, 0.35, 0.35, 2.1, 15, 0.5, 0.4, 0.2, 1.5, 1.25, 1.25, 4, 3.25, 2.5, 5, 4.5, 3.5, 0.1, 15, false, new double[] {0.15, 0.5, 0.2, 0.03}, new double[] {0.88, 1.12}, new double[] {0.9, 0.67, 1.2}, null, 0.5, -1, new double[] {4, 35, 330, 0.9, 0.75, 1.24}));
	weapons.put("M16A3", new Weapon("M16A3", 25, 18.4, 8, 50, 800, 650, 7, 0.26, 0.1, 0.4, 2.5, 18, 0.2, 0.2, 0.2, 1, 1, 1, 2.5, 2, 1.5, 3, 2.5, 2, 0.1, 15, false, new double[] {0.25, 0.5, 0.25, 0.123}, new double[] {0.8, 1.2}, new double[] {1, 0.75, 1.5}, new double[] {65, -1, 1.15, 0.25, 1.2}, 0.5, -1, new double[] {4, 35, 380, 0.9, 0.75, 1.4}));
	weapons.put("M16A4", new Weapon("M16A4", 25, 18.4, 8, 50, 800, 650, 7, 0.26, 0.075, 0.3, 2.5, 18, 0.1, 0.1, 0.1, 0.5, 0.5, 0.5, 2.5, 2, 1.5, 3, 2.5, 2, 0.1, 15, false, new double[] {0.25, 0.5, 0.25, 0.123}, new double[] {0.8, 1.2}, new double[] {1, 0.75, 1.5}, new double[] {65, -1, 1.15, 0.25, 1.2}, 0.5, -1, new double[] {4, 35, 380, 0.9, 0.75, 1.4})); //I presumed that the multipliers of the M16A4 foregrip should be different than those of the M16A3 foregrip, since the M16A4 has less horizontal recoil. Symthic says that they are the same.
	weapons.put("M1911", new Weapon("M1911", 34, 14.3, 12, 50, 333, 300, 7, 0.7, 0.1, 0.1, 1, 20, 0.5, 0.5, 0.5, 0.5, 0.5, 0.5, 1, 1, 1, 1.5, 1.5, 1.5, 0.2, 15, false, null, null, null, null, -1, -1, new double[] {6, 40, -1, 0.9, 0.75, 1.5}));
	weapons.put("M240B", new Weapon("M240B", 34, 22, 8, 60, 650, 610, 10, 0.7, 0.5, 0.5, 1.7, 12, 0.5, 0.4, 0.2, 1.5, 1.5, 1.5, 5, 4, 3, 6, 5, 4, 0.12, 15, false, new double[] {0.1, 0.25, 0.08, 0.014}, new double[] {0.71, 1}, new double[] {0.75, 0.8, 1.2}, null, 0.5, -1, new double[] {4, 35, 330, 0.9, 0.75, 1}));
	weapons.put("M249", new Weapon("M249", 25, 18.4, 8, 50, 800, 620, 7, 0.4, 0.4, 0.4, 2.2, 12, 0.5, 0.4, 0.2, 1.5, 1, 1, 5, 4, 3, 6, 5, 4, 0.1, 15, false, new double[] {0.1, 0.4, 0.16, 0.03}, new double[] {0.875, 11}, new double[] {11, 0.75, 1.2}, null, 0.5, -1, new double[] {4, 35, 330, 0.9, 0.75, 1}));
	weapons.put("M27 IAR", new Weapon("M27 IAR", 25, 18.4, 8, 50, 750, 650, 7, 0.35, 0.1, 0.3, 2.2, 13, 0.4, 0.4, 0.2, 1.5, 1, 1, 3.5, 3, 2.5, 4.5, 4, 3.5, 0.1, 15, false, new double[] {0.2, 0.35, 0.25, 0.042}, new double[] {0.85, 1.143}, new double[] {1, 0.67, 1.25}, new double[] {65, -1, 1.085, 0.5, 1.143}, 0.57, -1, new double[] {4, 35, 340, 0.9, 0.75, 1.143})); //The M27 IAR laser sight is not as effective as laser sights for other weapons are: 0.57x, compared to 0.5x.
	weapons.put("M39 EMR", new Weapon("M39 EMR", 50, 37.5, 15, 75, 300, 570, 20, 1.2, 0.2, 0.2, 1, 6, 0.0167, 0.0167, 0.0167, 1.5, 1, 1, 3.5, 3, 2.5, 4.5, 4, 3.5, 0.8, 15, true, new double[] {0.2, 1, 1, 1}, null, new double[] {0.67, 0.5, 2}, null, 0.5, -1, new double[] {6, 35, 320, 0.9, 0.75, 1.285})); //Symthic reports a recoil up multiplier of 0.20000000298 for the M39 EMR bipod.
	weapons.put("M4", new Weapon("M4", 25, 14.3, 8, 50, 800, 580, 7, 0.26, 0.075, 0.2, 2.8, 18, 0.2, 0.2, 0.2, 0.4, 0.4, 0.4, 2, 1.5, 1, 2.5, 2, 1.5, 0.1, 15, false, new double[] {0.25, 0.67, 0.5, 0.5}, new double[] {0.8, 1.2}, new double[] {1, 0.75, 1.25}, new double[] {65, 650, 1.15, 0.25, 1.25}, 0.5, -1, new double[] {4, 35, 330, 0.9, 0.75, 1.5})); //The M4 equipped with a suppressor has a 10 m/s muzzle velocity advantage over the M4A1 equipped with a suppressor, despite the two being virtually the same weapon.
	weapons.put("M40A5", new Weapon("M40A5", 80, 59.5, 15, 100, 54.5, 490, 35, 2, 0, 0, 1, 15, 0, 0, 0, 1, 1, 1, 4, 3.5, 3, 5, 4.5, 4, 1.2, 15, true, new double[] {0.2, 1, 0.3, 0.085}, null, null, null, 0.5, -1, new double[] {-1, -1, 310, 0.9, 1, 1}));
	weapons.put("M416", new Weapon("M416", 25, 18.4, 8, 50, 750, 600, 7, 0.26, 0.1, 0.3, 2, 18, 0.2, 0.2, 0.2, 1, 1, 1, 2.5, 2, 1.5, 3, 2.5, 2, 0.1, 15, false, new double[] {0.25, 0.4, 0.25, 0.123}, new double[] {0.82, 1.2}, new double[] {1, 0.6, 1.5}, new double[] {65, -1, 1.107, 0.25, 1.2}, 0.5, -1, new double[] {4, 35, 330, 0.9, 0.75, 1.4}));
	weapons.put("M417", new Weapon("M417", 50, 37.5, 15, 75, 295, 450, 20, 1.15, -0.05, 0.25, 1, 10, 0.05, 0.05, 0.05, 1.5, 1, 1, 3, 3, 2.5, 4.5, 4, 3.5, 0.55, 15, true, new double[] {0.2, 1, 1, 1}, null, new double[] {0.85, 0.8, 2}, null, 0.5, -1, new double[] {6, 35, 290, 0.95, 0.75, 1.34}));
	weapons.put("M4A1", new Weapon("M4A1", 25, 14.3, 8, 50, 800, 580, 7, 0.26, 0.1, 0.4, 2.8, 18, 0.4, 0.4, 0.4, 0.8, 0.8, 0.8, 2, 1.5, 1, 2.5, 2, 1.5, 0.1, 15, false, new double[] {0.25, 0.67, 0.5, 0.5}, new double[] {0.8, 1.2}, new double[] {1, 0.75, 1.25}, new double[] {65, 650, 1.15, 0.25, 1.25}, 0.5, -1, new double[] {4, 35, 320, 0.9, 0.75, 1.5}));
	weapons.put("M5K", new Weapon("M5K", 25, 13.75, 12, 50, 900, 380, 7, 0.25, 0.48, 0.48, 1.55, 30, 0.6, 0.6, 0.6, 0.6, 0.6, 0.6, 1.2, 1.2, 1.2, 1.7, 1.5, 1.5, 0.1, 1.5, false, null, null, null, null, -1, 0.5, new double[] {6, 40, 300, 0.88, 0.8, 1.25})); //The flash suppressor is compatible with the M5K but Symthic reports no data on the attachment.
	weapons.put("M60E4", new Weapon("M60E4", 34, 22, 8, 60, 580, 560, 10, 0.6, 0.2, 0.2, 1.5, 12, 0.5, 0.4, 0.2, 1.5, 1.5, 1.5, 5, 4, 3, 6, 5, 4, 0.12, 15, false, new double[] {0.1, 0.5, 0.08, 0.014}, new double[] {0.75, 1}, new double[] {0.85, 0.5, 1.2}, null, 0.5, -1, new double[] {4, 35, 310, 0.9, 0.75, 1}));
	weapons.put("M9", new Weapon("M9", 25, 13.75, 12, 50, 400, 380, 7, 0.7, 0.1, 0.1, 1, 20, 0.5, 0.5, 0.5, 0.5, 0.5, 0.5, 1, 1, 1, 1.5, 1.5, 1.5, 0.2, 15, false, null, null, null, null, -1, -1, new double[] {6, 40, -1, 0.9, 0.75, 1.5}));
	weapons.put("M98B", new Weapon("M98B", 95, 59, 15, 150, 46.2, 650, 35, 2, 0, 0, 1, 15, 0, 0, 0, 1.5, 1, 1, 5, 4, 3, 6, 5, 4, 1.2, 15, true, new double[] {0.2, 1, 0.3, 0.085}, null, null, null, 0.5, -1, new double[] {-1, -1, 310, 0.9, 1, 1}));
	weapons.put("MG36", new Weapon("MG36", 25, 18.4, 8, 50, 750, 550, 7, 0.4, 0.1, 0.3, 1.8, 13, 0.4, 0.4, 0.4, 1.5, 1, 1, 3.5, 3, 2.5, 4.5, 4, 3.5, 0.1, 15, false, new double[] {0.15, 0.35, 0.25, 0.042}, new double[] {0.85, 1.143}, new double[] {1, 0.67, 1.25}, new double[] {65, -1, 1.067, 0.5, 1.143}, 0.5, -1, new double[] {4, 35, 310, 0.9, 0.75, 1.143}));
	weapons.put("MK11 MOD 0", new Weapon("MK11 MOD 0", 50, 37.5, 15, 75, 260, 550, 20, 1.5, -0.1, 0.3, 1, 6, 0.0167, 0.0167, 0.0167, 1.5, 1, 1, 3.5, 3, 2.5, 4.5, 4, 3.5, 0.8, 15, true, new double[] {0.2, 1, 1, 1}, null, new double[] {0.67, 0.67, 2}, null, 0.5, -1, new double[] {6, 35, 310, 0.9, 0.75, 1.285}));
	weapons.put("MP412 REX", new Weapon("MP412 REX", 50, 28, 15, 37, 255, 370, 15, 1.2, 0.2, 0.2, 1, 10, 0.3, 0.3, 0.3, 0.3, 0.3, 0.3, 1.25, 1, 1, 1.75, 1.5, 1.5, 0.3, 15, false, null, null, null, null, -1, -1, null));
	weapons.put("MP443", new Weapon("MP443", 25, 13.75, 12, 50, 400, 320, 7, 0.7, 0.1, 0.1, 1, 20, 0.5, 0.5, 0.5, 0.5, 0.5, 0.5, 1, 1, 1, 1.5, 1.5, 1.5, 0.2, 15, false, null, null, null, null, -1, -1, new double[] {6, 40, -1, 0.9, 0.75, 1.5}));
	weapons.put("MP7", new Weapon("MP7", 20, 11.2, 12, 46, 950, 390, 7, 0.12, 0.45, 0.45, 2.2, 20, 0.5, 0.5, 0.5, 0.5, 0.5, 0.5, 1, 1, 1, 1.5, 1.25, 1.25, 0.06, 15, false, null, null, null, null, -1, 0.5, new double[] {6, 40, 270, 0.9, 0.8, 1.5})); //There's a reason why there's data on incompatible attachments (for multiplayer). It's because they are available in single player.
	weapons.put("MTAR-21", new Weapon("MTAR-21", 25, 14.3, 8, 50, 900, 570, 7, 0.3, 0.25, 0.5, 2.5, 18, 0.5, 0.5, 0.5, 0.8, 0.8, 0.8, 1.5, 1, 1, 2, 1.5, 1.5, 0.1, 15, false, null, new double[] {0.84, 1.34}, new double[] {1, 0.8, 1.2}, new double[] {75, 650, 1.1, 0.25, 1.33}, 0.5, -1, new double[] {4, 35, 320, 0.9, 0.75, 1.5}));
	weapons.put("P90", new Weapon("P90", 20, 11.2, 12, 46, 900, 420, 7, 0.18, 0.4, 0.4, 2, 20, 0.5, 0.5, 0.5, 0.5, 0.5, 0.5, 1, 1, 1, 1.5, 1.25, 1.25, 0.06, 15, false, null, new double[] {0.82, 1.25}, null, null, -1, 0.5, new double[] {6, 40, 280, 0.9, 0.8, 1.5}));
	weapons.put("PDW-R", new Weapon("PDW-R", 25, 14.3, 8, 50, 750, 430, 7, 0.2, 0.2, 0.4, 2, 18, 0.4, 0.4, 0.4, 0.6, 0.6, 0.6, 1.5, 1, 1, 2, 1.5, 1.5, 0.1, 15, false, null, null, null, null, -1, 0.5, new double[] {4, 35, 280, 0.9, 0.75, 1.67}));
	weapons.put("PKP Pecheneg", new Weapon("PKP Pecheneg", 34, 22, 8, 60, 600, 560, 10, 0.65, 0.4, 0.4, 1.5, 13, 0.5, 0.4, 0.2, 1.5, 1.5, 1.5, 5, 4, 3, 6, 5, 4, 0.12, 15, false, new double[] {0.1, 0.34, 0.08, 0.014}, new double[] {0.7, 1}, new double[] {0.77, 0.75, 1.2}, null, 0.5, -1, new double[] {4, 35, 330, 0.9, 0.75, 1})); //Symthic erroneously reports no change in muzzle velocity when the PKP Pecheneg is equipped with a suppressor.
	weapons.put("PP-19", new Weapon("PP-19", 16.7, 12.5, 12, 40, 900, 320, 7, 0.2, 0.3, 0.3, 1.5, 20, 0.5, 0.5, 0.5, 0.5, 0.5, 0.5, 1, 1, 1, 1.5, 1.25, 1.25, 0.06, 15, false, null, new double[] {0.82, 1.25}, null, null, -1, 0.5, new double[] {6, 32, 280, 0.9, 0.8, 1.5}));
	weapons.put("PP-2000", new Weapon("PP-2000", 25, 13.75, 12, 50, 650, 360, 7, 0.18, 0.3, 0.2, 2.5, 20, 0.5, 0.5, 0.5, 0.5, 0.5, 0.5, 1, 1, 1, 1.5, 1.25, 1.25, 0.06, 15, false, null, new double[] {0.82, 1.25}, null, null, -1, 0.5, new double[] {6, 40, 280, 0.9, 0.8, 1.5}));
	weapons.put("QBB-95", new Weapon("QBB-95", 25, 18.4, 8, 50, 650, 670, 7, 0.37, 0.3, 0.2, 2, 13, 0.4, 0.4, 0.2, 1, 0.7, 0.7, 3, 2.5, 2, 4, 3.5, 3, 0.1, 15, false, new double[] {0.2, 0.34, 0.25, 0.12}, new double[] {0.865, 1.143}, new double[] {1, 0.67, 1.25}, new double[] {65, -1, 1.081, 0.5, 1.168}, 0.5, -1, new double[] {4, 35, 340, 0.9, 0.75, 1.167}));
	weapons.put("QBU-88", new Weapon("QBU-88", 50, 37.5, 15, 75, 260, 550, 20, 1.5, 0.3, 0.3, 1, 6, 0.025, 0.025, 0.025, 1, 1, 1, 3, 2.5, 2, 4, 3.5, 3, 0.8, 15, true, new double[] {0.2, 1, 1, 1}, null, new double[] {0.67, 0.67, 2}, null, 0.5, -1, new double[] {6, 45, 310, 0.9, 0.75, 1.334}));
	weapons.put("QBZ-95B", new Weapon("QBZ-95B", 25, 14.3, 8, 50, 650, 490, 7, 0.2, 0.3, 0.3, 2.5, 13, 0.4, 0.4, 0.4, 0.8, 0.8, 0.8, 1.5, 1, 1, 2, 1.5, 1.5, 0.1, 15, false, null, new double[] {0.75, 1.33}, null, new double[] {75, 650, 1.15, 0.25, 1.33}, -1, 0.5, new double[] {4, 35, 330, 0.9, 0.75, 1.67}));
	weapons.put("RPK-74M", new Weapon("RPK-74M", 25, 18.4, 8, 50, 700, 600, 7, 0.3, 0.2, 0.2, 1.8, 13, 0.4, 0.2, 0.2, 1.5, 1, 1, 3.5, 3, 2.5, 4.5, 4, 3.5, 0.1, 15, false, new double[] {0.2, 0.75, 0.25, 0.042}, new double[] {0.833, 1.143}, new double[] {1, 0.5, 1.25}, new double[] {65, -1, 1.1, 0.5, 1.143}, 0.5, -1, new double[] {4, 35, 330, 0.9, 0.75, 1.143}));
	weapons.put("SCAR-H", new Weapon("SCAR-H", 30, 20, 8, 50, 600, 420, 10, 0.5, 0.2, 0.2, 1.35, 13, 0.3, 0.3, 0.3, 1.2, 1.2, 1.2, 2.5, 2, 1.5, 3, 2.5, 2, 0.12, 15, false, new double[] {0.25, 0.5, 0.25, 0.123}, new double[] {0.725, 1.2}, new double[] {1, 0.5, 1.34}, new double[] {75, 560, 1.06, 0.25, 1.2}, 0.5, -1, new double[] {4, 35, 320, 0.9, 0.75, 1.4}));
	weapons.put("SCAR-L", new Weapon("SCAR-L", 25, 18.4, 8, 50, 620, 580, 7, 0.2, 0.225, 0.225, 2.75, 18, 0.2, 0.2, 0.2, 1, 1, 1, 2.5, 2, 1.5, 3, 2.5, 2, 0.1, 15, false, new double[] {0.25, 0.67, 0.25, 0.094}, new double[] {0.75, 1.2}, new double[] {1, 0.58, 1.5}, new double[] {65, 640, 1.15, 0.25, 1.3}, 0.5, -1, new double[] {4, 35, 320, 0.9, 0.75, 1.3}));
	weapons.put("SG553", new Weapon("SG553", 25, 14.3, 8, 50, 700, 430, 7, 0.25, 0.2, 0.4, 2.2, 18, 0.4, 0.4, 0.4, 0.8, 0.8, 0.8, 2, 1.5, 1, 2.5, 2, 1.5, 0.1, 15, false, new double[] {0.25, 0.5, 0.25, 0.15}, new double[] {0.8, 1.25}, new double[] {1, 0.75, 1.25}, new double[] {75, 570, 1.12, 0.25, 1.25}, 0.5, -1, new double[] {4, 35, 320, 0.9, 0.75, 1.5}));
	weapons.put("SKS", new Weapon("SKS", 43, 27, 15, 60, 333, 440, 10, 0.55, 0.3, 0.4, 1, 15, 0.1, 0.1, 0.1, 1, 1, 1, 2.5, 2, 1.5, 3, 2.5, 2, 0.3, 15, true, new double[] {0.25, 0.5, 0.285, 0.133}, new double[] {0.85, 1.2}, new double[] {0.82, 0.75, 2}, new double[] {-1, 590, 1.1, 0.25, 1.2}, 0.5, -1, new double[] {6, 45, 380, 0.9, 0.75, 1.4}));
	weapons.put("SV-98", new Weapon("SV-98", 80, 50, 20, 80, 48, 520, 35, 2, 0, 0, 1, 15, 0, 0, 0, 1.5, 1, 1, 3.5, 3, 2.5, 4.5, 4, 3.5, 1.2, 15, true, new double[] {0.2, 1, 0.3, 0.085}, null, null, null, 0.5, -1, new double[] {-1, -1, 310, 0.9, 1, 1.143})); //All the bipods for bolt-action sniper rifles reduce ADS spread but there is no ADS spread for bolt-action sniper rifles except for when on the move. But then, the bipod will not be deployed and will not come into effect...
	weapons.put("SVD", new Weapon("SVD", 50, 37.5, 15, 75, 260, 530, 20, 1.5, -0.1, 0.3, 1, 6, 0.0167, 0.0167, 0.0167, 1.5, 1, 1, 3.5, 3, 2.5, 4.5, 4, 3.5, 0.8, 15, true, new double[] {0.2, 1, 1, 1}, null, new double[] {0.67, 0.67, 2}, null, 0.5, -1, new double[] {6, 35, 310, 0.9, 0.75, 1.285}));
	weapons.put("Type 88 LMG", new Weapon("Type 88 LMG", 25, 18.4, 8, 50, 650, 600, 7, 0.36, 0.3, 0.3, 1.5, 12, 0.5, 0.4, 0.2, 1.5, 1, 1, 5, 4, 3, 6, 5, 4, 0.1, 15, false, new double[] {0.1, 0.4, 0.16, 0.03}, new double[] {0.9, 1}, new double[] {1, 0.67, 1.2}, null, 0.5, -1, new double[] {4, 35, 380, 0.9, 0.75, 1}));
	weapons.put("UMP45", new Weapon("UMP45", 34, 12.5, 8, 40, 600, 320, 7, 0.25, 0.2, 0.2, 2.75, 20, 0.5, 0.5, 0.5, 0.5, 0.5, 0.5, 1, 1, 1, 1.5, 1.25, 1.25, 0.06, 15, false, null, new double[] {0.8, 1.25}, null, null, -1, 0.5, new double[] {4, 32, -1, 0.9, 0.8, 1.5})); //Every weapon seems to have a spread decrease of 15.
		
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setTitle("Battlefield 3 Weapon Comparison Utility");
	setResizable(false);
		
	instructionsLabel = new JLabel("<html>Up to date with the Aftermath patch (December 4, 2012). There has been no change to the weapons since.<br><b><u>How to use:</u></b> Select two weapons and optionally, a primary attachment and a secondary attachment for each weapon, and click Compare.");
		
	weapon1ComboBox = new JComboBox(new String[] {"Weapon 1", ".44 Magnum", "93R", "A-91", "ACW-R", "AEK-971", "AK-74M", "AKS-74U", "AN-94", "AS Val", "AUG A3", "F2000", "FAMAS", "G17C", "G18", "G36C", "G3A3", "G53", "JNG-90", "KH2002", "L85A2", "L86A2", "L96", "LSAT", "M16A3", "M16A4", "M1911", "M240B", "M249", "M27 IAR", "M39 EMR", "M4", "M40A5", "M416", "M417", "M4A1", "M5K", "M60E4", "M9", "M98B", "MG36", "MK11 MOD 0", "MP412 REX", "MP443", "MP7", "MTAR-21", "P90", "PDW-R", "PKP Pecheneg", "PP-19", "PP-2000", "QBB-95", "QBU-88", "QBZ-95B", "RPK-74M", "SCAR-H", "SCAR-L", "SG553", "SKS", "SV-98", "SVD", "Type 88 LMG", "UMP45"});
	weapon1ComboBox.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    if (weapon1ComboBox.getSelectedItem().equals("Weapon 1")) {
			weapon1PrimaryAttachmentComboBox.setModel(new DefaultComboBoxModel(new String[] {"None"}));
			weapon1SecondaryAttachmentComboBox.setModel(new DefaultComboBoxModel(new String[] {"None"}));
			return;
		    }
		    Weapon selectedWeapon = weapons.get((String) weapon1ComboBox.getSelectedItem());
		    ArrayList<String> availablePrimaryAttachments = new ArrayList<String>();
		    ArrayList<String> availableSecondaryAttachments = new ArrayList<String>();
		    availablePrimaryAttachments.add("None");
		    availableSecondaryAttachments.add("None");
		    if (selectedWeapon.BIPOD != null) {availablePrimaryAttachments.add("Bipod");}
		    if (selectedWeapon.FLASH_SUPPRESSOR != null) {availableSecondaryAttachments.add("Flash Suppressor");}
		    if (selectedWeapon.FOREGRIP != null) {availablePrimaryAttachments.add("Foregrip");}
		    if (selectedWeapon.HEAVY_BARREL != null) {availableSecondaryAttachments.add("Heavy Barrel");}
		    if (selectedWeapon.LASER_SIGHT != -1) {availableSecondaryAttachments.add("Laser Sight");}
		    if (selectedWeapon.LASER_SIGHT_PRIMARY != -1) {availablePrimaryAttachments.add("Laser Sight");}
		    if (selectedWeapon.SUPPRESSOR != null) {availableSecondaryAttachments.add("Suppressor");}
		    weapon1PrimaryAttachmentComboBox.setModel(new DefaultComboBoxModel(availablePrimaryAttachments.toArray(new String[] {})));
		    weapon1SecondaryAttachmentComboBox.setModel(new DefaultComboBoxModel(availableSecondaryAttachments.toArray(new String[] {})));
		    packAndCenter();
		}
	    });
	weapon1ComboBox.setToolTipText("Select a weapon.");
		
	weapon1PrimaryAttachmentComboBox = new JComboBox(new String[] {"None"});
	weapon1PrimaryAttachmentComboBox.setToolTipText("Select a primary attachment for weapon 1.");
		
	weapon1SecondaryAttachmentComboBox = new JComboBox(new String[] {"None"});
	weapon1SecondaryAttachmentComboBox.setToolTipText("Select a secondary attachment for weapon 1.");
		
	weapon2ComboBox = new JComboBox(new String[] {"Weapon 2", ".44 Magnum", "93R", "A-91", "ACW-R", "AEK-971", "AK-74M", "AKS-74U", "AN-94", "AS Val", "AUG A3", "F2000", "FAMAS", "G17C", "G18", "G36C", "G3A3", "G53", "JNG-90", "KH2002", "L85A2", "L86A2", "L96", "LSAT", "M16A3", "M16A4", "M1911", "M240B", "M249", "M27 IAR", "M39 EMR", "M4", "M40A5", "M416", "M417", "M4A1", "M5K", "M60E4", "M9", "M98B", "MG36", "MK11 MOD 0", "MP412 REX", "MP443", "MP7", "MTAR-21", "P90", "PDW-R", "PKP Pecheneg", "PP-19", "PP-2000", "QBB-95", "QBU-88", "QBZ-95B", "RPK-74M", "SCAR-H", "SCAR-L", "SG553", "SKS", "SV-98", "SVD", "Type 88 LMG", "UMP45"});
	weapon2ComboBox.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    if (weapon2ComboBox.getSelectedItem().equals("Weapon 2")) {
			weapon2PrimaryAttachmentComboBox.setModel(new DefaultComboBoxModel(new String[] {"None"}));
			weapon2SecondaryAttachmentComboBox.setModel(new DefaultComboBoxModel(new String[] {"None"}));
			return;
		    }
		    Weapon selectedWeapon = weapons.get((String) weapon2ComboBox.getSelectedItem());
		    ArrayList<String> availablePrimaryAttachments = new ArrayList<String>();
		    ArrayList<String> availableSecondaryAttachments = new ArrayList<String>();
		    availablePrimaryAttachments.add("None");
		    availableSecondaryAttachments.add("None");
		    if (selectedWeapon.BIPOD != null) {availablePrimaryAttachments.add("Bipod");}
		    if (selectedWeapon.FLASH_SUPPRESSOR != null) {availableSecondaryAttachments.add("Flash Suppressor");}
		    if (selectedWeapon.FOREGRIP != null) {availablePrimaryAttachments.add("Foregrip");}
		    if (selectedWeapon.HEAVY_BARREL != null) {availableSecondaryAttachments.add("Heavy Barrel");}
		    if (selectedWeapon.LASER_SIGHT != -1) {availableSecondaryAttachments.add("Laser Sight");}
		    if (selectedWeapon.LASER_SIGHT_PRIMARY != -1) {availablePrimaryAttachments.add("Laser Sight");}
		    if (selectedWeapon.SUPPRESSOR != null) {availableSecondaryAttachments.add("Suppressor");}
		    weapon2PrimaryAttachmentComboBox.setModel(new DefaultComboBoxModel(availablePrimaryAttachments.toArray(new String[] {})));
		    weapon2SecondaryAttachmentComboBox.setModel(new DefaultComboBoxModel(availableSecondaryAttachments.toArray(new String[] {})));
		    packAndCenter();
		}
	    });
	weapon2ComboBox.setToolTipText("Select a weapon.");
		
	weapon2PrimaryAttachmentComboBox = new JComboBox(new String[] {"None"});
	weapon2PrimaryAttachmentComboBox.setToolTipText("Select a primary attachment for weapon 2.");
		
	weapon2SecondaryAttachmentComboBox = new JComboBox(new String[] {"None"});
	weapon2SecondaryAttachmentComboBox.setToolTipText("Select a secondary attachment for weapon 2.");
		
	compareButton = new JButton("Compare");
	compareButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    long t1 = nanoTime();
		    if (((weapon1ComboBox.getSelectedItem()).equals("Weapon 1")) || ((weapon2ComboBox.getSelectedItem()).equals("Weapon 2"))) {return;}
		    Weapon weapon1 = weapons.get((String) weapon1ComboBox.getSelectedItem()), weapon2 = weapons.get((String) weapon2ComboBox.getSelectedItem());
		    weapon1Image.setIcon(null);
		    weapon2Image.setIcon(null);
		    packAndCenter();
		    try {weapon1Image.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/images/weapons/" + (weapon1.NAME).replace('.', '\u0000') + ".png")).getScaledInstance((int) ((double) (getWidth() - 32) / 2), -1, Image.SCALE_SMOOTH)));}
		    catch (Exception e2) {showErrorMessage(e2);}
		    weapon1Image.setText("<html><center>" + weapon1.NAME + "</center><b>Primary Attachment:</b> " + weapon1PrimaryAttachmentComboBox.getSelectedItem() + "<br><b>Secondary Attachment:</b> " + weapon1SecondaryAttachmentComboBox.getSelectedItem());
		    try {weapon2Image.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/images/weapons/" + (weapon2.NAME).replace('.', '\u0000') + ".png")).getScaledInstance((int) ((double) (getWidth() - 32) / 2), -1, Image.SCALE_SMOOTH)));}
		    catch (Exception e2) {showErrorMessage(e2);}
		    weapon2Image.setText("<html><center>" + weapon2.NAME + "</center><b>Primary Attachment:</b> " + weapon2PrimaryAttachmentComboBox.getSelectedItem() + "<br><b>Secondary Attachment:</b> " + weapon2SecondaryAttachmentComboBox.getSelectedItem());
		    try {
			timeToKillGraph.commandLater("clear-all");
			timeToKillGraph.commandLater("set _color red");
			timeToKillGraph.commandLater("graph \"" + weapon1.NAME + "\" " + weapon1.MAX_DAMAGE + " " + weapon1.MIN_DAMAGE + " " + weapon1.DAMAGE_DO_START + " " + weapon1.DAMAGE_DO_END + " " + weapon1.RATE_OF_FIRE + " " + weapon1.MUZZLE_VELOCITY);
			timeToKillGraph.commandLater("set _color blue");
			timeToKillGraph.commandLater("graph \"" + weapon2.NAME + "\" " + weapon2.MAX_DAMAGE + " " + weapon2.MIN_DAMAGE + " " + weapon2.DAMAGE_DO_START + " " + weapon2.DAMAGE_DO_END + " " + weapon2.RATE_OF_FIRE + " " + weapon2.MUZZLE_VELOCITY);
		    }
		    catch (Exception e2) {showErrorMessage(e2);}
		    packAndCenter();
		    System.out.println(getWidth());
		    long t2 = nanoTime();
		    System.out.println("Compare time: " + (t2 - t1) + " ns / " + ((double) (t2 - t1) / 1000000) + " ms / " + ((double) (t2 - t1) / 1000000000) + " s");
		}
	    });
		
	notesLabel = new JLabel("<html><b><u>Notes:</u></b><br>The laser sight in the primary attachment slot is only available for the G17C, personal defense weapons (PDWs), and the QBZ-95B.<br>You will still need to select the laser sight for the G17C.");
		
	separator1 = new JSeparator();
		
	weapon1Image = new JLabel("<html><center></center><b>Primary Attachment:</b> <br><b>Secondary Attachment:</b> ");
	weapon1Image.setHorizontalTextPosition(SwingConstants.CENTER);
	weapon1Image.setVerticalTextPosition(SwingConstants.BOTTOM);
		
	vsLabel = new JLabel("vs.");
	vsLabel.setPreferredSize(weapon1Image.getSize());
		
	weapon2Image = new JLabel("<html><center></center><b>Primary Attachment:</b> <br><b>Secondary Attachment:</b> ");
	weapon2Image.setHorizontalTextPosition(SwingConstants.CENTER);
	weapon2Image.setVerticalTextPosition(SwingConstants.BOTTOM);
		
		
		
	timeToKillGraph = new InterfaceComponent(this);
	try {timeToKillGraph.open("TimeToKillGraph.nlogo");}
	catch (Exception e) {showErrorMessage(e);}
		
	separator2 = new JSeparator();
		
	themeLabel = new JLabel("Theme:");
		
	UIManager.LookAndFeelInfo[] installedLookAndFeels = UIManager.getInstalledLookAndFeels();
	HashMap<String, String> _lookAndFeels = new HashMap<String, String>();
	String[] installedLookAndFeelsNames = new String[installedLookAndFeels.length];
	for (int i = 0; i < installedLookAndFeels.length; i++) {
	    _lookAndFeels.put(installedLookAndFeels[i].getName(), installedLookAndFeels[i].getClassName());
	    installedLookAndFeelsNames[i] = installedLookAndFeels[i].getName();
	}
	final HashMap<String, String> lookAndFeels = _lookAndFeels;
	themeComboBox = new JComboBox(installedLookAndFeelsNames);
	themeComboBox.setSelectedItem(UIManager.getLookAndFeel().getName());
	themeComboBox.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    try {UIManager.setLookAndFeel(lookAndFeels.get((String) themeComboBox.getSelectedItem()));}
		    catch (Exception e2) {showErrorMessage(e2);}
		    javax.swing.SwingUtilities.updateComponentTreeUI(Window.this);
		    packAndCenter();
		}
	    });

	separator3 = new JSeparator(); 
	
	String[] columnNames = {
	    "Stat",
	    "Name",
	    "Name",
	};

	Object[][] data = new Object[][] {new Object[] {"Max Damage", null, null}};
	
	table = new JTable(data, columnNames);
	JScrollPane scrollpane = new JScrollPane(table);

	GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
				  layout.createParallelGroup(Alignment.LEADING)
				  .addGroup(layout.createSequentialGroup()
					    .addContainerGap()
					    .addGroup(layout.createParallelGroup(Alignment.LEADING)
						      .addGroup(layout.createParallelGroup(Alignment.LEADING)
								.addComponent(instructionsLabel)
								.addGroup(layout.createSequentialGroup()
									  .addComponent(weapon1ComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									  .addPreferredGap(ComponentPlacement.RELATED)
									  .addComponent(weapon1PrimaryAttachmentComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									  .addPreferredGap(ComponentPlacement.RELATED)
									  .addComponent(weapon1SecondaryAttachmentComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									  .addGap(18, 18, 18)
									  .addComponent(weapon2ComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									  .addPreferredGap(ComponentPlacement.RELATED)
									  .addComponent(weapon2PrimaryAttachmentComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									  .addPreferredGap(ComponentPlacement.RELATED)
									  .addComponent(weapon2SecondaryAttachmentComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									  .addGap(18, 18, 18)
									  .addComponent(compareButton))
								.addComponent(notesLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(separator1)
								.addGroup(layout.createSequentialGroup()
									  .addComponent(weapon1Image)
									  .addPreferredGap(ComponentPlacement.RELATED)
									  .addComponent(vsLabel)
									  .addPreferredGap(ComponentPlacement.RELATED)
									  .addComponent(weapon2Image))
								.addComponent(timeToKillGraph, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(separator2))
						      .addGroup(layout.createSequentialGroup()
								.addComponent(themeLabel)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(themeComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				  );
        layout.setVerticalGroup(
				layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					  .addContainerGap()
					  .addComponent(instructionsLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					  .addPreferredGap(ComponentPlacement.RELATED)
					  .addGroup(layout.createParallelGroup(Alignment.BASELINE)
						    .addComponent(weapon1ComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						    .addComponent(weapon1PrimaryAttachmentComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						    .addComponent(weapon1SecondaryAttachmentComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						    .addComponent(weapon2ComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						    .addComponent(weapon2PrimaryAttachmentComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						    .addComponent(weapon2SecondaryAttachmentComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						    .addComponent(compareButton))
					  .addPreferredGap(ComponentPlacement.RELATED)
					  .addComponent(notesLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					  .addPreferredGap(ComponentPlacement.RELATED)
					  .addComponent(separator1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					  .addPreferredGap(ComponentPlacement.RELATED)
					  .addGroup(layout.createParallelGroup(Alignment.BASELINE)
						    .addComponent(weapon1Image)
						    .addComponent(vsLabel)
						    .addComponent(weapon2Image))
					  .addPreferredGap(ComponentPlacement.RELATED)
					  .addComponent(timeToKillGraph, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					  .addPreferredGap(ComponentPlacement.RELATED)
					  .addComponent(separator2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					  .addPreferredGap(ComponentPlacement.RELATED)
					  .addGroup(layout.createParallelGroup(Alignment.BASELINE)
						    .addComponent(themeComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						    .addComponent(themeLabel))
					  .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
		
	packAndCenter();
    }
	
    public final void packAndCenter() {
	pack();
	setLocationRelativeTo(null);
    }
	
    public final void showErrorMessage(Exception e) {JOptionPane.showMessageDialog(this, "An error has occurred. Stack trace:\n\n" + StackTrace.stackTraceToString(e), "Error", JOptionPane.ERROR_MESSAGE);}
}
