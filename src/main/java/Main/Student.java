package Main;

import com.google.gson.annotations.SerializedName;

public class Student {
    @SerializedName("StudentFullName")
    private String fullName;
    @SerializedName("UniversityID")
    private String universityId;
    @SerializedName("CurrentCourseNumber")
    private int currentCourseNumber;
    @SerializedName("AverageExamScore")
    private float avgExamScore;

    public boolean equalsByID(University university) {
        return this.universityId.equals(university.getId());
    }

    public Student() {
        this("", "", 0, 0);
    }

    public Student(String fullName, String universityId, int currentCourseNumber, float avgExamScore) {
        this.fullName = fullName;
        this.universityId = universityId;
        this.currentCourseNumber = currentCourseNumber;
        this.avgExamScore = avgExamScore;
    }

    @Override
    public String toString() {
        StringBuffer result = new StringBuffer();
        result.append("Full name: ").append(fullName).append("\n");
        result.append("Main.University ID: ").append(universityId).append("\n");
        result.append("Current course number: ").append(currentCourseNumber).append("\n");
        result.append("Average exam score: ").append(avgExamScore).append("\n");

        return result.toString();
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUniversityId() {
        return universityId;
    }

    public void setUniversityId(String universityId) {
        this.universityId = universityId;
    }

    public int getCurrentCourseNumber() {
        return currentCourseNumber;
    }

    public void setCurrentCourseNumber(int currentCourseNumber) {
        this.currentCourseNumber = currentCourseNumber;
    }

    public float getAvgExamScore() {
        return avgExamScore;
    }

    public void setAvgExamScore(float avgExamScore) {
        this.avgExamScore = avgExamScore;
    }
}

