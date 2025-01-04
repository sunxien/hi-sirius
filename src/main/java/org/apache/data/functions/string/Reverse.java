package org.apache.data.functions.string;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.data.constants.FunctionType;
import org.apache.data.functions.AbstractString2String;

/**
 * Ref: https://dev.mysql.com/doc/refman/8.0/en/string-functions.html#function_reverse
 *
 * @author sunxien
 * @date 2025/1/3
 * @since 1.0.0-SNAPSHOT
 */
public class Reverse extends AbstractString2String {

    private static final Reverse INSTANCE = new Reverse();

    private Reverse() {
    }

    public static Reverse newInstance() {
        return INSTANCE;
    }

    /**
     * @param args
     * @return String
     */
    @Override
    public String call(String... args) {
        if (args == null || args.length != 1) {
            throw new IllegalArgumentException("Incorrect parameter count in the call to function 'REVERSE'");
        }
        return args[0] == null ? null : new StringBuilder(args[0]).reverse().toString();
    }

    /**
     * @return String
     */
    @Override
    public String getName() {
        return FunctionType.REVERSE.name();
    }
}
