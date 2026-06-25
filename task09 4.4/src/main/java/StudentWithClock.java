import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class StudentWithClock implements Learner {
    private final Learner learner;

    public StudentWithClock(Learner learner) {
        this.learner = learner;
    }

    @Override
    public void learn() {
        learner.learn();

        LocalTime currentTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        System.out.println("Текущее время: " + currentTime.format(formatter));
    }

    public static void main(String[] args) {

        Learner student = new StudentWithClock(new Student());
        student.learn();
    }
}