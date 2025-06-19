package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import com.codeborne.selenide.WebDriverRunner;
import utils.helper.ConfigLoader;
import utils.helper.DriverFactory;

public class TestBase {
	@BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        // Initialize global resources like ReportPortal
		System.out.println("BeforeSuite: Load framework config & setup reports");
		ConfigLoader.loadConfig();
    }

    @BeforeTest(alwaysRun = true)
    public void beforeTest() {
    	System.out.println("BeforeTest: Ready to run tests under <test> tag");
    }

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        System.out.println("BeforeClass: Run once per test class");
    }

    @BeforeMethod(alwaysRun = true)
    @Parameters({"browser"})
    public void setUp(@Optional("chrome") String browser) {
        System.out.println("BeforeMethod: Launch browser for each test");
        DriverFactory.initDriver(browser);
        
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        System.out.println("AfterMethod: Close browser");
        if (WebDriverRunner.hasWebDriverStarted()) {
            DriverFactory.quitDriver();
        }
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        System.out.println("AfterClass: One-time class cleanup");
    }

    @AfterTest(alwaysRun = true)
    public void afterTest() {
        System.out.println("AfterTest: Test tag teardown");
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        System.out.println("AfterSuite: Finalize reports & global teardown");
        // Finalize reports, send emails, clean temp files
    }
}
