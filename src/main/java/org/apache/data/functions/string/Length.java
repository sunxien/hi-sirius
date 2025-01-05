package org.apache.data.functions.string;

import org.apache.data.constants.FunctionType;
import org.apache.data.functions.AbstractString2Integer;

/**
 * @author sunxien
 * @date 2025/1/3
 * @since 1.0.0-SNAPSHOT
 */
public final class Length extends AbstractString2Integer {

    private static final Length INSTANCE = new Length();

    private Length() {
    }

    public static Length newInstance() {
        return INSTANCE;
    }

    /**
     * @param args
     * @return Integer
     */
    @Override
    public Integer call(String... args) {
        if (args == null || args.length != 1) {
            throw new IllegalArgumentException("Incorrect parameter count to function 'LENGTH'");
        }
        return args[0] == null ? null : args[0].length();
    }

    @Deprecated
    public static void main(String[] args) {
        System.out.println(Length.newInstance().call(new String[]{null}));
    }

    /**
     * @return String
     */
    @Override
    public String getName() {
        return FunctionType.LENGTH.name();
    }
}
