package Main;

import Statistics.StatisticsCollection;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.xml.bind.annotation.*;
import java.text.SimpleDateFormat;
import java.util.List;

@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({StudentCollection.class, UniversityCollection.class, StatisticsCollection.class})
public class DataCollection {
    @SerializedName("root")
    @Expose
    @XmlAnyElement
    private List<StatFields> collections = null;
    @XmlElement
    @Expose
    private String processedAt = new SimpleDateFormat("yyyy-MM-dd'T'HH-mm-ss.SSSXXX")
            .format(System.currentTimeMillis());

    public List<StatFields> getCollections() {
        return collections;
    }

    public void setCollections(List<StatFields> collections) {
        this.collections = collections;
    }
}

