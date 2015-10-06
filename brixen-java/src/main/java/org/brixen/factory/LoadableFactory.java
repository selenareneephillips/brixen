package org.brixen.factory;

import org.brixen.pageobject.Loadable;
import org.brixen.bean.LoadableBean;
import org.brixen.builder.LoadableBuilder;

/**
 * Defines the contract for a factory which instantiates <b>Selenium</b> page objects.
 *
 * @see LoadableBean
 * @see LoadableBuilder
 */
public interface LoadableFactory {

    /**
     * Constructs and returns an instance of the specified page object using the specified data transfer object which
     * defines the state of the page object.
     *
     * @param bean           the data transfer object which defines the state of the page object
     * @param componentClass the {@code Class} of the page object
     * @param <BeanT>        the runtime type of the data transfer object
     * @param <LoadableT>    the runtime type of the page object
     * @return an instance of the specified page object
     */
    <BeanT extends LoadableBean, LoadableT extends Loadable> LoadableT create(BeanT bean, Class<LoadableT>
            componentClass);
}
