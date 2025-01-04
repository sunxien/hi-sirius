package org.apache.data.functions.string;

import org.apache.data.constants.FunctionType;
import org.apache.data.functions.AbstractBuiltinFunction;

import java.util.Arrays;

/**
 * @author sunxien
 * @date 2025/1/3
 * @since 1.0.0-SNAPSHOT
 */
public final class Rtrim extends AbstractBuiltinFunction<String> {

    /**
     *
     */
    private static final Rtrim SINGLETON = new Rtrim();

    /**
     *
     */
    private Rtrim() {
    }

    /**
     * @return Rtrim
     */
    public static Rtrim newInstance() {
        return SINGLETON;
    }

    /**
     * @param args
     * @return String
     */
    @Override
    public String call(String[] args) {
        if (args == null || args.length < 2) {
            throw new IllegalArgumentException("Invalid arguments");
        }
        if (args[0] == null) {
            return null;
        }
        String trimString = args[1];
        if (trimString == null) {
            trimString = " ";
        }
        char[] trimSet = trimString.toCharArray();
        int endIndex = args[0].length();
        for (; endIndex > 0; endIndex--) {
            char key = args[0].charAt(endIndex - 1);
            if (Arrays.binarySearch(trimSet, key) < 0)
                break;
        }
        return args[0].substring(0, endIndex);
    }

    /**
     * @return String
     */
    @Override
    public String getName() {
        return FunctionType.RTRIM.name();
    }
}
