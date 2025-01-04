package org.apache.data.functions.string;

import org.apache.data.constants.FunctionType;
import org.apache.data.functions.AbstractString2String;

/**
 * @author sunxien
 * @date 2025/1/3
 * @since 1.0.0-SNAPSHOT
 */
public final class Chr extends AbstractString2String {

    private static final Chr INSTANCE = new Chr();

    /**
     *
     */
    private Chr() {
    }

    /**
     * @return Chr instance
     */
    public static Chr newInstance() {
        return INSTANCE;
    }

    /**
     * @param args
     * @return String
     */
    @Override
    public String call(String... args) {
        if (args == null || args.length == 0 || args[0] == null) {
            return null;
        }
        try {
            return String.valueOf((char) (Integer.parseInt(args[0]) % 256));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("CHR required an integer argument. Error: " + e.getMessage());
        }
    }

    /**
     * @return String
     */
    @Override
    public String getName() {
        return FunctionType.CHR.name();
    }
}
