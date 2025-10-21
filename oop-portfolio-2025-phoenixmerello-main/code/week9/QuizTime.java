package week9;
import java.util.Scanner;

class Question {
    private String questionText;
    private String correctAnswer;

    public Question(String questionText, String correctAnswer) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestionText() {
        return questionText;
    }

    public boolean isCorrect(String userAnswer) {
        return correctAnswer.equalsIgnoreCase(userAnswer.trim());
    }
}

class Quiz {
    private Question[] questions;
    private int count;

    public Quiz() {
        questions = new Question[25];
        count = 0;
    }

    public void add(Question question) {
        if (count < questions.length) {
            questions[count] = question;
            count++;
        }

        else {
            System.out.println("Quiz is full, cannot add more questions");
        }
    }

    public void giveQuiz() {
        Scanner scan = new Scanner(System.in);
        int score = 0;

        for (int i = 0; i < count; i++) {
            System.out.println("Q" + (i +1) + ": " + questions[i].getQuestionText());
            System.out.println("Your answer: ");
            String answer = scan.nextLine();

            if (questions[i].isCorrect(answer)) {
                score++;
            }
        }

        System.out.println("\nQuiz finished. Your Score: " + score + "/" + count);
        scan.close();
    }
}



public class QuizTime {
    public static void main(String[] args) {
        Quiz quiz = new Quiz();

        quiz.add(new Question("What is the Largest cit in the world?", "tokyo"));
        quiz.add(new Question("10 + 65 = ?", "75"));
        quiz.add(new Question("What is the colour of a banana?", "yellow"));
        quiz.add(new Question("What is the capital of Russia?", "moscow"));
        quiz.add(new Question("80 / 5 = ?", "16"));

        quiz.giveQuiz();
    }
}
