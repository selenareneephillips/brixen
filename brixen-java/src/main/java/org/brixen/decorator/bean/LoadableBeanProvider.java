package org.brixen.decorator.bean;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.brixen.bean.LoadableBean;

/**
 * Serves as a {@code protected} access provider for an implementation of {@code LoadableBean} or an {@code interface}
 * extending {@code LoadableBean}.
 * <p>
 * {@code LoadableBeanProvider} is a means for avoiding unnecessary access to internal data for {@code classes} which
 * implement decorator {@code interfaces} for state beans.
 *
 * @param <BeanT>   the state bean to which this {@code LoadableBeanProvider} provides {@code protected} access
 */
@ToString(includeFieldNames = true)
@EqualsAndHashCode
public class LoadableBeanProvider<BeanT extends LoadableBean> {

    /**
     * The state bean to which this {@code LoadableBeanProvider} provides {@code protected} access
     */
    private @Getter(AccessLevel.PROTECTED) BeanT bean;

    /**
     * Constructs a {@code LoadableBeanProvider} which provides {@code protected} access to the specified state bean.
     *
     * @param bean  the state bean to which this {@code LoadableBeanProvider} provides {@code protected} access
     * @throws NullPointerException if the specified state bean is {@code null}
     *
     */
    public LoadableBeanProvider(BeanT bean) {
        if(bean == null) {
            throw new NullPointerException("Cannot construct a LoadableBeanProvider with a null bean");
        }

        this.bean = bean;
    }
}
