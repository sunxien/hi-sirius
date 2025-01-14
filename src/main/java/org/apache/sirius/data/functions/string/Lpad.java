package org.apache.sirius.data.functions.string;

import org.apache.commons.lang3.StringUtils;
import org.apache.sirius.common.enums.FunctionType;
import org.apache.sirius.data.functions.AbstractString2String;

/**
 * Ref: https://dev.mysql.com/doc/refman/8.0/en/string-functions.html#function_lpad
 *
 * @author sunxien
 * @date 2025/1/3
 * @since 1.0.0-SNAPSHOT
 */
public final class Lpad extends AbstractString2String {

    private static final Lpad INSTANCE = new Lpad();

    private Lpad() {
    }

    public static Lpad newInstance() {
        return INSTANCE;
    }

    /**
     * @param args
     * @return String
     */
    @Override
    public String call(String... args) {
        if (args == null || args.length != 3) {
            throw new IllegalArgumentException("Incorrect parameter count to function 'LPAD'");
        }
        if (args[0] == null || args[1] == null || args[2] == null) {
            return null;
        }
        String value = args[0];
        int paddedLength = Integer.parseInt(args[1]);
        if (paddedLength < 0) {
            return null;
        }
        String padString = args[2];
        if (padString.isEmpty()) {
            return StringUtils.EMPTY;
        }
        int length = value.length();
        if (paddedLength <= length) {
            return value.substring(0, paddedLength);
        }
        return StringUtils.leftPad(value, paddedLength, padString);
    }

    @Deprecated
    public static void main(String[] args) {
        System.out.println("[" + Lpad.newInstance().call("123", "4", "") + "]");
    }

    /**
     * @return String
     */
    @Override
    public String getName() {
        return FunctionType.LPAD.name();
    }
}
