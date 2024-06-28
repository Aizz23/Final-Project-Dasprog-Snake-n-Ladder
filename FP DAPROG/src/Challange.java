import java.util.Scanner;

class Challange {
    private int fromPosition;
    private int toPosition;
    private String question;
    private String answer;

    public Challange(int fromPosition, String question, String answer) {
        this.fromPosition = fromPosition;
        this.toPosition = fromPosition + 10; // misal tantangan selalu menggerakkan 10 posisi maju jika dijawab benar
        this.question = question;
        this.answer = answer;
    }

    public int getFromPosition() {
        return this.fromPosition;
    }

    public void setFromPosition(int fromPosition) {
        this.fromPosition = fromPosition;
    }

    public int getToPosition() {
        return this.toPosition;
    }

    public void setToPosition(int toPosition) {
        this.toPosition = toPosition;
    }

    public String getQuestion() {
        return this.question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return this.answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean askQuestion() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Challenge: " + this.question);
        String playerAnswer = scanner.nextLine();
        return playerAnswer.equalsIgnoreCase(this.answer);
    }
}
