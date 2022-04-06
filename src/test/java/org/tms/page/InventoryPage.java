package org.tms.page;                                              //5.

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
                                                                //страница проверки -
public class InventoryPage extends Page {

    @FindBy(xpath ="//span[@class='title']")
    private WebElement nameOfMainPageSection;

    public String getTexOfNameOfMainPageSection(){             //метод смысл глагол getText...
    return nameOfMainPageSection.getText();                    //получаем текст название констольной страницы
            }
}
