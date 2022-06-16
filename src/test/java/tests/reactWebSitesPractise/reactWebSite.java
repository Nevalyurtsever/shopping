package tests.reactWebSitesPractise;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ReactShoppingWeb;
import tests.utilities.ConfigReader;
import tests.utilities.Driver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class reactWebSite {
    @Test
    public void reactWebsiteTest() throws InterruptedException {


        // 1."https://react-shopping-cart-67954.firebaseapp.com/" adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("reactUrl"));
        ReactShoppingWeb rsw = new ReactShoppingWeb();
        // 2.Web sitesindeki tüm öğeleri listeleyin ve yazdirin
        // (sitede 16 urun var, 1.urun : 2.urun :.....seklinde yazdirin )
        System.out.println("***Task1***");
        int sayac = 1;
        for (WebElement each : rsw.tumOgeler) {
            System.out.println(sayac + ". ürün " + each.getText());
            sayac++;
        }

        // 3.Stringlerden olusan bir ArrayList oluşturun ve Ürün Adlarını ArrayList'e yerleştirin
        System.out.println("***Task3***");
        List<String> urunAdlarıList = new ArrayList<>(Arrays.asList());
        for (WebElement each : rsw.tumOgeler) {
            urunAdlarıList.add(each.getText());
        }
        System.out.println("urunAdlarıList = " + urunAdlarıList);
        // list old ıcın 0 dan baslıcak 15 e kadar

        // 4.Siteden Rastgele 5 öğe seçin, sepete ekleyin ve sectiginiz öğelerin adlarını yazdırın
        // (Her ürün 1 defadan fazla eklenemez!)
        // 5.Her bir öğenin fiyatını toplayın ve sonucunuzu web sitesiyle karşılaştırın
        System.out.println("*** Task4 ***");
        List<Integer> randomSecilenIndexler = new ArrayList<>();
        double expectedToplamFiyat = 0;
        for (int i = 0; i < 5; i++) {
            Faker faker = new Faker();

            int randomIndex = faker.random().nextInt(urunAdlarıList.size());
            if (!randomSecilenIndexler.contains(randomIndex)) {
                randomSecilenIndexler.add(randomIndex);
                rsw.addtoCartButtonList.get(randomIndex).click();
                String secilenUrunfiyatı = rsw.fiyatListesi.get(randomIndex).getText();
                double secilenUrunFiyatDouble = Double.parseDouble(secilenUrunfiyatı.substring(1));
                System.out.println("urun adı: " + urunAdlarıList.get(randomIndex));
                System.out.println("fiyatı: " + secilenUrunFiyatDouble);
                expectedToplamFiyat += secilenUrunFiyatDouble;
                Thread.sleep(3000);
                rsw.Xbutton.click();

            } else {
                i--;
            }
            //eger aynı seye tıklarsa bosa gıtmesın diye hakkımızı 1 arttırmak ıcın i yi 1 azaltıyoruz okey


        }
        //faker ya yazdıgımız exclusive yani dahıl degil demek
        //16 ya kadar sayı doncek 5 kere
        //listdde index =0 old ıcın 15 de bıtecek

        System.out.println("urunlerin toplam fiyatı: " + expectedToplamFiyat);


        //6- sonuclar eslesiyorsa konsola test pass yazdırın
        rsw.sepetGoruntule.click();
        Thread.sleep(4000);
        String actualFiyatStr = rsw.actualFiyat.getText();
        double actualFiyatDouble = Double.parseDouble(actualFiyatStr.substring(2));
        Assert.assertEquals((int) actualFiyatDouble, (int) expectedToplamFiyat);

        //7- Checkout a tıklayın
        rsw.checkOut.click();
        Driver.driver.switchTo().alert().accept();
        Driver.closeDriver();
    }
}

