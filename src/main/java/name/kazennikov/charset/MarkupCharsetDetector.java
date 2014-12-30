package name.kazennikov.charset;

import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by kazennikov on 30.12.2014.
 */
public class MarkupCharsetDetector implements CharsetDetector {
    private static Pattern xmlPrologPattern = Pattern.compile("\\<\\?xml\\s+version=\"\\d.?\\d+\"\\s+encoding=\"([^\"]+)\"\\?\\>");
    private static Pattern htmlMetaPattern = Pattern.compile("\\<meta\\s+http-equiv=\"Content-Type\"\\s+content=\"text/html; charset=([^\"]+)\">", Pattern.CASE_INSENSITIVE);
    private static Pattern html5CharsetPattern = Pattern.compile("\\<meta charset=\"([^\"]+)\"\\>", Pattern.CASE_INSENSITIVE);

    private static int XML_OFFSET_THRESHOLD = 8;
    private static int MARKUP_START_THRESHOLD = 10;


    boolean detectXml;
    boolean detectHtml;

    public MarkupCharsetDetector() {
        this(false, false);
    }

    public MarkupCharsetDetector(boolean detectXml, boolean detectHtml) {
        this.detectXml = detectXml;
        this.detectHtml = detectHtml;
    }

    public void setDetectXml(boolean detectXml) {
        this.detectXml = detectXml;
    }

    public void setDetectHtml(boolean detectHtml) {
        this.detectHtml = detectHtml;
    }

    @Override
    public String detect(byte[] bytes) {
        if(!detectHtml && !detectXml)
            return null;

        String s = new String(bytes, Charset.forName("ISO-8859-1"));
        int offset = s.indexOf('<');

        if(offset == -1 || offset > MARKUP_START_THRESHOLD)
            return null;

        if(detectXml) {
            Matcher m = xmlPrologPattern.matcher(s);

            if(offset != -1 && offset < MARKUP_START_THRESHOLD && m.find()) {
                if(m.start() < XML_OFFSET_THRESHOLD) {
                    return m.group(1);
                }
            }
        }

        if(detectHtml) {
            Matcher m = htmlMetaPattern.matcher(s);
            if(m.find()) {
                return m.group(1);
            }

            m = html5CharsetPattern.matcher(s);
            if(m.find()) {
                return m.group(1);
            }
        }

        return null;
    }
}
