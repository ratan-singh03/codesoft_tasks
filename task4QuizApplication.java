import java.util.Scanner;

public class QuizApplication {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        String[] questions = {
            "Which language is used for Android development?",
            "Which keyword is used to create a class in Java?",
            "Which method is the starting point of a Java program?",
            "Which symbol is used to end a Java statement?"
        };

        String[][] options = {
            {"1. Java", "2. HTML", "3. CSS", "4. SQL"},
            {"1. function", "2. class", "3. create", "4. newclass"},
            {"1. start()", "2. run()", "3. main()", "4. begin()"},
            {"1. :", "2. .", "3. ;", "4. ,"}
        };

        int[] answers = {1, 2, 3, 3};

        int score = 0;

        System.out.println("===== JAVA QUIZ =====");
        System.out.println("You have 10 seconds for each question.\n");

        for (int i = 0; i < questions.length; i++) {

            System.out.println("Question " + (i + 1));
            System.out.println(questions[i]);

            for (String option : options[i]) {
                System.out.println(option);
            }

            System.out.print("Your answer: ");

            long startTime = System.currentTimeMillis();

            int answer = sc.nextInt();

            long endTime = System.currentTimeMillis();

            long timeTaken = (endTime - startTime) / 1000;

            if (timeTaken > 10) {
                System.out.println("Time's up!");
            } else if (answer == answers[i]) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong answer!");
            }

            System.out.println();
        }

        System.out.println("===== RESULT =====");
        System.out.println("Total Questions: " + questions.length);
        System.out.println("Correct Answers: " + score);
        System.out.println("Wrong Answers: " + (questions.length - score));
        System.out.println("Final Score: " + score + "/" + questions.length);

        sc.close();
    }
}