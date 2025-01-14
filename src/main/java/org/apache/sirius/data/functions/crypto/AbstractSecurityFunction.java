package org.apache.sirius.data.functions.crypto;

import org.apache.sirius.data.functions.AbstractString2String;
import org.bouncycastle.crypto.digests.SM3Digest;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.security.Provider;
import java.security.Security;
import java.util.Base64;

/**
 * @author sunxien
 * @date 2025/1/4
 * @since 1.0.0-SNAPSHOT
 */
public abstract class AbstractSecurityFunction extends AbstractString2String {

    static {
        Security.addProvider((Provider) new BouncyCastleProvider());
    }

    /**
     * @param plainText
     * @param key
     * @return byte[]
     * @throws Exception
     */
    protected byte[] encryptSM4(byte[] plainText, byte[] key) throws Exception {
        Cipher cipher = Cipher.getInstance("SM4", "BC");
        cipher.init(1, new SecretKeySpec(key, "SM4"));
        return cipher.doFinal(plainText);
    }

    /**
     * @param cipherText
     * @param key
     * @return byte[]
     * @throws Exception
     */
    protected byte[] decryptSM4(byte[] cipherText, byte[] key) throws Exception {
        Cipher cipher = Cipher.getInstance("SM4", "BC");
        cipher.init(2, new SecretKeySpec(key, "SM4"));
        return cipher.doFinal(cipherText);
    }

    /**
     * @param bytes
     * @return byte[]
     * @throws Exception
     */
    protected byte[] digestSM3(byte[] bytes) throws Exception {
        SM3Digest digest = new SM3Digest();
        digest.update(bytes, 0, bytes.length);
        byte[] hash = new byte[digest.getDigestSize()];
        digest.doFinal(hash, 0);
        return hash;
    }

    /**
     * @param keyRef
     * @return String
     */
    protected byte[] readSecretKey(String keyRef) {
        if (keyRef == null || keyRef.isEmpty()) {
            throw new IllegalArgumentException("Key is null");
        }
        if (keyRef.startsWith("file://")) {
            // keyRef.substring(7);
            try (InputStream is = Files.newInputStream(new File(keyRef).toPath())) {
                try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
                    String line = null;
                    StringBuilder sb = new StringBuilder();
                    while ((line = br.readLine()) != null) {
                        sb.append(line);
                    }
                    return Base64.getDecoder().decode(sb.toString());
                }
            } catch (Exception ex) {
                throw new IllegalArgumentException("Read key failed", ex);
            }
        } else {
            return Base64.getDecoder().decode(keyRef);
        }
    }
}
