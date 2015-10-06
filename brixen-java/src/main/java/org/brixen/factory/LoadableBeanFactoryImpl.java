package org.brixen.factory;

import org.brixen.bean.LoadableBean;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Serves as the factory for instantiating data transfer objects to be used for constructing <b>Selenium</b> page
 * objects.
 *
 * <p>
 * {@code LoadableBeanFactoryImpl} assumes that the {@code class} definition for the desired data transfer object has a
 * no-arg constructor. In order to make use of the builder {@code interfaces} that come with te <b>Kwatee</b> API, this
 * is the design pattern that data transfer objects for page objects must use.
 */
public final class LoadableBeanFactoryImpl implements LoadableBeanFactory {

    /** Create singleton instance of this {@code LoadableBeanFactoryImpl} */
    private static final class Loader {
        private static final LoadableBeanFactoryImpl INSTANCE = new LoadableBeanFactoryImpl();
    }

    /** Constructs the singleton instance of this {@code LoadableBeanFactoryImpl}. */
    private LoadableBeanFactoryImpl() { }

    /**
     * Returns the singleton instance of {@code LoadableBeanFactoryImpl}.
     *
     * @return  the singleton instance of {@code LoadableBeanFactoryImpl}
     */
    public static LoadableBeanFactoryImpl getInstance() {
        return Loader.INSTANCE;
    }

    /**
     * Constructs and returns an instance of the specified data transfer object.
     * <p>
     * The {@code class} definition for the specified data transfer must define a no-arg constructor in order for this
     * {@code LoadableBeanFactoryImpl} to create an instance of it.
     *
     * @param beanClass         the {@code Class} of the data transfer object
     * @param <BeanT>           the runtime type of the data transfer object
     * @return                  an instance of the specified data transfer object
     * @throws IllegalArgumentException if the data transfer object's {@code class} definition does not have a no-arg
     *         constructor, the data transfer object's {@code Class} is {@code abstract}, this
     *         {@code LoadableBeanFactoryImpl} does not have access to the {@code class} definition of the data
     *         transfer object, or if this {@code LoadableBeanFactoryImpl} cannot construct an instance of the data
     *         transfer object for any other reason
     * @throws IllegalStateException if the constructor for the specified data transfer object throws an exception
     */
    //TODO Develop a enumerated set of exception codes for this method
    @Override
    public final <BeanT extends LoadableBean> BeanT create(final Class<BeanT> beanClass) {
        final BeanT optionBean ;

        try {
            final Constructor<BeanT> ctor = beanClass.getConstructor();
            optionBean = ctor.newInstance();
            return beanClass.cast(optionBean);
        } catch (NoSuchMethodException e) {
            throw new IllegalArgumentException("Could not instantiate an instance of " + beanClass + " because it " +
                    "does not have a no-arg constructor", e);
        } catch (InstantiationException e) {
            throw new IllegalArgumentException("Could not instantiate an instance of " + beanClass + " because it is " +
                    "abstract or for some other reason", e);
        } catch (InvocationTargetException e) {
            throw new IllegalStateException("Could not instantiate an instance of " + beanClass + " because the " +
                    "constructor threw an exception", e);
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException("Could not instantiate an instance of " + beanClass + " because " +
                    "LoadableFactoryImpl does not have access to it", e);
        }
    }
}


