package org.apache.data.functions.datetime;

import org.apache.data.constants.FunctionType;
import org.apache.data.functions.AbstractString2String;

/**
 * Ref: https://dev.mysql.com/doc/refman/8.0/en/date-and-time-functions.html#function_date-sub
 *
 * @author sunxien
 * @date 2025/1/4
 * @since 1.0.0-SNAPSHOT
 */
public final class DateSub extends AbstractString2String {

    private static final DateSub INSTANCE = new DateSub();

    private DateSub() {
    }

    public static DateSub newInstance() {
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
        return FunctionType.DATE_SUB.name();
    }
}
