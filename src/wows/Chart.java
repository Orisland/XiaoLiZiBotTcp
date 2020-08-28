package wows;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Chart {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
        WebDriver driver;
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("-headless");
        chromeOptions.addArguments("--user-data-dir=C:\\Users\\Orisland\\AppData\\Local\\Google\\Chrome\\User Data\\Default");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
//        String url1 = "https://wows-numbers.com/player/charts/";
//        String id = "";
//        String username = "";
//        String url = url1 + id + "," + username + "/";
        String url = "https://wows-numbers.com/player/charts/566316444,Orisland_EX/";
        driver.manage().window().setSize(new Dimension(1920,3000));
        driver.get(url);
        Thread.sleep(3000);
//        driver.findElements(By.xpath("/html/body/div[3]/p[2]/a[1]")).get(0).click();
//        driver.findElement(By.className("btn btn-primary btn-xs")).click();
//        driver.close();
        File pic = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try
        {
            org.apache.commons.io.FileUtils.copyFile(pic, new File("E:\\IdeaLib\\xiaolizi\\123.png"));  //使用copyFile()方法保存获取到的截图文件
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        driver.close();
    }
}
