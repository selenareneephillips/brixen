package org.brixen.test.bean;

import org.brixen.bean.LoadableBean;
import org.brixen.bean.LoadableBeanImpl;
import org.testng.annotations.Test;

@Test(groups = {"LoadableBeanTestGroup"})
public class LoadableBeanTest {

    @Test(groups = {"ExpectedExceptionsTestGroup", "BeanExpectedExceptionsTestGroup",
            "LoadableBeanExpectedExceptionsTestGroup"},
            expectedExceptions = { IllegalArgumentException.class },
            expectedExceptionsMessageRegExp = "Cannot specify a load timeout less than 0 seconds"
    )
    public void shouldThrowExceptionForNegativeLoadTimeout() {
        final LoadableBean bean = new LoadableBeanImpl();
        bean.setLoadTimeout(-1);
    }

    @SuppressWarnings("ConstantConditions")
    @Test(groups = {"ExpectedExceptionsTestGroup", "BeanExpectedExceptionsTestGroup",
            "LoadableBeanExpectedExceptionsTestGroup"},
            expectedExceptions = { NullPointerException.class }
    )
    public void shouldThrowExceptionForNullDriver() {
        final LoadableBean bean = new LoadableBeanImpl();
        bean.setDriver(null);
    }
}