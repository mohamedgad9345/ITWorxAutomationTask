package steps;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import tests.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LoginFeature extends TestBase {


    private By userNameTxt = By.id("Email");
    private By passwordTxt = By.id("inputPassword");
    private By loginBtn = By.id("btnLogin");

    private By coursesBtn = By.xpath("//*[@id=\"btnMyCoursesList\"]/em");

    private By addCourseBtn = By.id("btnListAddCourse");
    private By courseNameTxt = By.id("txtCourseName");
    private By selectGradeYear = By.xpath("//*[@id=\"divBasicInfo\"]/div[2]/div[3]/div[1]/label[1]/em");
    private By courseGrdDropDown = By.id("courseGrade");
    private By checkAssignedTeacher = By.xpath("//*[@id=\"lblGetSelectedSubjectTeachers\"]/i");
    private By courseTeacherDropDown = By.xpath("//*[@id=\"teacherOnBehalf\"]/div[1]/span/span[1]");
    private By courseCriteriaOption = By.xpath("//*[@id=\"divCompletionCriteria\"]/div[1]/label/em");
    private By createCourseBtn = By.id("btnSaveAsDraftCourse");
    private By courseTitle = By.linkText("Mohamed Gad Testing Course");
    private By sortingBar = By.xpath("//*[@id=\"CoursesOrderBy\"]");
    @Given("^I open the Winjigo website$")
    public void openWinjigoWebsite() {
        startDriver("chrome");
    }

    @When("^I sign in with username and password$")
    public void signIn() {
        WebElement userName = driver.findElement(userNameTxt);
        userName.sendKeys("testregister@aaa.com");
        WebElement password = driver.findElement(passwordTxt);
        password.sendKeys("Wakram_123");
        WebElement login = driver.findElement(loginBtn);
        login.click();
    }

    @When("^I open courses page$")
    public void openCoursesPage() {
        WebElement coursesBtnIcon = driver.findElement(coursesBtn);
        coursesBtnIcon.click();
    }

    @When("^I click on create course button$")
    public void clickCreateCourseButton() {
        WebElement addCourseButton = driver.findElement(addCourseBtn);
        addCourseButton.click();
    }

    @When("^I fill course basic info and click save$")
    public void fillCourseInfo() throws InterruptedException {
        WebElement courseName = driver.findElement(courseNameTxt);
        courseName.sendKeys("Mohamed Gad Testing Course11");

        WebElement selectGradeYearOption = driver.findElement(selectGradeYear);
        selectGradeYearOption.click();


        WebElement courseGrdDrop = driver.findElement(courseGrdDropDown);
        Select select = new Select(courseGrdDrop);
        select.selectByVisibleText("5");
        WebElement checkAssignedTeacherBox = driver.findElement(checkAssignedTeacher);
        checkAssignedTeacherBox.click();
        Thread.sleep(2000);
        try {
            WebElement courseTeacherName = driver.findElement(courseTeacherDropDown);
            List<WebElement> options = courseTeacherName.findElements(courseTeacherDropDown);
            options.get(0).click();
            options.get(0).findElement(By.xpath("//*[@id=\"lnkCourseOwnerMail\"]")).click();

        } catch(NoAlertPresentException noe) {
            System.out.println("Alert Exception here!");
        }
        scrollToBottom();
        WebElement selectCriteriaOption = driver.findElement(courseCriteriaOption);
        selectCriteriaOption.click();
        WebElement createButton = driver.findElement(createCourseBtn);
        createButton.click();
        Thread.sleep(2000);
    }

    @Then("^I should see the course title displayed on the courses list page$")
    public void assertCourseTitleDisplayed() throws InterruptedException {
        WebElement sortingMenu = driver.findElement(sortingBar);
        Select select = new Select(sortingMenu);
        select.selectByVisibleText("Creation Date Descending");
        Thread.sleep(2000);
        WebElement courseTitles = driver.findElement(courseTitle);
        Assert.assertTrue(courseTitles.isDisplayed());

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}


