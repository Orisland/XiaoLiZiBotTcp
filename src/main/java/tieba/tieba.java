package tieba;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class tieba {
    public static void autodata(){
        System.setProperty("webdriver.chrome.driver","C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
        WebDriver driver = null;

        try {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--disable-gpu");
            chromeOptions.addArguments("--user-data-dir=E:\\chromedata");
            //chromeOptions.addArguments("--headless");
            driver = new ChromeDriver(chromeOptions);
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            String url = "https://tieba.baidu.com/p/5811378801";
            driver.manage().window().setSize(new Dimension(1920,1080));
            driver.get(url);
            System.out.println("正在打开网页");
            ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");
            Thread.sleep(2000);
            System.out.println("键入内容");
            driver.findElement(By.id("ueditor_replace")).sendKeys("dd");
            driver.findElement(By.id("ueditor_replace")).click();
            Thread.sleep(3000);
            System.out.println("正在发送");
            driver.findElement(By.xpath("//*[@id=\"tb_rich_poster\"]/div[3]/div[3]/div/a/span/em")).click();
            driver.findElement(By.id("ueditor_replace")).sendKeys(Keys.CONTROL,Keys.ENTER);
            File pic = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            try
            {
                org.apache.commons.io.FileUtils.copyFile(pic, new File("E:\\IdeaLib\\xiaolizi\\JDK165\\src\\main\\resources\\123.png"));  //使用copyFile()方法保存获取到的截图文件
            } catch (IOException e)
            {
                e.printStackTrace();
            }
            Thread.sleep(3000);
            System.out.println("发送完成");

            //driver.findElement(By.xpath("//*[@id=\"tb_rich_poster\"]/div[3]/div[3]/div")).click();
            //driver.findElement(By.xpath("//*[@id=\"ueditor_replace\"]/p")).sendKeys("123456789");

//            System.out.println(((JavascriptExecutor)driver).executeScript("document.getElementById(\"ueditor_replace\").childNodes[0]"));


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            driver.quit();
        }
    }

    public static void main(String[] args) {

    }
}
