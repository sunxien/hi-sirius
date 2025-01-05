package org.apache.data.functions.string;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.data.constants.FunctionType;
import org.apache.data.functions.AbstractString2String;

/**
 * Ref: https://dev.mysql.com/doc/refman/8.0/en/string-functions.html#function_replace
 *
 * @author sunxien
 * @date 2025/1/3
 * @since 1.0.0-SNAPSHOT
 */
public final class Replace extends AbstractString2String {

    private static final Replace INSTANCE = new Replace();

    private Replace() {
    }

    public static Replace newInstance() {
        return INSTANCE;
    }

    /**
     * @param args
     * @return String
     */
    @Override
    public String call(String... args) {
        if (args == null || args.length != 3) {
            throw new IllegalArgumentException("Incorrect parameter count to function 'REPLACE'");
        }
        String value = args[0];
        String searchString = args[1];
        String replaceString = args[2];
        if (value == null || searchString == null || replaceString == null) {
            return null;
        }
        if (value.isEmpty() && searchString.isEmpty() && replaceString.isEmpty()) {
            return StringUtils.EMPTY;
        }
        return StringUtils.replace(value, searchString, replaceString);
    }

    @Deprecated
    public static void main(String[] args) {
        System.out.println(Replace.newInstance().call("  ", "", "-"));
    }

    /**
     * @return String
     */
    @Override
    public String getName() {
        return FunctionType.REPLACE.name();
    }
}
