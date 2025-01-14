package org.apache.sirius.data.functions.string;

import org.apache.sirius.common.enums.FunctionType;
import org.apache.sirius.data.functions.AbstractString2String;

/**
 * Ref: https://dev.mysql.com/doc/refman/8.0/en/string-functions.html#function_ltrim
 *
 * @author sunxien
 * @date 2025/1/3
 * @since 1.0.0-SNAPSHOT
 */
public final class Ltrim extends AbstractString2String {

    private static final Ltrim INSTANCE = new Ltrim();

    private Ltrim() {
    }

    public static Ltrim newInstance() {
        return INSTANCE;
    }

    /**
     * @param args
     * @return String
     */
    @Override
    public String call(String... args) {
        if (args == null || args.length != 1) {
            throw new IllegalArgumentException("Incorrect parameter count to function 'LTRIM'");
        }
        String value = args[0];
        if (value == null) {
            return null;
        } else {
            int beginIndex = 0;
            char[] chars = value.toCharArray();
            for (; beginIndex < chars.length; beginIndex++) {
                if (!Character.isWhitespace(chars[beginIndex])) {
                    break;
                }
            }
            return value.substring(beginIndex);
        }
    }

    /**
     * @return String
     */
    @Override
    public String getName() {
        return FunctionType.LTRIM.name();
    }
}
