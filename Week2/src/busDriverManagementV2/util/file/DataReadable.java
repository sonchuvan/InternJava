package busDriverManagementV2.util.file;

public interface DataReadable {
    <T> T readDataFromFile(String fileName);
}
