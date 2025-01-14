package org.apache.sirius.data.functions.datetime;

import org.apache.commons.lang3.StringUtils;
import org.apache.sirius.common.enums.FunctionType;
import org.apache.sirius.data.functions.AbstractString2Integer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.apache.sirius.common.consts.Constants.YMDHMS_FORMATER;

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
        if (args == null || args.length != 1) {
            throw new IllegalArgumentException("Incorrect parameter count in the call to native function 'DAYOFMONTH'");
        }
        if (args[0] == null || StringUtils.isBlank(args[0])) {
            return null;
        }
        try {
            DateTimeFormatter formatter = YMDHMS_FORMATER;
            return LocalDateTime.parse(args[0], formatter).getDayOfMonth();
        } catch (Exception ex) {
            return null;
        }
    }

    @Deprecated
    public static void main(String[] args) {
        System.out.println(DayOfMonth.newInstance().call("2025-01-05 12:00:00"));
    }

    @Override
    public String getName() {
        return FunctionType.DAY_OF_MONTH.name();
    }
}
