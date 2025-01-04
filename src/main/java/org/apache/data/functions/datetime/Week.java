package org.apache.data.functions.datetime;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.data.constants.FunctionType;
import org.apache.data.functions.AbstractBuiltinFunction;
import org.apache.data.functions.AbstractString2Integer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.WeekFields;

import static org.apache.data.constants.Constants.YMDHMS_FORMATER;

/**
 * @author sunxien
 * @date 2025/1/4
 * @since 1.0.0-SNAPSHOT
 */
public final class Week extends AbstractString2Integer {

    private static final Week INSTANCE = new Week();

    private Week() {
    }

    public static Week newInstance() {
        return INSTANCE;
    }

    /**
     * @param args
     * @return String
     */
    @Override
    public Integer call(String... args) {
        if (ArrayUtils.isEmpty(args) || StringUtils.isBlank(args[0])) {
            throw new IllegalArgumentException("Invalid arguments");
        }
        DateTimeFormatter formatter = YMDHMS_FORMATER;
        if (args.length > 1 && StringUtils.isNotBlank(args[1])) {
            formatter = DateTimeFormatter.ofPattern(args[1]);
        }
        return LocalDateTime.parse(args[0], formatter) //
                .toLocalDate().get(WeekFields.ISO.weekOfYear()) + 1;
    }


    /**
     * @return String
     */
    @Override
    public String getName() {
        return FunctionType.WEEK.name();
    }
}
