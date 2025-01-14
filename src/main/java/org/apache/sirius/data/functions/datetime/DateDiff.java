package org.apache.sirius.data.functions.datetime;

import org.apache.sirius.common.enums.FunctionType;
import org.apache.sirius.data.functions.AbstractString2Integer;

/**
 * Ref: https://dev.mysql.com/doc/refman/8.0/en/date-and-time-functions.html#function_datediff
 *
 * @author sunxien
 * @date 2025/1/4
 * @since 1.0.0-SNAPSHOT
 */
public final class DateDiff extends AbstractString2Integer {

    private static final DateDiff INSTANCE = new DateDiff();

    private DateDiff() {
    }

    public static DateDiff newInstance() {
        return INSTANCE;
    }

    /**
     * @param args
     * @return String
     */
    @Override
    public Integer call(String... args) {
        return 0;
    }

    @Override
    public String getName() {
        return FunctionType.DATE_DIFF.name();
    }
}
