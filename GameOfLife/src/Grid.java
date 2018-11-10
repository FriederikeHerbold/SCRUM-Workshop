import java.awt.*;
import javax.swing.*;

public class Grid extends JFrame {
    Game game;
    JButton[][] buttons;

    Grid() {
        game = new Game(20, 20);
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException
                | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        int x = 20;
        int y = 20;
        buttons = new JButton[x][y];
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(x, y));
        for (int ix = 0; ix < x; ix++) {
            for (int iy = 0; iy < y; iy++) {
                buttons[ix][iy] = new JButton();
                buttons[ix][iy].setPreferredSize(new Dimension(30, 30));
                gridPanel.add(buttons[ix][iy]);
            }
        }

        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);

        //frame.pack();


        JPanel buttonPanel = new JPanel();
        JButton step = new JButton();
        step.setPreferredSize(new Dimension(60, 30));
        step.setText("Step");
        buttonPanel.add(step);

        mainPanel.add(gridPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.PAGE_END);
        frame.add(mainPanel);

        frame.setVisible(true);
showField();

    }

    private void showField() {
        boolean[][] field = game.getField();
        for (int ix = 0; ix < 20; ix++) {
            for (int iy = 0; iy < 20; iy++) {
                if (field[ix][iy]) {
                    buttons[ix][iy].setBackground(Color.black);
                } else {
                    buttons[ix][iy].setBackground(Color.white);
                }
            }
        }
    }
}