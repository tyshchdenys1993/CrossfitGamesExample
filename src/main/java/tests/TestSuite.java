import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {OpenSiteTest.class,
                LoginTest.class,
                LeaderBoardTest.class,
                CrossFitStuffShopTest.class
        })
public class TestSuite {
}
