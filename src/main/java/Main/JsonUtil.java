package Main;

import Statistics.Statistics;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class JsonUtil {
    public static String studentSerialize(Student student) {
        Gson gson = new Gson();
        return gson.toJson(student);
    }

    public static String studentCollectionSerialize(Collection<Object> studentCollection) {
        return new Gson().toJson(studentCollection);
    }

    public static Student studentDeserialize(String studentJSON) {
        Gson gson = new Gson();
        return gson.fromJson(studentJSON, Student.class);
    }

    public static List<Student> studentCollectionDeserialize(String studentCollectionJSON) {
        Type listType = new TypeToken<ArrayList<Student>>(){}.getType();
        return new Gson().fromJson(studentCollectionJSON, listType);
    }

    public static String universitySerialize(University university) {
        return new Gson().toJson(university);
    }

    public static String universityCollectionSerialize(Collection<Object> universityCollection) {
        return new Gson().toJson(universityCollection);
    }

    public static University universityDeserialize(String universityJSON) {
        return new Gson().fromJson(String.valueOf(universityJSON), University.class);
    }

    public static List<University> universityCollectionDeserialize(String universityCollectionJSON) {
        Type listType = new TypeToken<ArrayList<University>>(){}.getType();
        return new Gson().fromJson(universityCollectionJSON, listType);
    }

    private static String statisticsCollectionSerialize(Collection<Object> collection) {
        return new Gson().toJson(collection);
    }

    public static String collectionSerialize(Collection<Object> collection) {
        if (!collection.isEmpty()) {
            Object element = collection.iterator().next();
            Class<?> elementType = element.getClass();
            if (elementType.equals(University.class)) {

                return universityCollectionSerialize(collection);
            } else if (elementType.equals(Student.class)) {
                return studentCollectionSerialize(collection);
            } else if (elementType.equals(Statistics.class)) {
                return statisticsCollectionSerialize(collection);
            } else {
                throw new IllegalStateException("Unexpected value: " + elementType);
            }
        }
        return "";
    }

}
