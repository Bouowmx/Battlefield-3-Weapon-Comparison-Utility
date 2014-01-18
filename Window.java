import static javax.swing.GroupLayout.Alignment;
import static javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.UIManager;
import java.util.ArrayList;
import java.util.HashMap;

public final class Window extends JFrame {
	public JButton compareButton;
	public JComboBox<String> themeComboBox;
	public JComboBox<String> weapon1ComboBox;
	public JComboBox<String> weapon1PrimaryAttachmentComboBox;
	public JComboBox<String> weapon1SecondaryAttachmentComboBox;
	public JComboBox<String> weapon2ComboBox;
	public JComboBox<String> weapon2PrimaryAttachmentComboBox;
	public JComboBox<String> weapon2SecondaryAttachmentComboBox;
	public JLabel instructionsLabel;
	public JLabel themeLabel;
	public JLabel notesLabel;
	public JLabel weapon1Image;
	public JLabel weapon2Image;
	public JLabel vsLabel;
	public JSeparator separator1;
	public JSeparator separator2;
	
	public Window() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Battlefield 3 Weapon Comparison Utility");
		setResizable(false);
		
		instructionsLabel = new JLabel("<html>Up to date with the Aftermath patch (December 4, 2012). There has been no change to the weapons since.<br><b><u>How to use:</u></b> Select two weapons and optionally, a primary attachment and a secondary attachment for each weapon, and click Compare.");
		
