package fr.afpa.pompey.cda.api;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SeleniumTest {
    private WebDriver driver;
    //private final String url = ;
    @BeforeEach
    public void setUp() {

        // Instanciation du pilote Chrome
        // recherche auto de driver
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        // options du navigateur
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless");
        // chargement du driver
        driver = new ChromeDriver(options);
    }
    @Test
    public void testPageTitle() {
        // Accédez à une URL
        driver.get("https://www.afpa.fr");

        // Récupérez le titre de la page
        String title = driver.getTitle();

        // Vérifiez si le titre est correct
        assertEquals("Afpa : formation professionnelle, formation adulte, formation-continue, VAE // AFPA | Afpa", title);
    }
    @AfterEach
    public void tearDown() {
        // Fermez le navigateur
        driver.quit();
    }
}
