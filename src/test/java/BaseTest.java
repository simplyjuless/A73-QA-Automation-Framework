import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.rmi.Remote;
import java.time.Duration;
import java.util.HashMap;

public class BaseTest {
    public static WebDriver driver = null;
    public static Actions actions = null;
    public static WebDriver wait = null;
    public static String = null;

    private static final ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();


    private String url;

    @BeforeSuite
    static void setupClass() {

        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void setUpBrowser(String BaseURL) throws MalformedURLException {
        //this is the initiation for gradle command
        threadDriver.set(pickBrowser(System.getProperty("browser")));
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);

        url = BaseURL;
        navigateToPage();
    }

    public void launchBrowser(String BaseURL) throws MalformedURLException {

        driver = pickBrowser(System.getProperty("browser"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        url = BaseURL;
        navigateToPage();
    }

    @AfterMethod
    public void tearDown(){
        threadDriver.get().quit();
        threadDriver.remove();
    }

    public void closerBrowser() {
        driver.quit();
    }

    private void navigateToPage() {
        getDriver().get(url);
    }

    public static WebDriver getDriver() {
        return threadDriver.get();
    }

    public WebDriver lambdatest(){
        String hubURL="https://hub.lambdatest.com/wb/hub";

        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("dev");
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("username", "Your LambdaTest Username");
        ltOptions.put("accessKey", "Your LambdaTest Access Key");
        ltOptions.put("project", "Untitled");
        ltOptions.put("w3c", true);
        ltOptions.put("plugin", "java-java");
        browserOptions.setCapability("LT:Options", ltOptions);

        return new RemoteWebDriver(new URL(hubURL),browserOptions);
    }

    public WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://192.168.1.232:4444/wd/hub";

        switch (browser){
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return driver= new FirefoxDriver();

            case "MicrosoftEdge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeoptions = new EdgeOptions();
                edgeoptions.addArguments("--remote-allow-origins=*");
                return driver = new EdgeDriver(edgeoptions);

            case "grid-edge": //gradle clean test -Dbrowser=grid-edge
                caps.setCapability("browserName", "MicrosoftEdge");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);

            case "grid-firefox":
                caps.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);

            case "grid-chrome":
                caps.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);

            case "cloud":
                return lambdatest();

            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                return driver = new ChromeDriver(options);
        }
    }
}
