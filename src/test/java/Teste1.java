import io.cucumber.core.gherkin.Pickle;
import io.cucumber.java.Scenario;
import jdk.jfr.Timespan;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Teste1 {

    @Test

    public void Cenario1() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "c:\\webdriver\\chromedriver.exe");
        WebDriver Driver = new ChromeDriver();
        Driver.get("https://wj-qa-automation-test.github.io/qa-test/");

        //Driver ira clicar no botao sugerido deixando ele invisivel
        Driver.findElement(By.id("btn_one")).click();

        //Driver ira clicar no botao sugerido deixando ele invisivel
        Driver.findElement(By.id("btn_two")).click();

        //Driver ira clicar no botao sugerido deixando ele invisivel
        Driver.findElement(By.id("btn_link")).click();

        Thread.sleep(1000);

        //devera verificar se o elemento esta invisivel se sim retornara true,
        // se não retornara false
        Assert.assertEquals(false,
                Driver.findElement(By.id("btn_one")).isDisplayed());
        //devera verificar se o elemento esta invisivel se sim retornara true,
        // se não retornara false
        Assert.assertEquals(false,
                Driver.findElement(By.id("btn_two")).isDisplayed());
        //devera verificar se o elemento esta invisivel se sim retornara true,
        // se não retornara false
        Assert.assertEquals(false,
                Driver.findElement(By.id("btn_link")).isDisplayed());

        //Comando para salvar em print o resultado do teste
        File file = ((TakesScreenshot)Driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File("target/screenshot/cenario1.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Driver.quit();
    }

    @Test
    public void Cenario2(){
        // Não consegui completar esta tarefa infelizmente nao encontrei uma forma de
        //interagir com o iframe pois ele não possui um NOME ou ID

        System.setProperty("webdriver.chrome.driver", "c:\\webdriver\\chromedriver.exe");
        WebDriver Driver = new ChromeDriver();
        Driver.get("https://wj-qa-automation-test.github.io/qa-test/");
        Driver.switchTo().frame("iframe_src=buttons.html");
        Driver.findElement(By.id("btn_one")).click();;

    }
    @Test
    public void Cenario3 () throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "c:\\webdriver\\chromedriver.exe");
        WebDriver Driver = new ChromeDriver();

        Driver.get("https://wj-qa-automation-test.github.io/qa-test/");
        //Driver devera digitar no campo first name
        Driver.findElement(By.id("first_name")).sendKeys("meu Primeiro nome");

        //Validação de que o campo first name foi realmete preenchido
        Assert.assertEquals("meu Primeiro nome",
                Driver.findElement(By.id("first_name")).getAttribute("value"));

        //Driver ira clicar no botao sugerido deixando ele invisivel
        Driver.findElement(By.id("btn_one")).click();

        //devera verificar se o elemento esta invisivel se sim retornara true,
        // se não retornara false
        Assert.assertEquals(true,
                Driver.findElement(By.id("btn_one")).isDisplayed());

        //Seleciona o checkbox OptionThree
        Driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div[2]/div[3]/label/input")).click();

        //Validando se o checkbox OptionThree foi selecionado
        Assert.assertTrue(Driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div[2]/div[3]/label/input")).isSelected());

        //Seleciona a caixa combo e seleciona a opção desejada
        WebElement element = Driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div[2]/select"));
        Select combo = new Select(element);
        combo.selectByVisibleText("ExampleTwo");

        //Verifica se a opção selecionada é realmete a que queremos
        Assert.assertEquals("ExampleTwo", combo.getFirstSelectedOption().getText());

        WebElement Selenium = Driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[3]/div/div[2]/img[4]"));
        if (Selenium.isDisplayed()){
            System.out.println("imagem selenium esta aqui");

            System.out.println("o texto da imagem è"+ Selenium.getAttribute("alt"));

            Assert.assertEquals(true,
                    Driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[3]/div/div[2]/img[4]")).isDisplayed());
        }

        Thread.sleep(1000);

        //Comando para salvar em print o resultado do teste
        File file = ((TakesScreenshot)Driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File("target/screenshot/cenario3.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Driver.quit();


    }
}



