package org.apache.sirius.data.functions.numeric;

import org.apache.sirius.common.enums.FunctionType;
import org.apache.sirius.data.functions.AbstractNumber2Number;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Ref: https://docs.oracle.com/en/database/oracle/oracle-database/21/sqlrf/TRUNC-date.html
 * Ref: https://docs.oracle.com/en/database/oracle/oracle-database/21/sqlrf/TRUNC-number.html
 *
 * @author sunxien
 * @date 2025/1/3
 * @since 1.0.0-SNAPSHOT
 */
public final class Trunc extends AbstractNumber2Number {


    private static final Trunc INSTANCE = new Trunc();

    /**
     *
     */
    private Trunc() {
    }

    /**
     * @return Trunc instance
     */
    public static Trunc newInstance() {
        return INSTANCE;
    }

    /**
     * @param args
     * @return
     */
    @Override
    public Number call(Number... args) {
        if (args == null || args.length == 0 || args[0] == null) {
            return null;
        }
        try {
            BigDecimal number = (BigDecimal) args[0];
            return trunc(number, args[1].intValue());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e);
        }
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
        return FunctionType.TRUNC.name();
    }
}
