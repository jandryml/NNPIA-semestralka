package cz.edu.upce.selenium

import cz.edu.upce.Creator
import cz.edu.upce.controller.auth.AuthController
import cz.edu.upce.model.Role
import cz.edu.upce.model.RoleType
import cz.edu.upce.model.User
import cz.edu.upce.repository.RoleRepository
import cz.edu.upce.repository.UserRepository
import cz.upce.eshop.ui.TestImplementation
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.ComponentScan
import org.springframework.test.context.ActiveProfiles
import java.io.File
import java.util.concurrent.TimeUnit

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ActiveProfiles("test")
@ComponentScan
@ExperimentalStdlibApi
class SeleniumTest
@Autowired constructor(
    private val creator: Creator,
    private val userRepository: UserRepository,
    private val roleRepository: RoleRepository,
    private val authController: AuthController
) {

    private lateinit var driver: WebDriver
    private lateinit var wait: WebDriverWait

    @BeforeAll
    fun setupWebdriverChromeDriver() {
        val chromeDriverPath = TestImplementation::class.java.getResource("/chromedriver.exe").file
        val circleCIChromedriverPath = "/usr/local/bin/chromedriver"

        if (File(circleCIChromedriverPath).exists()) {
            System.setProperty(
                "webdriver.chrome.driver",
                circleCIChromedriverPath
            )
        } else {
            System.setProperty(
                "webdriver.chrome.driver",
                chromeDriverPath
            )
        }
    }

    @BeforeEach
    fun setup() {
        val chromeOptions = ChromeOptions()
        chromeOptions.setHeadless(true)
        driver = ChromeDriver(chromeOptions)
        wait = WebDriverWait(driver, 10)
    }

    @AfterEach
    fun teardown() {
        if (driver != null) {
            driver?.quit()
        }
    }

    fun getOrigin(): String {
        return "https://nnpia-semestralka.herokuapp.com"
    }

    @Test
    fun loginSuccess() {
        val user = User(username = "Test", email = "test@gmail.com", password = "password")

        creator.save(user)

        driver.get(getOrigin())
        driver.findElement(By.id("loginLink"))?.click()

        driver.findElement(By.id("username"))?.sendKeys("Test")
        driver.findElement(By.id("password"))?.sendKeys("password")
        driver.findElement(By.xpath("//button[@id='loginButton']"))?.click()

        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS); driver.get(getOrigin());

        assertEquals(0, driver.findElements(By.id("errorMessage"))?.size)
    }

    @Test
    fun loginFailed() {
        val user = User(username = "Test2", email = "tes2t@gmail.com", password = "password")
        creator.save(user)

        driver.get(getOrigin())
        driver.findElement(By.id("loginLink"))?.click()

        driver.findElement(By.id("username"))?.sendKeys("asdasd")
        driver.findElement(By.id("password"))?.sendKeys("afdfs")
        driver.findElement(By.xpath("//button[@id='loginButton']"))?.click()

//        wait.until(ExpectedConditions.urlContains(getOrigin() + "/login"))
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        assertEquals(1, driver.findElements(By.id("errorMessage"))?.size)
    }
}