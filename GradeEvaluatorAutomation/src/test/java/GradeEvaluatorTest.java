import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class GradeEvaluatorTest {
    private AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        // 1. Konfigurasi Emulator dan lokasi APK
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("emulator-5554");
        options.setPlatformName("Android");

        // Pastikan path ini benar-benar sesuai dengan lokasi file APK
        options.setApp("C:\\Users\\n6nrc\\AndroidStudioProjects\\GradeEvaluator\\app\\build\\outputs\\apk\\debug\\gradeevaluator.apk");

        // 2. Menyambungkan ke Appium Server
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void testValidGradeInput() {
        // 3. Mencari elemen antarmuka
        WebElement etScore = driver.findElement(By.id("com.example.gradeevaluator:id/etScore"));
        WebElement btnCalculate = driver.findElement(By.id("com.example.gradeevaluator:id/btnCalculate"));

        // 4. Simulasi input nilai benar (85)
        etScore.clear();
        etScore.sendKeys("85");
        btnCalculate.click();

        // 5. Verifikasi hasil
        WebElement tvResult = driver.findElement(By.id("com.example.gradeevaluator:id/tvResult"));
        Assert.assertEquals(tvResult.getText(), "Grade: A");
    }

    @Test
    public void testInvalidGradeInput() {
        WebElement etScore = driver.findElement(By.id("com.example.gradeevaluator:id/etScore"));
        WebElement btnCalculate = driver.findElement(By.id("com.example.gradeevaluator:id/btnCalculate"));

        // Simulasi input nilai di luar batas
        etScore.clear();
        etScore.sendKeys("150");
        btnCalculate.click();

        // Verifikasi hasil error
        WebElement tvResult = driver.findElement(By.id("com.example.gradeevaluator:id/tvResult"));
        Assert.assertEquals(tvResult.getText(), "Grade: Nilai tidak valid (0-100)");
    }

    @AfterClass
    public void tearDown() {
        // 6. Menutup aplikasi
        if (driver != null) {
            driver.quit();
        }
    }
}