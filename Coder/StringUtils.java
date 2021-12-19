import java.util.Arrays;

/**
 * 字符串工具类
 *
 * @author: curryhqy
 * @date: 2021-12-14 21:19
 **/
public class StringUtils {

    /**
     * 判断组成字符串的字符是否唯一
     * 其中字符串的组成仅包括 大小写字母 A-Z，a-z
     *
     * @param targetString 目标字符串
     * @return true / false
     */
    public static boolean uniqueString(String targetString) {
        int length = targetString.length();
        long bits = 0L;
        for (int i = 0; i < length; i++) {

            //move的值为bits的多少位
            int move = targetString.charAt(i) - 'A';

            if ((bits & (1L << move)) != 0) {
                return false;
            } else {
                bits |= (1L << move);
            }
        }
        return true;
    }

    /**
     * 判断两个字符串的组成是否相同
     *
     * @param s1 待判断字符串1
     * @param s2 待判断字符串2
     * @return true / false
     */
    public static boolean checkPermutation(String s1, String s2) {
        char[] s1ToArray = s1.toCharArray();
        char[] s2ToArray = s2.toCharArray();
        Arrays.sort(s1ToArray);
        Arrays.sort(s2ToArray);
        return Arrays.equals(s1ToArray, s2ToArray);
    }

    /**
     * 将字符串中的空格全部替换为%20
     *
     * @param str 待处理字符串
     * @return 处理后的字符串
     */
    public static String replaceSpaces(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                stringBuilder.append("%20");
            } else {
                stringBuilder.append(str.charAt(i));
            }
        }
        return stringBuilder.toString();
    }

}
