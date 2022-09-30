public class Platform {
    
    private int platformId;
    private String applicationList;
    private String workshopNo;

    public Platform (String applicationList, String workshopNo) {
        this.applicationList = applicationList;
        this.workshopNo = workshopNo;
    }

    public int getPlatformId () {
        return platformId;
    }
    
    public String getApplicationList () {
        return applicationList;
    }

    public String getworkshopNo () {
        return workshopNo;
    }

    public void setPlatformId (int platformId) {
        this.platformId = platformId;
    }

    public void setApplicationList (String applicationList) {
        this.applicationList = applicationList;
    }

    public void setWorkshopNp (String workshopNo) {
        this.workshopNo = workshopNo;
    }

    public String toString () {
        return "Platform / Application use: " + applicationList + " Workshop: " + workshopNo;
    }
}