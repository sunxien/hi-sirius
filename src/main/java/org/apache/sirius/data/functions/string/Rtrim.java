package org.apache.sirius.data.functions.string;

import org.apache.commons.lang3.StringUtils;
import org.apache.sirius.common.enums.FunctionType;
import org.apache.sirius.data.functions.AbstractString2String;

/**
 * @author sunxien
 * @date 2025/1/3
 * @since 1.0.0-SNAPSHOT
 */
public final class Rtrim extends AbstractString2String {

    private static final Rtrim INSTANCE = new Rtrim();

    private Rtrim() {
    }

    public static Rtrim newInstance() {
        return INSTANCE;
    }

    /**
     * @param args
     * @return String
     */
    @Override
    public String call(String... args) {
        if (args == null || args.length != 1) {
            throw new IllegalArgumentException("Incorrect parameter count to function 'RTRIM'");
        }
        final String value = args[0];
        if (value == null) {
            return null;
        }
        if (value.isEmpty()) {
            return StringUtils.EMPTY;
        }
        char[] chars = value.toCharArray();
        int endIndex = value.length() - 1;
        for (; endIndex > 0; endIndex--) {
            if (!Character.isWhitespace(chars[endIndex])) {
                break;
            }
        }
        return args[0].substring(0, endIndex);
    }

    @Deprecated
    public static void main(String[] args) {
        System.out.println(Rtrim.newInstance().call(new String[]{null}));
    }

    /**
     * @return String
     */
    @Override
    public String getName() {
        return FunctionType.RTRIM.name();
    }
}
