package org.apache.sirius.data.functions.string;

import org.apache.sirius.common.enums.FunctionType;
import org.apache.sirius.data.functions.AbstractString2String;

/**
 * @author sunxien
 * @date 2025/1/3
 * @since 1.0.0-SNAPSHOT
 */
public final class Rpadb extends AbstractString2String {

    private static final Rpadb INSTANCE = new Rpadb();

    private Rpadb() {
    }

    public static Rpadb newInstance() {
        return INSTANCE;
    }

    /**
     * @param args
     * @return String
     */
    @Override
    public String call(String... args) {
        return "";
    }

    /**
     * @return String
     */
    @Override
    public String getName() {
        return FunctionType.RPADB.name();
    }
}
