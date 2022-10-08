package src;

public class Student {
    private String id;
    private String startTime;
    private String completionTime;
    private String email;
    private String name;
    private String fnameLname;
    private String studentID;
    private String workshopClass;
    private String preferableTeammates;
    private String projectOption;
    private String itlanguage;
    private String timezone;
    private String preferableDays;
    private String preferableTime;


    public Student(String id, String startTime, String completionTime, String email, String name, String fnameLname, String studentID, String workshopClass, String preferableTeammates, String projectOption, String ITlanguage, String timezone, String preferableDays, String preferableTime ) {
        this.id                  = id;
        this.startTime           = startTime;
        this.completionTime      = completionTime;
        this.email               = email;
        this.name                = name;
        this.fnameLname          = fnameLname;
        this.studentID           = studentID;
        this.workshopClass       = workshopClass;
        this.preferableTeammates = preferableTeammates;
        this.projectOption       = projectOption;
        this.itlanguage            = ITlanguage;
        this.timezone            = timezone;
        this.preferableDays      = preferableDays;
        this.preferableTime      = preferableTime;

    }

    public String getId() {
        return id;
    }

    public void setId (String id) {
        this.id = id;

    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime (String stime) {
        this.startTime = stime;
    }

    public String getCompletionTime() {
        return completionTime;
    }

    public void setCompletionTime (String ctime) {
        this.completionTime = ctime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail (String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getFnameLname() {
        return fnameLname;
    }

    public void setFnameLname (String fnamelname) {
        this.fnameLname = fnamelname;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID (String studentID) {
        this.studentID = studentID;
    }

    public String getWorkshopClass() {
        return workshopClass;
    }

    public void setWorkshopClass (String workshop) {
        this.workshopClass = workshop;
    }

    public String getPreferableTeammates() {
        return preferableTeammates;
    }

    public void setPreferableTeammates (String teammates) {
        this.preferableTeammates = teammates;
    }

    public String getProjectOption() {
        return projectOption;
    }

    public void setProjectOption (String poption) {
        this.projectOption = poption;
    }

    public String getItlanguage() {
        return itlanguage;
    }

    public void setItlanguage(String language) {
        this.itlanguage = language;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone (String timezone) {
        this.timezone = timezone;
    }

    public String getPreferableDays() {
        return preferableDays;
    }

    public void setPreferableDays (String pdays) {
        this.preferableDays = pdays;
    }

    public String getPreferableTime() {
        return preferableTime;
    }

    public void setPreferableTime (String ptime) {
        this.preferableTime = ptime;
    }



    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Value{");
        sb.append("id='").append(id).append('\'');
        sb.append(", startTime='").append(startTime).append('\'');
        sb.append(", completionTime='").append(completionTime).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append("firstnameLastname='").append(fnameLname).append('\'');
        sb.append(", studentID='").append(studentID).append('\'');
        sb.append(", workshopClass='").append(workshopClass).append('\'');
        sb.append(", preferableTeammates='").append(preferableTeammates).append('\'');
        sb.append(", projectOption='").append(projectOption).append('\'');
        sb.append("ITLanguage='").append(itlanguage).append('\'');
        sb.append(", timezone='").append(timezone).append('\'');
        sb.append(", preferableDays='").append(preferableDays).append('\'');
        sb.append(", preferableTime='").append(preferableTime).append('\'');
        sb.append('}');
        return sb.toString();
    }
    public String toStringSimplified() {
        final StringBuilder sb = new StringBuilder("Student " + id + "{");
        sb.append(", name='").append(name).append('\'');
        sb.append(", studentID='").append(studentID).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", workshopClass='").append(workshopClass).append('\'');
        sb.append(", preferableTeammates='").append(preferableTeammates).append('\'');
        sb.append(", projectOption='").append(projectOption).append('\'');
        sb.append("ITLanguage='").append(itlanguage).append('\'');
        sb.append(", timezone='").append(timezone).append('\'');
        sb.append('}');
        return sb.toString();
    }
}







   




