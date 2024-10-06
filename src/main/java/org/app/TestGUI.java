package org.app;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

import static org.app.TextGenerate.generateText;


public class TestGUI extends JFrame {

    private JEditorPane originalTextPane;
    private JEditorPane userInputArea;
    private JLabel timerLabel;
    private Timer timer;
    private long startTime;

    private String generatedText;

    public static final int PARAGRAPH_MIN = 50;
    public static final int PARAGRAPH_MAX = 100;
    public static final int SENTENCE_MIN = 10;
    public static final int SENTENCE_MAX = 20;

    public TestGUI(int wantedValue) {
        if(wantedValue > 0){
            generatedText = generateText(wantedValue);
        }
        else if(wantedValue == -1){
            generatedText = generateText(SENTENCE_MIN, SENTENCE_MAX);
            System.out.println(generatedText);
        }else if (wantedValue == -2){
            generatedText = generateText(PARAGRAPH_MIN, PARAGRAPH_MAX);
        }


        //FOR DEBUG ONLY
        if (generatedText == null || generatedText.isEmpty()) {
            System.out.println("No text generated.");
        }


        setTitle("Typing Tracker");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Original Text Pane
        originalTextPane = new JEditorPane();
        originalTextPane.setContentType("text/html");
        originalTextPane.setText(generatedTextStyle(0));
        originalTextPane.setEditable(false);
        originalTextPane.setPreferredSize(new Dimension(600, 50));

        // User Input Pane
        userInputArea = new JEditorPane();
        userInputArea.setContentType("text/plain");
        userInputArea.setEditable(true);
        userInputArea.setPreferredSize(new Dimension(600, 200));
        userInputArea.getDocument().addDocumentListener(new InputListener());

        // Timer Label
        timerLabel = new JLabel("Time: 0.0 seconds");
        timerLabel.setFont(new Font("Arial", Font.BOLD, 16));
        timerLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Adding components to the frame
        add(originalTextPane, BorderLayout.NORTH);
        add(new JScrollPane(userInputArea), BorderLayout.CENTER);
        add(timerLabel, BorderLayout.SOUTH);

        // Timer initialization
        timer = new Timer(100, e -> updateTimer());

        setVisible(true);
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


    private void updateText() {
        String userInput = userInputArea.getText();
        StringBuilder styledText = new StringBuilder("<html><body>");

        for (int i = 0; i < generatedText.length(); i++) {
            if (i < userInput.length()) {
                char userChar = userInput.charAt(i);
                char originalChar = generatedText.charAt(i);
                if (userChar == originalChar) {
                    styledText.append("<span style='color: black; opacity: 1;'>" + originalChar + "</span>");
                } else {
                    styledText.append("<span style='color: red; opacity: 1;'>" + originalChar + "</span>");
                }
            } else {
                styledText.append("<span style='color: rgba(0, 0, 0, 0.4);'>" + generatedText.charAt(i) + "</span>");
            }
        }

        styledText.append("</body></html>");
        originalTextPane.setText(styledText.toString());
    }

    private String generatedTextStyle(int opacity) {
        return "<html><body><span style='color: rgba(0, 0, 0, 0.4); font-size: 24px;'>" + generatedText + "</span></body></html>";
    }

    public static void main(String[] args) {
        new TestGUI(1);
    }

}
