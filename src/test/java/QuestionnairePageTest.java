import ru.protei.config.Config;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.protei.page_objects.AuthPage;
import ru.protei.page_objects.QuestionnairePage;
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
        authPage.fillAuthPage(Config.EMAIL, Config.PASSWORD).authButtonClick();
    }
    @After
    public void Teardown() {
        driver.quit();
    }

    @Test
    public void allFieldsAddCorrect(){
        questionnairePage
                .fillEmail(Config.getRandomEmail())
                .fillName(Config.getRandomName())
                .chooseGenderWomen()
                .chooseDataCheck11()
                .chooseDataSelect23()
                .clickSubmitButtonWithWait();
        boolean result = questionnairePage.addDataConfirm();
        assertTrue(result);
        assertEquals(questionnairePage.getInputEmail(), questionnairePage.getAddedEmail());
        assertEquals(questionnairePage.getInputName(), questionnairePage.getAddedName());
        assertEquals(questionnairePage.getInputGender(),questionnairePage.getAddedGender());
        assertEquals("1.1",questionnairePage.getAddedDataCheck());
        assertEquals("2.3", questionnairePage.getAddedDataSelect());
    }
    @Test
    public void fillFormWithoutEmail(){
        questionnairePage
                .fillEmail(Config.EMPTY_FIELD)
                .fillName(Config.getRandomName())
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
                .fillEmail(Config.getRandomEmail())
                .fillName(Config.EMPTY_FIELD)
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
                .fillEmail(Config.INVALID_EMAIL)
                .fillName(Config.getRandomName())
                .chooseGenderMen()
                .chooseDataCheck12()
                .chooseDataSelect22()
                .clickSubmitButton();
        boolean result = questionnairePage.emailError();
        assertTrue(result);
    }
}
