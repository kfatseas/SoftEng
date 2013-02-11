/*
 * Enarksi tis efarmogis
 * dimiourgia antikoimenou MainFrame
 */

package engtest;

/**
 *
 * @author CFatseas, GPanetsos
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
              
            }
        });
    }

}
