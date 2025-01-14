package org.apache.sirius.data.functions.string;

import org.apache.sirius.common.enums.FunctionType;
import org.apache.sirius.common.utils.CodecUtils;
import org.apache.sirius.data.functions.AbstractString2String;

import java.util.Locale;

/**
 * @author sunxien
 * @date 2025/1/3
 * @since 1.0.0-SNAPSHOT
 */
public final class Nvl extends AbstractString2String {

    private static final Nvl INSTANCE = new Nvl();

    private Nvl() {
    }

    public static Nvl newInstance() {
        return INSTANCE;
    }

    /**
     * @param args
     * @return String
     */
    @Override
    public String call(String... args) {

        if (args == null || args.length != 2) {
            throw new IllegalArgumentException("Incorrect parameter count to function 'NVL'");
        }

        final String value = args[0];
        if (value != null) {
            return value;
        }

        String replacer = args[1];
        if (replacer == null) {
            return null;
        } else {
            replacer = replacer.trim().toLowerCase(Locale.getDefault());
            if (replacer.length() == 4 && replacer.startsWith("0x")) {
                try {
                    return new String(CodecUtils.decodeHex(replacer.substring(2)));
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            } else {
                return replacer;
            }
        }
    }

    /**
     * @return String
     */
    @Override
    public String getName() {
        return FunctionType.NVL.name();
    }
}
