import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class Selenium {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\IdeaProjects\\Selenium3\\src\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(" https://www.avito.ru/");
        System.out.println("захожу на сайт авито ");
        driver.manage().window().maximize();
        System.out.println("Делаю окно на весь экран");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        System.out.println("добавляю время ожидания отклика элемента");
        Select category = new Select(driver.findElement(Xpath.SelectCategory.by));
        category.selectByValue("99");
        System.out.println("создаю элемент списка и выбираю нужную мне категорию в списке");
        WebElement vvodPrinter =driver.findElement(Xpath.VvodPrinterVstroku.by);
        vvodPrinter.sendKeys("Принтер");
        System.out.println("ввожу в поисковую строку 'Принтер'");
        driver.findElement(Xpath.ClickGorod.by).click();
        System.out.println("Кликаю по кнопке,для ввода нужного города");
        WebElement gorod = driver.findElement(Xpath.VvodVladivostok.by);
        gorod.sendKeys("Владивосток");
        System.out.println("Ввожу нужный мне город");
        WebElement ckickFirstItem = driver.findElement(Xpath.SelectClickFirstItem.by);
        ckickFirstItem.click();
        driver.findElement(Xpath.ClickPoisk.by).click();
        System.out.println("Выбираю и кликаю на первый элемент из списка, и кликаю по поиску");
        WebElement checkbox = driver.findElement(Xpath.ClickCheckBox.by);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkbox);
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
        System.out.println("Проверяю активировано ли поле чекбокса и кликаю по нему");
        driver.findElement(Xpath.ClickPoisk2.by).click();
        System.out.println("кликаю по поиску");
        Select doroje=new Select(driver.findElement(Xpath.SelectDoroje.by));
        doroje.selectByValue("2");
        System.out.println("Выбираю из сортировки списка, сначала чтоб шли самые дорогие");
        List<WebElement> webElementsList=driver.findElements(Xpath.ListPriner.by);
        {
            for (int i = 0; i < 3; i++) {
                System.out.println("Название: " +webElementsList.get(i).findElement(Xpath.Nazvanie.by).getText()+
                        " Цена: "+webElementsList.get(i).findElement(Xpath.Cena.by).getText());

            }
        }
        System.out.println("Создаю лист всех принтеров на странице , а пототм выбираю 3 самых первых элемента с выводом их цены и названия");



    }
}