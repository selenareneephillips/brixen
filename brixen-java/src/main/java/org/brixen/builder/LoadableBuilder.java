package org.brixen.builder;

import org.brixen.bean.LoadableBean;
import org.brixen.config.LoadableConfig;
import org.brixen.factory.LoadableFactory;
import org.brixen.pageobject.Loadable;
import org.openqa.selenium.WebDriver;

/**
 * Defines the contract for a builder of a basic <b>Selenium</b> page object.
 *
 * <p>
 * {@code LoadableBuilder} is used in conjunction with {@link LoadableBean} and {@link LoadableFactory} to
 * construct page objects. It is designed to be extended by other builder {@code interfaces} for more complex page
 * objects in such a way that any setter function on {@code LoadableBuilder} or an {@code interface} that
 * {@code extends} it can be called in any order. This is why {@code LoadableBuilder} has a self-referential generic
 * type parameter. This allows all setter functions to return a builder of the runtime type.
 * <p>
 * All builders within the page object API follow this design pattern. An {@code abstract} implementation is provided
 * for all builder {@code interfaces} which requires a self-referential generic type parameter. The
 * {@code abstract class} is meant to be extended by other types of builders that need additional setters.  The result
 * is that the inherited setter methods can be invoked in any order because they return a builder of the actual runtime
 * type. One does not have to call all the setters in a child builder {@code class} before calling the setters in the
 * parent builder {@code class} when building the page object.
 * <p>
 * For example, the abstract implementation for {@code LoadableBuilder} is {@link AbstractLoadableBuilder}. The
 * {@code class} declaration takes a self-referential parameter because it is meant to be extended by other builders.
 * These builders would define additional setter methods that need to return the runtime type of the sub-{@code class}.
 * <pre>{@code
 * public abstract class AbstractLoadableBuilder<
 *         LoadableT extends Loadable,
 *         BeanT extends LoadableBean,
 *         BuilderT extends LoadableBuilder<LoadableT,BeanT,BuilderT> //self-referential generic parameter
 *    >
 *    implements LoadableBuilder<LoadableT,BeanT,BuilderT>
 * }
 * </pre>
 * A setter method from {@code AbstractLoadableBuilder} is here:
 * <pre>{@code
 * //Note that the return type is the same as the self-referential generic type parameter specified in the class
 * //declaration. This is the runtime type of the builder. This is what allows the setters in AbstractLoadableBuilder
 * //to be called in any order with the setter methods in any sub-classes which extend it.
 * public BuilderT setDriver(WebDriver driver) {
 *     getState().setDriver(driver);
 *     return (BuilderT)this; //cast this AbstractLoadableBuilder to its runtime type before returning it
 * }
 * }
 * </pre>
 * There is a concrete implementation for {@code LoadableBuilder}: {@link LoadableBuilderImpl}. Its {@code class}
 * declaration does not take the self-referential parameter because it is not expected to be extended by another
 * builder {@code class} which would add additional setter methods that would need to return the runtime type of the
 * sub-{@code class}. In fact, {@code LoadableBuilderImpl} does not define any methods:
 * <pre>{@code
 * public class LoadableBuilderImpl<LoadableT extends Loadable>
 *         extends AbstractLoadableBuilder<LoadableT, LoadableBean, LoadableBuilderImpl<LoadableT>> {
 * }
 * }</pre>
 *
 * If you want to develop a bean and builder for a more complex page object than an {@code Loadable}, you would need
 * to write an {@code interface} for the builder that {@code extends LoadableBuilder}, an {@code interface} for the
 * bean that {@code extends} {@code LoadableBean} and an implementation for your bean. If you want extensibility for
 * the page object and its corresponding builder, you would need to provide {@code abstract} and concrete
 * implementations like those described above.
 *
 * @param <LoadableT>   the type of page object that this {@code LoadableBuilder} builds
 * @param <BeanT>       the data transfer object used to construct the page object that this {@code LoadableBuilder}
 *                      builds
 * @param <BuilderT>    the runtime type of this {@code LoadableBuilder}
 */
public interface LoadableBuilder<
            LoadableT extends Loadable,
            BeanT extends LoadableBean,
            BuilderT extends LoadableBuilder<LoadableT, BeanT, BuilderT>
        > {

    /**
     * Returns the {@code LoadableBean} which specifies all the necessary information to construct an instance of the
     * page object.
     *
     * @return  the {@code LoadableBean} which specifies all the necessary information to construct an instance of the
     *          page object
     */
    BeanT getState();

    /**
     * Sets the {@code Class} of the page object.
     *
     * @param componentClass    the {@code Class} of the page object
     * @return                  this {@code LoadableBuilder}, cast to its runtime type
     */
    BuilderT setComponentClass(Class<LoadableT> componentClass);

    /**
     * Returns the {@code Class} of the page object.
     *
     * @return  the {@code Class} of the page object
     */
    Class<LoadableT> getComponentClass();

    /**
     * Sets the {@code WebDriver} to use for browsing the page object.
     *
     * @param driver    the driver for browsing the page object
     * @return          this {@code LoadableBuilder}, cast to its runtime type
     */
    BuilderT setDriver(WebDriver driver);

    /**
     * Sets the load timeout in seconds for the page object.
     *
     * @param loadTimeout  the load timeout in seconds for the page object
     * @return             this {@code LoadableBuilder}, cast to its runtime type
     */
    BuilderT setLoadTimeout(int loadTimeout);

    /**
     * Sets the load timeout in seconds for the page object with the setting from the specified configuration.
     *
     * @param config       the configuration bean that encapsulates the settings in the JSON configuration source for
     *                     the page object
     * @return             this {@code LoadableBuilder}, cast to its runtime type
     */
    BuilderT setLoadTimeout(LoadableConfig config);

    /**
     * Instantiates and returns an instance of the page object.
     *
     * @return      an instance of the page object
     */
    LoadableT build();
}