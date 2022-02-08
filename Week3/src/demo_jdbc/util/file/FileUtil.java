package demo_jdbc.util.file;

import demo_jdbc.util.DataUtil;

import java.io.*;
import java.util.List;

public class FileUtil implements DataReadable,DataWriteable{
    @Override
    public <T> T readDataFromDB(String fileName) {

        return null;
    }

    @Override
    public void writeDataToDB(List T, String fileName) {
        if (StringUtil.isNullOrEmpty(fileName) || DataUtil.isNullOrEmpty(T)) {
            return;
        }
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            objectOutputStream.writeObject(T);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
