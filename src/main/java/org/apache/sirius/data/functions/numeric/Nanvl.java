package org.apache.sirius.data.functions.numeric;

import org.apache.sirius.common.enums.FunctionType;
import org.apache.sirius.data.functions.AbstractNumber2Number;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Ref: https://docs.oracle.com/en/database/oracle/oracle-database/21/sqlrf/NANVL.html
 *
 * @author sunxien
 * @date 2025/1/3
 * @since 1.0.0-SNAPSHOT
 */
public final class Nanvl extends AbstractNumber2Number {

    private static final Nanvl INSTANCE = new Nanvl();

    private Nanvl() {
    }

    /**
     * @return Nanvl instance
     */
    public static Nanvl newInstance() {
        return INSTANCE;
    }

    /**
     * @param args
     * @return Number
     */
    @Override
    public Number call(Number... args) {
        if (args == null || args.length == 0) {
            return null;
        }
        return args[0] == null ? args[1] : args[0];
    }

    /**
     * @param number
     * @param decimal
     * @return Number
     */
    private Number trunc(BigDecimal number, int decimal) {
        if (decimal >= 0) {
            return number.setScale(decimal, RoundingMode.DOWN);
        }
        final double factor = Math.pow(10.0D, -decimal);
        return BigDecimal.valueOf((number.longValue() / factor) * factor);
    }

    /**
     * @return String
     */
    @Override
    public String getName() {
        return FunctionType.NANVL.name();
    }
}
