package tests.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Driver {

    //driver a heryerden ulasım olamsı gerektigi ıcın webdrıverımızda statıc olacak get drıver methodomuzda
    //closedriver methodumuzda
    //Driverımızda cons olusturuyoruz ve private yapıyoruz kı kımse bu calsstan obje olusturmasın
  private   Driver(){

    }

   public static WebDriver driver;
    public static WebDriver getDriver(){
        if (driver==null){
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
        return driver;
    }

    public static void  closeDriver(){
        if (driver!=null){
            driver.close();
            driver=null;
        }
    }


}
