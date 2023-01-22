import config.Config;

import org.apache.maven.surefire.shared.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page_objects.AuthPage;
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
        authPage.fillAuthPage(Config.getEmail(), Config.getPassword()).authButtonClick();
        boolean result = authPage.authSuccess();
        assertTrue(result);
    }
    @Test
    public void AuthWithoutEmail(){
        authPage.fillAuthPage(Config.getEmptyField(),Config.getPassword()).authButtonClick();
        boolean result = authPage.authSuccess();
        assertFalse(result);
    }
    @Test
    public void AuthWithoutPassword(){
        authPage.fillAuthPage(Config.getEmail(),Config.getEmptyField()).authButtonClick();
        boolean result = authPage.authSuccess();
        assertFalse(result);
    }
    @Test
    public void AuthWithEmptyFields(){
        authPage.fillAuthPage(Config.getEmptyField(),Config.getEmptyField()).authButtonClick();
        boolean result = authPage.authSuccess();
        assertFalse(result);
    }
    @Test
    public void AuthWithWrongEmail() {
        authPage.fillAuthPage(RandomStringUtils.randomAlphabetic(4) + "@protei.ru", Config.getPassword())
                .authButtonClick();
        boolean result = authPage.authSuccess();
        assertFalse(result);
    }
    @Test
    public void AuthWithWrongPassword() {
        authPage.fillAuthPage(Config.getEmail(),RandomStringUtils.randomAlphabetic(4)).authButtonClick();
        boolean result = authPage.authSuccess();
        assertFalse(result);
    }
}

