package org.apache.data.functions.maksing;

import org.apache.data.constants.FunctionType;
import org.apache.data.functions.AbstractString2String;

/**
 * @author sunxien
 * @date 2025/1/5
 * @since 1.0.0-SNAPSHOT
 */
public final class MaskRangeN extends AbstractString2String {

    private static final MaskRangeN INSTANCE = new MaskRangeN();

    private MaskRangeN() {
    }

    public static MaskRangeN newInstance() {
        return INSTANCE;
    }

    /**
     * SQL: select mask_range_n('13854320087', 4, 7, '*') from dual;
     *
     * @param args
     * @return
     */
    @Override
    public String call(String... args) {
        if (args == null || args.length != 4) {
            throw new IllegalArgumentException("Incorrect parameter count to function 'MASK_RANGE_N'");
        }
        try {
            String value = args[0];
            final char[] chars = value.toCharArray();
            final int fromIndex = Integer.parseInt(args[1]);
            final int toIndex = Integer.parseInt(args[2]);
            if (fromIndex < 0 || toIndex > chars.length) {
                throw new IllegalArgumentException("Incorrect parameters to function MASK_RANGE_N");
            }
            final String replacement = args[3];
            if (replacement == null || replacement.trim().length() != 1) {
                throw new IllegalArgumentException("Incorrect parameters to function MASK_RANGE_N");
            }
            for (int i = fromIndex; i < toIndex; i++) {
                chars[i] = replacement.charAt(0);
            }
            return new String(chars);
        } catch (Exception ex) {
            throw new IllegalArgumentException("Incorrect parameters to function MASK_RANGE_N");
        }
    }

    @Deprecated
    public static void main(String[] args) {
        System.out.println(MaskRangeN.newInstance().call("13854320087", "3", "7", "*"));
    }

    @Override
    public String getName() {
        return FunctionType.MASK_RANGE_N.name();
    }
}
