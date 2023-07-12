import com.google.gson.annotations.SerializedName;

public class University {
    @SerializedName("ID")
    private String id;
    @SerializedName("UniversityFullName")
    private String fullName;
    @SerializedName("UniversityShortName")
    private String shortName;
    @SerializedName("YearOfFoundation")
    private int yearOfFoundation;
    @SerializedName("MainProfile")
    private StudyProfile mainProfile;

    public University() {
        this("", "", "", 1900, StudyProfile.NOT_DEFINED);
    }

    public University(String id, String fullName, String shortName, int yearOfFoundation, StudyProfile mainProfile) {
        this.id = id;
        this.fullName = fullName;
        this.shortName = shortName;
        this.yearOfFoundation = yearOfFoundation;
        this.mainProfile = mainProfile;
    }

    @Override
    public String toString() {
        StringBuffer result = new StringBuffer();
        result.append("ID: ").append(id).append("\n");
        result.append("Full name: ").append(fullName).append("\n");
        result.append("Short name: ").append(shortName).append("\n");
        result.append("Year of foundation: ").append(yearOfFoundation).append("\n");
        result.append("Main profile: ").append(mainProfile.toString()).append("\n");

        return result.toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public int getYearOfFoundation() {
        return yearOfFoundation;
    }

    public void setYearOfFoundation(int yearOfFoundation) {
        this.yearOfFoundation = yearOfFoundation;
    }

    public StudyProfile getMainProfile() {
        return mainProfile;
    }

    public void setMainProfile(StudyProfile mainProfile) {
        this.mainProfile = mainProfile;
    }
}
