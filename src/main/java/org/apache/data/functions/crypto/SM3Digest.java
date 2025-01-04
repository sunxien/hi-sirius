package org.apache.data.functions.crypto;

import org.apache.commons.codec.binary.Hex;
import org.apache.data.constants.FunctionType;
import org.apache.data.constants.TextEncoding;

import java.util.Base64;

/**
 * @author sunxien
 * @date 2025/1/4
 * @since 1.0.0-SNAPSHOT
 */
public final class SM3Digest extends AbstractSecurityFunction {

    private static final SM3Digest INSTANCE = new SM3Digest();

    private SM3Digest() {
    }

    /**
     * @return SM3Encrypt
     */
    public static SM3Digest newInstance() {
        return INSTANCE;
    }

    /**
     * SQL: select sm3_encrypt('abc', 'BASE64') from dual;
     * Output:
     *
     * @param args
     * @return String
     */
    @Override
    public String call(String... args) {
        if (args == null || args.length == 0) {
            throw new IllegalArgumentException("Invalid arguments");
        }
        final String value = args[0];
        if (value == null || value.isEmpty()) {
            return value;
        }
        try {
            final byte[] digestBytes = digestSM3(value.getBytes());
            if (TextEncoding.BASE64.name().equalsIgnoreCase(args[1])) {
                return Base64.getEncoder().encodeToString(digestBytes);
            } else if (TextEncoding.HEX.name().equalsIgnoreCase(args[1])) {
                return Hex.encodeHexString(digestBytes);
            } else {
                throw new IllegalArgumentException("Unknown text encoding: " + args[1]);
            }
        } catch (Exception e) {
            throw new RuntimeException("SM3 encrypt failed", e);
        }
    }

    /**
     * @return String
     */
    @Override
    public String getName() {
        return FunctionType.SM3_ENCRYPT.name();
    }
}
