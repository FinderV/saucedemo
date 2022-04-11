package org.tms.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverSingleton {         //1.

    private static WebDriver driver;   //static обращ к перем без созд обьекта; 1. null; 2. установленный драйвер

    private DriverSingleton() {            //конструктор приватн внутри класса
    }

    public static WebDriver getDriver() {          //получ драйвера без созд обьекта
        if (null == driver) {
            switch (System.getProperty("browser")) {            //задается в add configiration
                case "firefox": {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                }
                default: {                                         //если не фаерфокс
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();                   // инициализация драйвера
                }
            }
            driver.manage().window().maximize();
            //driver.manage().timeouts().implicitlyWait(Duration.ofMillis(15000));    //15 сек
        }
        return driver;                                             //в др классе можем обращ к драйверу, в BaseTest например
    }

    public static void closeDriver() {
        driver.quit();                                             //закрывает драйвер
        driver = null;                                             //и обнуляет ссылку на объект
    }
}
