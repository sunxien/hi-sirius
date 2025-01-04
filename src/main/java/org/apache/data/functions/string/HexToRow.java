package org.apache.data.functions.string;

import org.apache.data.constants.FunctionType;
import org.apache.data.functions.AbstractBuiltinFunction;

/**
 * @author sunxien
 * @date 2025/1/3
 * @since 1.0.0-SNAPSHOT
 */
public class HexToRow extends AbstractBuiltinFunction<String> {

    /**
     * @param args
     * @return
     */
    @Override
    public String call(String[] args) {
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
