package org.tms.service;                              //6.


import org.tms.model.User;
import org.tms.page.InventoryPage;
import org.tms.page.LoginPage;

public class LoginPageService {                              //вспомог класс, большие методы

    private static final String LOGIN_PAGE_URL = "https://www.saucedemo.com/";  //static final константа, урл не измен втеч выпол теста

    private LoginPage loginPage = new LoginPage();
    private User user = new User();

    public InventoryPage login() {                           //успешно перешли на ту стр-у, мет возвращ объект той страницы; мет login использ для LoginPageTest
        loginPage.openPage(LOGIN_PAGE_URL)                   //переход на страницу, запол поля, клик на кнопку, возвр страницу
                .fillInUsername(user.getName())              //методы цепочкой из LoginPage, подтяг из User(менять зн)
                .fillInPassword(user.getPassword())          //позвол не писать loginPage
                .clickLoginButton();                         //иногда помещ в LoginPage
        return new InventoryPage();                          //login возвращ новый объект страницы InventoryPage
    }
}
