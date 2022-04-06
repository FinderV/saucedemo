package org.tms.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.tms.page.InventoryPage;
import org.tms.service.LoginPageService;

public class LoginPageTest extends BaseTest {                  //8. тестирует страницу логина, LoginPageTest запускается testng-smoke.xml

    private LoginPageService loginPageService = new LoginPageService();

    @Test                                                                                     //тестирует метод логин
    public void loginTest() {                                                                 //залогиниться, из LoginPageService
        InventoryPage inventoryPage = loginPageService.login();                               //получ страницу, не должно быть сл driver
        String actualTextOfInventoryPage = inventoryPage.getTexOfNameOfMainPageSection();     //опред там ли где нужно, вытаскиваем текст
        String expectedPagetext = "PRODUCTS";
        Assert.assertEquals(actualTextOfInventoryPage, expectedPagetext, "The actual text of the page does not match expected!");
        //если assert упадет,негат сл
    }
}
