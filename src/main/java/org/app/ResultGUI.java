package org.app;

import javax.swing.*;
import java.awt.*;

public class ResultGUI extends JFrame{

    private int numberOfErrors;
    private String generatedText;
    private double timeTaken;

    public ResultGUI(int numberOfErrors, double timeTaken, String generatedText) {
        this.numberOfErrors = numberOfErrors;
        this.timeTaken = timeTaken;
        this.generatedText = generatedText;


        int accuracy = (int) calculateAccuracy();
        int WPM = (int) calculateWPM();

        setTitle("Typing Tracker");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(340,100);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));


        JLabel welcomeLabel = new JLabel("Your Results!");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel accuracyLabel = new JLabel("Your Accuracy :  " + accuracy + "%");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 18));
        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel WPMLabel = new JLabel("Your WPM Score :  " + WPM );
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 18));
        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);


        JButton yesButton = new JButton("Yes");
        JButton noButton = new JButton("No");


        JLabel questionLabel = new JLabel("Would you like to test again ?");

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

        buttonPanel.add(questionLabel);
        buttonPanel.add(yesButton);
        buttonPanel.add(noButton);


        yesButton.addActionListener(e -> new ChoicesGUI());
        noButton.addActionListener(e -> System.exit(0));



        add(Box.createRigidArea(new Dimension(0,30)));
        add(welcomeLabel);
        add(Box.createRigidArea(new Dimension(0,20)));
        add(accuracyLabel);
        add(Box.createRigidArea(new Dimension(0,20)));
        add(WPMLabel);
        add(Box.createRigidArea(new Dimension(0,40)));
        add(buttonPanel);


        setVisible(true);
    }



    public double calculateAccuracy() {
        int totalChars = generatedText.length();
        int correctChars = totalChars - numberOfErrors;

        double accuracy =  (double) correctChars / totalChars * 100;

        return accuracy;
    }


    public double calculateWPM(){

        int totalWords = generatedText.split("\\s+").length;

        double wordPerMinute = 60 * totalWords / timeTaken;

        return wordPerMinute;

    }


    public static void main(String[] args) {
        new ResultGUI(2,3,"test test");
    }

}
