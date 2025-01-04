package org.apache.data.functions.crypto;

import org.apache.data.constants.FunctionType;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.pqc.crypto.DigestUtils;
import org.bouncycastle.util.encoders.Hex;

import java.nio.charset.StandardCharsets;

/**
 * @author sunxien
 * @date 2025/1/4
 * @since 1.0.0-SNAPSHOT
 */
public final class SHADigest extends AbstractSecurityFunction {

    private static final SHADigest INSTANCE = new SHADigest();

    private SHADigest() {
    }

    /**
     * @return SHAEncrypt instance
     */
    public static SHADigest newInstance() {
        return INSTANCE;
    }

    /**
     * SQL: select sha_encrypt("abc", 256) from dual;
     *
     * @param args
     * @return String
     */
    @Override
    public String call(String[] args) {
        if (args == null | args.length == 0) {
            throw new IllegalArgumentException("Invalid arguments");
        }
        String digestName = "SHA-" + args[1];
        ASN1ObjectIdentifier identifier = DigestUtils.getDigestOid(digestName);
        try {
            return Hex.toHexString(identifier.getEncoded(StandardCharsets.UTF_8.name()));
        } catch (Exception ex) {
            throw new RuntimeException(digestName + " encrypt failed", ex);
        }
    }

    public static void main(String[] args) {
        String[] strs = {"abcs", "256"};
        System.out.println(SHADigest.newInstance().call(strs));
    }

    /**
     * @return String
     */
    @Override
    public String getName() {
        return FunctionType.SHA.name();
    }
}
