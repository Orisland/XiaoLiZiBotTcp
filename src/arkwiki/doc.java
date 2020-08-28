package arkwiki;

import arkwiki.bot.Core;
import com.sun.java.swing.plaf.windows.resources.windows;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import arkwiki.bot.arkWikiMain;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class doc {

    public static String docbase64(String juse, int i) {
        System.setProperty("webdriver.chrome.driver", "C:\\酷Q Pro\\Application\\chromedriver.exe");
        WebDriver driver=null;
        String pic="";
        //ChromeDriverService service = new ChromeDriverService.Builder().usingDriverExecutable(new File("C:\\酷Q Pro\\Application\\chromedriver.exe")).usingAnyFreePort().build();
        //尝试使用其他方式来进行操作
        try{
            ChromeOptions chromeOptions=new ChromeOptions();
            chromeOptions.addArguments("-headless");
            driver = new ChromeDriver(chromeOptions);
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            String url1 = "http://prts.wiki/w/";
            String url2 = "#.E5.90.8E.E5.8B.A4.E6.8A.80.E8.83.BD";
            String url;
            if (i == 1){
                url = url1 + juse;
                driver.manage().window().setSize(new Dimension(900,6700));
                Core.sendGroupMessages(arkWikiMain.selfQQ,arkWikiMain.fromGroup,"长图模式~",0);
            }
            else {
                url = url1+juse+url2;
                driver.manage().window().setSize(new Dimension(900,1200));
                Core.sendGroupMessages(arkWikiMain.selfQQ,arkWikiMain.fromGroup,"区域模式~",0);
            }
            System.out.println("加载页面");
            driver.get(url);
            //((JavascriptExecutor)driver).executeScript("document.body.style.zoom='0.9'");
            ((JavascriptExecutor)driver).executeScript("window.scrollBy(100,0)");
            System.out.println("chrome页面加载");
            Thread.sleep(3000);
            pic = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
            System.out.println("转化完毕");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            driver.quit();      //不能close，否则chromedriver进程仍然存在。
        }

        return pic;
    }

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
        WebDriver driver;
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(900,2000));

//        driver.get("http://prts.wiki/w/巫恋#.E7.B2.BE.E8.8B.B1.E5.8C.96.E6.9D.90.E6.96.99");
        driver.get("http://prts.wiki/w/巫恋");
//        ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,4550)");
        ((JavascriptExecutor)driver).executeScript("document.body.style.zoom='0.9'");
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(100,4020)");
//        System.out.println(((JavascriptExecutor)driver).executeScript("window.getScrollX"));
//        System.out.println(((JavascriptExecutor)driver).executeScript("window.getScrollY"));;
        Thread.sleep(3000);
        File pic = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try
        {
            org.apache.commons.io.FileUtils.copyFile(pic, new File("E:\\IdeaLib\\xiaolizi\\123.png"));  //使用copyFile()方法保存获取到的截图文件
        } catch (IOException e)
        {
            e.printStackTrace();
        }
//        System.out.println(driver.findElements(By.tagName("table")).size());
//        List<WebElement> list = driver.findElements(By.tagName("table"));
//        for (WebElement webElement : list){
//            System.out.println(webElement.getText());
//        }
        //System.out.println(driver.getPageSource());
        driver.manage().deleteAllCookies();
        driver.close();


//        try {
//            Thread.sleep(3000);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        driver.close();
    }
}
