package org.brixen.test.bean;

import org.brixen.bean.LoadableBean;
import org.brixen.bean.LoadableBeanImpl;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

@Test(groups = {"LoadableBeanTestGroup"})
public class LoadableBeanTest {

    private @Mock WebDriver mockDriverOne;
    private @Mock WebDriver mockDriverTwo;

    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

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

    @Test(groups = {"EqualityNegativeTestGroup", "BeanEqualityNegativeTestGroup",
            "LoadableBeanEqualityNegativeTestGroup"}
    )
    public void shouldNotBeEqual() {
        LoadableBean beanOne = new LoadableBeanImpl();
        LoadableBean beanTwo = new LoadableBeanImpl();

        beanOne.setDriver(mockDriverOne);
        beanTwo.setDriver(mockDriverTwo);

        assertNotEquals(beanOne, beanTwo, "Beans with different driver references should not be equal");

        beanOne = new LoadableBeanImpl();
        beanTwo = new LoadableBeanImpl();

        beanOne.setLoadTimeout(40);

        assertNotEquals(beanOne, beanTwo, "Beans with different load timeouts should not be equal");
    }

    @Test(groups = {"EqualityPositiveTestGroup", "BeanEqualityPositiveTestGroup",
            "LoadableBeanEqualityPositiveTestGroup"}
    )
    public void shouldBeEqual() {
        LoadableBean beanOne = new LoadableBeanImpl();
        LoadableBean beanTwo = new LoadableBeanImpl();

        assertEquals(beanOne, beanTwo, "Two newly constructed beans should be equal before any setters are invoked");

        beanOne.setDriver(mockDriverOne);
        beanTwo.setDriver(mockDriverOne);

        assertEquals(beanOne, beanTwo, "Two beans should be equal if they have the same web driver reference and the " +
                "default load timeout");

        beanOne.setLoadTimeout(40);
        beanTwo.setLoadTimeout(40);

        assertEquals(beanOne, beanTwo, "Two beans should be equal if they have the same web driver reference and the " +
                "same non-default load timeout");

        beanOne = new LoadableBeanImpl();
        beanTwo = new LoadableBeanImpl();

        beanOne.setLoadTimeout(40);
        beanTwo.setLoadTimeout(40);

        assertEquals(beanOne, beanTwo, "Two beans should be equal if they have null web driver reference and the " +
                "same non-default load timeout");
    }
}