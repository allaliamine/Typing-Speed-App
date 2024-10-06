package org.app;

import com.sun.jdi.Value;

import javax.swing.*;
import java.awt.*;

import static org.app.AppGUI.buttonDimension;

public class ChoicesGUI extends JFrame {
    private JTextArea customTextArea;
    private JButton startButton;

    public ChoicesGUI(){
        setTitle("Choice Window");
        setSize(600,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));


        JLabel inputTypeLabel = new JLabel("Select the type of input:");
        inputTypeLabel.setFont(new Font("Arial", Font.BOLD, 18));
        inputTypeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton sentenceButton = new JButton("Sentence");
        JButton paragraphButton = new JButton("Paragraph");
        JButton customButton = new JButton("Custom");

        sentenceButton.setMaximumSize(buttonDimension);
        paragraphButton.setMaximumSize(buttonDimension);
        customButton.setMaximumSize(buttonDimension);

        sentenceButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        paragraphButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        customButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        sentenceButton.addActionListener(e -> {
            System.out.println("Sentence selected.");
        });
        paragraphButton.addActionListener(e -> {
            System.out.println("Paragraph selected.");
        });
        customButton.addActionListener(e -> CustomTextSelect());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.add(sentenceButton);
        buttonPanel.add(paragraphButton);
        buttonPanel.add(customButton);

        //space between buttons
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        //margin top
        add(Box.createRigidArea(new Dimension(0,40)));

        //add text component
        add(inputTypeLabel);
        //space between label and buttons
        add(Box.createRigidArea(new Dimension(0, 20)));
        //add Panel that contains buttons
        add(buttonPanel);

        setVisible(true);
    }


    public static void main(String[] args) {
        new ChoicesGUI();
    }


    public void CustomTextSelect(){

        JLabel infoLabel = new JLabel("please select the number of words :");
        infoLabel.setFont(new Font("Arial", Font.ITALIC, 11));
        infoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Create the text area
        customTextArea = new JTextArea(5, 20);
        customTextArea.setLineWrap(true);
        customTextArea.setWrapStyleWord(true);

        //set size for the text area
        customTextArea.setMaximumSize(new Dimension(50, 20));
        customTextArea.setAlignmentX(Component.CENTER_ALIGNMENT); // Center the text area

        // Create the start button
        startButton = new JButton("Start");
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        startButton.setMinimumSize(buttonDimension);


        // Add the component to the frame && spacing
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(infoLabel);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(customTextArea);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(startButton);


        startButton.addActionListener(e->getValue());
        // repaint and revalidate to show the new components
        revalidate();
        repaint();
    }

    public void getValue(){
        String typedValue = customTextArea.getText().trim();

        if(!typedValue.isEmpty()){
            try{
                int wantedValue = Integer.parseInt(customTextArea.getText());
                if(wantedValue > 300 || wantedValue <= 0){
                    showErrorDialog("Value must be positif and below 300");
                }else{
                    customTextArea.setEditable(false);
                    System.out.println("Valid value: " + wantedValue);
                }
            }catch(NumberFormatException e){
                showErrorDialog("Value must be an integer");
            }

        }else {
            showErrorDialog("Value cannot be empty");
        }

    }

    private void showErrorDialog(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
