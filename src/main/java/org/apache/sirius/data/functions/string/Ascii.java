package org.apache.sirius.data.functions.string;

import org.apache.sirius.common.enums.FunctionType;
import org.apache.sirius.data.functions.AbstractString2Integer;

import java.math.BigDecimal;

/**
 * @author sunxien
 * @date 2025/1/3
 * @since 1.0.0-SNAPSHOT
 */
public final class Ascii extends AbstractString2Integer {

    private static final Ascii INSTANCE = new Ascii();

    /**
     *
     */
    private Ascii() {
    }

    /**
     * @return Ascii instance
     */
    public static Ascii newInstance() {
        return INSTANCE;
    }

    /**
     * Unsupported Chinese Input.
     *
     * @param args
     * @return String
     */
    @Override
    public Integer call(String... args) {
        if (args == null || args.length != 1) {
            throw new IllegalArgumentException("Incorrect parameter count to function 'ASCII'");
        }
        if (args[0] == null) {
            return null;
        } else if (args[0].isEmpty()) {
            return BigDecimal.ZERO.intValue();
        }
        return Character.codePointAt(args[0], 0);
    }

    @Deprecated
    public static void main(String[] args) {
        System.out.println(Ascii.newInstance().call(" "));
    }

    /**
     * Return ASCII
     *
     * @return String
     */
    @Override
    public String getName() {
        return FunctionType.ASCII.name();
    }
}
