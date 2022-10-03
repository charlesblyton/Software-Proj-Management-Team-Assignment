package CharlieExampleClasses;

public class Property {
    private String property;
    private String location;
    private String description;
    private String accomType;
    private String hostName;
    private int maxGuests;
    private double rating;
    private final double pricePerNight;
    private double serviceFee;
    private double cleaningFee;
    private int weeklyDiscount;


    public Property(String property, String location, String description, String accomType, String hostName, int maxGuests, double rating, double pricePerNight, double serviceFee, double cleaningFee, int weeklyDiscount) {
        this.property = property;
        this.location = location;
        this.description = description;
        this.accomType = accomType;
        this.hostName = hostName;
        this.maxGuests = maxGuests;
        this.rating = rating;
        this.pricePerNight = pricePerNight;
        this.serviceFee = serviceFee;
        this.cleaningFee = cleaningFee;
        this.weeklyDiscount = weeklyDiscount;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String name) {
        this.property = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAccomType() {
        return accomType;
    }

    public void setAccomType(String accomType) {
        this.accomType = accomType;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public int getMaxGuests() {
        return maxGuests;
    }

    public void setMaxGuests(int maxGuests) {
        this.maxGuests = maxGuests;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(double serviceFee) {
        this.serviceFee = serviceFee;
    }

    public double getCleaningFee() {
        return cleaningFee;
    }

    public void setCleaningFee(double cleaningFee) {
        this.cleaningFee = cleaningFee;
    }

    public int getWeeklyDiscount() {
        return weeklyDiscount;
    }

    public void setWeeklyDiscount(int weeklyDiscount) {
        this.weeklyDiscount = weeklyDiscount;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Property{");
        sb.append("property='").append(property).append('\'');
        sb.append(", location='").append(location).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", accomType='").append(accomType).append('\'');
        sb.append(", hostName='").append(hostName).append('\'');
        sb.append(", maxGuests=").append(maxGuests);
        sb.append(", rating=").append(rating);
        sb.append(", pricePerNight=").append(pricePerNight);
        sb.append(", serviceFee=").append(serviceFee);
        sb.append(", cleaningFee=").append(cleaningFee);
        sb.append(", weeklyDiscount=").append(weeklyDiscount);
        sb.append('}');
        return sb.toString();
    }
}
