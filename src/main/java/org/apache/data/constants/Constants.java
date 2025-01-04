package org.apache.data.constants;

import java.time.format.DateTimeFormatter;

/**
 * @author sunxien
 * @date 2025/1/4
 * @since 1.0.0-SNAPSHOT
 */
public final class Constants {

    private Constants() {
    }

    public static final String YMD_PATTERN = "yyyy-MM-dd";
    public static final String HMS_PATTERN = "HH:mm:ss";
    public static final String YMDHMS_PATTERN = "yyyy-MM-dd HH:mm:ss";

    public static final DateTimeFormatter YMD_FORMATER = DateTimeFormatter.ofPattern(YMD_PATTERN);
    public static final DateTimeFormatter HMS_FORMATER = DateTimeFormatter.ofPattern(HMS_PATTERN);
    public static final DateTimeFormatter YMDHMS_FORMATER = DateTimeFormatter.ofPattern(YMDHMS_PATTERN);

}
