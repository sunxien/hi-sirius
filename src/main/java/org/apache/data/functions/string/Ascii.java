package org.apache.data.functions.string;

import org.apache.data.constants.FunctionType;
import org.apache.data.functions.AbstractBuiltinFunction;

/**
 * @author sunxien
 * @date 2025/1/3
 * @since 1.0.0-SNAPSHOT
 */
public final class Ascii extends AbstractBuiltinFunction<String> {

    private static final Ascii INSTANCE = new Ascii();

    /**
     *
     */
    private Ascii() {
    }

    /**
     * @return Ascii instance
     */
    public static Ascii newInstance() {
        return INSTANCE;
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
        return String.valueOf(Character.codePointAt(args[0], 0));
    }

    /**
     * Return ASCII
     *
     * @return String
     */
    @Override
    public String getName() {
        return FunctionType.ASCII.name();
    }
}
