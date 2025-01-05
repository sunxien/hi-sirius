package org.apache.data.functions.string;

import org.apache.data.constants.FunctionType;
import org.apache.data.functions.AbstractString2String;

/**
 * @author sunxien
 * @date 2025/1/3
 * @since 1.0.0-SNAPSHOT
 */
public final class Trim extends AbstractString2String {

    private static final Trim INSTANCE = new Trim();

    private Trim() {
    }

    public static Trim newInstance() {
        return INSTANCE;
    }

    /**
     * @param args
     * @return String
     */
    @Override
    public String call(String... args) {
        if (args == null || args.length != 1) {
            throw new IllegalArgumentException("Incorrect parameter count to function 'TRIM'");
        }
        return args[0] == null ? null : args[0].trim();
    }

    /**
     * @return String
     */
    @Override
    public String getName() {
        return FunctionType.TRIM.name();
    }
}
