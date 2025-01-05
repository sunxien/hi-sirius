package org.apache.data.functions.datetime;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.data.constants.FunctionType;
import org.apache.data.functions.AbstractString2String;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.apache.data.constants.Constants.HMS_PATTERN;

/**
 * Ref: https://dev.mysql.com/doc/refman/8.0/en/date-and-time-functions.html#function_curtime
 *
 * @author sunxien
 * @date 2025/1/4
 * @since 1.0.0-SNAPSHOT
 */
public final class CurTime extends AbstractString2String {

    private static final CurTime INSTANCE = new CurTime();

    private CurTime() {
    }

    /**
     * @return CurTime
     */
    public static CurTime newInstance() {
        return INSTANCE;
    }

    /**
     * @param args
     * @return String
     */
    @Override
    public String call(String... args) {
        String pattern = HMS_PATTERN;
        if (ArrayUtils.isNotEmpty(args)) {
            if (args.length != 1) {
                throw new IllegalArgumentException("Incorrect parameter count to function 'CURTIME'");
            }
            int fsp = Integer.parseInt(args[0]);
            if (fsp < 0) {
                throw new IllegalArgumentException("Invalid precision for curtime(fsp). Valid: [0,6]");
            } else {
                if (fsp > 6) {
                    throw new IllegalArgumentException("Too-big precision 7 specified for 'curtime'. Maximum is 6.");
                }
                pattern = HMS_PATTERN + "." + StringUtils.repeat('S', fsp);
            }
        }
        return DateTimeFormatter.ofPattern(pattern).format(LocalDateTime.now());
    }

    /**
     * @return String
     */
    @Override
    public String getName() {
        return FunctionType.CURRENT_TIME.name();
    }
}
