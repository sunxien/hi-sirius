package org.apache.data.functions.string;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
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
        if (ArrayUtils.isEmpty(args)) {
            throw new IllegalArgumentException("Incorrect parameter count in the call to native function 'LENGTH'");
        }
        return args[0].length();
    }

    /**
     * @return String
     */
    @Override
    public String getName() {
        return FunctionType.LENGTH.name();
    }
}
