package demo_jdbc.util.file;

public interface DataReadable {
    <T> T readDataFromDB(String fileName);
}
