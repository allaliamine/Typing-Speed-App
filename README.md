# Typing Tracker

A Java-based application that tracks and evaluates your typing performance, including accuracy and words per minute (WPM) scores. The application provides feedback on your typing accuracy and allows you to retake the typing test.

## Features

- **Accuracy Calculation**: Displays the accuracy of your typed characters.
- **WPM Calculation**: Measures your typing speed in words per minute.
- **User Interface**: A simple and user-friendly GUI that presents your results and allows you to retake the test or exit the application.
- **Error Tracking**: Counts the number of incorrectly typed characters.

## Requirements

- Java Development Kit (JDK) 8 or higher
- An IDE for Java (e.g., IntelliJ IDEA, Eclipse, or NetBeans)

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/typing-tracker.git
   ```
   
2. Navigate to the project directory:
   ```bash
   cd typing-tracker
   ```

3. Open the project in your preferred IDE.

4. Run the `Main` class to start the application.

## Usage

1. Follow the prompts in the application to start typing the displayed text.
2. Once you finish typing, the results window will display:
   - Your accuracy percentage.
   - Your WPM score.
   - The number of correct and incorrect typed characters.
3. Choose whether to retake the test or exit the application.

## Code Structure

- **`org.app`**: Contains the main application classes, including:
  - `Main`: The entry point of the application.
  - `AppGui`: A class to display the home GUI.
  - `ChoiceGUI`: A GUI class to display the different tracking methods **Sentence** or **Paragraph** or **custom** (where u choose the number of words that u want).
  - `ResultGUI`: A GUI class to display the results of the typing test.

## Contributing

Contributions are welcome! If you would like to improve the application, feel free to fork the repository and submit a pull request.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
