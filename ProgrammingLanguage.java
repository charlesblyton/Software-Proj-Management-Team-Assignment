public class ProgrammingLanguage {

    private int programmingLanguageId;
    private String prgLanguage;

    public ProgrammingLanguage (String javaLanguage, String pythonLanguage) {
        this.prgLanguage = prgLanguage;
    }

    public int getProgrammingLanguageId () {
        return programmingLanguageId;
    }

    public String getPrgLanguage () {
        return prgLanguage;
    }

    public void setProgrammingLanguageId (int programmingLanguageId) {
        this.programmingLanguageId = programmingLanguageId;
    }

    public void setPrgLanguage (String prgLanguage) {
        this.prgLanguage = prgLanguage;
    }

    public String toString () {
        return " Program Language: " +prgLanguage;
    }
}
