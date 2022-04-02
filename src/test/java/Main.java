import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Set;
import java.util.concurrent.TimeUnit;


public class Main {
    WebDriver driver;
    private org.apache.logging.log4j.Logger logger = LogManager.getLogger(Main.class);

    @Before
    public void StartUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        logger.info("Драйвер поднят");
    }

//    @After
//    public void End() {
//        if (driver != null)
//            driver.quit();
//    }

    @Test
    public void Test1() throws InterruptedException {
        //Открыть Chrome в headless режиме
        driver.quit();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("headless");
        //Перейти на https://duckduckgo.com/
        driver = new ChromeDriver(chromeOptions);
        driver.get("https://duckduckgo.com/");
        //        В поисковую строку ввести ОТУС
        //driver.findElement(By.xpath("//input[@id = 'search_form_input_homepage']")).sendKeys("ОТУС" + Keys.ENTER);
        driver.findElement(By.cssSelector("input[id = 'search_form_input_homepage']")).sendKeys("ОТУС" + Keys.ENTER);
        //        Проверить что в поисковой выдаче первый результат Онлайн‑курсы для профессионалов, дистанционное обучение
        driver.findElement(By.xpath("//a[@data-testid='result-title-a' and contains (text(), 'Онлайн‑курсы для профессионалов, дистанционное обучение')]"));
        logger.info(driver.getTitle());
    }
@Test
    public void Test2() throws InterruptedException {
//        Открыть Chrome в режиме киоска
driver.manage().window().fullscreen();
//        Перейти на https://demo.w3layouts.com/demos_new/template_demo/03-10-2020/photoflash-liberty-demo_Free/685659620/web/index.html?_ga=2.181802926.889871791.1632394818-2083132868.1632394818
driver.get("https://demo.w3layouts.com/demos_new/template_demo/03-10-2020/photoflash-liberty-demo_Free/685659620/web/index.html?_ga=2.181802926.889871791.1632394818-2083132868.1632394818");
//        Нажать на любую картинку
    Thread.sleep(1500);
driver.findElement(By.xpath("//img[@src ='assets/images/p1.jpg']")).click();
    Thread.sleep(1500);
//        Проверить что картинка открылась в модальном окне

//    driver.findElement(By.xpath("//div[@class='pp_pic_holder light_rounded']"));

    }


@Test
public void Test3() throws InterruptedException {
        //        Открыть Chrome в режиме полного экрана
    driver.manage().window().maximize();
    //        Перейти на https://otus.ru
    driver.get("https://otus.ru");
    driver.findElement(By.xpath("//span[@class='header2__auth-reg']")).click();
    //        Авторизоваться под каким-нибудь тестовым пользователем(можно создать нового)
    driver.findElement(By.xpath("//div[@class='new-log-reg__body']//input[@name='email']")).sendKeys("toyeyi1115@sartess.com");
    driver.findElement(By.xpath("//div[@class='new-log-reg__body']//input[@name='password']")).sendKeys("Qwerty123");
    driver.findElement(By.xpath("//div[@class='new-log-reg__body']//button")).click();
    logger.info("Пользователь авторизован");
//        Вывести в лог все cookie
//    driver.manage().getCookies();

}
}









