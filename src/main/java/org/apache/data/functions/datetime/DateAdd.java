package org.apache.data.functions.datetime;

import org.apache.data.constants.FunctionType;
import org.apache.data.functions.AbstractString2String;

/**
 * Ref: https://dev.mysql.com/doc/refman/8.0/en/date-and-time-functions.html#function_date-add
 *
 * @author sunxien
 * @date 2025/1/4
 * @since 1.0.0-SNAPSHOT
 */
public final class DateAdd extends AbstractString2String {

    private static final DateAdd INSTANCE = new DateAdd();

    private DateAdd() {
    }

    public static DateAdd newInstance() {
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

    @Override
    public String getName() {
        return FunctionType.DATE_ADD.name();
    }
}
