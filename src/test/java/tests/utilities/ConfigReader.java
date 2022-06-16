package tests.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

  public static   Properties properties;

  static {
      properties=new Properties();
      String dosyaYolu="configuration.properties";
      try {
          FileInputStream fis=new FileInputStream(dosyaYolu);
          properties.load(fis);
      } catch (FileNotFoundException e) {
          e.printStackTrace();
      } catch (IOException e) {
          e.printStackTrace();
      }
  }

    public static String getProperty(String key){
        return properties.getProperty(key);
    }


}


//biz key veriyoruz value degerini almak istiyoruz
//propertiesın bize value getirebilmesi ıcın onun yolunu bilmemiz gerekir
// ve propertiese dosya yolunu ekliyoruz

//config reader aracı propertiesten aldıgı bilgileri classa ıletmek ıcın


