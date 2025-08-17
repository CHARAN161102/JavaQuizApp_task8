import java.util.*;

class Question {
    private String questionText;
    private List<String> options;
    private int correctOption; // index starts from 1

    public Question(String questionText, List<String> options, int correctOption) {
        this.questionText = questionText;
        this.options = options;
        this.correctOption = correctOption;
    }

    public String getQuestionText() {
        return questionText;
    }

    public List<String> getOptions() {
        return options;
    }

    public int getCorrectOption() {
        return correctOption;
    }
}

public class QuizApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Question> quiz = new ArrayList<>();

        // Add sample questions
        quiz.add(new Question("Which language is platform independent?",
                Arrays.asList("1. C", "2. C++", "3. Java", "4. Assembly"), 3));
        quiz.add(new Question("Which of these is not an OOP concept?",
                Arrays.asList("1. Inheritance", "2. Encapsulation", "3. Polymorphism", "4. Compilation"), 4));
        quiz.add(new Question("Which keyword is used to inherit a class in Java?",
                Arrays.asList("1. extend", "2. implements", "3. extends", "4. inherit"), 3));

        int score = 0;

        System.out.println("Welcome to the Quiz App ");
        for (int i = 0; i < quiz.size(); i++) {
            Question q = quiz.get(i);
            System.out.println("\nQ" + (i + 1) + ". " + q.getQuestionText());
            for (String opt : q.getOptions()) {
                System.out.println(opt);
            }

            System.out.print("Enter your answer (1-4): ");
            int answer = sc.nextInt();

            if (answer == q.getCorrectOption()) {
                System.out.println(" Correct!");
                score++;
            } else {
                System.out.println(" Wrong! Correct answer: " + q.getCorrectOption());
            }
        }

        System.out.println("\n===== Quiz Finished =====");
        System.out.println("Your Score: " + score + "/" + quiz.size());

        if (score == quiz.size()) {
            System.out.println(" Excellent! Full marks!");
        } else if (score >= quiz.size() / 2) {
            System.out.println(" Good job!");
        } else {
            System.out.println(" Keep practicing!");
        }

        sc.close();
    }
}
