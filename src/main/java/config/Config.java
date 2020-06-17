package config;

import domain.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.ArrayList;


@Configuration
@ComponentScan(basePackages = "domain")
public class Config {

    /**
     * <bean name="student" class="domain.Student">
     *         <property name="name" value="zhangsan"/>
     *         <property name="room" ref="room" />
     *     </bean>
     * @param name
     * @param room
     * @return
     */
    @Bean
    @Scope("singleton")
    public Student student(@Value("zhangsan") String name,Room room) {
        return new Student(name,room);
    }

    /**
     * <bean name="room" class="domain.Room">
     *         <property name="roomName" value="软件实训"/>
     *         <property name="teacher" ref="teacher"/>
     *     </bean>
     * @param roomName
     * @return
     */
    @Bean
    public Room room(@Value("大帅哥") String roomName) {
        return new Room(roomName);
    }

    /**
     * <bean name="teacher" class="domain.Teacher">
     *         <property name="name" value="陈龙"/>
     *     </bean>
     * @param name
     * @return
     */
    @Bean
    public Teacher teacher(@Value("大帅哥") String name) {
        return new Teacher(name);
    }

    /**
     * <bean name="RoomOne" class="domain.RoomOne">
     *         <property name="list" >
     *             <list>
     *                 <bean class="domain.Course">
     *                     <property name="cid" value="1"/>
     *                     <property name="cname" value="高数"/>
     *                 </bean>
     *                 <bean class="domain.Course">
     *                     <property name="cid" value="2"/>
     *                     <property name="cname" value="离散"/>
     *                 </bean>
     *                 <bean class="domain.Course">
     *                     <property name="cid" value="3"/>
     *                     <property name="cname" value="现代"/>
     *                 </bean>
     *             </list>
     *         </property>
     *     </bean>
     * @param courses
     * @return
     */
    @Bean
    public RoomOne roomOne(ArrayList<Course> courses) {
        courses.add(new Course(1,"高数"));
        courses.add(new Course(2, "线代"));
        courses.add(new Course(3, "离散"));
        return new RoomOne(courses);
    }

    @Bean
    public Course course() {
        return new Course();
    }
}
