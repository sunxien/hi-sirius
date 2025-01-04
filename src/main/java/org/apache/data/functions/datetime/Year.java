package org.apache.data.functions.datetime;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.data.constants.FunctionType;
import org.apache.data.functions.AbstractBuiltinFunction;
import org.apache.data.functions.AbstractString2Integer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.apache.data.constants.Constants.YMDHMS_FORMATER;

/**
 * Ref: https://dev.mysql.com/doc/refman/8.0/en/date-and-time-functions.html#function_year
 *
 * @author sunxien
 * @date 2025/1/4
 * @since 1.0.0-SNAPSHOT
 */
public class Year extends AbstractString2Integer {


    /**
     * MySQL: select year('2025-01-04 22:54:21') from dual;
     * Output 2025
     *
     * @param args ['2025-01-04 22:54:21'], ['2025-01-04 22:54:21', 'yyyy-MM-dd HH:mm:ss']
     * @return String
     */
    @Override
    public Integer call(String... args) {
        if (ArrayUtils.isNotEmpty(args) || args.length < 2) {
            throw new IllegalArgumentException("Invalid arguments");
        }
        DateTimeFormatter formatter = YMDHMS_FORMATER;
        if (StringUtils.isNotBlank(args[1])) {
            formatter = DateTimeFormatter.ofPattern(args[1]);
        }
        return LocalDateTime.parse(args[0], formatter).toLocalDate().getYear();
    }

    /**
     * @return String
     */
    @Override
    public String getName() {
        return FunctionType.YEAR.name();
    }
}
