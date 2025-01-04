package org.apache.data.functions;

/**
 * @author sunxien
 * @date 2025/1/3
 * @since 1.0.0-SNAPSHOT
 */
public interface Function<T> {

    /**
     * Call this function and return.
     *
     * @param args
     * @return String
     */
    public abstract T call(T[] args);

    /**
     * Return the function name.
     * @return String
     */
    public abstract String getName();
}
