package Statistics;

import Main.StatFields;
import Main.StudyProfile;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "statisticsEntry")
@XmlAccessorType(XmlAccessType.FIELD)
public class Statistics {
    @Expose
    @SerializedName("universityProfile")
    @XmlElement(name = "universityProfile")
    private StudyProfile studyProfile;
    @Expose
    @SerializedName("avgScore")
    @XmlElement(name = "avgScore")
    private double avgExamScore;
    @XmlTransient
    private long studentsByProfile;
    @XmlTransient
    private long universitiesByProfile;
    @XmlTransient
    private List<String> universitiesNames;

    public Statistics() {
    }

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
