package org.apache.data.functions.string;

import org.apache.data.constants.FunctionType;
import org.apache.data.functions.AbstractBuiltinFunction;

/**
 * @author sunxien
 * @date 2025/1/3
 * @since 1.0.0-SNAPSHOT
 */
public final class Concat extends AbstractBuiltinFunction<String> {

    /**
     *
     */
    private static final Concat INSTANCE = new Concat();

    /**
     *
     */
    private Concat() {
    }

    /**
     * @return Concat instance
     */
    public static Concat newInstance() {
        return INSTANCE;
    }

    /**
     * @param args
     * @return String
     */
    @Override
    public String call(String[] args) {
        if (args == null || args.length < 2) {
            return null;
        }
        if (args[0] == null && args[1] == null) {
            return null;
        }
        return ((args[0] == null) ? "" : args[0]) + ((args[1] == null) ? "" : args[1]);
    }

    /**
     * @return String
     */
    @Override
    public String getName() {
        return FunctionType.CONCAT.name();
    }
}
