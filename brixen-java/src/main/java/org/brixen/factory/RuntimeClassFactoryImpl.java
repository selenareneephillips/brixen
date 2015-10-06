package org.brixen.factory;

import com.google.common.reflect.TypeToken;

/**
 * Serves as the factory for instantiating runtime {@code Class} objects for the type parameters for generic
 * parameterized {@code classes}.
 *
 * <p>
 * This {@code class} uses the <b>Guava</b> reflection API. If you develop a {@code class} that makes use of this
 * factory, it works best if an {@code abstract} base {@code class} is the parameterized {@code class} and you write a
 * concrete {@code class} that {@code extends} it and specifies the type to its parent {@code class}. See the following
 * example:
 * <pre>{@code
 * public abstract MyGenericAbstractClass<MyGenericParam> {
 *.....implementation details.....
 * }
 *
 * public class MyConcreteClass extends MyGenericAbstractClass<MyType> {
 *     ....implementation details.....
 * }
 * }</pre>
 *
 * If your concrete {@code class} takes a generic parameter you have to use the following syntax when instantiating an
 * instance of it in order to determine the runtime type of the generic parameter through the <b>Guava</b> reflection
 * API:
 * <pre>{@code
 * MyGenericObject<MyRunTimeType> myGenericObjectVar = new MyGenericObject<>() {};
 * }</pre>
 *
 * If your concrete {@code class} does not take a generic parameter that you want to be able to derive the runtime type
 * for, you do not need to use the above syntax.
 */
public class RuntimeClassFactoryImpl implements RuntimeClassFactory {

    /** Create singleton instance of this {@code RuntimeClassFactoryImpl} */
    private static final class Loader {
        private static final RuntimeClassFactoryImpl INSTANCE = new RuntimeClassFactoryImpl();
    }

    /** Constructs the singleton instance of this {@code RuntimeClassFactoryImpl}. */
    private RuntimeClassFactoryImpl() { }

    /**
     * Returns the singleton instance of {@code RuntimeClassFactoryImpl}.
     *
     * @return  the singleton instance of {@code RuntimeClassFactoryImpl}
     */
    public static RuntimeClassFactoryImpl getInstance() {
        return Loader.INSTANCE;
    }

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
     * @throws IllegalArgumentException if the runtime {@code class} for the generic parameter cannot be derived
     */
    @Override
    public Class<?> create(TypeToken<?> typeToken, Class<?> parameterizedClass, int genericParamIndex) {

        final TypeToken<?> genericParam =
                typeToken.resolveType(parameterizedClass.getTypeParameters()[genericParamIndex]);
        Class<?> clazz = null;

        //First try to get a raw type
        try {
            clazz = Class.forName(genericParam.getRawType().getTypeName());
        } catch(ClassNotFoundException e) {
            //Do nothing....
        }

        //If getting raw type fails, try to get non-raw type
        if(clazz == null || clazz.isInterface()) {
            try {
                return Class.forName(genericParam.getType().getTypeName());
            } catch(ClassNotFoundException e) {
                throw new IllegalArgumentException("Unable to derive runtime class for: " + genericParam.getType()
                        .getTypeName(), e);
            }
        }

        return clazz;
    }
}
