package pages;

import base.BaseUiTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    @FindBy(xpath = "//li[contains(@class,'games-full-nav')]//a[@class='leaderboard-main-nav']")
    private WebElement leaderBoardMainNavigationButton;

    @FindBy(xpath = "//li[@aria-describedby='slick-slide73']")
    private WebElement gamesCarouselButton;

    public HomePage(BaseUiTest testClass) {
        super(testClass);
    }

    public LeaderBoardPage clickToLeaderBoardPage(){
        testClass.waitTillElementIsVisible(gamesCarouselButton);
        String classAttributeForGamesCarouselButton = gamesCarouselButton.getAttribute("class");
        if (classAttributeForGamesCarouselButton.contains("active")){
            testClass.waitTillElementIsVisible(leaderBoardMainNavigationButton);
            leaderBoardMainNavigationButton.click();
        }
        return new LeaderBoardPage(testClass);
    }
}
