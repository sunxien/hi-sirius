package org.apache.sirius.data.functions.string;

import org.apache.sirius.common.enums.FunctionType;
import org.apache.sirius.data.functions.AbstractString2String;

/**
 * @author sunxien
 * @date 2025/1/3
 * @since 1.0.0-SNAPSHOT
 */
public final class HexToRow extends AbstractString2String {

    private static final HexToRow INSTANCE = new HexToRow();

    private HexToRow() {
    }

    public static HexToRow newInstance() {
        return INSTANCE;
    }

    /**
     * @param args
     * @return
     */
    @Override
    public String call(String... args) {
        return "";
    }

    /**
     * @return String
     */
    @Override
    public String getName() {
        return FunctionType.HEXTORAW.name();
    }
}
