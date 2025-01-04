package org.apache.data.functions.string;

import org.apache.data.constants.FunctionType;
import org.apache.data.functions.AbstractBuiltinFunction;

/**
 * @author sunxien
 * @date 2025/1/3
 * @since 1.0.0-SNAPSHOT
 */
public final class Trim extends AbstractBuiltinFunction<String> {

    /**
     *
     */
    private static final Trim SINGLETON = new Trim();

    /**
     *
     */
    private Trim(){}

    /**
     * @return Trim
     */
    public static Trim newInstance() {
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
        return args[0].trim();
    }

    /**
     * @return String
     */
    @Override
    public String getName() {
        return FunctionType.TRIM.name();
    }
}
