package base;

import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class RunTestRule extends TestWatcher {
    private BaseUiTest testClass;

    public RunTestRule(BaseUiTest testClass) {
        this.testClass = testClass;
    }

    @Override
    protected void finished(Description description) {
        testClass.getDriver().quit();
    }

    @Override
    protected void failed(Throwable e, Description description) {
        testClass.getDriver().quit();
    }
}
