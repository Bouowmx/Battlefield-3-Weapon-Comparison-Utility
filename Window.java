import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.LayoutStyle;

public class Window extends JFrame {
	public JButton jButton1;
	public JComboBox<String> weapon1ComboBox;
	public JComboBox<String> weapon1PrimaryAttachmentComboBox;
	public JComboBox<String> weapon1SecondaryAttachmentComboBox;
	public JComboBox<String> weapon2ComboBox;
	public JComboBox<String> weapon2PrimaryAttachmentComboBox;
	public JComboBox<String> weapon2SecondaryAttachmentComboBox;
	public JLabel jLabel1;
	public JLabel jLabel2;
	
	public Window() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Battlefield 3 Weapon Comparison Utility");
		
		weapon1ComboBox = new JComboBox<>(new String[] {"Weapon 1", ".44 Magnum", "93R", "A-91", "ACW-R", "AEK-971", "AK-74M", "AKS-74U", "AN-94", "AS Val", "AUG A3", "F2000", "FAMAS", "G17C", "G18", "G36C", "G3A3", "G53", "JNG-90", "KH2002", "L85A2", "L86A2", "L96", "LSAT", "M16A3", "M16A4", "M1911", "M240B", "M249", "M27 IAR", "M39 EMR", "M4", "M40A5", "M416", "M417", "M4A1", "M5K", "M60E4", "M9", "M98B", "MG36", "MK11 MOD 0", "MP412 REX", "MP443", "MP7", "MTAR-21", "P90", "PDW-R", "PKP Pecheneg", "PP-19", "PP-2000", "QBB-95", "QBU-88", "QBZ-95B", "RPK-74M", "SCAR-H", "SCAR-L", "SG553", "SKS", "SV-98", "SVD", "Type 88 LMG", "UMP45"});
		weapon1ComboBox.addActionListener(new ActionListener() {
			@Override
            public void actionPerformed(ActionEvent e) {
				if (weapon1ComboBox.getSelectedItem().equals("Weapon 1")) {
					weapon1PrimaryAttachmentComboBox.setModel(new DefaultComboBoxModel(new String[] {"None"}));
					weapon1SecondaryAttachmentComboBox.setModel(new DefaultComboBoxModel(new String[] {"None"}));
					return;
				}
				Weapon selectedWeapon = Battlefield3WeaponComparison.weapons.get((String) weapon1ComboBox.getSelectedItem());
				ArrayList<String> availablePrimaryAttachments = new ArrayList<>();
				ArrayList<String> availableSecondaryAttachments = new ArrayList<>();
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
			}
		});
		weapon1ComboBox.setToolTipText("Select a weapon.");
		
		weapon1PrimaryAttachmentComboBox = new JComboBox<>(new String[] {"None"});
		weapon1PrimaryAttachmentComboBox.setToolTipText("Select a primary attachment for weapon 1.");
		
		weapon1SecondaryAttachmentComboBox = new JComboBox<>(new String[] {"None"});
		weapon1SecondaryAttachmentComboBox.setToolTipText("Select a secondary attachment for weapon 1.");
		
		weapon2ComboBox = new JComboBox<>(new String[] {"Weapon 2", ".44 Magnum", "93R", "A-91", "ACW-R", "AEK-971", "AK-74M", "AKS-74U", "AN-94", "AS Val", "AUG A3", "F2000", "FAMAS", "G17C", "G18", "G36C", "G3A3", "G53", "JNG-90", "KH2002", "L85A2", "L86A2", "L96", "LSAT", "M16A3", "M16A4", "M1911", "M240B", "M249", "M27 IAR", "M39 EMR", "M4", "M40A5", "M416", "M417", "M4A1", "M5K", "M60E4", "M9", "M98B", "MG36", "MK11 MOD 0", "MP412 REX", "MP443", "MP7", "MTAR-21", "P90", "PDW-R", "PKP Pecheneg", "PP-19", "PP-2000", "QBB-95", "QBU-88", "QBZ-95B", "RPK-74M", "SCAR-H", "SCAR-L", "SG553", "SKS", "SV-98", "SVD", "Type 88 LMG", "UMP45"});
		weapon2ComboBox.addActionListener(new ActionListener() {
			@Override
            public void actionPerformed(ActionEvent e) {
				if (weapon2ComboBox.getSelectedItem().equals("Weapon 1")) {
					weapon2PrimaryAttachmentComboBox.setModel(new DefaultComboBoxModel(new String[] {"None"}));
					weapon2SecondaryAttachmentComboBox.setModel(new DefaultComboBoxModel(new String[] {"None"}));
					return;
				}
				Weapon selectedWeapon = Battlefield3WeaponComparison.weapons.get((String) weapon2ComboBox.getSelectedItem());
				ArrayList<String> availablePrimaryAttachments = new ArrayList<>();
				ArrayList<String> availableSecondaryAttachments = new ArrayList<>();
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
			}
		});
		weapon2ComboBox.setToolTipText("Select a weapon.");
		
		weapon2PrimaryAttachmentComboBox = new JComboBox<>(new String[] {"None"});
		weapon2PrimaryAttachmentComboBox.setToolTipText("Select a primary attachment for weapon 2.");
		
		weapon2SecondaryAttachmentComboBox = new JComboBox<>(new String[] {"None"});
		weapon2SecondaryAttachmentComboBox.setToolTipText("Select a secondary attachment for weapon 2.");
		
		jButton1 = new JButton("Compare");
		
		jLabel1 = new JLabel("<html>Up to date with the Aftermath patch (December 4, 2012). There has been no change to the weapons since.<br><b><u>How to use:</u></b> Select two weapons and optionally, a primary attachment and a secondary attachment for each weapon, and click Compare.");
		
		jLabel2 = new JLabel("<html><b><u>Notes:</u></b><br>The laser sight in the primary attachment slot is only available for the G17C, personal defense weapons (PDWs), and the QBZ-95B.<br>You will still need to select the laser sight for the G17C.");

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
						.addComponent(weapon1ComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(weapon1PrimaryAttachmentComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(weapon1SecondaryAttachmentComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addComponent(weapon2ComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(weapon2PrimaryAttachmentComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(weapon2SecondaryAttachmentComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
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
					.addComponent(weapon1ComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addComponent(weapon1PrimaryAttachmentComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addComponent(weapon1SecondaryAttachmentComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addComponent(weapon2ComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addComponent(weapon2PrimaryAttachmentComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addComponent(weapon2SecondaryAttachmentComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addComponent(jButton1))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);

		pack();
		setLocationRelativeTo(null);
	}
}
