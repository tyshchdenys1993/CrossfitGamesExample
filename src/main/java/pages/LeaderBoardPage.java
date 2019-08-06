package pages;

import base.BaseUiTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeaderBoardPage extends AbstractPage {

    @FindBy(xpath = "//select[@id='control-competition']")
    private WebElement competitionDropBox;

    @FindBy(id = "control-division")
    private WebElement divisionDropBox;

    @FindBy(id = "control-year")
    private WebElement yearDropBox;

    @FindBy(xpath = "//tr[contains(@class,'collapsed')]/td[@class='name']//div[@class='first-name']")
    private List<WebElement> athletesFirstNames;

    @FindBy(xpath = "//tr[contains(@class,'collapsed')]/td[@class='name']//div[@class='last-name']")
    private List<WebElement> athletesLastNames;

    @FindBy (xpath = "//tr[contains(@class,'collapsed')]/td[contains(@class,'pos')]//div[@class='cell-inner']")
    private List<WebElement> athletesRank;


    public LeaderBoardPage(BaseUiTest testClass) {
        super(testClass);
    }

    public void selectCompetitionTypeFromDropBox(String competition) {
        testClass.waitTillElementIsVisible(testClass.getDriver().findElement(By.xpath("//div[@class='global-error-message']/following-sibling::div[contains(@class, 'controls')]")));
        Select select = new Select(competitionDropBox);
        if (!testClass.getDriver().findElement(By.xpath("//div[@data-name='competition']/div")).getText().trim().equals(competition)) {
            select.selectByVisibleText(competition);
        }
    }

    public void selectDivisionFromDropBox(String division) {
        Select select = new Select(divisionDropBox);
        if (!testClass.getDriver().findElement(By.xpath("//div[@data-name='division']/div")).getText().trim().equals(division)) {
            select.selectByVisibleText(division);
        }
    }

    public void selectYearFromDropBox(String year) {

        Select select = new Select(yearDropBox);
        if (!testClass.getDriver().findElement(By.xpath("//div[@data-name='year']/div")).getText().trim().equals(year)) {
            select.selectByValue(year);
        }
    }

    public void selectCompetitionDivisionYearFromDropBox(String competition, String division, String year) {
        selectCompetitionTypeFromDropBox(competition);
        selectDivisionFromDropBox(division);
        selectYearFromDropBox(year);
        testClass.waitTillElementIsVisible(testClass.getDriver().findElement(By.xpath("//div[@class='global-error-message']/following-sibling::div[contains(@class, 'controls')]")));
    }

    public void verifyCountOfAthletes(int expectedCount){
        testClass.waitTillElementIsVisible(athletesRank.get(0));
        int sizeOfDisqualifiedAthletes = 0;
        for (int i = 0; i < athletesRank.size(); i++) {
            if (athletesRank.get(i).getText().equals("DQ"))
                sizeOfDisqualifiedAthletes++;
        }
        Assert.assertEquals("Count Of athletes is not expected", expectedCount, athletesRank.size()-sizeOfDisqualifiedAthletes);

    }

    public List<String> getAllAthletesFirstNames() {
        List<String> listOfAllFirstNames = new ArrayList<>();
        List<String> listOfAllSurnames = new ArrayList<>();
        List<String> listOfAllFullNames = new ArrayList<>();
        for (int i = 0; i < athletesFirstNames.size(); i++) {
            listOfAllFirstNames.add(i,athletesFirstNames.get(i).getText());
        }
        for (int i = 0; i < athletesLastNames.size(); i++) {
            listOfAllSurnames.add(i,athletesLastNames.get(i).getText());
        }
        for (int i = 0; i < listOfAllFirstNames.size(); i++) {
            listOfAllFullNames.add(i, (listOfAllFirstNames.get(i)+ " " + listOfAllSurnames.get(i)));
        }
        return listOfAllFullNames;
    }

    public void writeAthletesToFile(List<String> listOfAllFullNames) throws IOException {
        String baseDir = "src/main//resources/allusers.txt";
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(baseDir));
            for (String listOfAllFullName : listOfAllFullNames) {
                bufferedWriter.write(listOfAllFullName);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
    }

}








