package busDriverManagementV2.util.file;

import busDriverManagementV2.util.DataUtil;

import java.io.*;
import java.util.List;

public class FileUtil implements DataReadable,DataWriteable{
    @Override
    public <T> T readDataFromFile(String fileName) {
        if (StringUtil.isNullOrEmpty(fileName)){
            return null;
        }
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            return (T) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void writeDataToFile(List T, String fileName) {
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
