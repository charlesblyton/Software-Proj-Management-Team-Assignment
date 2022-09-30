public class Student {
    
    private int studentId;
    private String studentName;
    private int studentNum;
    private String workshop;

    public Student (String studentName, int studentId, String workshop) {
        this.studentName = studentName;
        this.studentNum = studentNum;
        this.workshop = workshop;
    }

    public int getStudentId () {
        return studentId;
    }
    
    public String getStudentName () {
        return studentName;
    }

    public int getStudentNum () {
        return studentNum;
    }

    public String getWorkshop () {
        return workshop;
    }

    public void setStudentId (int studentId) {
        this.studentId = studentId;
    }

    public void setStudentName (String studentName) {
        this.studentName = studentName;
    }

    public void setStudentNum (int studentNum) {
        this.studentNum = studentNum;
    }

    public void setWorkshop (String workshop) {
        this.workshop = workshop;
    }

    public String toString () {
        return "Student ID: " + studentId + ", Name: " + studentName + "Student Number: " + studentNum + " Current workshop: " + workshop;
    }
}