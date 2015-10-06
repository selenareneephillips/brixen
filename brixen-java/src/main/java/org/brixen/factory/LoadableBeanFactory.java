package org.brixen.factory;

import org.brixen.bean.LoadableBean;

/**
 * Defines the contract for a factory which instantiates data transfer objects to be used for constructing
 * <b>Selenium</b> page objects.
 */
public interface LoadableBeanFactory {
    /**
     * Constructs and returns an instance of the specified data transfer object {@code Class}.
     *
     * @param beanClass     the data transfer object {@code Class}
     * @param <BeanT>       the runtime time of the data transfer object
     * @return              an instance of the data transfer object
     */
    <BeanT extends LoadableBean> BeanT create(final Class<BeanT> beanClass);
}
