package org.brixen.config;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.brixen.pageobject.ClickControl;

/**
 * Serves as a POJO to encapsulate the data deserialized by <b>Jackson</b> from the JSON configuration source for a
 * {@link ClickControl}.
 */
@ToString(callSuper = true, includeFieldNames = true)
@EqualsAndHashCode(callSuper = true)
public class ClickControlConfigImpl extends ClickableConfigImpl implements ClickControlConfig {
}
