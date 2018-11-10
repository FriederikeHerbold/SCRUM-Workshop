import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Grid extends JFrame {
    Game game;
    JButton[][] buttons;
    static String START = "Start";
    static String STOP = "Stop";
    static String STEP = "Step";
    static String SET = "Set";
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
        JPanel sizePannel = new JPanel();

        JButton set = new JButton();
        set.setPreferredSize(new Dimension(60, 30));
        set.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // set size
            }
        });
        set.setText(SET);
        sizePannel.add(set);

        int x = 20;
        int y = 20;
        buttons = new JButton[x][y];
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(set, BorderLayout.PAGE_START);

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

        JPanel buttonPanel = new JPanel();

        int delay = 1000; //milliseconds
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                nextGen();
            }
        };
        Timer timer = new javax.swing.Timer(delay, taskPerformer);

        JButton startStopButton = new JButton();
        startStopButton.setPreferredSize(new Dimension(60, 30));
        startStopButton.setText(START);

        startStopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(timer.isRunning()) {
                    timer.stop();
                    startStopButton.setText(START);
                } else {
                    nextGen();
                    timer.start();
                    startStopButton.setText(STOP);
                }
            }
        });
        //action listener
        buttonPanel.add(startStopButton);


        JButton step = new JButton();
        step.setPreferredSize(new Dimension(60, 30));
        step.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nextGen();
            }
        });
        step.setText(STEP);
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

    public void nextGen() {
        game.nextGen();
        showField();
    }
}