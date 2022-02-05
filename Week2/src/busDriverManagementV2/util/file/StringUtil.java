package busDriverManagementV2.util.file;

import busDriverManagementV2.util.DataUtil;

public class StringUtil {
    public static boolean isNullOrEmpty(String str) {
        return DataUtil.isNullOrEmpty(str) && str.trim().isEmpty();
    }
}
