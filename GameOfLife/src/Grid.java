import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.*;

public class Grid extends JFrame {

    Grid() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException
                | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        int x = 30;
        int y = 30;

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(x, y));
        for (int i = 0; i < x * y; i++) {
            JButton button = new JButton();
            button.setPreferredSize(new Dimension(x, y));
            panel.add(button);
        }
        JPanel container = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        container.add(panel);
        JScrollPane scrollPane = new JScrollPane(container);
        f.getContentPane().add(scrollPane);

        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}