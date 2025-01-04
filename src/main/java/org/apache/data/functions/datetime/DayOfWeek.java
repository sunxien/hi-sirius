package org.apache.data.functions.datetime;

import org.apache.data.constants.FunctionType;
import org.apache.data.functions.AbstractBuiltinFunction;
import org.apache.data.functions.AbstractString2Integer;

/**
 * @author sunxien
 * @date 2025/1/4
 * @since 1.0.0-SNAPSHOT
 */
public class DayOfWeek extends AbstractString2Integer {

    private static final DayOfWeek INSTANCE = new DayOfWeek();

    private DayOfWeek() {
    }

    public static DayOfWeek newInstance() {
        return INSTANCE;
    }

    @Override
    public Integer call(String... args) {
        return 0;
    }

    @Override
    public String getName() {
        return FunctionType.DAY_OF_WEEK.name();
    }
}
