package name.kazennikov.common;

/**
 * Created with IntelliJ IDEA.
 * User: kzn
 * Date: 07.10.12
 * Time: 20:19
 * To change this template use File | Settings | File Templates.
 */
public class XmlUtils {
    public static boolean isValidXml(int ch) {
        return ch == 0x9 || ch == 0xA || ch == 0xD || (ch >= 0x20 && ch <= 0xD7FF)
                || (ch >= 0xE000 && ch <= 0xFFFD);
    }

}
