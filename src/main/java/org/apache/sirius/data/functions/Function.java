package org.apache.sirius.data.functions;

/**
 * @author sunxien
 * @date 2025/1/3
 * @since 1.0.0-SNAPSHOT
 */
public interface Function<Input, Output> {

    /**
     * Call this function and return.
     *
     * @param args
     * @return String
     */
    public abstract Output call(Input... args);

    /**
     * Return the function name.
     *
     * @return String
     */
    public abstract String getName();
}
