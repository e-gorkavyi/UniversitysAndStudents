package Main;

import com.google.gson.annotations.Expose;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "universitiesInfo")
@XmlAccessorType(XmlAccessType.FIELD)
public class UniversityCollection extends StatFields {
    @Expose
    @XmlElement(name = "universityEntry")
    private List<University> universities = null;

    public List<University> getUniversities() {
        return universities;
    }

    public void setUniversities(List<University> universities) {
        this.universities = universities;
    }
}
