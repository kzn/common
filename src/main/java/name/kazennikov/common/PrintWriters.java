package name.kazennikov.common;

/**
 * Created by kzn on 1/20/16.
 */

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Simple print writers wrapper with access by key
 */
public class PrintWriters implements Closeable {
    File baseDir;
    String baseName;

    Map<String, PrintWriter> pws = new HashMap<>();

    public PrintWriters(File baseDir, String baseName) {
        this.baseDir = baseDir;
        this.baseName = baseName;
    }

    public PrintWriter get(String key) throws IOException {
        PrintWriter pw = pws.get(key);

        if(pw == null) {
            pw = new PrintWriter(new File(baseDir, baseName + "." + key + ".txt"), "UTF-8");
            pws.put(key, pw);
        }

        return pw;
    }

    @Override
    public void close() throws IOException {
        for(Map.Entry<String, PrintWriter> e : pws.entrySet()) {
            e.getValue().close();
        }

        pws.clear();
    }
}
