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
public final class SM4Encrypt extends AbstractSecurityFunction {

    private static final SM4Encrypt INSTANCE = new SM4Encrypt();

    private SM4Encrypt() {
    }

    /**
     * @return SM4Encrypt
     */
    public static SM4Encrypt newInstance() {
        return INSTANCE;
    }

    /**
     * SQL: select sm4_encrypt('abc', 'BASE64', 'file://secret.key') from dual;
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
            final byte[] cipherBytes = encryptSM4(value.getBytes(), readSecretKey(args[2]));
            if (TextEncoding.BASE64.name().equalsIgnoreCase(args[1])) {
                return Base64.getEncoder().encodeToString(cipherBytes);
            } else if (TextEncoding.HEX.name().equalsIgnoreCase(args[1])) {
                return Hex.encodeHexString(cipherBytes);
            } else {
                throw new IllegalArgumentException("Unknown text encoding: " + args[1]);
            }
        } catch (Exception e) {
            throw new RuntimeException("SM4 encrypt failed", e);
        }
    }

    /**
     * @return String
     */
    @Override
    public String getName() {
        return FunctionType.SM4_ENCRYPT.name();
    }
}
