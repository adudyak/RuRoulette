import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;

public class Roulette extends JDialog {
    private JPanel contentPane;
    private JButton buttonCancel;
    private JButton button1;
    private JButton button2;
    private JLabel label;

    public Roulette() {
        //Initialize barrel
        ArrayList<Boolean> lBullets = new ArrayList<Boolean>(6);
        lBullets.add(true);
        for (int i = 0; i < 5; i++)
            lBullets.add(false);
        Collections.shuffle(lBullets);

        //some unknown stuff
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(button1);

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

// call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

// call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (lBullets.get(0) == false){
                    lBullets.remove(0);
                    lBullets.add(false);
                    label.setText("Lucky");
                }
                else{
                    label.setText("Dead");
                    Collections.shuffle(lBullets);
                }
            }
        });
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Collections.shuffle(lBullets);
            }
        });
    }

    private void onCancel() {
// add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        Roulette dialog = new Roulette();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
