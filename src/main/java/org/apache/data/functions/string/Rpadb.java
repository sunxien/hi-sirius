package org.apache.data.functions.string;

import org.apache.data.constants.FunctionType;
import org.apache.data.functions.AbstractBuiltinFunction;

/**
 * @author sunxien
 * @date 2025/1/3
 * @since 1.0.0-SNAPSHOT
 */
public final class Rpadb extends AbstractBuiltinFunction<String> {

    /**
     *
     */
    private static final Rpadb SINGLETON = new Rpadb();

    /**
     *
     */
    private Rpadb() {
    }

    /**
     * @return Rpadb
     */
    public static Rpadb newInstance() {
        return SINGLETON;
    }

    /**
     * @param args
     * @return String
     */
    @Override
    public String call(String[] args) {
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
