import base.BaseUiTest;
import org.junit.Test;
import pages.HomePage;
import pages.LeaderBoardPage;
import pages.LoginPage;

import java.io.IOException;

public class LeaderBoardTest extends BaseUiTest {

    @Test
    public void testLeaderBoardTest() throws IOException {
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

        LeaderBoardPage leaderBoardPage = homePage.clickToLeaderBoardPage();
        log("User opens Leader Board Page from main carousel");

        leaderBoardPage.selectCompetitionDivisionYearFromDropBox("Games", "Men","2017");
        log("Select 'Games' in competition, 'Men' in Division and '2017' in year");


        leaderBoardPage.verifyCountOfAthletes(38);
        log("Verify count of all active (not disqualified) athletes");

        leaderBoardPage.writeAthletesToFile(leaderBoardPage.getAllAthletesFirstNames());
        log("Write all athletes to a file");

        closeSite();
        log("Close site");
    }
}
