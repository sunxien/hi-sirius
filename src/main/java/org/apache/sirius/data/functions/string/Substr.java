package org.apache.sirius.data.functions.string;

import org.apache.commons.lang3.StringUtils;
import org.apache.sirius.common.enums.FunctionType;
import org.apache.sirius.data.functions.AbstractString2String;

/**
 * @author sunxien
 * @date 2025/1/3
 * @since 1.0.0-SNAPSHOT
 */
public final class Substr extends AbstractString2String {

    private static final Substr INSTANCE = new Substr();

    private Substr() {
    }

    public static Substr newInstance() {
        return INSTANCE;
    }

    /**
     * @param args
     * @return String
     */
    @Override
    public String call(String... args) {
        if (args == null || args.length < 2 || args.length > 3) {
            throw new IllegalArgumentException("Incorrect parameter count to function 'SUBSTR'");
        }
        if (args[0] == null || args[1] == null || (args.length > 2 && args[2] == null)) {
            return null;
        }
        if (args[0].isEmpty() || args[1].isEmpty() || (args.length > 2 && args[2].isEmpty())) {
            return StringUtils.EMPTY;
        }
        try {
            String str = args[0];
            int startIndex = Integer.parseInt(args[1]);
            int substringLength = Integer.parseInt(args[2]);
            return substr(str, startIndex, substringLength);
        } catch (Exception ex) {
            return StringUtils.EMPTY;
        }
    }

    /**
     * @param value
     * @param startIndex
     * @param substringLength
     * @return String
     */
    private String substr(String value, int startIndex, int substringLength) {
        if (value == null) {
            return null;
        }
        final int length = value.length();
        if (startIndex > length) {
            return null;
        }
        if (startIndex < 0) {
            startIndex += length;
        } else {
            startIndex--;
        }
        if (substringLength < 1) {
            return null;
        }
        int endIndex = startIndex + substringLength;
        if (endIndex > length) {
            endIndex = length;
        }
        StringBuilder temp = new StringBuilder(endIndex - startIndex + 1);
        for (int i = startIndex; i < endIndex; i++) {
            temp.append(value.charAt(i));
        }
        return temp.toString();
    }

    /**
     * @return String
     */
    @Override
    public String getName() {
        return FunctionType.SUBSTR.name();
    }
}
