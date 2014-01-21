import static java.lang.System.nanoTime;
import javax.swing.UIManager;

public final class Battlefield3WeaponComparison {
	
	public static void main(String[] args) {
		long t1 = nanoTime();	
		try {
			//Use the following for the "Nimbus" look and feel (L&F):
			/*for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}*/
			//Use the following for the "System" (Windows/Mac/Linux/etc.) L&F:
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, e);}
		java.awt.EventQueue.invokeLater(new Runnable() {public void run() {new Window().setVisible(true);}});
		long t2 = nanoTime();
		System.out.println("Initialization time: " + (t2 - t1) + " ns / " + ((double) (t2 - t1) / 1000000) + " ms / " + ((double) (t2 - t1) / 1000000000) + " s");
	}
}
