package org.brixen.factory;

import com.google.common.reflect.TypeToken;

/**
 * Defines the contract for a factory that instantiates runtime {@code Class} objects for the type parameters for
 * generic parameterized {@code classes}.
 */
public interface RuntimeClassFactory {
    /**
     * Constructs and returns an instance of the runtime {@code Class} object for the generic type parameter with the
     * specified index for the specified parameterized {@code class}.
     *
     * @param typeToken             the type token for the specified parameterized {@code class}
     * @param parameterizedClass    the parameterized {@code class} for which to get a runtime {@code Class} object for
     *                              the generic type parameter at the specified index
     * @param genericParamIndex     the index of the generic type parameter for which to get a runtime {@code Class}
     *                              object; the first type parameter in the list of type parameters for a parameterized
     *                              {@code class} has index 0
     * @return                      the runtime {@code Class} object for the generic type parameter at the specified
     *                              index
     */
    Class<?> create(TypeToken<?> typeToken, Class<?> parameterizedClass, int genericParamIndex);
}
