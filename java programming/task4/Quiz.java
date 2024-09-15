import java.util.Scanner;
import java.util.concurrent.TimeUnit;

class Quiz {
    private Question[] questions;
    private int score;
    private static final int TIME_LIMIT = 10; // seconds

    public Quiz(Question[] questions) {
        this.questions = questions;
        this.score = 0;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        for (Question question : questions) {
            System.out.println(question.getQuestionText());
            String[] options = question.getOptions();
            for (int i = 0; i < options.length; i++) {
                System.out.println((i + 1) + ". " + options[i]);
            }

            System.out.print("You have " + TIME_LIMIT + " seconds to answer. Your answer: ");

            // Start a timer thread
            Timer timer = new Timer(TIME_LIMIT);
            timer.start();

            int answerIndex = -1;
            try {
                answerIndex = scanner.nextInt() - 1; // User input
                timer.interrupt(); // Stop the timer if answered in time
            } catch (Exception e) {
                System.out.println("Time's up or invalid input!");
                scanner.next(); // Clear invalid input
            }

            if (answerIndex >= 0 && answerIndex < options.length) {
                if (question.isCorrect(answerIndex)) {
                    System.out.println("Correct!");
                    score++;
                } else {
                    System.out.println("Incorrect! The correct answer was: " + options[question.correctAnswerIndex]);
                }
            } else {
                System.out.println("Invalid option selected.");
            }

            System.out.println();
        }

        displayResults();
    }

    private void displayResults() {
        System.out.println("Quiz finished! Your final score: " + score + "/" + questions.length);
    }

    private class Timer extends Thread {
        private int timeLimit;

        public Timer(int timeLimit) {
            this.timeLimit = timeLimit;
        }

        @Override
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(timeLimit);
                System.out.println("Time's up!");
                System.exit(0); // Exit the quiz if time runs out
            } catch (InterruptedException e) {
                // Timer interrupted, do nothing
            }
        }
    }
}
