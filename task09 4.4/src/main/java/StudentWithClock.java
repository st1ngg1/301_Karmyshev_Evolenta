import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class StudentWithClock {
    private String name;
    
    public StudentWithClock(String name) {
        this.name = name;
    }
    
    public void learn() {
        System.out.println("Я учусь. .zZ");
        
        LocalTime currentTime = LocalTime.now();
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formattedTime = currentTime.format(formatter);
        System.out.println("Я закончил учиться");
        System.out.println("Текущее время: " + formattedTime);
    }
    
    public static void main(String[] args) {
        StudentWithClock student = new StudentWithClock("Студент");
        student.learn();
    }
}