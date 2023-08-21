package Main;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class JsonUtil {
    private static final Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .excludeFieldsWithoutExposeAnnotation()
            .create();

    public static String objectSerialize(StatFields object) {
        return gson.toJson(object);
    }

    public static Student studentDeserialize(String studentJSON) {
        return gson.fromJson(studentJSON, Student.class);
    }

    public static List<Student> studentCollectionDeserialize(String studentCollectionJSON) {
        Type listType = new TypeToken<ArrayList<Student>>() {
        }.getType();
        return gson.fromJson(studentCollectionJSON, listType);
    }

    public static University universityDeserialize(String universityJSON) {
        return gson.fromJson(String.valueOf(universityJSON), University.class);
    }

    public static List<University> universityCollectionDeserialize(String universityCollectionJSON) {
        Type listType = new TypeToken<ArrayList<University>>() {
        }.getType();
        return gson.fromJson(universityCollectionJSON, listType);
    }

    public static String objectCollectionSerialize(Collection<StatFields> collection) {
        return gson.toJson(collection);
    }

    public static String listOfCollectionsSerialize(Collection<StatFields> collection) {
        if (!collection.isEmpty()) {
            return objectCollectionSerialize(collection);
        }
        return "";
    }

    public static String dataCollectionSerialize(DataCollection dataCollection) {
        StringBuilder result = new StringBuilder();
        var data = dataCollection.getCollections();
        result.append(listOfCollectionsSerialize(data));
        return result.toString();
    }

    public static String collectionOfCollectionsSerialize(DataCollection dataCollection) {
        return gson.toJson(dataCollection);
    }
}
