package org.apache.data.functions.crypto;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.data.constants.FunctionType;

/**
 * @author sunxien
 * @date 2025/1/4
 * @since 1.0.0-SNAPSHOT
 */
public final class MD5 extends AbstractSecurityFunction {

    private static final MD5 INSTANCE = new MD5();

    private MD5() {
    }

    /**
     * @return MD5
     */
    public static MD5 newInstance() {
        return INSTANCE;
    }

    /**
     * SQL: select md5('asdb') from dual;
     *
     * @param args
     * @return String
     */
    @Override
    public String call(String... args) {
        if (args == null || args.length == 0) {
            throw new IllegalArgumentException("Invalid arguments");
        }
        return DigestUtils.md5Hex(args[0]);
    }

    /**
     * @return String
     */
    @Override
    public String getName() {
        return FunctionType.MD5.name();
    }
}
