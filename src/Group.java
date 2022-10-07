package src;

import java.util.ArrayList;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicInteger;

public class Group {

    private static final AtomicInteger idGenerator = new AtomicInteger(1);

    private final int id;

    private int maxGroupSize;
    private ArrayList<Student> studentList;
    private Language language;
    private Platform platform;
    private TimeZone timeZone;


    public Group(int maxGroupSize) {
        this.id = idGenerator.getAndIncrement(); //Giving each instantiated group a unique ID
        this.maxGroupSize = maxGroupSize;
    }

    public int getID() {
        return id;
    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }

    public void addStudent(Student newStudent){
        studentList.add(newStudent);
    }

    public Language getProgrammingLanguage() {
        return language;
    }

    public void setProgrammingLanguage(Language language) {
        this.language = language;
    }

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    public TimeZone getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(TimeZone timeZone) {
        this.timeZone = timeZone;
    }
}