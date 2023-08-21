import DataOutput.Marshalling;
import DataOutput.XmlOutput;
import Statistics.*;
import XLSX.XLSXRead;
import Main.*;
import org.apache.poi.EmptyFileException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import javax.xml.bind.JAXBException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    protected static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) throws IOException, URISyntaxException, ClassNotFoundException, JAXBException {

//        Marshalling.marshalingExample();

        logger.info("--- Application started. ---");
        URL resource = Main.class.getResource("universityInfo.xlsx");
        assert resource != null;
        final String FILE_NAME = Paths.get(resource.toURI()).toFile().getAbsolutePath();
        try {
            FileInputStream inputStream = new FileInputStream(FILE_NAME);
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet sheetStudents = workbook.getSheet("Студенты");
            XSSFSheet sheetUniversities = workbook.getSheet("Университеты");

            XLSXRead reader = XLSXRead.INSTANCE;

            StudentCollection students = new StudentCollection();
            students.setStudents(reader.getStudents(sheetStudents));
            UniversityCollection universities = new UniversityCollection();
            universities.setUniversities(reader.getUnivetsities(sheetUniversities));
            StatisticsCollection statistics = new StatisticsCollection();
            statistics.setStatistics(StatCalc.calculation(students.getStudents(), universities.getUniversities()));

//            XLSXWriter xlsxWriter = XLSXWriter.INSTANCE;
//            xlsxWriter.create(statistics.getStatistics(), "out/statistics.xlsx");

//            XmlOutput xmlOutput = new XmlOutput(new Object[]{students});
//            xmlOutput.out();
            DataCollection dataCollection = new DataCollection();
            List<StatFields> fields = new ArrayList<>();
            fields.add(students);
            fields.add(universities);
            fields.add(statistics);
            dataCollection.setCollections(fields);
            XmlOutput xmlOutputTest = new XmlOutput(students, dataCollection);
            xmlOutputTest.out();

        } catch (FileNotFoundException e) {
            logger.error("Input file not found, exit.");
            System.exit(1);
        } catch (EmptyFileException e) {
            logger.error("File is empty or blocked.");
        } catch (JAXBException e) {
            e.printStackTrace();
            logger.error("JAXB throws Exception.");
        }


        logger.info("--- Application finished. ---");
    }
}
