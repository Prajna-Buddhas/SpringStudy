package domain;


public class Student {
    private String name;
    private Room room;

    public Student() {
    }

    public Student(String name, Room room) {
        this.name = name;
        this.room = room;
    }

    public Student(String name) {

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", room=" + room +
                '}';
    }
}
