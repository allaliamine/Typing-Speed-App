package org.app;

import javax.swing.*;
import java.awt.*;

public class AppGUI extends JFrame {

    public static final Dimension buttonDimension = new Dimension(140, 30);

    public AppGUI(){

        //window initializing
        setTitle("Speed Typing App");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));



        JLabel welcomeLabel = new JLabel("Welcome to Speed Typing App!");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);


        JButton startButton = new JButton("Start");
        JButton exitButton = new JButton("Exit");

        startButton.setBackground(Color.GREEN);
        exitButton.setBackground(Color.RED);

        startButton.setOpaque(true);
        exitButton.setOpaque(true);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        buttonPanel.add(startButton);
        buttonPanel.add(Box.createHorizontalStrut(40));
        buttonPanel.add(exitButton);



        //start button functionality
        startButton.addActionListener(e-> startApp());

        //exit button functionality
        exitButton.addActionListener(e->System.exit(0));


        //margin top
        add(Box.createRigidArea(new Dimension(0,50)));
        //add text component
        add(welcomeLabel);
        //margin between label and buttonPanel
        add(Box.createRigidArea(new Dimension(0,30)));

        add(buttonPanel, BorderLayout.CENTER);

        setVisible(true);
    }


    public void startApp(){
        new ChoicesGUI();
        dispose();
    }
}
