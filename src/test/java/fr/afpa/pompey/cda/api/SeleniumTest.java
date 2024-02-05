package fr.afpa.pompey.cda.api;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SeleniumTest {
    private WebDriver driver;
    //private final String url = ;

    @BeforeEach
    public void setUp() {
        // emplacement du pilote Chrome
        System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");

        // Instanciation du pilote Chrome
        driver = new ChromeDriver();
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
