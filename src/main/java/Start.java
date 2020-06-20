import domain.Info;
import utils.JdbcUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Start {
    public static void main(String[] args) throws SQLException {
//        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
//        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
//        RoomOne roomOne1 = (RoomOne) context.getBean("RoomOne1");
////        Student student = (Student) context.getBean("student");
//        System.out.println(roomOne1);
//        for (Object course:
//             roomOne1.getList()) {
//            System.out.println(course);
//        }
//
//        RoomOne roomOne2 = (RoomOne) context.getBean("RoomOne2");
//        System.out.println(roomOne2);
//        for (Object course:
//                roomOne2.getList()) {
//            System.out.println(course);
//        }
        ResultSet rs = JdbcUtil.select("SELECT * FROM TEST");
        ArrayList<Info> infos = new ArrayList<Info>();
        System.out.println("id\tcourse_id\tstudent_id\tscore");
        while (rs.next()) {
            int sno = rs.getInt(1);
            int course_id = rs.getInt(2);
            int student_id = rs.getInt(3);
            int score = rs.getInt(4);
            infos.add(new Info(sno, course_id, student_id, score));
            System.out.println(sno + "\t" + course_id + "\t\t\t" + student_id + "\t\t" + score);
        }
        JdbcUtil.close(rs);
    }
}
