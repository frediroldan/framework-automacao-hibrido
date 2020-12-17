package br.com.dgelli.pages;

import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;

import br.com.dgelli.utils.BasePage;
import br.com.dgelli.utils.Variaveis;

/**
 * @author Douglas Gelli
 * @version 2.0
 *
 */
public class LoginGridPage extends BasePage {

	protected WebDriver driver;
	public LoginGridPage(WebDriver driver) {
		super(driver);
	}

	public void start(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		if (driver != null) {
			wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(15))
					.pollingEvery(Duration.ofMillis(1000))
					.ignoring(NoSuchElementException.class, org.openqa.selenium.WebDriverException.class);
		}
	}
	


	// Locators

	//@FindBy(how = How.NAME, using = "email")
	@FindBy(xpath ="//input[@id='email']")
	private WebElement setFieldMail;

	@FindBy(how = How.NAME, using = "senha")
	private WebElement setFieldPassword;

	@FindBy(how = How.XPATH, using = "//button[@type='submit' and @class='btn btn-primary']")
	private WebElement submitFieldLogin;

	@FindBy(how = How.XPATH, using = "//*[@class='alert alert-success']")
	private WebElement validateMessagemLogin;

	@FindBy(how = How.XPATH, using = "//*[@id=\"navbar\"]/ul/li[5]/a")
	private WebElement submitFieldLogout;

	@FindBy(xpath = "//div[contains(text(),'Quadro de Cadeira')]")
	private WebElement menu_quadro_cadeira;

	//////////////////////////////////////////////////////////////

	public void setUrl(String pUrl) {
		String vv = Variaveis.MANHA.getDescricao();
		System.out.println(vv);
		driver.navigate().to(pUrl);
	}

	public void setFieldMail(String pEmail) {
		escrever(setFieldMail, pEmail);
	}

	public void setFieldPassword(String pSenha) {
		escrever(setFieldPassword, pSenha);
	}

	public void submitFieldLogin() {
		click(submitFieldLogin);
	}

	public String getMessageLoginSuccess() throws InterruptedException {
		return obterTexto(validateMessagemLogin);
	}

	public void submitFieldLogout() {
		click(submitFieldLogout);
	}

}
