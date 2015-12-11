package org.brixen.test.decorator.bean;

import org.brixen.bean.LoadableBean;
import org.brixen.decorator.bean.LoadableBeanProvider;
import org.testng.annotations.Test;

@Test(groups = {"ProviderTestGroup"})
public class LoadableBeanProviderTest {

    @SuppressWarnings("ConstantConditions")
    @Test(groups = {"ExpectedExceptionsTestGroup", "ProviderExpectedExceptionsTestGroup",
            "LoadableBeanProviderExpectedExceptionsTestGroup"},
            expectedExceptions = { NullPointerException.class },
            expectedExceptionsMessageRegExp = "Cannot construct a LoadableBeanProvider with a null bean"
    )
    public void shouldThrowExceptionForNullBean() {
        new LoadableBeanProvider<>((LoadableBean)null);
    }
}
