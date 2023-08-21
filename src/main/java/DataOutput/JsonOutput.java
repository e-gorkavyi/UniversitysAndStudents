package DataOutput;

import Main.DataCollection;
import Main.JsonUtil;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;

public class JsonOutput {
    static DataCollection dataCollection = new DataCollection();
    private String filePath;

    public JsonOutput(DataCollection dataCOl, String filePath) {
        dataCollection = dataCOl;
        this.filePath = filePath;
    }

    public void out() throws IOException {
        String outFileName = filePath.replaceAll(
                "--datetime--",
                new SimpleDateFormat("yyyy-MM-dd'T'HH-mm-ss.SSS")
                        .format(System.currentTimeMillis()));
        File dir = new File(Paths.get(outFileName).getParent().toUri());
        if (!dir.exists())
            dir.mkdirs();
        String jsonString = JsonUtil.collectionOfCollectionsSerialize(dataCollection);
        FileWriter jsonWrite = new FileWriter(new File(outFileName));
        jsonWrite.write(jsonString);
        jsonWrite.close();
    }
}
