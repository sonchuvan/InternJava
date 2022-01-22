package busDriverManagement;

import java.io.*;
import java.util.List;

public class FileIO {
    private static final String filepath = "D:\\ITSOL\\Week2\\src\\busDriverManagement\\";
    public static  <T> void writeObjectToFile(T t, String fileName) {
        try {
            FileOutputStream f = new FileOutputStream(new File(filepath + fileName));
            ObjectOutputStream o = new ObjectOutputStream(f);
            o.writeObject(t);
            o.close();
            f.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T>  List<T>  readObjectFromFile(String fileName) {
        try {
            FileInputStream fi = new FileInputStream(new File(filepath + fileName));
            ObjectInputStream oi = new ObjectInputStream(fi);
            List<T> t = (List<T>) oi.readObject();
            return t;
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
