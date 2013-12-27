import java.awt.Cursor;
import java.awt.Rectangle;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;

public class Window extends JFrame {
	private JButton jButton1;
	private JComboBox<String> jComboBox1;
	private JComboBox<String> jComboBox2;
	private JComboBox<String> jComboBox3;
	private JComboBox<String> jComboBox4;
	private JComboBox<String> jComboBox5;
	private JComboBox<String> jComboBox6;
	private JLabel jLabel1;
	private JLabel jLabel2;
	
	public Window() {
		jComboBox1 = new JComboBox<>();
        jComboBox2 = new JComboBox<>();
        jComboBox3 = new JComboBox<>();
        jComboBox5 = new JComboBox<>();
        jComboBox4 = new JComboBox<>();
        jComboBox6 = new JComboBox<>();
        jButton1 = new JButton();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Battlefield 3 Weapon Comparison Utility");
        setBounds(new Rectangle(0, 0, 0, 0));
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

        jComboBox1.setModel(new DefaultComboBoxModel(new String[] {"Weapon 1", ".44 Magnum", "93R", "A-91", "ACW-R", "AEK-971", "AK-74M", "AKS-74U", "AN-94", "AS Val", "AUG A3", "F2000", "FAMAS", "G17C", "G18", "G36C", "G3A3", "G53", "JNG-90", "KH2002", "L85A2", "L86A2", "L96", "LSAT", "M16A3", "M16A4", "M1911", "M240B", "M249", "M27 IAR", "M39 EMR", "M4", "M40A5", "M416", "M417", "M4A1", "M5K", "M60E4", "M9", "M98B", "MG36", "MK11 MOD 0", "MP412 REX", "MP443", "MP7", "MTAR-21", "P90", "PDW-R", "PKP Pecheneg", "PP-19", "PP-2000", "QBB-95", "QBU-88", "QBZ-95B", "RPK-74M", "SCAR-H", "SCAR-L", "SG553", "SKS", "SV-98", "SVD", "Type 88 LMG", "UMP45"}));
        jComboBox1.setToolTipText("Select a weapon.");

        jComboBox2.setModel(new DefaultComboBoxModel(new String[] {"None", "Bipod", "Foregrip", "Laser Sight"}));
        jComboBox2.setToolTipText("Select a primary attachment for weapon 1.");

        jComboBox3.setModel(new DefaultComboBoxModel(new String[] {"None", "Flash Suppressor", "Heavy Barrel", "Laser Sight", "Suppressor"}));
        jComboBox3.setToolTipText("Select a secondary attachment for weapon 1.");
		
		jComboBox4.setModel(new DefaultComboBoxModel(new String[] {"None", "Bipod", "Foregrip", "Laser Sight"}));
        jComboBox4.setToolTipText("Select a primary attachment for weapon 2.");

        jComboBox5.setModel(new DefaultComboBoxModel(new String[] {"Weapon 2", ".44 Magnum", "93R", "A-91", "ACW-R", "AEK-971", "AK-74M", "AKS-74U", "AN-94", "AS Val", "AUG A3", "F2000", "FAMAS", "G17C", "G18", "G36C", "G3A3", "G53", "JNG-90", "KH2002", "L85A2", "L86A2", "L96", "LSAT", "M16A3", "M16A4", "M1911", "M240B", "M249", "M27 IAR", "M39 EMR", "M4", "M40A5", "M416", "M417", "M4A1", "M5K", "M60E4", "M9", "M98B", "MG36", "MK11 MOD 0", "MP412 REX", "MP443", "MP7", "MTAR-21", "P90", "PDW-R", "PKP Pecheneg", "PP-19", "PP-2000", "QBB-95", "QBU-88", "QBZ-95B", "RPK-74M", "SCAR-H", "SCAR-L", "SG553", "SKS", "SV-98", "SVD", "Type 88 LMG", "UMP45"}));
        jComboBox5.setToolTipText("Select a weapon.");

        jComboBox6.setModel(new DefaultComboBoxModel(new String[] {"None", "Flash Suppressor", "Heavy Barrel", "Laser Sight", "Suppressor"}));
        jComboBox6.setToolTipText("Select a secondary attachment for weapon 2.");

        jButton1.setText("Compare");

        jLabel1.setText("<html>Up to date with the Aftermath patch (December 4, 2012). There has been no change to the weapons since.<br><b><u>How to use:</u></b> Select two weapons and optionally, a primary attachment and a secondary attachment for each weapon, and click Compare.");

        jLabel2.setText("<html><b><u>Notes:</u></b><br>The laser sight in the primary attachment slot is only available for the G17C, personal defense weapons (PDWs), and the QBZ-95B.<br>You will still need to select the laser sight for the G17C.");

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
			layout.createParallelGroup(GroupLayout.Alignment.LEADING)
			.addGroup(layout.createSequentialGroup()
				.addContainerGap()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
					.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGroup(layout.createSequentialGroup()
						.addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jComboBox2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jComboBox3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addComponent(jComboBox5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jComboBox4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jComboBox6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addComponent(jButton1)))
				.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(GroupLayout.Alignment.LEADING)
			.addGroup(layout.createSequentialGroup()
				.addContainerGap()
				.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addGap(12, 12, 12)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addComponent(jComboBox2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addComponent(jComboBox3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addComponent(jComboBox5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addComponent(jComboBox4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addComponent(jComboBox6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addComponent(jButton1))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);

		pack();
		setLocationRelativeTo(null);
	}
}
