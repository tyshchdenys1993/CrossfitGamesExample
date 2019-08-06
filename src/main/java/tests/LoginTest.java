import base.BaseUiTest;
import org.junit.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseUiTest {

    @Test
    public void testLoginTest(){
        HomePage homePage = openSite();
        log("User opens site");

        homePage.clickToAcceptCookieButton();
        log("User clicks to 'Accept' button");

        LoginPage loginPage = homePage.clickToLoginButton();
        log("Login page is opened");

        loginPage.login();
        log("Login in system");

        homePage.verifyThatUserIsLoggedIn();
        log("Verify, that user is correct");

        homePage.logout();
        log("Logout");

        homePage.verifyThatUserIsLoggedOut();
        log("Verify that user is logged out");

        closeSite();
        log("User closes site");
    }

}
