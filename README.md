# Typing Tracker

The Typing Tracker is a Java Swing application designed to help users improve their typing speed and accuracy. The application generates random text for users to type, tracks their performance, and provides feedback on their typing accuracy and speed after each test.

## Table of Contents

- [Features](#features)
- [Requirements](#requirements)
- [Technologies Used](#technologies-used)
- [Installation](#installation)
- [Usage](#usage)
- [Code Structure](#code-structure)
- [Contributing](#contributing)
- [Version Information](#version-information)
- [Contacts](#contacts)


## Features

- **Accuracy Calculation**: Displays the accuracy of your typed characters.
- **WPM Calculation**: Measures your typing speed in words per minute.
- **Real Time Tracking**: Mistakes are highlighted in red while the users are typing, giving them the opportunity to see where corrections are needed.
- **User Interface**: A simple and user-friendly GUI that presents your results and allows you to retake the test or exit the application.
- **Error Tracking**: Counts the number of incorrectly and correctly typed characters.

## Requirements

- Java Development Kit (JDK) 17 or higher
- An IDE for Java (e.g., IntelliJ IDEA, Eclipse, or NetBeans)

## Technologies Used

- Java Swing for the graphical user interface (GUI).
- Java for backend logic and functionality.
- HTML/CSS for text styling in the application.

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

1. Run the main application by executing the `TestGUI` class.
2. Choose **Start** to begin the typing test or **Exit** to close the application.
3. Select one of the evaluation modes:
   - **Sentence**: Text will vary between 10 to 20 words.
   - **Paragraph**: Text will vary between 50 to 100 words.
   - **Custom**: You choose the exact number of words you want.
4. Type the original text displayed in the top panel into the bottom panel.
5. The timer starts once you begin typing.
6. Hit the period ('.') key to finish typing. If you type '.', the typing stops, and the application transitions to the results GUI.
7. Once you finish typing, the results window will display:
   - Your accuracy percentage.
   - Your WPM score.
   - The number of correct and incorrect typed characters.
8. Choose whether to retake the test or exit the application.

## Code Structure

- **`org.app`**: Contains the main application classes, including:
  - `Main`: The entry point of the application.
  - `AppGui`: A class to display the home GUI.
  - `ChoiceGUI`: A GUI class to display the different tracking modes **Sentence**, **Paragraph** or **Custom**.
  - `TestGUI`: A GUI class where you start the typing test.
  - `ResultGUI`: A GUI class to display the results of the typing test.

## Contributing

Contributions are welcome! If you would like to improve the application, feel free to fork the repository and submit a pull request.

## Version Information

This is version 1.0 of the Typing Tracker application. Many additional functionalities will be added over time to enhance user experience and improve typing skills.

## Contacts

For any feedback or inquiries, feel free to contact me at:
[Allali Mohamed Amin](https://www.linkedin.com/in/m-amin-allali/)


