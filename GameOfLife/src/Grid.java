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

    JPanel gridPanel = new JPanel();

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

        JLabel widthLabel = new JLabel("Width:");
        sizePannel.add(widthLabel);
        JTextField widthField = new JTextField("20");
        widthField.setMinimumSize(new Dimension(100, 30));
        sizePannel.add(widthField);
        JLabel heightLabel = new JLabel("Height:");
        sizePannel.add(heightLabel);
        JTextField heightField = new JTextField("20");


        heightField.setMinimumSize(new Dimension(100, 30));
        sizePannel.add(heightField);

        JButton set = new JButton();
        set.setPreferredSize(new Dimension(60, 30));
        set.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int newWidth = Integer.parseInt(widthField.getText(), 10);
                int newHeight = Integer.parseInt(heightField.getText(), 10);
                game = new Game(newWidth, newHeight);
                createButtons();
                showField();
            }
        });
        set.setText(SET);
        sizePannel.add(set);


        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(sizePannel, BorderLayout.PAGE_START);

        gridPanel = new JPanel();

        createButtons();

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

    private void createButtons() {
        gridPanel.removeAll();
        int x = game.getWidth();
        int y = game.getHeight();
        gridPanel.setLayout(new GridLayout(x, y));

        buttons = new JButton[x][y];
        for (int ix = 0; ix < x; ix++) {
            for (int iy = 0; iy < y; iy++) {
                buttons[ix][iy] = new JButton();
                buttons[ix][iy].setPreferredSize(new Dimension(30, 30));
                gridPanel.add(buttons[ix][iy]);
            }
        }
        gridPanel.updateUI();
    }

    private void showField() {
        boolean[][] field = game.getField();
        for (int ix = 0; ix < game.getWidth(); ix++) {
            for (int iy = 0; iy < game.getHeight(); iy++) {
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