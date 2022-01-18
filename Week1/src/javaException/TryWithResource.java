package javaException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResource {
    static String readFirstLineFromFile(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            return br.readLine();
        }
    }

    public static void main(String[] args)throws Exception {
        int a = 1;
        int b = 2;
        if (a >b) {
            // ném unchecked exception thì không cần throws
            //throw new NullPointerException("error");
            // ném checked exception thì cần throws
            throw new IOException("error");
        }
    }
}
