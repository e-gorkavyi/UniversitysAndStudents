import Comparators.*;
import DataOutput.JsonOutput;
import DataOutput.XmlOutput;
import Main.DataCollection;
import Main.StatFields;
import Main.StudentCollection;
import Main.UniversityCollection;
import Statistics.StatCalc;
import Statistics.StatisticsCollection;
import XLSX.XLSXRead;
import XLSX.XLSXWriter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.EmptyFileException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.xml.bind.JAXBException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    protected static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) throws IOException, URISyntaxException, ClassNotFoundException, JAXBException {
        logger.info("--- Application started. ---");
        URL resource = Main.class.getResource("universityInfo.xlsx");
        assert resource != null;
        final String FILE_NAME = Paths.get(resource.toURI()).toFile().getAbsolutePath();
        try {
            StudentComparator studentNameCompare =
                    ComparatorFactory.getStudentComparator(StudentCompareType.NAME);
            UniversityComparator universityMainProfileCompare =
                    ComparatorFactory.getUniversityComparator(UniversityCompareType.MAIN_PROFILE);

            FileInputStream inputStream = new FileInputStream(FILE_NAME);
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet sheetStudents = workbook.getSheet("Студенты");
            XSSFSheet sheetUniversities = workbook.getSheet("Университеты");
            XLSXRead reader = XLSXRead.INSTANCE;

            StudentCollection students = new StudentCollection();
            assert studentNameCompare != null;
            students.setStudents(
                    reader
                            .getStudents(sheetStudents)
                            .stream()
                            .sorted(studentNameCompare)
                            .collect(Collectors.toList())
            );
            UniversityCollection universities = new UniversityCollection();
            assert universityMainProfileCompare != null;
            universities.setUniversities(
                    reader
                            .getUnivetsities(sheetUniversities)
                            .stream()
                            .sorted(universityMainProfileCompare)
                            .collect(Collectors.toList())
            );
            StatisticsCollection statistics = new StatisticsCollection();
            statistics.setStatistics(StatCalc.calculation(students.getStudents(), universities.getUniversities()));

            XLSXWriter xlsxWriter = XLSXWriter.INSTANCE;
            xlsxWriter.create(statistics.getStatistics(), "out/statistics.xlsx");

            DataCollection dataCollection = new DataCollection();
            List<StatFields> fields = new ArrayList<>();
            fields.add(students);
            fields.add(universities);
            fields.add(statistics);
            dataCollection.setCollections(fields);
            JsonOutput jsonOutput = new JsonOutput(dataCollection, "jsonReqs/req_--datetime--.json");
            jsonOutput.out();
            XmlOutput xmlOutput = new XmlOutput(dataCollection, "xmlReqs/req_--datetime--.xml");
            xmlOutput.out();

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
