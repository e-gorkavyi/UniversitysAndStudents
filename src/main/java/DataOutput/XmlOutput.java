package DataOutput;

import Main.DataCollection;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;

public class XmlOutput {
    static DataCollection dataCollection = new DataCollection();
    private String filePath;

    private XmlOutput() {
        this(null, null);
    }

    public XmlOutput(DataCollection dataCOl, String filePath) {
        dataCollection = dataCOl;
        this.filePath = filePath;
    }

    public void out() throws JAXBException {
        String outFileName = filePath.replaceAll(
                "--datetime--",
                new SimpleDateFormat("yyyy-MM-dd'T'HH-mm-ss.SSS")
                        .format(System.currentTimeMillis()));
        File dir = new File(Paths.get(outFileName).getParent().toUri());
        if (!dir.exists())
            dir.mkdirs();
        JAXBContext context = JAXBContext.newInstance(DataCollection.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(dataCollection, new File(outFileName));

    }
}

