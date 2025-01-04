package org.apache.data.functions.string;

import org.apache.data.constants.FunctionType;
import org.apache.data.functions.AbstractBuiltinFunction;

/**
 * @author sunxien
 * @date 2025/1/3
 * @since 1.0.0-SNAPSHOT
 */
public final class Chr extends AbstractBuiltinFunction<Integer, Character> {

    private static final Chr INSTANCE = new Chr();

    private Chr() {
    }

    public static Chr newInstance() {
        return INSTANCE;
    }

    /**
     * @param args
     * @return String
     */
    @Override
    public Character call(Integer... args) {
        if (args == null || args.length != 1) {
            throw new IllegalArgumentException("Incorrect parameter count in the call to function 'CHR'");
        }
        return (char) (args[0] % 256);
    }


    @Deprecated
    public static void main(String[] args) {
        System.out.println(Chr.newInstance().call(1));
    }

    /**
     * @return String
     */
    @Override
    public String getName() {
        return FunctionType.CHR.name();
    }
}
