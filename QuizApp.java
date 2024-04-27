import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class Quiz {
    private String question;
    private String[] options;
    private int correctOptionIndex;

    public Quiz(String question, String[] options, int correctOptionIndex) {
        this.question = question;
        this.options = options;
        this.correctOptionIndex = correctOptionIndex;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }

    public boolean isCorrect(int selectedOptionIndex) {
        return selectedOptionIndex == correctOptionIndex;
    }
}

public class QuizApp {
    private static int score = 0;
    private static int questionIndex = 0;
    private static Timer timer;

    private static Quiz[] quizzes = {
            new Quiz("What is the capital of France?", new String[]{"A. London", "B. Paris", "C. Rome", "D. Berlin"}, 1),
            new Quiz("What is the largest mammal?", new String[]{"A. Elephant", "B. Blue Whale", "C. Giraffe", "D. Lion"}, 1),
            new Quiz("What is the chemical symbol for gold?", new String[]{"A. Au", "B. Ag", "C. Fe", "D. Hg"}, 0)
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        timer = new Timer();

        System.out.println("Welcome to the Quiz App!");

        // Start the quiz
        startNextQuestion(scanner);
    }

    private static void startNextQuestion(Scanner scanner) {
        if (questionIndex < quizzes.length) {
            Quiz currentQuiz = quizzes[questionIndex];
            System.out.println("\nQuestion " + (questionIndex + 1) + ": " + currentQuiz.getQuestion());

            // Display options
            String[] options = currentQuiz.getOptions();
            for (String option : options) {
                System.out.println(option);
            }

            // Start timer
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println("\nTime's up!");
                    showNextQuestion(scanner);
                }
            }, 10000); // 10 seconds

            // Get user's answer
            System.out.print("Enter your answer (A/B/C/D): ");
            String userAnswer = scanner.next().toUpperCase();

            // Check answer
            int selectedOptionIndex = userAnswer.charAt(0) - 'A';
            if (selectedOptionIndex >= 0 && selectedOptionIndex < options.length) {
                if (currentQuiz.isCorrect(selectedOptionIndex)) {
                    System.out.println("Correct!");
                    score++;
                } else {
                    System.out.println("Incorrect!");
                }
            } else {
                System.out.println("Invalid option!");
            }

            // Move to next question
            showNextQuestion(scanner);
        } else {
            // Quiz ends
            System.out.println("\nQuiz ends. Your score is: " + score);
            timer.cancel();
            scanner.close();
        }
    }

    private static void showNextQuestion(Scanner scanner) {
        questionIndex++;
        startNextQuestion(scanner);
    }
}
