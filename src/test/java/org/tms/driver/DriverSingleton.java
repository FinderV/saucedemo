package org.tms.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSingleton {         //1.

    private static WebDriver driver;   //static обращ к перем без созд обьекта; 1. null; 2. установленный драйвер

    private DriverSingleton() {            //конструктор приватн внутри класса
    }

    public static WebDriver getDriver() {          //получ драйвера без созд обьекта
        if (null == driver) {
            switch (System.getProperty("browser")) {
                case "firefox": {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                }
                default: {                                        //если не фаерфокс
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();                   // инициализация драйвера
                }
            }
            driver.manage().window().maximize();
        }
        return driver;                        //в др классе можем обращ к драйверу
    }

    public static void closeDriver() {
        driver.quit();                             //закрывает драйвер
        driver = null;                             //обнуляет ссылку на объект
    }
}
