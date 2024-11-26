package myaccounts;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class MyAccountsTest extends Utility {

    String baseUrl = "https://tutorialsninja.com/demo/index.php?";

    //Open Browser
    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    //selectMenu method
    public void selectMyAccountOption(String option) {
        // clickOnElement(By.xpath("//span[normalize-space()='My Account']"));

        List<WebElement> options = driver.findElements(By.xpath("//li[@class='dropdown open']//li/a"));

        for (WebElement e : options) {
            System.out.println(option);
            System.out.println(e);
            if (e.getText().equalsIgnoreCase(option)) {
                e.click();
                break;
            }
        }

    }

    //verify User Should Navigate To Register Page Successfully()
    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        //Click on the My Account Link.
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));

        //Call the method “selectMyAccountOptions()” method and pass the parameter “Register”
        selectMyAccountOption("Register");

        //Verify the text “Register Account”.
        String actualRegisterAccountText = getTextFromElement(By.xpath("//h1[normalize-space()='Register Account']"));
        String expectedRegisterAccountText = "Register Account";
        Assert.assertEquals("The text Register Account is not displayed", expectedRegisterAccountText, actualRegisterAccountText);
    }

    //verify User Should Navigate To Login Page Successfully
    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        //Click on the My Account Link.
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));

        //Call the method “selectMyAccountOptions()” method and pass the parameter “Login”
        selectMyAccountOption("Login");

        //Verify the text “Returning Customer”.
        String actualReturningCustomerText = getTextFromElement(By.xpath("//h2[normalize-space()='Returning Customer']"));
        String expectedReturningCustomerText = "Returning Customer";
        Assert.assertEquals("The text Register Account is not displayed", expectedReturningCustomerText, actualReturningCustomerText);
    }

    //verify That User Register Account Successfully
    @Test
    public void verifyThatUserRegisterAccountSuccessfully() {
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));

        //Call the method “selectMyAccountOptions()” method and pass the parameter “Register”
        selectMyAccountOption("Register");

        //Enter the First Name
        sendTextOnElement(By.xpath("//input[@id='input-firstname']"), "jalpa");

        //Enter the Last Name
        sendTextOnElement(By.xpath("//input[@id='input-lastname']"), "kalpesh");

        //Enter the Email
        sendTextOnElement(By.xpath("//input[@id='input-email']"), "jalpa567@gmail.com");
        //Enter the Telephone
        sendTextOnElement(By.xpath("//input[@id='input-telephone']"), "jk123456");
        //3.7 Enter the Password
        sendTextOnElement(By.xpath("//input[@id='input-password']"), "jalpal123@");

        //3.8 Enter the Password Confirm
        sendTextOnElement(By.xpath("//input[@id='input-confirm']"), "jalpa123@");

        //Select Subscribe Yes radio button
        clickOnElement(By.cssSelector("input[value='1'][name='newsletter']"));

        //3.10 Click on the Privacy Policy check box
        clickOnElement(By.xpath("//input[@name='agree']"));

        //3.11 Click on the Continue button
        clickOnElement(By.xpath("//input[@value='Continue']"));

        //3.12 Verify the message “Your Account Has Been Created!”
        String actualMessageText = getTextFromElement(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']"));
        String expectedMessageText = "Your Account Has Been Created!";
        Assert.assertEquals("The message your account has been created is not displayed", expectedMessageText, actualMessageText);

        //3.13 Click on the Continue button
        clickOnElement(By.linkText("Continue"));

        //3.14 Click on the My Account Link.
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));

        //3.15 Call the method “selectMyAccountOptions()” method and pass the parameter “Logout”
        selectMyAccountOption("Logout");

        //3.16 Verify the text “Account Logout”
        String actualLogoutText = getTextFromElement(By.xpath("//h1[normalize-space()='Account Logout']"));
        String expectedLogoutText = "Account Logout";
        Assert.assertEquals("The text Account Logout is not displayed", expectedLogoutText, actualLogoutText);

        //3.17 Click on the Continue button
        clickOnElement(By.linkText("Continue"));
    }

    //verify That User Should Login And Logout Successfully
    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() {
        //4.1 Click on the My Account Link.
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));

        //4.2 Call the method “selectMyAccountOptions()” method and pass the parameter “Login”
        selectMyAccountOption("Login");

        //4.3 Enter the Email address
        sendTextOnElement(By.xpath("//input[@id='input-email']"), "jalpa123@gmail.com");

        //4.4 Enter the Last Name
        //sendTextOnElement(By.xpath(""),"Patel");

        //4.5 Enter the Password
        sendTextOnElement(By.xpath("//input[@id='input-password']"), "jalpa123@");

        //4.6 Click on the Login button
        clickOnElement(By.xpath("//input[@value='Login']"));

        //4.7 Verify text “My Account”
        String actualMyAccountText = getTextFromElement(By.xpath("//h2[normalize-space()='My Account']"));
        String expectedAccountText = "My Account";
        Assert.assertEquals("The text My Account is not displayed", expectedAccountText, actualMyAccountText);

        //4.8 Click on the My Account Link.
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));

        //4.9 Call the method “selectMyAccountOptions()” method and pass the parameter “Logout”
        selectMyAccountOption("Logout");

        //4.10 Verify the text “Account Logout”
        String actualLogoutText = getTextFromElement(By.xpath("//h1[normalize-space()='Account Logout']"));
        String expectedLogoutText = "Account Logout";
        Assert.assertEquals("The text Account Logout is not displayed", expectedLogoutText, actualLogoutText);

        //4.11 Click on the Continue button
        clickOnElement(By.linkText("Continue"));
    }

    @After
    public void tearDown() {
        //closeBrowser();
    }
}
