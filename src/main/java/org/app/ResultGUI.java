package org.app;

import javax.swing.*;
import java.awt.*;

public class ResultGUI extends JFrame {

    private int numberOfErrors;
    private int correctTypedChars;
    private String generatedText;
    private double timeTaken;
    private int numberOfTypedWords;

    public ResultGUI(int numberOfErrors, int correctTypedChars, double timeTaken, String generatedText, int numberOfTypedWords) {
        this.numberOfErrors = numberOfErrors;
        this.correctTypedChars = correctTypedChars;
        this.timeTaken = timeTaken;
        this.generatedText = generatedText;
        this.numberOfTypedWords = numberOfTypedWords;

        int accuracy = (int) calculateAccuracy();
        int WPM = (int) calculateWPM();

        setTitle("Typing Tracker");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(340, 100);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        JLabel welcomeLabel = new JLabel("Your Results!");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel statisticLabel = new JLabel("(correct/incorrect typed characters) :  " + "(" + correctTypedChars + "," + numberOfErrors + ")");
        statisticLabel.setFont(new Font("Arial", Font.ITALIC, 12));
        statisticLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel accuracyLabel = new JLabel("Your Accuracy :  " + accuracy + "%");
        accuracyLabel.setFont(new Font("Arial", Font.BOLD, 12));
        accuracyLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel WPMLabel = new JLabel("Your WPM Score :  " + WPM);
        WPMLabel.setFont(new Font("Arial", Font.BOLD, 12));
        WPMLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton yesButton = new JButton("Yes");
        yesButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton noButton = new JButton("No");
        noButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel questionLabel = new JLabel("Would you like to test again?");
        questionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonPanel.add(yesButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        buttonPanel.add(noButton);

        yesButton.addActionListener(e -> new ChoicesGUI());
        noButton.addActionListener(e -> System.exit(0));

        // add all component to the main window
        add(Box.createRigidArea(new Dimension(0, 30)));
        add(welcomeLabel);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(accuracyLabel);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(WPMLabel);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(statisticLabel);
        add(Box.createRigidArea(new Dimension(0, 40)));
        add(questionLabel);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(buttonPanel);

        setVisible(true);
    }

    public double calculateAccuracy() {
        int totalChars = generatedText.length();
        double accuracy = (double) correctTypedChars / totalChars * 100;
        return accuracy;
    }

    public double calculateWPM() {
        double wordPerMinute = 60 * numberOfTypedWords / timeTaken;
        return wordPerMinute;
    }
}
