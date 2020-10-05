package tieba;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class tieba2 {
    public static void tieba2(){
        WebDriver driver = null;
        System.out.println("test");
        String path="C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedgedriver.exe";
        System.setProperty("webdriver.edge.driver",path);
        System.out.println("test");
        try{
            EdgeOptions options = new EdgeOptions();

            driver = new EdgeDriver();
            driver.get("https://www.baidu.com/s?ie=UTF-8&wd=selenium%20edge");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //driver.quit();
        }
    }

    public static void main(String[] args) {
        tieba2();
    }
}
