package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthPage {
    public AuthPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        driver.get(URL);
    }
    WebDriver driver;
    private final String URL = "file:///C:/Users/AIREDALE/Downloads/Telegram%20Desktop/qa-test.html";
    @FindBy(xpath = ".//*[@id='loginEmail']")
    private WebElement inputEmail;
    @FindBy(xpath = ".//*[@id='loginPassword']")
    private  WebElement inputPassword;
    @FindBy(xpath = ".//*[@id='authButton']")
    private WebElement authButton;
    @FindBy(xpath = ".//*[@id='inputsPage']")
    private WebElement form;

    public AuthPage fillEmail(String email){
        inputEmail.sendKeys(email);
        return this;
    }
    public AuthPage fillPassword(String password){
        inputPassword.sendKeys(password);
        return this;
    }
    public AuthPage fillAuthPage(String email,String password){
        fillEmail(email);
        fillPassword(password);
        return this;
    }
    public AuthPage authButtonClick(){
        authButton.click();
        return this;
    }
    public boolean authSuccess(){
        return form.isDisplayed();
    }
}
