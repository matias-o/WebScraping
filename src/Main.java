import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Main {
    public static void main(String[] args){

        String aboutButtonXpath = "//*[@id=\"about\"]/div/a";
        String languageParagraph = "/html/body/div[3]/div[2]/div[2]/div[5]";
        String codeLanguageXpath = "/html/body/div[3]/div[2]/div[2]/div[5]/p";

        ChromeDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 30);

        driver.navigate().to("http://www.galabra.co.il");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(aboutButtonXpath)));
        driver.findElement(By.xpath(aboutButtonXpath)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(languageParagraph)));
        List<WebElement> languagesNamesList = driver.findElements(By.xpath(codeLanguageXpath));

        for (WebElement languageElement : languagesNamesList){
            String languageName = languageElement.getText();
            System.out.println(languageName);
        }

        driver.close();


    }
}
