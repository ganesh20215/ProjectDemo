package testbase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utility.Util;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

public class WebTestBase {
    public static WebDriver driver;
    public static Properties prop;

    public WebTestBase() {
        try {
            FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/properties/config.properties");
            prop = new Properties();
            prop.load(fileInputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void initialization() {
        String browserName = prop.getProperty("browser");
        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/driver/chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browserName.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/main/resources/driver/geckodriver.exe");
            driver = new ChromeDriver();
        } else if (browserName.equals("edge")) {
            System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "/src/main/resources/driver/msedgedriver.exe");
            driver = new ChromeDriver();
        } else {
            System.out.println("Please insert valid browser name");
        }
        driver.get(prop.getProperty("url"));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Util.PAGELOADTIMEOUT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Util.IMPLICITEWAIT));
    }
}

