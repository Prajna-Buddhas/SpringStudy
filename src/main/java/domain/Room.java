package domain;

import org.springframework.beans.factory.annotation.Autowired;

public class Room {
    private String roomName;
    @Autowired
    private Teacher teacher;

    public Room() {
    }

    public Room(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomName() {
        return roomName;
    }

    public Room(String roomName, Teacher teacher) {
        this.roomName = roomName;
        this.teacher = teacher;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomName='" + roomName + '\'' +
                ", teacher=" + teacher +
                '}';
    }
}
