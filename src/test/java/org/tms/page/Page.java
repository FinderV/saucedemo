package org.tms.page;                                            //page object созд объекты кажд страницы, будут обращ все классы кот используют
                                                                 //для кажд страницы свой класс

import org.openqa.selenium.WebDriver;                            //абстрактн страница суперкласса
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.tms.driver.DriverSingleton;

import java.time.Duration;

public abstract class Page {                                     //2.   абстрактн т к наслед, никто не созд объект стр, не зачем сущ-ть для др

    protected WebDriver driver = DriverSingleton.getDriver();    //получить драйвер
    private final static int WAIT_TIMEOUT_SECONDS = 10;         // перем времени, можн указ разн

    protected Page() {
        PageFactory.initElements(driver, this);             //ссылка на объект страницы
    }

    //могл раб классы насл, можно отпр не только WebEl, также xpath
    protected WebElement waitVisibilityOf(WebElement element) {                 // эл кот дожидаемся, в LoginPage
        return new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS)).until(ExpectedConditions.visibilityOf(element));                                                          // ожидание
    }

    protected WebElement waitElementToBeClickable(WebElement element) {                 //дожидаемся кликабельн, в LoginPage
        return new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS)).until(ExpectedConditions.elementToBeClickable(element));
    }
}
