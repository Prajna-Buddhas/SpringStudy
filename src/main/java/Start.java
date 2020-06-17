import config.Config;
import domain.Course;
import domain.RoomOne;
import domain.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Start {
    public static void main(String[] args) {
//        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        RoomOne roomOne1 = (RoomOne) context.getBean("RoomOne1");
//        Student student = (Student) context.getBean("student");
        System.out.println(roomOne1);
        for (Object course:
             roomOne1.getList()) {
            System.out.println(course);
        }

        RoomOne roomOne2 = (RoomOne) context.getBean("RoomOne2");
        System.out.println(roomOne2);
        for (Object course:
                roomOne2.getList()) {
            System.out.println(course);
        }
    }
}
