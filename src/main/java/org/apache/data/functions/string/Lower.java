package org.apache.data.functions.string;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.data.constants.FunctionType;
import org.apache.data.functions.AbstractString2String;

import java.util.Locale;

/**
 * @author sunxien
 * @date 2025/1/3
 * @since 1.0.0-SNAPSHOT
 */
public final class Lower extends AbstractString2String {

    private static final Lower INSTANCE = new Lower();

    private Lower() {
    }

    public static Lower newInstance() {
        return INSTANCE;
    }

    @Override
    public String call(String... args) {
        if (ArrayUtils.isEmpty(args) || StringUtils.isBlank(args[0])) {
            return null;
        }
        return args[0].toLowerCase(Locale.getDefault());
    }

    /**
     * @return String
     */
    @Override
    public String getName() {
        return FunctionType.LOWER.name();
    }
}
