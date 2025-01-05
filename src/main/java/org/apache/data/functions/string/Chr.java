package org.apache.data.functions.string;

import org.apache.data.constants.FunctionType;
import org.apache.data.functions.AbstractBuiltinFunction;

import java.math.BigDecimal;

/**
 * @author sunxien
 * @date 2025/1/3
 * @since 1.0.0-SNAPSHOT
 */
public final class Chr extends AbstractBuiltinFunction<String, Character> {

    private static final Chr INSTANCE = new Chr();

    private Chr() {
    }

    public static Chr newInstance() {
        return INSTANCE;
    }

    /**
     * CHR returns the character having the binary equivalent to n as a VARCHAR2 value in either the database character set or, if you specify USING NCHAR_CS, the national character set.
     * <p>
     * For single-byte character sets, if n > 256, then Oracle Database returns the binary equivalent of n mod 256. For multibyte character sets, n must resolve to one entire code point. Invalid code points are not validated, and the result of specifying invalid code points is indeterminate.
     * <p>
     * This function takes as an argument a NUMBER value, or any value that can be implicitly converted to NUMBER, and returns a character.
     *
     * @param args
     * @return String
     */
    @Override
    public Character call(String... args) {
        if (args == null || args.length != 1) {
            throw new IllegalArgumentException("Incorrect parameter count in the call to function 'CHR'");
        }
        final String arg = args[0];
        if (arg == null) {
            return null;
        } else if (arg.trim().isEmpty()) {
            throw new IllegalArgumentException("Incorrect arguments to function CHR");
        }
        try {
            int unicode = new BigDecimal(arg).intValue();
            if (unicode < 0) {
                throw new IllegalArgumentException("Incorrect arguments to function CHR");
            } else if (unicode > 256) {
                unicode = unicode % 256;
            }
            return (char) unicode;
        } catch (NumberFormatException e) {
            throw new RuntimeException("Incorrect arguments to function CHR. Error: " + e.getMessage());
        }
    }

    @Deprecated
    public static void main(String[] args) {
        System.out.println(Chr.newInstance().call(""));
    }

    /**
     * @return String
     */
    @Override
    public String getName() {
        return FunctionType.CHR.name();
    }
}
