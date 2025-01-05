package org.apache.data.functions.string;

import org.apache.commons.lang3.StringUtils;
import org.apache.data.constants.FunctionType;
import org.apache.data.functions.AbstractBuiltinFunction;

import java.math.BigDecimal;

/**
 * Ref: https://docs.oracle.com/en/database/oracle/oracle-database/21/sqlrf/NCHR.html
 *
 * @author sunxien
 * @date 2025/1/3
 * @since 1.0.0-SNAPSHOT
 */
public class Nchr extends AbstractBuiltinFunction<String, Character> {

    private static final Nchr INSTANCE = new Nchr();

    private Nchr() {
    }

    public static Nchr newInstance() {
        return INSTANCE;
    }

    /**
     * NCHR returns the character having the binary equivalent to number in the national character set. The value returned is always NVARCHAR2. This function is equivalent to using the CHR function with the USING NCHAR_CS clause.
     * <p>
     * This function takes as an argument a NUMBER value, or any value that can be implicitly converted to NUMBER, and returns a character.
     *
     * @param args
     * @return String
     */
    @Override
    public Character call(String... args) {
        if (args == null || args.length != 1) {
            throw new IllegalArgumentException("Incorrect parameter count in the call to function 'NCHR'");
        }
        final String arg = args[0];
        if (arg == null) {
            return null;
        } else if (arg.trim().isEmpty()) {
            throw new IllegalArgumentException("Incorrect arguments to function NCHR");
        }
        try {
            int unicode = new BigDecimal(arg).intValue();
            if (unicode < 0) {
                throw new IllegalArgumentException("Incorrect arguments to function NCHR");
            } else if (unicode > 256) {
                unicode = unicode % 256;
            }
            return (char) unicode;
        } catch (NumberFormatException e) {
            throw new RuntimeException("Incorrect arguments to function NCHR. Error: " + e.getMessage());
        }
    }

    @Deprecated
    public static void main(String[] args) {
        System.out.println(Nchr.newInstance().call("97.684"));
    }

    /**
     * @return String
     */
    @Override
    public String getName() {
        return FunctionType.NCHR.name();
    }
}
