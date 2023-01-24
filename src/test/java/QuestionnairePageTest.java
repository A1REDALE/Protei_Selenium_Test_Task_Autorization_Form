import config.Config;

import org.apache.maven.surefire.shared.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page_objects.AuthPage;
import page_objects.QuestionnairePage;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class QuestionnairePageTest {
    WebDriver driver;
    AuthPage authPage;
    QuestionnairePage questionnairePage;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        authPage = new AuthPage(driver);
        questionnairePage = new QuestionnairePage(driver);
        authPage.fillAuthPage(Config.getEmail(), Config.getPassword()).authButtonClick();
    }
    @After
    public void Teardown() {
        driver.quit();
    }

    @Test
    public void allFieldsAddCorrect(){
        questionnairePage
                .fillEmail(RandomStringUtils.randomAlphabetic(4) + "@protei.ru")
                .fillName(RandomStringUtils.randomAlphabetic(6))
                .chooseGenderWomen()
                .chooseDataCheck11()
                .chooseDataSelect23()
                .clickSubmitButton();
        boolean result = questionnairePage.addDataConfirm();
        assertTrue(result);
        assertEquals(questionnairePage.checkInputEmail(), questionnairePage.getAddedEmail());
        assertEquals(questionnairePage.checkInputName(), questionnairePage.getAddedName());
        assertEquals(questionnairePage.checkInputGender(),questionnairePage.getAddedGender());
        assertEquals(("1.1"),questionnairePage.getAddedDataCheck());
        assertEquals("2.3", questionnairePage.getAddedDataSelect());
    }
    @Test
    public void fillFormWithoutEmail(){
        questionnairePage
                .fillName(RandomStringUtils.randomAlphabetic(6))
                .chooseGenderWomen()
                .chooseDataCheck11()
                .chooseDataSelect21()
                .clickSubmitButton();
        boolean result = questionnairePage.emailError();
        assertTrue(result);
    }
    @Test
    public void fillFormWithoutName(){
        questionnairePage
                .fillEmail(RandomStringUtils.randomAlphabetic(4) + "@protei.ru")
                .chooseGenderWomen()
                .chooseDataCheck11()
                .chooseDataSelect23()
                .clickSubmitButton();
        boolean result = questionnairePage.nameError();
        assertTrue(result);
    }
    @Test
    public void fillFormWithWrongEmail(){
        questionnairePage
                .fillEmail("protei.ru")
                .fillName(RandomStringUtils.randomAlphabetic(6))
                .chooseGenderMen()
                .chooseDataCheck12()
                .chooseDataSelect22()
                .clickSubmitButton();
        boolean result = questionnairePage.emailError();
        assertTrue(result);
    }
}
