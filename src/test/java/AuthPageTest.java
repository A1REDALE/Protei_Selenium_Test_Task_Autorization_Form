import ru.protei.config.Config;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.protei.page_objects.AuthPage;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AuthPageTest {
    WebDriver driver;
    AuthPage authPage;
    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        authPage = new AuthPage(driver);
    }
    @After
    public void Teardown() {
        driver.quit();
    }
    @Test
    public void authWithCorrectFields(){
        authPage.fillAuthPage(Config.EMAIL, Config.PASSWORD).authButtonClick();
        boolean result = authPage.authSuccess();
        assertTrue(result);
    }
    @Test
    public void AuthWithoutEmail(){
        authPage.fillAuthPage(Config.EMPTY_FIELD,Config.PASSWORD).authButtonClick();
        boolean result = authPage.authSuccess();
        assertFalse(result);
    }
    @Test
    public void AuthWithoutPassword(){
        authPage.fillAuthPage(Config.EMAIL,Config.EMPTY_FIELD).authButtonClick();
        boolean result = authPage.authSuccess();
        assertFalse(result);
    }
    @Test
    public void AuthWithEmptyFields(){
        authPage.fillAuthPage(Config.EMPTY_FIELD,Config.EMPTY_FIELD).authButtonClick();
        boolean result = authPage.authSuccess();
        assertFalse(result);
    }
    @Test
    public void AuthWithWrongEmail() {
        authPage.fillAuthPage(Config.invalidEmail, Config.PASSWORD)
                .authButtonClick();
        boolean result = authPage.authSuccess();
        assertFalse(result);
    }
    @Test
    public void AuthWithWrongPassword() {
        authPage.fillAuthPage(Config.EMAIL,Config.getRandomPassword()).authButtonClick();
        boolean result = authPage.authSuccess();
        assertFalse(result);
    }
}

