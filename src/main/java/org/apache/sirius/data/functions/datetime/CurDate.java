package org.apache.sirius.data.functions.datetime;

import org.apache.sirius.common.enums.FunctionType;
import org.apache.sirius.data.functions.AbstractBuiltinFunction;

import java.time.LocalDate;

import static org.apache.sirius.common.consts.Constants.YMD_FORMATER;

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

    public static CurDate newInstance() {
        return INSTANCE;
    }

    /**
     * @param args
     * @return String
     */
    @Override
    public String call(String... args) {
        if (args != null) {
            throw new IllegalArgumentException("Incorrect parameter count to function 'CURDATE'");
        }
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
