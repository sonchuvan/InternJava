package demo_jdbc.util.file;

import java.util.List;

public interface DataWriteable<T> {
    void writeDataToDB(List<T> T , String fileName);
}
