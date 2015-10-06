package org.brixen.builder;

import org.brixen.bean.ClickableBean;
import org.brixen.config.ClickableConfig;
import org.brixen.pageobject.Clickable;

/**
 * Serves as an {@code abstract} builder of <b>Selenium</b> page object which models a {@code Clickable} component.
 *
 * @param <ClickableT>   the type of {@code Clickable} page object that this {@code AbstractClickableBuilder} builds
 * @param <BeanT>        the data transfer object used to construct the {@code Clickable} page object that this
 *                       {@code AbstractClickableBuilder} builds
 * @param <BuilderT>     the runtime type of this {@code AbstractClickableBuilder}
 */
public abstract class AbstractClickableBuilder<
        ClickableT extends Clickable,
        BeanT extends ClickableBean,
        BuilderT extends ClickableBuilder<ClickableT,BeanT,BuilderT>
    > extends AbstractContentContainerBuilder<ClickableT,BeanT,BuilderT>
    implements ClickableBuilder<ClickableT,BeanT,BuilderT> {

    /**
     * Constructs an {@code AbstractClickableBuilder} with the specified {@code ClickableBean} to define the state of
     * the page object.
     *
     * @param state     the {@code ClickableBean} that defines the state of the page object
     */
    public AbstractClickableBuilder(BeanT state) {
        super(state);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public BuilderT setClickWithJavascript(boolean setClickWithJavascript) {
        getState().setClickWithJavascript(setClickWithJavascript);
        return (BuilderT)this;
    }

    /**
     * Enables or disabled the Javascript click workaround, based on the configuration value for this flag in the
     * specified {@code ClickableConfig}.
     * <p>
     * If the specified configuration is {@code null}, if it does not define a value for the flag or if it defines an
     * explicit {@code null} value for the flag, the default value of the flag is left unchanged.
     *
     * @param config    the configuration bean that encapsulates the settings in the JSON configuration source for the
     *                  {@code Clickable} page opbject
     * @return          this {@code AbstractClickableBuilder}, cast to its runtime type
     */
    @SuppressWarnings("unchecked")
    @Override
    public BuilderT setClickWithJavascript(ClickableConfig config) {
        if(config != null) {
            if(config.getClickWithJavascript() != null && config.getClickWithJavascript().get() != null) {
                setClickWithJavascript(config.getClickWithJavascript().get());
            }
        }

        return (BuilderT)this;
    }
}
