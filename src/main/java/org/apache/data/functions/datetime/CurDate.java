package org.apache.data.functions.datetime;

import static org.apache.data.constants.Constants.YMD_FORMATER;
import org.apache.data.constants.FunctionType;
import org.apache.data.functions.AbstractBuiltinFunction;

import java.time.LocalDate;

/**
 * Ref: https://dev.mysql.com/doc/refman/8.0/en/date-and-time-functions.html#function_curdate
 *
 * @author sunxien
 * @date 2025/1/4
 * @since 1.0.0-SNAPSHOT
 */
public final class CurDate extends AbstractBuiltinFunction<String, String> {

    private static final CurDate INSTANCE = new CurDate();

    private CurDate() {
    }

    /**
     * @return CurDate
     */
    public static CurDate newInstance() {
        return INSTANCE;
    }

    /**
     * @param args
     * @return String
     */
    @Override
    public String call(String... args) {
        return YMD_FORMATER.format(LocalDate.now());
    }

    /**
     * @return String
     */
    @Override
    public String getName() {
        return FunctionType.CURRENT_DATE.name();
    }
}
