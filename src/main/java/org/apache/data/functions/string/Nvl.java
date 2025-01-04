package org.apache.data.functions.string;

import org.apache.data.constants.FunctionType;
import org.apache.data.functions.AbstractString2String;

/**
 * @author sunxien
 * @date 2025/1/3
 * @since 1.0.0-SNAPSHOT
 */
public final class Nvl extends AbstractString2String {

    private static final Nvl INSTANCE = new Nvl();

    private Nvl() {
    }

    public static Nvl newInstance() {
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
        return FunctionType.NVL.name();
    }
}
