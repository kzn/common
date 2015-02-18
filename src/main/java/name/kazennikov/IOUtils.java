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
}
