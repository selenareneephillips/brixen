package org.brixen.function;

/**
 * Function interface which accepts three parameters and returns no value.
 *
 * @param <T>   the first parameter
 * @param <U>   the second parameter
 * @param <V>   the third parameter
 */
@FunctionalInterface
@SuppressWarnings("UnusedDeclaration")
public interface TriConsumer<T,U,V> {

    /**
     * Consumes the three specified parameters.
     *
     * @param v   the first parameter
     * @param u   the second parameter
     * @param v   the third parameter
     */
    void accept(T t, U u, V v);
}
