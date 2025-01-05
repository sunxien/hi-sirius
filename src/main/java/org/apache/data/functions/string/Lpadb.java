package org.apache.data.functions.string;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.data.constants.FunctionType;
import org.apache.data.functions.AbstractString2String;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;

/**
 * @author sunxien
 * @date 2025/1/3
 * @since 1.0.0-SNAPSHOT
 */
public final class Lpadb extends AbstractString2String {

    private static final Lpadb INSTANCE = new Lpadb();

    private Lpadb() {
    }

    public static Lpadb newInstance() {
        return INSTANCE;
    }

    /**
     * @param args
     * @return String
     */
    @Override
    public String call(String... args) {
        if (args == null || args.length != 3) {
            throw new IllegalArgumentException("Incorrect parameter count to function 'LPAD'");
        }
        if (args[0] == null || args[1] == null || args[2] == null) {
            return null;
        }
        String value = args[0];
        int paddedLength = Integer.parseInt(args[1]);
        if (paddedLength < 0) {
            return null;
        }
        String padString = args[2];
        if (padString.isEmpty()) {
            return StringUtils.EMPTY;
        }
        if (StringUtils.isEmpty(padString)) {
            padString = " ";
        } else if ((padString.getBytes()).length > 1) {
            throw new IllegalArgumentException("Incorrect pad string must be a single byte character");
        }
        int paddedSize = paddedLength - (value.getBytes()).length;
        if (paddedSize == 0) {
            return value;
        } else if (paddedSize < 0) {
            value = truncateb(value, paddedLength, padString.charAt(0));
            paddedSize = paddedLength - value.getBytes().length;
            if (paddedSize == 0) {
                return value;
            }
        }
        StringBuilder sb = new StringBuilder(paddedLength);
        for (int i = 0; i < paddedSize; i++) {
            sb.append(padString);
        }
        return sb.append(value).toString();
    }

    /**
     * @param value
     * @param fixedSize
     * @param padChar
     * @return String
     */
    private String truncateb(String value, int fixedSize, char padChar) {
        if (value == null) {
            return null;
        }

        Charset charset = Charset.defaultCharset();
        byte[] bytes = value.getBytes(charset);
        if (fixedSize >= bytes.length) {
            return value;
        }

        ByteBuffer bb = null;
        CharBuffer cb = null;
        try {
            bb = ByteBuffer.wrap(bytes, 0, fixedSize);
            cb = CharBuffer.allocate(fixedSize);

            CharsetDecoder decoder = charset.newDecoder();
            decoder.onMalformedInput(CodingErrorAction.IGNORE);
            decoder.decode(bb, cb, true);
            decoder.flush(cb);
            return new String(cb.array(), 0, cb.position());
        } finally {
            if (cb != null) {
                cb.clear();
            }
            if (bb != null) {
                bb.clear();
            }
        }
    }

    /**
     * @return String
     */
    @Override
    public String getName() {
        return FunctionType.LPADB.name();
    }
}
