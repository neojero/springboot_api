package fr.afpa.pompey.cda.api.exemple;

import fr.afpa.pompey.cda.api.config.SeleniumConfig;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class SeleniumExample {

    private final SeleniumConfig config;
    private final String url = "https://localhost:9000/";

    public SeleniumExample() {
        config = new SeleniumConfig();
        config.getDriver()
                .get(url);
    }

    /**
     * fermeture du navigateur
     */
    public void closeWindow() {
        this.config.getDriver().close();
    }

    /**
     * retourne le titre de la page
     * @return
     */
    public String getTitle() {
        return this.config.getDriver().getTitle();
    }

    private void clickAboutLink() {
        Actions actions = new Actions(config.getDriver());
        WebElement aboutElement = this.config.getDriver()
                .findElement(By.id("menu-item-6138"));

        actions.moveToElement(aboutElement).perform();
    }

    public boolean isAuthorInformationAvailable() {
        return this.config.getDriver()
                .getPageSource()
                .contains("Hey ! I'm Eugen");
    }
}
