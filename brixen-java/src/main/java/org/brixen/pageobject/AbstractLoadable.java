package org.brixen.pageobject;

import lombok.Getter;
import lombok.extern.slf4j.XSlf4j;
import org.brixen.config.ConfigService;
import org.brixen.config.ConfigServiceImpl;
import org.brixen.config.LoadableConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.SlowLoadableComponent;
import org.openqa.selenium.support.ui.SystemClock;
import org.brixen.bean.LoadableBean;

/**
 * Serves as an {@code abstract} implementation for a basic <b>Selenium</b> page object.
 *
 * <p>
 * {@code AbstractLoadable} {@code extends} the {@link SlowLoadableComponent} {@code class} in the <b>Selenium</b>
 * support library. {@code SlowLoadableComponent} offers several advantages:
 * <ul>
 * <li>It provides a standard way to ensure that page objects are loaded
 * <li>It provides some hooks to facilitate debugging the failure of a page object to load
 * <li>It provides a mechanism for configuring load timeouts for page objects that are slow to load
 * <li>It makes it possible to write tests with less boilerplate code
 * </ul>
 * <p>
 *
 * @see WebDriver
 * @see org.openqa.selenium.WebElement
 * @see PageFactory
 * @param <LoadableT> the {@code class} which {@code extends} this {@code AbstractLoadable}
 */
@XSlf4j
@SuppressWarnings("UnusedDeclaration")
public abstract class AbstractLoadable<LoadableT extends AbstractLoadable<LoadableT>> extends
        SlowLoadableComponent<LoadableT> implements Loadable {

    /** The driver for browsing this {@code AbstractLoadable} */
    private final @Getter WebDriver driver;

    /** The load timeout in seconds for this {@code AbstractLoadable} */
    private final @Getter int loadTimeout;

    /**
     * Constructs an {@code AbstractLoadable} with the state specified by the {@code LoadableBean}.
     *
     * @param bean  the data transfer object for constructing this {@code AbstractLoadable}
     */
    public AbstractLoadable(final LoadableBean bean) {
        super(new SystemClock(), bean.getLoadTimeout());

        this.driver = bean.getDriver();
        this.loadTimeout = bean.getLoadTimeout();
    }

    /**
     * Loads this {@code AbstractLoadable} by initializing its elements through
     * {@link PageFactory#initElements(WebDriver, Object)}.
     * <p>
     * {@code PageFactory#initElements(WebDriver, Object)} generates dynamic proxy {@code classes} for all the
     * {@code WebElements} declared as fields on this {@code AbstractLoadable} which are annotated with {@code FindBy},
     * {@code FindBys} or {@code FindAll}. These fields will be {@code null} until this {@code AbstractLoadable} is
     * initialized through {@code PageFactory}.
     */
    @Override
    protected void load() {
        PageFactory.initElements(getDriver(), this);
    }

    /**
     * Gets the configuration service that provides access to component configurations by {@code String id}.
     *
     * @return  the configuration service that provides access to component configurations by {@code String id}.
     */
    protected ConfigService getConfigService() {
        return ConfigServiceImpl.getInstance();
    }

    /**
     * Retrieves a component configuration by {@code String id}.
     *
     * @param configId      the id of the configuration to retrieve
     * @param <ConfigT>     the type of the configuration to retrieve
     * @return              the configuration if it exists, {@code null} otherwise
     */
    protected <ConfigT extends LoadableConfig> ConfigT getConfig(final String configId) {
        return getConfigService().getConfig(configId, getDriver());
    }

    /**
     * Retrieves the specified custom configuration property from the specified configuration.
     * <p>
     *  A custom configuration property is a property which is not defined or required by the {@code interface(s)}
     *  implemented by the configuration.
     *
     * @param configId          the ID of the configuration
     * @param propertyName      the name of the custom configuration property
     * @param propertyType      the {@code Class} type of the custom configuration property
     * @param <TypeT>           the type of the customer configuration property
     * @return                  the specified custom configuration property from the specified configuration
     */
    protected <TypeT> TypeT getCustomConfigProperty(String configId, String propertyName, Class<TypeT> propertyType) {
        LoadableConfig config = getConfig(configId);

        if(config != null) {
            log.debug("There is a config with id {} for the current environment", configId);
            return propertyType.cast(config.getAdditionalProperties().get(propertyName));
        }

        log.debug("There is no config with id {} for the current environment", configId);

        return null;
    }
}