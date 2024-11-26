package utilities;

import browserfactory.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseTest {

        /**
         * this method will click on element
         */

        public void clickOnElement(By by) {
            WebElement loginLink = driver.findElement(by);
            loginLink.click();
        }

        /**
         * this method will get text from element
         */

        public String getTextFromElement(By by){
            return driver.findElement(by).getText();
        }

        /**
         * this method will send text on element
         */

        public void  sendTextOnElement(By by, String text){
            driver.findElement(by).sendKeys(text);
        }


    /**
     * this method will switchToAlert
     */


    public void switchToAlert(){
        driver.switchTo().alert().accept();;
    }

    /**
     * this method will select the option by value
     */
    public void selectByValueFromDown(By by,String value){
        WebElement dropdown = driver.findElement(by);
        Select select= new Select(dropdown);


    }

    public void  mouseHooverAndClickOnElement(By by) {
        WebElement loginLink = driver.findElement(by);
        loginLink.click();
    }

    public void findWebElement(By by){
        WebElement findWebElement = driver.findElement(by);
    }


}
