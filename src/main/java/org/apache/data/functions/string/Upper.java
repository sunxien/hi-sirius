package org.apache.data.functions.string;

import org.apache.data.constants.FunctionType;
import org.apache.data.functions.AbstractBuiltinFunction;

import java.util.Locale;

/**
 * @author sunxien
 * @date 2025/1/3
 * @since 1.0.0-SNAPSHOT
 */
public final class Upper extends AbstractBuiltinFunction<String> {

    /**
     *
     */
    private static final Upper SINGLETON = new Upper();

    /**
     *
     */
    private Upper(){}

    /**
     * @return Upper
     */
    public static Upper newInstance() {
        return SINGLETON;
    }

    /**
     * @param args
     * @return String
     */
    @Override
    public String call(String[] args) {
        if (args == null || args.length == 0 || args[0] == null) {
            return null;
        }
        return args[0].toUpperCase(Locale.getDefault());
    }

    /**
     * @return String
     */
    @Override
    public String getName() {
        return FunctionType.UPPER.name();
    }
}
