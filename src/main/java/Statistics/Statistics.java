package Statistics;

import Main.StudyProfile;

import java.util.List;

public class Statistics {
    private StudyProfile studyProfile;
    private double avgExamScore;
    private long studentsByProfile;
    private long universitiesByProfile;
    private List<String> universitiesNames;

    public Statistics(){}

    public Statistics(StudyProfile studyProfile,
                      double avgExamScore,
                      int studentsByProfile,
                      int universitiesByProfile,
                      List<String> universitiesNames) {
        this.studyProfile = studyProfile;
        this.avgExamScore = avgExamScore;
        this.studentsByProfile = studentsByProfile;
        this.universitiesByProfile = universitiesByProfile;
        this.universitiesNames = universitiesNames;
    }

    public StudyProfile getStudyProfile() {
        return studyProfile;
    }

    public void setStudyProfile(StudyProfile studyProfile) {
        this.studyProfile = studyProfile;
    }

    public double getAvgExamScore() {
        return avgExamScore;
    }

    public void setAvgExamScore(double avgExamScore) {
        this.avgExamScore = avgExamScore;
    }

    public long getStudentsByProfile() {
        return studentsByProfile;
    }

    public void setStudentsByProfile(long studentsByProfile) {
        this.studentsByProfile = studentsByProfile;
    }

    public long getUniversitiesByProfile() {
        return universitiesByProfile;
    }

    public void setUniversitiesByProfile(long universitiesByProfile) {
        this.universitiesByProfile = universitiesByProfile;
    }

    public List<String> getUniversitiesNames() {
        return universitiesNames;
    }

    public void setUniversitiesNames(List<String> universitiesNames) {
        this.universitiesNames = universitiesNames;
    }
}
