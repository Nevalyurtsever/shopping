package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import tests.utilities.Driver;

import java.util.List;

public class ReactShoppingWeb {
    public ReactShoppingWeb() {
        PageFactory.initElements(Driver.getDriver(), this);//driverimizi tanıttık bu calssta her obje olusturuldugunda
        //drıver olarak bunu al

    }

    @FindBy(xpath = "//p[@class='sc-124al1g-4 eeXMBo']")// 16 tane oldugu ıcın webelemtdden olusan list dondu
    public List<WebElement> tumOgeler;

    @FindBy(xpath = "//button[@class='sc-124al1g-0 jCsgpZ']")
    public List<WebElement> addtoCartButtonList;
    @FindBy(xpath = "//*[@class='sc-1h98xa9-0 gFkyvN']")
    public WebElement Xbutton;
    @FindBy(xpath = "//p[@class='sc-124al1g-6 ljgnQL']")
    public List<WebElement> fiyatListesi;
    @FindBy(xpath = "//*[@class='sc-1h98xa9-2 fGgnoG']")
    public WebElement sepetGoruntule;
    @FindBy(xpath = "//p[@class='sc-1h98xa9-9 jzywDV']")
    public WebElement actualFiyat;
    @FindBy(xpath = "//button[@class='sc-1h98xa9-11 gnXVNU']")
    public WebElement checkOut;


}
