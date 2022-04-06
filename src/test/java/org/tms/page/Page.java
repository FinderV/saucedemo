package org.tms.page;                                   //page object созд объекты кажд страницы, будут обращ все классы кот используют
                                                        //для кажд страницы свой класс

import org.openqa.selenium.WebDriver;                   //абстрактн страница суперкласса
import org.openqa.selenium.support.PageFactory;
import org.tms.driver.DriverSingleton;

public abstract class Page {                                     //2.   абстрактн т к наслед, никто не созд объект стр, не зачем сущ-ть для др

    protected WebDriver driver = DriverSingleton.getDriver();    //получить драйвер

    protected Page() {
        PageFactory.initElements(driver, this);              //ссылка на объект страницы
    }
}
