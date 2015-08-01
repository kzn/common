package name.kazennikov;

import java.io.*;
import java.nio.charset.Charset;

/**
 * Created by kzn on 2/18/15.
 */
public class IOUtils {
    private IOUtils() {}

    public static BufferedReader newReader(File f) throws IOException {
        return newReader(f, Charset.defaultCharset());

    }

    public static BufferedReader newReader(File f, Charset cs) throws IOException {
        return new BufferedReader(new InputStreamReader(new FileInputStream(f), cs));
    }

    public static BufferedReader newReader(File f, String charset) throws IOException {
        return new BufferedReader(new InputStreamReader(new FileInputStream(f), Charset.forName(charset)));
    }

    public static ObjectInputStream newObjectInputStream(File f) throws IOException {
        return new ObjectInputStream(new FileInputStream(f));
    }

    public static ObjectOutputStream newObjectOutputStream(File f) throws IOException {
        return new ObjectOutputStream(new FileOutputStream(f));
    }
}
