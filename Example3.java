import org.nlogo.lite.InterfaceComponent;
public class Example3 {
  public static void main(String[] argv) {
    try {
      final javax.swing.JFrame frame = new javax.swing.JFrame();
      final InterfaceComponent comp = new InterfaceComponent(frame);
      java.awt.EventQueue.invokeAndWait(
	new Runnable() {
	  public void run() {
	    frame.setSize(1000, 700);
	    frame.add(comp);
	    frame.setVisible(true);
	    try {
	      comp.open("TimeToKillGraph.nlogo");
	    }
	    catch(Exception ex) {
	      ex.printStackTrace();
	    }}});
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
}