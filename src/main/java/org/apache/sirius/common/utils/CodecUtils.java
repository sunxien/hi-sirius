package org.apache.sirius.common.utils;

/**
 * @author sunxien
 * @date 2025/1/14
 * @since 1.0.0-SNAPSHOT
 */
public class CodecUtils {


    private static final char[] DIGITS_LOWER = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final char[] DIGITS_UPPER = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public CodecUtils() {
    }

    /**
     * @param bytes
     * @return String
     */
    public static String encodeHexString(byte[] bytes) {
        return bytes == null ? null : new String(encodeHex(bytes));
    }

    /**
     * @param data
     * @param toLowerCase
     * @return String
     */
    public static String encodeHexString(byte[] data, boolean toLowerCase) {
        return data == null ? null : new String(encodeHex(data, toLowerCase));
    }

    /**
     * @param bytes
     * @return char[]
     */
    public static char[] encodeHex(byte[] bytes) {
        return bytes == null ? null : encodeHex(bytes, true);
    }

    /**
     * @param bytes
     * @param toLowerCase
     * @return char[]
     */
    public static char[] encodeHex(byte[] bytes, boolean toLowerCase) {
        return bytes == null ? null : encodeHex(bytes, toLowerCase ? DIGITS_LOWER : DIGITS_UPPER);
    }

    /**
     * @param bytes
     * @param toDigits
     * @return char[]
     */
    protected static char[] encodeHex(byte[] bytes, char[] toDigits) {
        if (bytes == null) {
            return null;
        } else {
            int l = bytes.length;
            char[] out = new char[l << 1];
            int i = 0;
            for (int j = 0; i < l; ++i) {
                out[j++] = toDigits[(240 & bytes[i]) >>> 4];
                out[j++] = toDigits[15 & bytes[i]];
            }
            return out;
        }
    }

    /**
     * @param strings
     * @return String
     * @throws Exception
     */
    public static String decodeHex(String[] strings) throws Exception {
        StringBuilder sb = new StringBuilder(strings.length * 2);
        for (String string : strings) {
            sb.append(new String(decodeHex(string.toCharArray())));
        }
        return sb.toString();
    }

    /**
     * @param data
     * @return byte[]
     * @throws Exception
     */
    public static byte[] decodeHex(String data) throws Exception {
        return decodeHex(data.toCharArray());
    }

    /**
     * @param chars
     * @return byte[]
     * @throws Exception
     */
    public static byte[] decodeHex(char[] chars) throws Exception {
        int len = chars.length;
        if ((len & 1) != 0) {
            throw new RuntimeException("Odd number of characters.");
        } else {
            byte[] out = new byte[len >> 1];
            int i = 0;

            for (int j = 0; j < len; ++i) {
                int f = toDigit(chars[j], j) << 4;
                ++j;
                f |= toDigit(chars[j], j);
                ++j;
                out[i] = (byte) (f & 255);
            }
            return out;
        }
    }

    /**
     * @param ch
     * @param index
     * @return int
     * @throws Exception
     */
    protected static int toDigit(char ch, int index) throws Exception {
        int digit = Character.digit(ch, 16);
        if (digit == -1) {
            throw new RuntimeException("Illegal hexadecimal character " + ch + " at index " + index);
        } else {
            return digit;
        }
    }
}
