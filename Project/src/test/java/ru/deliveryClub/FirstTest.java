package ru.deliveryClub;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**Case 1*/
public class FirstTest  extends WebDriverSettings {
    @Test
    public void CaseTest1() {
        driver.get(" https://testsheepnz.github.io/BasicCalculator.html ");

        JavascriptExecutor js = driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        Select dropdown = new Select(driver.findElement(By.id("selectBuild")));
        dropdown.selectByVisibleText("Prototype");

        String frstNumber = "2";
        String scndNumber = "3";
        WebElement Field1 = driver.findElement(By.id("number1Field"));
        WebElement Field2 = driver.findElement(By.id("number2Field"));
        Field1.sendKeys(frstNumber);
        Field2.sendKeys(scndNumber);

        Select dropdown2 = new Select(driver.findElement(By.id("selectOperationDropdown")));
        dropdown2.selectByVisibleText("Subtract");
        driver.findElement(By.id("calculateButton")).click();

         String answer = driver.findElement(By.id("numberAnswerField")).getAttribute("value");
         Assert.assertEquals("-1",answer);
    }
    /**Case2*/
    @Test
    public void CaseTest2() {
        driver.get(" https://testsheepnz.github.io/BasicCalculator.html ");

        JavascriptExecutor js = driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        Select dropdown = new Select(driver.findElement(By.id("selectBuild")));
        dropdown.selectByVisibleText("Prototype");

        String frstNumber = "gs";
        String scndNumber = "bu";
        WebElement Field1 = driver.findElement(By.id("number1Field"));
        WebElement Field2 = driver.findElement(By.id("number2Field"));
        Field1.sendKeys(frstNumber);
        Field2.sendKeys(scndNumber);

        Select dropdown2 = new Select(driver.findElement(By.id("selectOperationDropdown")));
        dropdown2.selectByVisibleText("Concatenate");
        driver.findElement(By.id("calculateButton")).click();

        String answer = driver.findElement(By.id("numberAnswerField")).getAttribute("value");
        Assert.assertEquals("gsbu",answer);
    }

    @Test
    public void CaseTest3() {
        driver.get(" https://testsheepnz.github.io/random-number.html ");

        JavascriptExecutor js = driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        Select dropdown = new Select(driver.findElement(By.id("buildNumber")));
        dropdown.selectByVisibleText("Demo");

        driver.findElement(By.id("rollDiceButton")).click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("numberGuess")));
        driver.findElement(By.id("numberGuess")).click();
        driver.findElement(By.id("numberGuess")).sendKeys("String");
        driver.findElement(By.id("submitButton")).click();

        String itogLabel = driver.findElement(By.id("feedbackLabel")).getText();
        Assert.assertEquals("String: Not a number!",itogLabel);




    }
}

