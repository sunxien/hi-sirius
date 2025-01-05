package org.apache.data.functions.maksing;

import org.apache.data.constants.FunctionType;
import org.apache.data.functions.AbstractString2String;

/**
 * @author sunxien
 * @date 2025/1/3
 * @since 1.0.0-SNAPSHOT
 */
public final class MaskLastN extends AbstractString2String {

    private static final MaskLastN INSTANCE = new MaskLastN();

    private MaskLastN() {
    }

    public static MaskLastN newInstance() {
        return INSTANCE;
    }

    /**
     * SQL: select mask_last_n('Ab1Ab1', 'X', 'x', 4) from dual;
     *
     * @param args
     * @return String
     */
    @Override
    public String call(String... args) {
        if (args == null || args.length != 5) {
            throw new IllegalArgumentException("Incorrect parameter count to function 'MASK_LAST_N'");
        }
        final String value = args[0];
        final int lastN = Integer.parseInt(args[4]);
        if (value == null || value.isEmpty() || lastN <= 0) {
            return value;
        }
        final int len = value.length();
        final StringBuilder sb = new StringBuilder(len);
        final int n = Math.min(lastN, len);
        sb.append(value, 0, len - n);
        for (int i = len - n; i < len; i++) {
            char c = value.charAt(i);
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

    /**
     * @return String
     */
    @Override
    public String getName() {
        return FunctionType.MASK_LAST_N.name();
    }
}
