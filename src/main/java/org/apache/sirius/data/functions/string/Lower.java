package org.apache.sirius.data.functions.string;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.sirius.common.enums.FunctionType;
import org.apache.sirius.data.functions.AbstractString2String;

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

    /**
     * @param args
     * @return String
     */
    @Override
    public String call(String... args) {
        if (ArrayUtils.isEmpty(args)) {
            throw new IllegalArgumentException("Incorrect parameter count to function 'LOWER'");
        }
        return args[0] == null ? null : args[0].toLowerCase(Locale.getDefault());
    }

    /**
     * @return String
     */
    @Override
    public String getName() {
        return FunctionType.LOWER.name();
    }
}
