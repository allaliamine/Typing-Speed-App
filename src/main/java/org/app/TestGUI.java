package org.app;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

import static org.app.ChoicesGUI.showInfoDialog;
import static org.app.TextGenerate.generateText;

public class TestGUI extends JFrame {


    private JEditorPane originalTextArea;
    private JEditorPane userInputArea;
    private JLabel timerLabel;
    private Timer timer;
    private long startTime;
    private int numberOfTypedWords;
    private int correctTypedChars = 0;

    private int numberOfErrors = 0;

    private String generatedText;

    public static final int PARAGRAPH_MIN = 50;
    public static final int PARAGRAPH_MAX = 100;
    public static final int SENTENCE_MIN = 10;
    public static final int SENTENCE_MAX = 20;

    public TestGUI(int wantedValue) {

        //generating text based on the mode selected
        if(wantedValue > 0){
            generatedText = generateText(wantedValue);
        }
        else if(wantedValue == -1){
            generatedText = generateText(SENTENCE_MIN, SENTENCE_MAX);
            System.out.println(generatedText);//for debug only
        }else if (wantedValue == -2){
            generatedText = generateText(PARAGRAPH_MIN, PARAGRAPH_MAX);
            System.out.println(generatedText);//for debug only
        }


        //FOR DEBUG ONLY
        if (generatedText == null || generatedText.isEmpty()) {
            System.out.println("No text generated.");
        }


        setTitle("Typing Tracker");
        setSize(600, 400);
        setLocation(340,100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // devide a panel by 2 for both original and input area
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new GridLayout(2, 1));

        // original text area
        originalTextArea = new JEditorPane();
        originalTextArea.setContentType("text/html");
        originalTextArea.setText(generatedTextStyle(0));
        originalTextArea.setEditable(false);

        // user input area
        userInputArea = new JEditorPane();
        userInputArea.setContentType("text/plain");
        userInputArea.setEditable(true);
        userInputArea.getDocument().addDocumentListener(new InputListener());


        textPanel.add(new JScrollPane(originalTextArea));
        textPanel.add(new JScrollPane(userInputArea));

        // timer Label
        timerLabel = new JLabel("Time: 0.0 seconds");
        timerLabel.setFont(new Font("Arial", Font.BOLD, 16));
        timerLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // adding components to the frame
        add(textPanel, BorderLayout.CENTER);
        add(timerLabel, BorderLayout.SOUTH);

        // Timer initialization
        timer = new Timer(100, e -> updateTimer());

        setVisible(true);

        showInfoDialog("the test will start once you start typing \nthe test will stop once you type a dot '.'", new JFrame());
    }

    private class InputListener implements DocumentListener {
        @Override
        public void insertUpdate(DocumentEvent e) {
            timerStartAndStop();
            updateText();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            updateText();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            updateText();
        }
    }


    /**
     * this method is used to start and stop the timer.
     * the timer starts when the user starts to write,
     * and it stops when he writes a "."
     * as well it launch the result window once the test is finished
     */
    private void timerStartAndStop() {

        String userInput = userInputArea.getText();

        if (userInput.length() == 1 && !timer.isRunning()) {
            startTime = System.currentTimeMillis();
            timer.start();
        }

        if (userInput.endsWith(".")) {
            timer.stop();
            userInputArea.setEditable(false);

            long timeSpent = System.currentTimeMillis() - startTime;
            double totalSeconds = timeSpent / 1000.0;

            new ResultGUI(numberOfErrors, correctTypedChars,totalSeconds, generatedText, numberOfTypedWords);
            dispose();
        }
    }

    /**
     * this method updates display of the timer
     */
    private void updateTimer() {
        long timeSpent = System.currentTimeMillis() - startTime;
        double seconds = timeSpent / 1000.0;
        timerLabel.setText(String.format("Time: %.1f seconds", seconds));
    }


    /**
     * this method updates the text in the original text area
     * if the input matches the char at the same position text becomes black
     * else it becomes red (unmatched char at the same position)
     */
    private void updateText() {
        String userInput = userInputArea.getText();
        StringBuilder styledText = new StringBuilder("<html><body>");

        boolean missmatched = false;

        for (int i = 0; i < generatedText.length() ; i++) {

            if (i < userInput.length()) {
                char userChar = userInput.charAt(i);
                char originalChar = generatedText.charAt(i);
                if (userChar == originalChar) {
                    styledText.append("<span style='color: black; opacity: 1;  font-size: 12px;'>" + originalChar + "</span>");
                    correctTypedChars++;
                    missmatched = false;
                } else {
                    styledText.append("<span style='color: red; opacity: 1;  font-size: 12px;'>" + originalChar + "</span>");
                    if (!missmatched) {
                        numberOfErrors++;
                        missmatched = true;
                    }
                }
            } else {
                styledText.append("<span style='color: rgba(0, 0, 0, 0.4);  font-size: 12px;'>" + generatedText.charAt(i) + "</span>");
            }
        }

        styledText.append("</body></html>");
        originalTextArea.setText(styledText.toString());
        numberOfTypedWords = (userInputArea.getText()).split("\\s+").length;
    }


    /**
     * this method generate the style of the text in the original area
     */
    private String generatedTextStyle(int opacity) {
        return "<html><body><span style='color: rgba(0, 0, 0, 0.4); font-size: 12px;'>" + generatedText + "</span></body></html>";
    }

}