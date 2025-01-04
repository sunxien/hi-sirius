package org.apache.data.functions.maksing;

import org.apache.data.constants.FunctionType;
import org.apache.data.functions.AbstractBuiltinFunction;

/**
 * @author sunxien
 * @date 2025/1/3
 * @since 1.0.0-SNAPSHOT
 */
public final class MaskFirstN extends AbstractBuiltinFunction<String> {

    private static final MaskFirstN INSTANCE = new MaskFirstN();

    private MaskFirstN() {
    }

    /**
     * @return MaskFirstN
     */
    public static MaskFirstN newInstance() {
        return INSTANCE;
    }

    /**
     * SQL: select mask_first_n('ABCabcdefg', 'X', 'x', 'n', 3);
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
        final int firstN = Integer.parseInt(args[4]);
        if (value == null || value.isEmpty() || firstN <= 0) {
            return value;
        }

        final int len = value.length();
        final int n = Math.min(firstN, len);
        final StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < n; i++) {
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
        return sb.append(value, n, len).toString();
    }

    /**
     * @return String
     */
    @Override
    public String getName() {
        return FunctionType.MASK_FIRST_N.name();
    }
}
