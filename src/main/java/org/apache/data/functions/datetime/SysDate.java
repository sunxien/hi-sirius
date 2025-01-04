package org.apache.data.functions.datetime;

import org.apache.data.constants.FunctionType;
import org.apache.data.functions.AbstractBuiltinFunction;
import org.apache.data.functions.AbstractString2String;

import java.time.LocalDateTime;

import static org.apache.data.constants.Constants.YMDHMS_FORMATER;

/**
 * Ref: https://dev.mysql.com/doc/refman/8.0/en/date-and-time-functions.html#function_sysdate
 *
 * @author sunxien
 * @date 2025/1/4
 * @since 1.0.0-SNAPSHOT
 */
public final class SysDate extends AbstractString2String {

    private static final SysDate INSTANCE = new SysDate();

    private SysDate() {
    }

    public static SysDate newInstance() {
        return INSTANCE;
    }

    /**
     * @param args
     * @return String
     */
    @Override
    public String call(String... args) {
        return YMDHMS_FORMATER.format(LocalDateTime.now());
    }

    /**
     * @return String
     */
    @Override
    public String getName() {
        return FunctionType.SYSDATE.name();
    }
}
