import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class OnlineExamination {
    private String username;
    private String password;
    private int score;

    public OnlineExamination(String username, String password) {
        this.username = username;
        this.password = password;
        this.score = 0;
    }

    public void login() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String inputUsername = scanner.nextLine();
        System.out.print("Enter password: ");
        String inputPassword = scanner.nextLine();

        if (inputUsername.equals(username) && inputPassword.equals(password)) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    public void updateProfileAndPassword() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter new username: ");
        String newUsername = scanner.nextLine();
        System.out.print("Enter new password: ");
        String newPassword = scanner.nextLine();

        username = newUsername;
        password = newPassword;

        System.out.println("Profile and password updated successfully!");
    }

    public void selectAnswersForMCQs() {
        // Implement MCQ questions and answers here
        // For demonstration purposes, let's assume we have 5 questions
        String[] questions = {"What is the capital of France?", "What is the largest planet in our solar system?", "What is the smallest country in the world?", "What is the most popular programming language?", "What is the largest living species of lizard?"};
        String[] answers = {"Paris", "Jupiter", "Vatican City", "Java", "Komodo dragon"};

        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);
            Scanner scanner = new Scanner(System.in);
            String userAnswer = scanner.nextLine();

            if (userAnswer.equals(answers[i])) {
                score++;
                System.out.println("Correct answer!");
            } else {
                System.out.println("Incorrect answer. The correct answer is " + answers[i]);
            }
        }

        System.out.println("Your score is " + score + " out of " + questions.length);
    }

    public void timerAndAutoSubmit() {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Time's up! Your score is " + score + " out of " + 5);
                System.exit(0);
            }
        };

        timer.schedule(task, 300000); // 5 minutes

        selectAnswersForMCQs();
    }

    public void closingSessionAndLogout() {
        System.out.println("Closing session and logging out...");
        System.exit(0);
    }

    public static void main(String[] args) {
        OnlineExamination onlineExamination = new OnlineExamination("admin", "password");
        onlineExamination.login();
        onlineExamination.updateProfileAndPassword();
        onlineExamination.timerAndAutoSubmit();
        onlineExamination.closingSessionAndLogout();
    }
}