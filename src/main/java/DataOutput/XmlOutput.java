package DataOutput;

import Main.DataCollection;
import Main.StatFields;
import Main.StudentCollection;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

public class XmlOutput {
    private final String XML_FILE_NAME = "xmlReqs/req_--datetime--.xml";
    static DataCollection dataCollection = new DataCollection();
    static StudentCollection studentCollection = new StudentCollection();

    private XmlOutput() {
        this( null);
    }

    public XmlOutput(StatFields[] collections){
        dataCollection.getCollections().addAll(List.of(collections));
    }

    public XmlOutput(StudentCollection collection, DataCollection dataCOl) {
        studentCollection = collection;
        dataCollection = dataCOl;
    }

    public void out() throws JAXBException {
        String outFileName = XML_FILE_NAME.replaceAll(
                "--datetime--",
                new SimpleDateFormat("yyyy-MM-dd'T'HH-mm-ss.SSS")
                        .format(System.currentTimeMillis()));
        File dir = new File(Paths.get(outFileName).getParent().toUri());
        System.out.println(outFileName);
        if (!dir.exists())
            dir.mkdirs();
        System.out.println(dataCollection.getClass());
        JAXBContext context = JAXBContext.newInstance(DataCollection.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(dataCollection, System.out);
//        marshaller.marshal(dataCollection, new File(outFileName));
    }

    public void testOut() throws JAXBException {
        String outFileName = XML_FILE_NAME.replaceAll(
                "--datetime--",
                new SimpleDateFormat("yyyy-MM-dd'T'HH-mm-ss.SSS")
                        .format(System.currentTimeMillis()));
        File dir = new File(Paths.get(outFileName).getParent().toUri());
        JAXBContext jaxbContext = JAXBContext.newInstance(StudentCollection.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(studentCollection, System.out);
    }
}

