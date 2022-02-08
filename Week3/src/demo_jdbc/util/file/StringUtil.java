package demo_jdbc.util.file;

import demo_jdbc.util.DataUtil;

public class StringUtil {
    public static boolean isNullOrEmpty(String str) {
        return DataUtil.isNullOrEmpty(str) && str.trim().isEmpty();
    }
}
