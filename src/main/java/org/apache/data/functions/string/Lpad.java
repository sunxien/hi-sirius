package org.apache.data.functions.string;

import org.apache.data.constants.FunctionType;
import org.apache.data.functions.AbstractString2String;

/**
 * @author sunxien
 * @date 2025/1/3
 * @since 1.0.0-SNAPSHOT
 */
public final class Lpad extends AbstractString2String {

    private static final Lpad INSTANCE = new Lpad();

    private Lpad() {
    }

    public static Lpad newInstance() {
        return INSTANCE;
    }

    @Override
    public String call(String... args) {
        return "";
    }

    /**
     * @return String
     */
    @Override
    public String getName() {
        return FunctionType.LPAD.name();
    }
}
