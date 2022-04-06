package org.tms.page;             //3. элементы страницы LoginPage

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Page {                       //имя класса, переменной существит

    @FindBy(xpath = "//input[@id='user-name']")         //имя поле логина
    private WebElement username;                        //инициализирует поле

    @FindBy(xpath = "//input[@id='password']")          //пароль
    private WebElement password;

    @FindBy(xpath = "//input[@id='login-button']")      //кнопка Логин
    private WebElement loginButton;                     //private - инкапсул, скрыв для др классов, для получ гетер

                                                        // public LoginPage() -конструктор из супер класса Page
    public LoginPage openPage(String url) {              // метод открытия страницы, можно создать в Page
        driver.get(url);                                 //абстракнт методы раот с единичными элементами
        return this;                                     // вызыв методы цепочкой в LoginPageservice, возвр обьект страницы
    }

    public LoginPage fillInUsername(String userName) {    //имя метода глагол, заполняет поле логином
        username.clear();                                //очистить поле перед вводом
        username.sendKeys(userName);
        return this;                                        //  возвр обьект страницы
    }

    public LoginPage fillInPassword(String keyPassword) {          //значения из параметров
        password.clear();                                          //указать пароль
        password.sendKeys(keyPassword);
        return this;
    }

    public void clickLoginButton() {                                  //нажать кнопку
        loginButton.click();                                         // в др месте будет весь процесс залогинивания
    }
}
