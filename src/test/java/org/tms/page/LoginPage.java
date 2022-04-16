package org.tms.page;                                    //3. элементы страницы LoginPage

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.tms.utils.Waiter;

import java.time.Duration;

public class LoginPage extends Page {                   //имя класса, переменной существит

    @FindBy(xpath = "//input[@id='user-name']")         //имя поле логина
    private WebElement username;                        //инициализирует поле

    @FindBy(xpath = "//input[@id='password']")          //пароль
    private WebElement password;

    @FindBy(xpath = "//input[@id='login-button']")      //кнопка Логин
    private WebElement loginButton;                     //private - инкапсул, скрыв для др классов, для получ гетер

                                                        // public LoginPage() -конструктор из супер класса Page
    public LoginPage openPage(String url) {             // метод открытия страницы, можно создать в Page
        driver.get(url);                                //абстракнт методы работ с единичными элементами
        //new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(username));  //спрятать в базов стр Page
        return this;                                    // вызыв методы цепочкой в LoginPageservice, возвр обьект страницы
    }

    public LoginPage fillInUsername(String userName) {   //имя метода глагол, заполняет поле логином
        //new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(username));   //стар, явн ожиню, ждет когда появ эл 10 сек, как только появ эл
        //new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOf(username)); //нов версия, не буд раб т к неяв ожид больше
        waitVisibilityOf(username).sendKeys(userName);                      // мет ждет отображ username, из Page
        //username.clear();                                //очистить поле перед вводом, в баз не нужен
        //username.sendKeys(userName);                     // перенесли в waitVisibilityOf(username).sendKeys(userName);
        return this;                                     //  возвр обьект страницы
    }

    public LoginPage fillInPassword(String keyPassword) {          //значения из параметров
        waitVisibilityOf(password);
        password.clear();                                          //указать пароль
        password.sendKeys(keyPassword);
        return this;
    }

    public void clickLoginButton() {                                  //нажать кнопку
        //Waiter.waitForElementToBeClickable(loginButton);
        waitElementToBeClickable(loginButton).click();                          // ожид кнопку, не обязат, можно подожд и взаимод в 1 строчке
        //loginButton.click();                                         // в др месте будет весь процесс залогинивания
    }
}
