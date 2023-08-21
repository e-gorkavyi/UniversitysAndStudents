package Statistics;

import Main.StatFields;
import com.google.gson.annotations.Expose;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name = "statisticalInfo")
@XmlAccessorType(XmlAccessType.FIELD)
public class StatisticsCollection extends StatFields {
    @Expose
    @XmlElement(name = "statisticsEntry")
    private ArrayList<Statistics> statistics = null;

    public ArrayList<Statistics> getStatistics() {
        return statistics;
    }

    public void setStatistics(ArrayList<Statistics> statistics) {
        this.statistics = statistics;
    }
}
