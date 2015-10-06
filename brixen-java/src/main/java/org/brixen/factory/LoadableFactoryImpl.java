package org.brixen.factory;

import org.apache.commons.lang3.reflect.ConstructorUtils;
import org.brixen.pageobject.Loadable;
import org.brixen.bean.LoadableBean;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Serves as the factory for instantiating <b>Selenium</b>page objects.
 *
 * <p>
 * {@code LoadableFactoryImpl} assumes that the {@code class} definition for a page object defines a single-arg
 * constructor that takes an data transfer object as a parameter. In order to make use of the builder
 * {@code interfaces} that come with the API, this is the design pattern that page objects must use.
 */
public class LoadableFactoryImpl implements LoadableFactory {

    /** Create singleton instance of this {@code LoadableFactoryImpl} */
    private static final class Loader {
        private static final LoadableFactoryImpl INSTANCE = new LoadableFactoryImpl();
    }

    /** Constructs the singleton instance of this {@code LoadableFactoryImpl}. */
    private LoadableFactoryImpl() { }

    /**
     * Returns the singleton instance of {@code LoadableFactoryImpl}.
     *
     * @return  the singleton instance of {@code LoadableFactoryImpl}
     */
    public static LoadableFactoryImpl getInstance() {
        return Loader.INSTANCE;
    }

    /**
     * Constructs and returns an instance of the specified page object using the specified data transfer object.
     * <p>
     * The {@code class} definition for the specified page object must define a single-arg constructor which accepts
     * the data transfer object as a parameter in order for this {@code LoadableFactoryImpl} to create an instance of
     * it.
     *
     * @param bean              the data transfer object
     * @param componentClass    the {@code Class} of the page object
     * @param <BeanT>           the runtime type of the data transfer object
     * @param <LoadableT>       the runtime type of the page object
     * @return                  an instance of the specified page object
     * @throws IllegalArgumentException if the page object's {@code class} definition does not have a single-arg
     *         constructor that accepts the data transfer object as a parameter, the page object's {@code Class} is
     *         {@code abstract}, this {@code LoadableFactoryImpl} does not have access to the {@code class} definition
     *         of the page object, or if this {@code LoadableFactoryImpl} cannot construct an instance of the page
     *         object for any other reason
     * @throws IllegalStateException if the constructor for the specified page object throws an exception
     */
    @Override
    public <BeanT extends LoadableBean, LoadableT extends Loadable> LoadableT create(BeanT bean, Class<LoadableT>
            componentClass) {

        LoadableT component;

        try {
            Constructor<LoadableT> ctor = ConstructorUtils.getMatchingAccessibleConstructor(componentClass, bean
                    .getClass());

            if(ctor == null) {
                throw new IllegalArgumentException("Could not instantiate an instance of " +
                        componentClass + " because there is no single-arg constructor that takes a bean of type " +
                        bean.getClass());
            }

            component = ctor.newInstance(bean);
            return componentClass.cast(component);
        } catch (InstantiationException e) {
            throw new IllegalArgumentException("Could not instantiate an instance of " + componentClass + " because " +
                    "it is abstract or for some other reason", e);
        } catch (InvocationTargetException e) {
            throw new IllegalStateException("Could not instantiate an instance of " + componentClass + " because the " +
                    "constructor threw an exception", e);
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException("Could not instantiate an instance of " + componentClass + " because " +
                    "LoadableFactoryImpl does not have access to it", e);
        }
    }
}
