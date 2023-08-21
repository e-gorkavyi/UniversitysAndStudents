package Main;

import Statistics.StatisticsCollection;

import java.util.Collection;
import java.util.List;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({StudentCollection.class, UniversityCollection.class, StatisticsCollection.class})
public class DataCollection {
    @XmlAnyElement
    private List<StatFields> collections = null;

    public List<StatFields> getCollections() {
        return collections;
    }

    public void setCollections(List<StatFields> collections) {
        this.collections = collections;
    }
}

