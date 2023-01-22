package page_objects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QuestionnairePage {
    public QuestionnairePage(WebDriver driver){
        this.driver =driver;
        PageFactory.initElements(driver,this);

    }
    WebDriver driver;

    @FindBy(xpath = ".//*[@id='dataEmail']")
    private WebElement inputEmail;
    @FindBy(xpath = ".//*[@id='dataName']")
    private WebElement inputName;
    @FindBy(xpath = ".//*[@id='dataGender']")
    private WebElement chooseGender;
    @FindBy(xpath = ".//*[@id='dataCheck11']")
    private WebElement dataCheck11;
    @FindBy(xpath = ".//*[@id='dataCheck12']")
    private WebElement dataCheck12;
    @FindBy(xpath = ".//*[@id='dataSelect21']")
    private WebElement dataSelect21;
    @FindBy(xpath = ".//*[@id='dataSelect22']")
    private WebElement dataSelect22;
    @FindBy(xpath = ".//*[@id='dataSelect23']")
    private WebElement dataSelect23;
    @FindBy(xpath = ".//*[@id='dataSend']")
    private WebElement submitButton;
    @FindBy(css= ".uk-margin.uk-modal-content")
    private WebElement addDataConfirm;
    @FindBy(css = ".uk-modal-close")
    private WebElement okButton;
    @FindBy(xpath = ".//*[@id='emailFormatError']")
    private  WebElement emailError;
    @FindBy(xpath = ".//*[@id='blankNameError']")
    private WebElement nameError;

    public QuestionnairePage fillEmail(String email){
        inputEmail.sendKeys(email);
        return this;
    }
    public QuestionnairePage fillName(String name){
        inputName.sendKeys(name);
        return this;
    }
    public QuestionnairePage chooseGenderMen(){
        chooseGender.click();
        return this;
    }
    public QuestionnairePage chooseGenderWomen(){
        chooseGender.sendKeys(Keys.DOWN);
        return this;
    }
    public QuestionnairePage chooseDataCheck11(){
        dataCheck11.click();
        return this;
    }
    public QuestionnairePage chooseDataCheck12(){
        dataCheck12.click();
        return this;
    }
    public QuestionnairePage chooseDataSelect21(){
        dataSelect21.click();
        return this;
    }
    public QuestionnairePage chooseDataSelect22(){
        dataSelect22.click();
        return this;
    }
    public QuestionnairePage chooseDataSelect23(){
        dataSelect23.click();
        return this;
    }
    public QuestionnairePage clickSubmitButton(){
        submitButton.click();
        return this;
    }
    public QuestionnairePage clickOkButton(){
        okButton.click();
        return this;
    }
    public boolean addDataConfirm(){
        return addDataConfirm.isDisplayed();
    }
    public boolean emailError(){
        return emailError.isDisplayed();
    }
    public boolean nameError(){
        return nameError.isDisplayed();
    }
}

