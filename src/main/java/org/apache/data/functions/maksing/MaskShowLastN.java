package org.apache.data.functions.maksing;

import org.apache.data.constants.FunctionType;
import org.apache.data.functions.AbstractBuiltinFunction;

/**
 * @author sunxien
 * @date 2025/1/3
 * @since 1.0.0-SNAPSHOT
 */
public final class MaskShowLastN extends AbstractBuiltinFunction<String> {

    private static final MaskShowLastN INSTANCE = new MaskShowLastN();

    private MaskShowLastN() {
    }

    /**
     * @return MaskShowLastN
     */
    public static MaskShowLastN newInstance() {
        return INSTANCE;
    }

    /**
     * SQL: select mask_show_last_n('Ab3cB2', 'X', 'x', 'n', 3) from dual;
     *
     * @param args
     * @return String
     */
    @Override
    public String call(String[] args) {
        if (args == null || args.length < 5) {
            throw new IllegalArgumentException("Invalid arguments");
        }
        final String value = args[0];
        final int lastN = Integer.parseInt(args[4]);
        if (value == null || value.isEmpty() || lastN <= 0) {
            return value;
        }
        final int len = value.length();
        int n = Math.min(lastN, len);
        final StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len - n; i++) {
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
        return sb.append(value, (len - n), len).toString();
    }

    public static void main(String[] args) {
        String[] strs = {"Ab3", "X", "x", "n", "3"};
        String str = MaskShowLastN.newInstance().call(strs);
        System.out.println(str);
    }

    /**
     * @return String
     */
    @Override
    public String getName() {
        return FunctionType.MASK_SHOW_LAST_N.name();
    }
}
