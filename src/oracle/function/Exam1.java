package oracle.function;



public class Exam1 {
    private String ExamId;
    private String question;
    private String Duration;

    public Exam1(String ExamId, String question, String Duration) {
        this.ExamId = ExamId;
        this.question = question;
        this.Duration = Duration;
    }
     public Exam1() {
    }

    public String getDuration() {
        return Duration;
    }

    public void setDuration(String Duration) {
        this.Duration = Duration;
    }

    public String getExamId() {
        return ExamId;
    }

    public void setExamId(String ExamId) {
        this.ExamId = ExamId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
     
}
