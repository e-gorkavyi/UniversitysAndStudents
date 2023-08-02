package Comparators;

import Main.Student;

import java.util.Comparator;

public interface StudentComparator extends Comparator<Student> {
    public int compare(Student a, Student b);
}
