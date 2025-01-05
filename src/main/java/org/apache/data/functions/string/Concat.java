package org.apache.data.functions.string;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.data.constants.FunctionType;
import org.apache.data.functions.AbstractString2String;

/**
 * @author sunxien
 * @date 2025/1/3
 * @since 1.0.0-SNAPSHOT
 */
public final class Concat extends AbstractString2String {

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
    public String call(String... args) {
        if (ArrayUtils.isEmpty(args)) {
            throw new IllegalArgumentException("Incorrect parameter count to function 'CONCAT'");
        }
        StringBuilder sb = new StringBuilder();
        for (String arg : args) {
            if (arg == null) {
                sb.setLength(0); // gc
                return null;
            }
            sb.append(arg);
        }
        return sb.toString();
    }

    /**
     * @return String
     */
    @Override
    public String getName() {
        return FunctionType.CONCAT.name();
    }
}
