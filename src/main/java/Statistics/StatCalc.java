package Statistics;

import Comparators.StudentComparator;
import Main.Student;
import Main.StudyProfile;
import Main.University;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.function.DoubleSupplier;
import java.util.stream.Collectors;

import static java.math.RoundingMode.HALF_EVEN;

public class StatCalc {
    public static List<Statistics> calculation(List<Student> students, List<University> universities) {
        List<Statistics> statistics = new ArrayList<>();

        Set<StudyProfile> profiles = new HashSet<>();
        universities.forEach(university -> profiles.add(university.getMainProfile()));
        for (StudyProfile profile : profiles) {
            Statistics stat = new Statistics();
            stat.setStudyProfile(profile);
            stat.setUniversitiesByProfile(
                    universities
                            .stream()
                            .filter(u -> u.getMainProfile().equals(profile))
                            .count()
            );
            stat.setStudentsByProfile(
                    students
                            .stream()
                            .filter(student -> student.equalsByID(
                                    universities
                                            .stream()
                                            .filter(university -> university.getMainProfile().equals(profile))
                                            .findFirst()
                                            .get()
                            )).count()
            );
            stat.setUniversitiesNames(
                    universities.stream()
                            .filter(u -> u.getMainProfile().equals(profile))
                            .map(University::getFullName)
                            .toList()
            );

            BigDecimal averageScore = BigDecimal.valueOf(
                    students
                            .stream()
                            .filter(student -> student.equalsByID(
                                    universities
                                            .stream()
                                            .filter(university -> university.getMainProfile().equals(profile))
                                            .findFirst()
                                            .get()
                            ))
                            .mapToDouble(Student::getAvgExamScore)
                            .average()
                            .orElseGet(new DoubleSupplier() {
                                @Override
                                public double getAsDouble() {
                                    return 0;
                                }
                            })).setScale(2, HALF_EVEN);

            stat.setAvgExamScore(averageScore.doubleValue());

            statistics.add(stat);
        }

        return statistics;
    }
}
