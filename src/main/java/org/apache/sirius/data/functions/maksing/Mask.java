package org.apache.sirius.data.functions.maksing;

import org.apache.sirius.common.enums.FunctionType;
import org.apache.sirius.data.functions.AbstractString2String;

/**
 * @author sunxien
 * @date 2025/1/3
 * @since 1.0.0-SNAPSHOT
 */
public final class Mask extends AbstractString2String {

    private static final Mask INSTANCE = new Mask();

    private Mask() {
    }

    /**
     * @return Mask
     */
    public static Mask newInstance() {
        return INSTANCE;
    }

    /**
     * SQL: select mask('ABCabc123', 'X', 'x', 'n') from dual;
     * Output: XXXxxnnn
     *
     * @param args
     * @return String
     */
    @Override
    public String call(String... args) {
        if (args == null || args.length != 4) {
            throw new IllegalArgumentException("Incorrect parameter count to function 'MASK'");
        }
        final String value = args[0];
        if (value == null || value.isEmpty()) {
            return value;
        }
        final StringBuilder sb = new StringBuilder(value.length());
        for (char c : value.toCharArray()) {
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
        return FunctionType.MASK.name();
    }
}
