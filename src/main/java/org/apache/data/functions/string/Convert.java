package org.apache.data.functions.string;

import org.apache.data.constants.FunctionType;
import org.apache.data.functions.AbstractString2String;

/**
 * Ref: https://dev.mysql.com/doc/refman/8.0/en/cast-functions.html#function_convert
 * Ref: https://docs.oracle.com/en/database/oracle/oracle-database/21/sqlrf/CONVERT.html
 *
 * @author sunxien
 * @date 2025/1/3
 * @since 1.0.0-SNAPSHOT
 */
public final class Convert extends AbstractString2String {

    private static final Convert INSTANCE = new Convert();

    /**
     *
     */
    private Convert() {
    }

    /**
     * @return Convert instance
     */
    public static Convert newInstance() {
        return INSTANCE;
    }

    @Override
    public String call(String... args) {
        return "";
    }

    /**
     * @return String
     */
    @Override
    public String getName() {
        return FunctionType.CONVERT.name();
    }
}
