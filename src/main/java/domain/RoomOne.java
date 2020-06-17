package domain;

import java.util.ArrayList;
import java.util.List;

public class RoomOne {
    private String className;
    private ArrayList<Course> list = new ArrayList();

    public RoomOne(ArrayList<Course> list) {
        this.list = list;
    }

    public ArrayList getList() {
        return list;
    }

    public void setList(ArrayList<Course> list) {
        this.list = list;
    }

    public RoomOne() {
    }

    @Override
    public String toString() {
        return "RoomOne{" +
                "className='" + className + '\'' +
                ", list=" + list +
                '}';
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
