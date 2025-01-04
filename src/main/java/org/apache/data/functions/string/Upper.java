package org.apache.data.functions.string;

import org.apache.data.constants.FunctionType;
import org.apache.data.functions.AbstractString2String;

import java.util.Locale;

/**
 * @author sunxien
 * @date 2025/1/3
 * @since 1.0.0-SNAPSHOT
 */
public final class Upper extends AbstractString2String {

    private static final Upper INSTANCE = new Upper();

    private Upper() {
    }

    public static Upper newInstance() {
        return INSTANCE;
    }

    /**
     * @param args
     * @return String
     */
    @Override
    public String call(String... args) {
        if (args == null || args.length != 1) {
            throw new IllegalArgumentException("Incorrect parameter count in the call to native function 'UPPER'");
        }
        return args[0] == null ? null : args[0].toUpperCase(Locale.getDefault());
    }

    /**
     * @return String
     */
    @Override
    public String getName() {
        return FunctionType.UPPER.name();
    }
}
