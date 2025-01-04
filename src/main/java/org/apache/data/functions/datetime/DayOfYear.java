package org.apache.data.functions.datetime;

import org.apache.data.constants.FunctionType;
import org.apache.data.functions.AbstractBuiltinFunction;

/**
 * @author sunxien
 * @date 2025/1/4
 * @since 1.0.0-SNAPSHOT
 */
public class DayOfYear extends AbstractBuiltinFunction<String, String> {

    private static final DayOfYear INSTANCE = new DayOfYear();

    private DayOfYear() {
    }

    public static DayOfYear newInstance() {
        return INSTANCE;
    }

    @Override
    public String call(String... args) {
        return "";
    }

    @Override
    public String getName() {
        return FunctionType.DAY_OF_YEAR.name();
    }
}
