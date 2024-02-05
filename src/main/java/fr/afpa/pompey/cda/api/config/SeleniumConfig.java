package fr.afpa.pompey.cda.api.config;

import java.io.File;
import java.time.Duration;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@Data
public class SeleniumConfig {

    private WebDriver driver;

    public SeleniumConfig() {
        //System.setProperty("webdriver.gecko.driver", "D:\\PROJETS\\JAVA\\SPRINGBOOT\\api\\driver\\geckodriver.exe");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        // positionnement d'une temporisation entre les actions
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    /**
     * methode de fermeture du driver
     */
    public void close() {
        driver.close();
    }

    /**
     * methode de navigation à l'url donnée
     * @param url
     */
    public void navigateTo(String url) {
        driver.navigate().to(url);
    }

    /**
     * Methode de click sur un élément html
     * @param element
     */
    public void clickElement(WebElement element) {
        element.click();
    }
}
