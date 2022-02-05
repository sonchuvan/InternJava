package busDriverManagementV2.util.file;

import java.util.List;

public interface DataWriteable<T> {
    void writeDataToFile(List<T> T , String fileName);
}
