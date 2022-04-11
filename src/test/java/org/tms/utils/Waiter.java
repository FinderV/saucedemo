package org.tms.utils;     //9. содержит вспомог метод wait, для опис всех ожид

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.tms.driver.DriverSingleton;

import java.time.Duration;

public class Waiter {

    private final static int WAIT_TIMEOUT_SECONDS = 5;              //как в Page
    private final static int TIMEOUT_SECONDS = 500;

    private Waiter() {                 //не надо созд объекты
    }
    public static void waitForElementToBeClickable(WebElement element) {                                    // в люб месте прил, без созд объекта
        new FluentWait<>(DriverSingleton.getDriver()).withTimeout(Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .pollingEvery(Duration.ofMillis(TIMEOUT_SECONDS)).ignoring(NoSuchElementException.class)   //частота обращ, excep когда не находит продолж обращ
                .until((ExpectedCondition<Boolean>) webDriver -> element.isDisplayed() && element          //лямбда выраж, до тех пор пока выраж ст верным
                        .isEnabled());

    }
}
