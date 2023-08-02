package Main;

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

    public static String studentCollectionSerialize(Collection<Student> studentCollection) {
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

    public static String universityCollectionSerialize(Collection<University> universityCollection) {
        return new Gson().toJson(universityCollection);
    }

    public static University universityDeserialize(String universityJSON) {
        return new Gson().fromJson(String.valueOf(universityJSON), University.class);
    }

    public static List<University> universityCollectionDeserialize(String universityCollectionJSON) {
        Type listType = new TypeToken<ArrayList<University>>(){}.getType();
        return new Gson().fromJson(universityCollectionJSON, listType);
    }
}