		weapon1ComboBox = new JComboBox<>(new String[] {"Weapon 1", ".44 Magnum", "93R", "A-91", "ACW-R", "AEK-971", "AK-74M", "AKS-74U", "AN-94", "AS Val", "AUG A3", "F2000", "FAMAS", "G17C", "G18", "G36C", "G3A3", "G53", "JNG-90", "KH2002", "L85A2", "L86A2", "L96", "LSAT", "M16A3", "M16A4", "M1911", "M240B", "M249", "M27 IAR", "M39 EMR", "M4", "M40A5", "M416", "M417", "M4A1", "M5K", "M60E4", "M9", "M98B", "MG36", "MK11 MOD 0", "MP412 REX", "MP443", "MP7", "MTAR-21", "P90", "PDW-R", "PKP Pecheneg", "PP-19", "PP-2000", "QBB-95", "QBU-88", "QBZ-95B", "RPK-74M", "SCAR-H", "SCAR-L", "SG553", "SKS", "SV-98", "SVD", "Type 88 LMG", "UMP45"});
		weapon1ComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (weapon1ComboBox.getSelectedItem().equals("Weapon 1")) {
					weapon1PrimaryAttachmentComboBox.setModel(new DefaultComboBoxModel<>(new String[] {"None"}));
					weapon1SecondaryAttachmentComboBox.setModel(new DefaultComboBoxModel<>(new String[] {"None"}));
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
				weapon1PrimaryAttachmentComboBox.setModel(new DefaultComboBoxModel<>(availablePrimaryAttachments.toArray(new String[] {})));
				weapon1SecondaryAttachmentComboBox.setModel(new DefaultComboBoxModel<>(availableSecondaryAttachments.toArray(new String[] {})));
				packAndCenter();
			}
		});
		weapon1ComboBox.setToolTipText("Select a weapon.");
		
		weapon1PrimaryAttachmentComboBox = new JComboBox<>(new String[] {"None"});
		weapon1PrimaryAttachmentComboBox.setToolTipText("Select a primary attachment for weapon 1.");
		
		weapon1SecondaryAttachmentComboBox = new JComboBox<>(new String[] {"None"});
		weapon1SecondaryAttachmentComboBox.setToolTipText("Select a secondary attachment for weapon 1.");
		
		weapon2ComboBox = new JComboBox<>(new String[] {"Weapon 2", ".44 Magnum", "93R", "A-91", "ACW-R", "AEK-971", "AK-74M", "AKS-74U", "AN-94", "AS Val", "AUG A3", "F2000", "FAMAS", "G17C", "G18", "G36C", "G3A3", "G53", "JNG-90", "KH2002", "L85A2", "L86A2", "L96", "LSAT", "M16A3", "M16A4", "M1911", "M240B", "M249", "M27 IAR", "M39 EMR", "M4", "M40A5", "M416", "M417", "M4A1", "M5K", "M60E4", "M9", "M98B", "MG36", "MK11 MOD 0", "MP412 REX", "MP443", "MP7", "MTAR-21", "P90", "PDW-R", "PKP Pecheneg", "PP-19", "PP-2000", "QBB-95", "QBU-88", "QBZ-95B", "RPK-74M", "SCAR-H", "SCAR-L", "SG553", "SKS", "SV-98", "SVD", "Type 88 LMG", "UMP45"});
		weapon2ComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (weapon2ComboBox.getSelectedItem().equals("Weapon 2")) {
					weapon2PrimaryAttachmentComboBox.setModel(new DefaultComboBoxModel<>(new String[] {"None"}));
					weapon2SecondaryAttachmentComboBox.setModel(new DefaultComboBoxModel<>(new String[] {"None"}));
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
				weapon2PrimaryAttachmentComboBox.setModel(new DefaultComboBoxModel<>(availablePrimaryAttachments.toArray(new String[] {})));
				weapon2SecondaryAttachmentComboBox.setModel(new DefaultComboBoxModel<>(availableSecondaryAttachments.toArray(new String[] {})));
				packAndCenter();
			}
		});
		weapon2ComboBox.setToolTipText("Select a weapon.");
		
		weapon2PrimaryAttachmentComboBox = new JComboBox<>(new String[] {"None"});
		weapon2PrimaryAttachmentComboBox.setToolTipText("Select a primary attachment for weapon 2.");
		
		weapon2SecondaryAttachmentComboBox = new JComboBox<>(new String[] {"None"});
		weapon2SecondaryAttachmentComboBox.setToolTipText("Select a secondary attachment for weapon 2.");
		
		compareButton = new JButton("Compare");
		
		notesLabel = new JLabel("<html><b><u>Notes:</u></b><br>The laser sight in the primary attachment slot is only available for the G17C, personal defense weapons (PDWs), and the QBZ-95B.<br>You will still need to select the laser sight for the G17C.");
		
		weapon1Image = new JLabel(" ");
		
		vsLabel = new JLabel("vs.");
		
		weapon2Image = new JLabel();
		
		separator1 = new JSeparator();
		
		
		
		separator2 = new JSeparator();
		
		themeLabel = new JLabel("Theme:");
		
		UIManager.LookAndFeelInfo[] installedLookAndFeels = UIManager.getInstalledLookAndFeels();
		HashMap<String, String> _lookAndFeels = new HashMap<>();
		String[] installedLookAndFeelsNames = new String[installedLookAndFeels.length];
		for (int i = 0; i < installedLookAndFeels.length; i++) {
			_lookAndFeels.put(installedLookAndFeels[i].getName(), installedLookAndFeels[i].getClassName());
			installedLookAndFeelsNames[i] = installedLookAndFeels[i].getName();
		}
		final HashMap<String, String> lookAndFeels = _lookAndFeels;
		themeComboBox = new JComboBox<>(installedLookAndFeelsNames);
		themeComboBox.setSelectedItem(UIManager.getLookAndFeel().getName());
		themeComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {UIManager.setLookAndFeel(lookAndFeels.get((String) themeComboBox.getSelectedItem()));}
				catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException e2) {java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, e2);}
				javax.swing.SwingUtilities.updateComponentTreeUI(Window.this);
				packAndCenter();
			}
		});

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
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
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
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(weapon1Image)
                    .addComponent(vsLabel)
                    .addComponent(weapon2Image))
                .addPreferredGap(ComponentPlacement.RELATED)
                .addComponent(separator2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
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
}
