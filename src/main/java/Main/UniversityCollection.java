package Main;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "universitiesInfo")
@XmlAccessorType(XmlAccessType.FIELD)
public class UniversityCollection extends StatFields {
    @XmlElement(name = "universityEntry")
    private ArrayList<University> universities = null;

    public ArrayList<University> getUniversities() {
        return universities;
    }

    public void setUniversities(ArrayList<University> universities) {
        this.universities = universities;
    }
}
