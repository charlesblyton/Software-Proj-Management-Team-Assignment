package src;

//Test class to display a list of groups for PBI19 demonstration
public class testGroup {

    private int testGroupID;
    private String firstStudent;
    private String secondStudent;
    private String thirdStudent;
    private String fourthStudent;
    private String fifthStudent;
    private String sixthStudent;
    private String seventhStudent;

    public testGroup (String firstStudent, String secondStudent, String thirdStudent, String fourthStudent, String fifthStudent, String sixthStudent, String seventhStudent) {
        this.firstStudent = firstStudent;
        this.secondStudent = secondStudent;
        this.thirdStudent = thirdStudent;
        this.fourthStudent = fourthStudent;
        this.fifthStudent = fifthStudent;
        this.sixthStudent = sixthStudent;
        this.seventhStudent = seventhStudent;
    }

    public int getTestGroupID () {
        return testGroupID;
    }

    public String getFirstStudent () {
        return firstStudent;
    }

    public void setFirstStudent(String firstStudent) {
        this.firstStudent = firstStudent;
    }

    public String getSecondStudent () {
        return secondStudent;
    }

    public void setSecondStudent(String secondStudent) {
        this.secondStudent = secondStudent;
    }

    public String getThirdStudent () {
        return thirdStudent;
    }

    public void setThirdStudent(String thirdStudent) {
        this.thirdStudent = thirdStudent;
    }

    public String getFourthStudent () {
        return fourthStudent;
    }

    public void setFourthStudent(String fourthStudent) {
        this.fourthStudent = fourthStudent;
    }

    public String getFifthStudent () {
        return fifthStudent;
    }

    public void setFifthStudent(String fifthStudent) {
        this.fifthStudent = fifthStudent;
    }

    public String getSixthStudent () {
        return fifthStudent;
    }

    public void setSixthStudent(String sixthStudent) {
        this.sixthStudent = sixthStudent;
    }

    public String getSeventhStudent () {
        return seventhStudent;
    }

    public void setSeventhStudent(String seventhStudent) {
        this.seventhStudent = seventhStudent;
    }

    public String toString() {
        return "Group ID: " + this.testGroupID + ", First Student: " + this.firstStudent + ", Second Student: " + this.secondStudent + ", Third Student: " + this.thirdStudent + ", Fourth Student: " + this.fourthStudent + ", Fifth Student: " + this.fifthStudent + ", Sixth Student: " + this.sixthStudent + ", Seventh Student: " + this.seventhStudent;
    }
}