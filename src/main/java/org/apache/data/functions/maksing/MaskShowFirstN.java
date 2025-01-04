package org.apache.data.functions.maksing;

import org.apache.data.constants.FunctionType;
import org.apache.data.functions.AbstractString2String;

/**
 * @author sunxien
 * @date 2025/1/3
 * @since 1.0.0-SNAPSHOT
 */
public final class MaskShowFirstN extends AbstractString2String {

    private static final MaskShowFirstN INSTANCE = new MaskShowFirstN();

    private MaskShowFirstN() {
    }

    /**
     * @return MaskShowFirstN
     */
    public static MaskShowFirstN newInstance() {
        return INSTANCE;
    }

    /**
     * @param args
     * @return String
     */
    @Override
    public String call(String... args) {
        if (args == null || args.length < 5) {
            throw new IllegalArgumentException("Invalid arguments");
        }
        final String value = args[0];
        final int firstN = Integer.parseInt(args[4]);
        if (value == null || value.isEmpty() || firstN <= 0) {
            return value;
        }

        final int len = value.length();
        final int n = Math.min(firstN, len);
        final StringBuilder sb = new StringBuilder(len);
        sb.append(value, 0, n);
        for (int i = n; i < len; i++) {
            final char c = value.charAt(i);
            if (Character.isUpperCase(c)) {
                sb.append(args[1]); // upper mask
            } else if (Character.isLowerCase(c)) {
                sb.append(args[2]); // lower mask
            } else if (Character.isDigit(c)) {
                sb.append(args[3]); // number mask
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] strs = {"Ab3cB2", "X", "x", "n", "3"};
        String str = MaskShowFirstN.newInstance().call(strs);
        System.out.println(str);
    }

    /**
     * @return String
     */
    @Override
    public String getName() {
        return FunctionType.MASK_SHOW_FIRST_N.name();
    }
}
