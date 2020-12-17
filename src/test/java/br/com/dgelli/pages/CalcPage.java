package br.com.dgelli.pages;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import br.com.dgelli.utils.BasePage;
import br.com.dgelli.utils.Utils;

public class CalcPage extends BasePage {

	public CalcPage(WebDriver driver) {
		super(driver);
	}
	Utils utils = new Utils();

	@FindBy(id = "plusButton")
	private WebElement plus;

	@FindBy(how = How.ID, using = "num8Button")
	private WebElement n8;

	@FindBy(id = "equalButton")
	private WebElement equal;

	@FindBy(id = "CalculatorResults")
	private WebElement result;

	@FindBy(id = "Close")
	private WebElement close;

	public void abrirAPP(String processo) throws IOException {
		assertTrue(utils.verificaProcessoWin(processo));
	}

	public void valores() { 
		click(n8);
		click(plus);
		click(n8);
		click(equal);
		espera(2000);

	}
	Logger logger = Logger.getLogger(getClass().getName());
	public void resultado() {
		String output = obterTextoAtributo(result, "Name");
		//System.out.println(output);
		Assert.assertEquals("Exibição é 16", output);
		// click(close);
	}

}
