package name.kazennikov.charset;

import org.mozilla.universalchardet.UniversalDetector;

/**
 * Created by kazennikov on 30.12.2014.
 */
public class MozillaCharsetDetector implements CharsetDetector {

    @Override
    public String detect(byte[] data) {
        UniversalDetector d = new UniversalDetector(null);
        d.handleData(data, 0, data.length);
        d.dataEnd();
        String s = d.getDetectedCharset();
        return s;

    }
}
