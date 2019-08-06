import base.BaseUiTest;

import org.junit.Test;
import pages.HomePage;
import pages.LoginPage;

public class OpenSiteTest extends BaseUiTest {

    @Test
    public void testOpenSiteTest(){
        HomePage homePage = openSite();
        log("User opens site");

        LoginPage loginPage = homePage.clickToLoginButton();
        log("Login page is opened");

        closeSite();
        log("User closes site");
    }
}
