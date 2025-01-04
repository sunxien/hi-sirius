package org.apache.data.functions.datetime;

import org.apache.data.constants.FunctionType;
import org.apache.data.functions.AbstractBuiltinFunction;
import org.apache.data.functions.AbstractString2Integer;

/**
 * @author sunxien
 * @date 2025/1/4
 * @since 1.0.0-SNAPSHOT
 */
public final class DayOfMonth extends AbstractString2Integer {

    private static final DayOfMonth INSTANCE = new DayOfMonth();

    private DayOfMonth() {
    }

    public static DayOfMonth newInstance() {
        return INSTANCE;
    }

    @Override
    public Integer call(String... args) {
        return 0;
    }

    @Override
    public String getName() {
        return FunctionType.DAY_OF_MONTH.name();
    }
}
