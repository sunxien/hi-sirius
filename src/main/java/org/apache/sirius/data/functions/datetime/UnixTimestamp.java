package org.apache.sirius.data.functions.datetime;

import org.apache.commons.lang3.StringUtils;
import org.apache.sirius.common.consts.Constants;
import org.apache.sirius.data.functions.AbstractString2String;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * Ref: https://dev.mysql.com/doc/refman/8.0/en/date-and-time-functions.html#function_unix-timestamp
 *
 * @author sunxien
 * @date 2025/1/4
 * @since 1.0.0-SNAPSHOT
 */
public class UnixTimestamp extends AbstractString2String {

    private static final UnixTimestamp INSTANCE = new UnixTimestamp();

    private UnixTimestamp() {
    }

    public static UnixTimestamp newInstance() {
        return INSTANCE;
    }

    /**
     * @param args
     * @return String
     */
    @Override
    public String call(String... args) {
        if (args != null && args.length > 1) {
            throw new IllegalArgumentException("Incorrect parameter count in the call to native function 'UNIX_TIMESTAMP'");
        }
        if (args == null || args.length == 0) {
            return String.valueOf((System.currentTimeMillis() / 1000));
        }
        if (args[0] == null) {
            return null;
        }
        if (StringUtils.isBlank(args[0])) {
            return "0.000000";
        }
        DateTimeFormatter formatter = Constants.YMDHMS_FORMATER;
        try {
            LocalDateTime ldt = LocalDateTime.parse(args[0], formatter);
            return String.valueOf(ldt.atZone(ZoneId.systemDefault()).toEpochSecond());
        } catch (Exception ex) {
            return "0.000000";
        }
    }

    @Deprecated
    public static void main(String[] args) {
        System.out.println(UnixTimestamp.newInstance().call("2025-01-01 11:49:00"));
    }

    @Override
    public String getName() {
        return "";
    }
}
