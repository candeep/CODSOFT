public class QuizApp {
    public static void main(String[] args) {
        Question[] questions = {
            new Question("What is the capital of France?", new String[]{"Berlin", "Madrid", "Paris", "Rome"}, 2),
            new Question("What is 2 + 2?", new String[]{"3", "4", "5", "6"}, 1),
            new Question("Which planet is known as the Red Planet?", new String[]{"Earth", "Mars", "Jupiter", "Saturn"}, 1),
            new Question("What is the largest ocean on Earth?", new String[]{"Atlantic Ocean", "Indian Ocean", "Arctic Ocean", "Pacific Ocean"}, 3)
        };

        Quiz quiz = new Quiz(questions);
        quiz.start();
    }
}
