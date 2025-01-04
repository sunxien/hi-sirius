package org.apache.data.constants;

/**
 * Follow Reference: https://dev.mysql.com/doc/refman/8.0/en/built-in-function-reference.html
 *
 * @author sunxien
 * @date 2025/1/3
 * @since 1.0.0-SNAPSHOT
 */
public enum FunctionType {

    /**
     * STRINGS
     */
    ASCII,
    CHR,
    CONCAT,
    CONVERT,
    HEXTORAW,
    LENGTH,
    LOWER,
    LPAD,
    LPADB,
    LTRIM,
    NCHR,
    NVL,
    RAWTOHEX,
    REPLACE,
    REVERSE,
    RPAD,
    RPADB,
    RTRIM,
    SUBSTR,
    TRIM,
    UPPER,

    /** NUMBER */
    NANVL,
    TRUNC,

    /** HASH */
    MD5,
    SHA,

    /** ENCRYPT */
    SM3_ENCRYPT,
    SM4_ENCRYPT,

    /** DECRYPT */
    SM3_DECRYPT,
    SM4_DECRYPT,

    /** DATETIME */
    CURRENT_DATE,
    CURRENT_TIME,
    DATE_ADD,
    DATE_DIFF,
    DATE_SUB,
    DATE_TRUNC,
    DAY_OF_MONTH,
    DAY_OF_WEEK,
    DAY_OF_YEAR,
    HOUR,
    MINUTE,
    MONTH,
    SYSDATE,
    SYS_TIMESTAMP,
    TIMESTAMP_ADD,
    TIMESTAMP_FORMAT,
    TIMESTAMP_TRUNC,
    TO_TIMESTAMP,
    WEEK,
    YEAR,

    /**
     * MASKING
     */
    MASK_FIRST_N,
    MASK,
    MASK_LAST_N,
    MASK_SHOW_FIRST_N,
    MASK_SHOW_LAST_N;

    /**
     *
     */
    private static final FunctionType[] FUNCTION_TYPES = FunctionType.values();

    /**
     *
     */
    private FunctionType() {
    }

    /**
     * @param functionTypeName
     * @return FunctionType
     */
    public static FunctionType valueOfName(String functionTypeName) {
        for (FunctionType functionType : FUNCTION_TYPES) {
            if (functionType.name().equalsIgnoreCase(functionTypeName)) {
                return functionType;
            }
        }
        throw new IllegalArgumentException("Unknown function type: " + functionTypeName);
    }
}
