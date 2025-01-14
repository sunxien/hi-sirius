package org.apache.sirius.data.functions.crypto;

import org.apache.commons.codec.binary.Hex;
import org.apache.sirius.common.enums.FunctionType;
import org.apache.sirius.common.enums.TextEncoding;

import java.util.Base64;

/**
 * @author sunxien
 * @date 2025/1/4
 * @since 1.0.0-SNAPSHOT
 */
public final class SM4Decrypt extends AbstractSecurityFunction {

    private static final SM4Decrypt INSTANCE = new SM4Decrypt();

    private SM4Decrypt() {
    }

    /**
     * @return SM4Decrypt
     */
    public static SM4Decrypt newInstance() {
        return INSTANCE;
    }

    /**
     * SQL: select sm4_decrypt('abc', 'BASE64', 'file://secret.key') from dual;
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
            byte[] cipherBytes;
            if (TextEncoding.BASE64.name().equalsIgnoreCase(args[1])) {
                cipherBytes = Base64.getDecoder().decode(value);
            } else if (TextEncoding.HEX.name().equalsIgnoreCase(args[1])) {
                cipherBytes = Hex.decodeHex(value);
            } else {
                throw new IllegalArgumentException("Unknown text encoding: " + args[1]);
            }
            return new String(decryptSM4(cipherBytes, readSecretKey(args[2])));
        } catch (Exception e) {
            throw new RuntimeException("SM4 decrypt failed", e);
        }
    }

    /**
     * @return String
     */
    @Override
    public String getName() {
        return FunctionType.SM4_DECRYPT.name();
    }
}
