package org.tms.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.tms.driver.DriverSingleton;

                                              //7.
public class BaseTest {

    protected WebDriver driver;    //protected все классы могут использовать, тот же что в Singleton

    @BeforeClass                                //все что одинаково для всех классов
    public void setUp() {
        driver = DriverSingleton.getDriver();
    }

    @AfterClass                                    //обращ в Singleton для закр драйвера и обнул ссылки
    public void stopBrowser() {
        DriverSingleton.closeDriver();
    }
}
