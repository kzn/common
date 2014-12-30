package name.kazennikov.charset;

/**
 * Created by kazennikov on 30.12.2014.
 */
public class CombinedDetector implements CharsetDetector {
    MozillaCharsetDetector mozilla = new MozillaCharsetDetector();
    MarkupCharsetDetector markup = new MarkupCharsetDetector(false, false);



    @Override
    public String detect(byte[] data) {
        String charset = markup.detect(data);

        if(charset != null)
            return charset;

        charset = mozilla.detect(data);

        return charset;
    }

    public void setDetectXml(boolean detectXml) {
        markup.setDetectXml(detectXml);
    }

    public void setDetectHtml(boolean detectHtml) {
        markup.setDetectHtml(detectHtml);
    }
}
