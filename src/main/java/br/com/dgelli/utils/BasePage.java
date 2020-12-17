
package br.com.dgelli.utils;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import br.com.dgelli.framework.PropertiesHelper;
import cucumber.api.Scenario;


public class BasePage {

	protected static WebDriver driver;
	protected Wait<WebDriver> wait;
	protected Logger logger = Logger.getLogger(getClass().getName());
	Utils utils = new Utils();
	private Robot robot;
	protected static Scenario scenario;
	private static Properties properties = PropertiesHelper.getProperties();
	private static boolean lastPrint = Boolean.parseBoolean(properties.getProperty("lastPrint"));
	private static boolean fullPrint = Boolean.parseBoolean(properties.getProperty("fullPrint"));
	private static boolean wordPrint = Boolean.parseBoolean(properties.getProperty("wordPrint"));


	public BasePage(WebDriver driver) {
		BasePage.driver = driver;
		PageFactory.initElements(driver, this);
		if (driver != null) {
			wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
					.pollingEvery(Duration.ofMillis(1000))
					.ignoring(NoSuchElementException.class, org.openqa.selenium.WebDriverException.class);
		}
	}

	public void setScenario(Scenario s) {
		BasePage.scenario = s;
	}

	/************** Navigate URL *********************/

	public void setUrl(String url) {
		logger.info("Url: " + url);
		driver.navigate().to(url);
	}

	/************** Esperar *********************/

	public void espera(int milisegundos) {
		try {
			Thread.sleep(milisegundos);
			logger.info("Espera de " + milisegundos + " milisegundos");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void espera(WebElement element) {
		boolean visible = false;
		int i = 0;
		while (visible == false && i <= 25) {
			try {
				visible = element.isDisplayed();
			} catch (Exception e) {
				espera(1000);
			}
			i++;
		}
	}
	

	/**************
	 * Click
	 * 
	 * @param <T>
	 *********************/

	public void click(WebElement element) {
		int i = 0;
		boolean click_ok = false;
		while (click_ok == false && i < 2) {
			try {
				logger.info("Click on element: " + element);
				wait.until(ExpectedConditions.visibilityOf(element));
				wait.until(ExpectedConditions.elementToBeClickable(element));
				print("Click");
				element.click();
				click_ok = true;
			} catch (Exception e) {
				logger.error("Error Click: " + e.getCause());
				System.out.println("Elemento click nao localizado: " + e.getCause());
				espera(1000);
				click_ok = false;
			}
			i++;
		}
		if (i >= 2) {
			element.click();
		}

	}

	public void clickDuplo(WebElement element) {
		Actions actions = new Actions(driver);
		int i = 0;
		boolean click_ok = false;
		while (click_ok == false && i < 2) {
			try {
				logger.info("Duplo Click on element: " + element);
				wait.until(ExpectedConditions.visibilityOf(element));
				wait.until(ExpectedConditions.elementToBeClickable(element));
				print("DoubleClick");
				actions.doubleClick(element).perform();
				click_ok = true;
			} catch (Exception e) {
				logger.error("Error Duplo Click: " + e.getCause());
				System.out.println("Elemento duplo click nao localizado: " + e.getCause());
				espera(1000);
				click_ok = false;
			}
			i++;
		}
		if (i >= 2) {
			actions.doubleClick(element).perform();
		}
	}

	public void clickArrasta(WebElement elementFrom, WebElement elementTo) {
		Actions actions = new Actions(driver);
		int i = 0;
		boolean click_ok = false;
		while (click_ok == false && i < 2) {
			try {
				logger.info("Click e arrasta: " + elementFrom + " para elemento " + elementTo);
				wait.until(ExpectedConditions.visibilityOf(elementFrom));
				wait.until(ExpectedConditions.elementToBeClickable(elementFrom));
				wait.until(ExpectedConditions.visibilityOf(elementTo));
				wait.until(ExpectedConditions.elementToBeClickable(elementTo));
				print("DragAndDrop");
				actions.dragAndDrop(elementFrom, elementTo).build().perform();
				click_ok = true;
			} catch (Exception e) {
				logger.error("Error Click e arrasta: " + e.getCause());
				System.out.println("Elementos ClickArrastaFrom nao localizado: " + elementFrom);
				System.out.println("Elementos ClickArrastaTo nao localizado: " + elementTo);
				espera(1000);
				click_ok = false;
			}
			i++;
		}
		if (i >= 2) {
			actions.dragAndDrop(elementFrom, elementTo).build().perform();
		}
	}

	public void clicarLink(String link) {
		driver.findElement(By.linkText(link)).click();
	}

	/************** Escrever *********************/

	public void escrever(WebElement element, String texto) {
		int i = 0;
		boolean write_ok = false;
		while (write_ok == false && i < 2) {
			try {
				logger.info("Escrever on element: " + element + " Texto: " + texto);
				wait.until(ExpectedConditions.visibilityOf(element));
				element.clear();
				espera(50);
				print("SendKeys");
				element.sendKeys(texto);
				write_ok = true;
			} catch (Exception e) {
				logger.error("Error Escrever: " + e.getCause());
				System.out.println("Elemento escrita nao localizado: " + e.getCause());
				espera(1000);
				write_ok = false;
			}
			i++;
		}
		if (i >= 2) {
			element.sendKeys(texto);
		}
	}

	public String obterTexto(WebElement element) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			logger.info("Obter texto: " + element.getText());
		} catch (Exception e) {
			logger.error("Error Obter texto: " + e.getCause());
		}
		return element.getText();
	}

	public String obterTextoAtributo(WebElement element, String atributo) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			logger.info("Obter Atributo: " + element.getAttribute(atributo));
		} catch (Exception e) {
			logger.error("Error Obter Atributo: " + e.getCause());
		}
		return element.getAttribute(atributo);
	}

	
	/**
	 * Return all text in page
	 * 
	 * @param driver
	 * @return List<String> Lista com os textos coletados
	 */
	public static List<String> obterTextosParaComparacao() {
		List<WebElement> todosElementos = driver.findElements(By.xpath("//*"));
		List<String> textosDaPagina = new ArrayList<>();

		for (WebElement elemento : todosElementos) {
			textosDaPagina.add(elemento.getText());
		}
		return textosDaPagina;
	}
	
	/********************* Regex ************************/

	public static String reduzirMultiplosEspacosEmUnicoEspaco(String texto) {
		String limpo = texto;
		Pattern pattern = Pattern.compile("(.*)(\\S)(\\s{2,})(\\S)(.*)");
		Matcher matcher = pattern.matcher(limpo);
		while (matcher.matches()) {
			String inicio = matcher.group(1);
			String meio1 = matcher.group(2);
			String meio2 = matcher.group(4);
			String fim = matcher.group(5);
			limpo = inicio + meio1 + " " + meio2 + fim;
			matcher = pattern.matcher(limpo);
		}
		return limpo;
	}
	
	/************** CheckBox *******************/

	public boolean isCheckboxMarcado(WebElement element) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			logger.info("CheckBox selecionada: " + element.isSelected());
		} catch (Exception e) {
			logger.error(e.getCause());
		}
		return element.isSelected();
	}

	/************** Tecla Enter *********************/

	public void pressENTER(WebElement element) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			logger.info("Press Enter on element: " + element);
			print("PressEnter");
			element.sendKeys(Keys.ENTER);
		} catch (Exception e) {
			logger.error(e.getCause());
			element.sendKeys(Keys.ENTER);
		}
	}

	public void pressEnter() {
		logger.info("Press Enter");
		try {
			robot = new Robot();
		} catch (AWTException e1) {
			e1.printStackTrace();
		}
		print("PressEnter");
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.delay(1000);
	}

	public void pressESC(WebElement element) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			logger.info("Press ESC on element: " + element);
			print("PressEsk");
			element.sendKeys(Keys.ESCAPE);
		} catch (Exception e) {
			logger.error(e.getCause());
			element.sendKeys(Keys.ESCAPE);
		}
	}

	public void pressTAB(WebElement element) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			logger.info("Press TAB on element: " + element);
			print("PressTab");
			element.sendKeys(Keys.TAB);
		} catch (Exception e) {
			logger.error(e.getCause());
			element.sendKeys(Keys.TAB);
		}
	}

	public void pressTAB() {
		logger.info("Press TAB");
		try {
			robot = new Robot();
		} catch (AWTException e1) {
			e1.printStackTrace();
		}
		print("PressTab");
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.delay(1000);
	}

	public void pressDEL(WebElement element) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			logger.info("Press DELETE on element: " + element);
			print("PressDel");
			element.sendKeys(Keys.DELETE);
		} catch (Exception e) {
			logger.error(e.getCause());
			element.sendKeys(Keys.DELETE);
		}
	}

	public void pressBackSpace(WebElement element) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			logger.info("Press BackSpace on element: " + element);
			print("PressBackSpace");
			element.sendKeys(Keys.BACK_SPACE);
		} catch (Exception e) {
			logger.error(e.getCause());
			element.sendKeys(Keys.BACK_SPACE);
		}
	}

	/************** Combo Box *********************/

	public void selecionarComboTexto(WebElement element, String texto_visivel) {
		logger.info("Selecionar texto visivel: " + texto_visivel);
		int i = 0;
		boolean elementVisibled = false;
		while (elementVisibled == false && i < 2) {
			try {
				wait.until(ExpectedConditions.elementToBeClickable(element));
				print("SelectCombo");
				Select combo = new Select(element);
				combo.selectByVisibleText(texto_visivel);
				elementVisibled = true;
			} catch (Exception e) {
				logger.error(e.getCause());
			}
			i++;
		}
		if (i >= 2) {
			Select combo = new Select(element);
			combo.selectByVisibleText(texto_visivel);
		}
	}

	public void selecionarComboPosicao(WebElement element, int posicao) {
		logger.info("Selecionar por posicao: " + posicao);
		int i = 0;
		boolean elementVisibled = false;
		while (elementVisibled == false && i < 2) {
			try {
				wait.until(ExpectedConditions.elementToBeClickable(element));
				print("SelectCombo");
				Select combo = new Select(element);
				combo.selectByIndex(posicao);
				elementVisibled = true;
			} catch (Exception e) {
				logger.error(e.getCause());
			}
			i++;
		}
		if (i >= 2) {
			Select combo = new Select(element);
			combo.selectByIndex(posicao);
		}
	}

	public void deselecionarComboTexto(WebElement element, String texto_visivel) {
		logger.info("Deselecionar texto visivel: " + texto_visivel);
		int i = 0;
		boolean elementVisibled = false;
		while (elementVisibled == false && i < 2) {
			try {
				wait.until(ExpectedConditions.elementToBeClickable(element));
				print("DeselectCombo");
				Select combo = new Select(element);
				combo.deselectByVisibleText(texto_visivel);
				elementVisibled = true;
			} catch (Exception e) {
				logger.error(e.getCause());
			}
			i++;
		}
		if (i >= 2) {
			Select combo = new Select(element);
			combo.deselectByVisibleText(texto_visivel);
		}
	}

	public int obterQuantidadeOpcoesCombo(WebElement element) {
		logger.info("Obter quantidade de opcoes no elemento: " + element);
		int i = 0;
		boolean elementVisibled = false;
		List<WebElement> options = null;
		while (elementVisibled == false && i < 2) {
			try {
				wait.until(ExpectedConditions.elementToBeClickable(element));
				Select combo = new Select(element);
				options = combo.getOptions();
				elementVisibled = true;
			} catch (Exception e) {
				logger.error(e.getCause());
			}
			i++;
		}
		if (i >= 2) {
			Select combo = new Select(element);
			options = combo.getOptions();
		}
		return options.size();
	}

	public String obterTextoSelecionadoCombo(WebElement element) {
		logger.info("Obter texto selecionado: " + element);
		int i = 0;
		boolean elementVisibled = false;
		String resultado = null;
		while (elementVisibled == false && i < 2) {
			try {
				wait.until(ExpectedConditions.elementToBeClickable(element));
				Select combo = new Select(element);
				resultado = combo.getFirstSelectedOption().getText();
				elementVisibled = true;
			} catch (Exception e) {
				logger.error(e.getCause());
			}
			i++;
		}
		if (i >= 2) {
			Select combo = new Select(element);
			resultado = combo.getFirstSelectedOption().getText();
		}
		return resultado;
	}

	public List<String> obterValoresCombo(WebElement element) {
		logger.info("Obter valores da combo: " + element);
		int i = 0;
		boolean elementVisibled = false;
		List<String> valores = null;
		while (elementVisibled == false && i < 2) {
			try {
				wait.until(ExpectedConditions.elementToBeClickable(element));
				Select combo = new Select(element);
				List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
				valores = new ArrayList<String>();
				for (WebElement opcao : allSelectedOptions) {
					valores.add(opcao.getText());
				}
				elementVisibled = true;
			} catch (Exception e) {
				logger.error(e.getCause());
			}
			i++;
		}
		if (i >= 2) {
			Select combo = new Select(element);
			List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
			valores = new ArrayList<String>();
			for (WebElement opcao : allSelectedOptions) {
				valores.add(opcao.getText());
			}
		}
		return valores;
	}

	public boolean verificarOpcaoCombo(WebElement element, String opcao) {
		logger.info("Verifica opcao combo se esta selecionada " + element + " Opcao: " + opcao);
		int i = 0;
		boolean elementVisibled = false;
		while (elementVisibled == false && i < 2) {
			try {
				wait.until(ExpectedConditions.elementToBeClickable(element));
				Select combo = new Select(element);
				List<WebElement> options = combo.getOptions();
				for (WebElement option : options) {
					if (option.getText().equals(opcao)) {
						elementVisibled = true;
						return true;
					}
				}
				elementVisibled = true;
			} catch (Exception e) {
				logger.error(e.getCause());
			}
			i++;
		}
		if (i >= 2) {
			Select combo = new Select(element);
			List<WebElement> options = combo.getOptions();
			for (WebElement option : options) {
				if (option.getText().equals(opcao)) {
					return true;
				}
			}
		}
		return false;
	}
	
	/********************* Clipboard ************************/

	public static String getStringFromClipboard() {
		String text = new String();
		try {
			text = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
		} catch (HeadlessException | UnsupportedFlavorException | IOException e) {
			e.printStackTrace();
		}
		return text;
	}

	/************** JS *********************/

	public Object executarJS(String cmd, Object... param) {
		logger.info("Excutar JS! cmd: " + cmd + " Parametro: " + param);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript(cmd, param);
	}

	public void scrollDown(WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", element);
			logger.info("ScrollDown to : " + element.getText());
		} catch (Exception e) {
			logger.error("Error ScrollDown: " + e.getCause());
		}
	}

	public void scrollDown() {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			logger.info("ScrollDown to end page");
		} catch (Exception e) {
			logger.error("Error ScrollDown: " + e.getCause());
		}
	}
	
	public static void clicarPorJSByID(String id) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById(arguments[0]).click()",id);
	}

	/************** Pop Up / Alerts *********************/

	public String alertaObterTexto() {
		Alert alert = driver.switchTo().alert();
		String texto = alert.getText();
		logger.info("Obter texto do alerta: " + texto);
		return texto;
	}

	public String alertaObterTextoEAceita() {
		Alert alert = driver.switchTo().alert();
		String valor = alert.getText();
		print("AcceptAlert");
		alert.accept();
		logger.info("Obter texto do alerta e aceitar: " + valor);
		return valor;
	}

	public String alertaObterTextoENega() {
		Alert alert = driver.switchTo().alert();
		String valor = alert.getText();
		print("DismissAlert");
		alert.dismiss();
		logger.info("Obter texto do alerta e negar: " + valor);
		return valor;
	}

	public void alertaEscreverEAceita(String valor) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(valor);
		logger.info("Escrever no alerta e aceitar: " + valor);
		print("AcceptAlert");
		alert.accept();
	}

	/************** Frames e Janelas ****************/

	public void entrarFrame(String nameOrId) {
		// id = (String) driver.getWindowHandles().toArray()[1]
		logger.info("Entrar no frame: " + nameOrId);
		driver.switchTo().frame(nameOrId);
	}

	public void sairFrame() {
		logger.info("Sair do frame");
		driver.switchTo().defaultContent();
	}

	public void trocarJanela(String nameOrHandle) {
		// List<String> handle = new ArrayList<>(driver.getWindowHandles());
		logger.info("Trocar janela para: " + nameOrHandle);
		driver.switchTo().window(nameOrHandle);
	}

	public void trocarHandle(int janelaArray) {
		// janelaArray = 0 eh janela original e 1 eh a nova janela
		logger.info("Trocar janela para: " + janelaArray);
		driver.switchTo().window((String) driver.getWindowHandles().toArray()[janelaArray]);
	}

	/********** Anexar documento com interacao tela windows *****************/

	public void anexar_objeto(String absolutePath, WebElement button_add, WebElement button_submit) {

		try {
			robot = new Robot();
		} catch (AWTException e1) {
			e1.printStackTrace();
		}
		// Espera o elemento de add arquivo ficar visivel
		wait.until(ExpectedConditions.visibilityOf(button_add));
		wait.until(ExpectedConditions.elementToBeClickable(button_add));
		button_add.click();

		// Aguarda a janela para selecao do arquivo abrir em 5s caso lentidao
		espera(5000);

		// texto (absolutePath) para area de tranferencia (ctrl+c)
		StringSelection textToClip = new StringSelection(absolutePath);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(textToClip, textToClip);

		// Simular (ctrl v) e e solta
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.delay(1000);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);

		// Simular o (Enter) e solta
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.delay(2000);

		// Finaliza clicanco no submit para enviar
		wait.until(ExpectedConditions.elementToBeClickable(button_submit));
		button_submit.click();

	}

	/*********************** Tabela *********************/

	public WebElement obterCelula(WebElement tabela, String colunaBusca, String valor, String colunaBotao) {

		// procurar coluna do registro
		int idColuna = obterIndiceColuna(colunaBusca, tabela);

		// encontrar a linha do registro
		int idLinha = obterIndiceLinha(valor, tabela, idColuna);

		// procurar coluna do botao
		int idColunaBotao = obterIndiceColuna(colunaBotao, tabela);

		// clicar no botao da celula encontrada
		WebElement celula = tabela.findElement(By.xpath(".//tr[" + idLinha + "]/td[" + idColunaBotao + "]"));
		return celula;
	}

	public void clicarBotaoTabela(WebElement tabela, String colunaBusca, String valor, String colunaBotao) {
		WebElement celula = obterCelula(tabela, colunaBusca, valor, colunaBotao);
		celula.findElement(By.xpath(".//input")).click();
	}

	protected int obterIndiceLinha(String valor, WebElement tabela, int idColuna) {
		List<WebElement> linhas = tabela.findElements(By.xpath("./tbody/tr/td[" + idColuna + "]"));
		int idLinha = -1;
		for (int i = 0; i < linhas.size(); i++) {
			if (linhas.get(i).getText().equals(valor)) {
				idLinha = i + 1;
				break;
			}
		}
		return idLinha;
	}

	protected int obterIndiceColuna(String coluna, WebElement tabela) {
		List<WebElement> colunas = tabela.findElements(By.xpath(".//th"));
		int idColuna = -1;
		for (int i = 0; i < colunas.size(); i++) {
			if (colunas.get(i).getText().equals(coluna)) {
				idColuna = i + 1;
				break;
			}
		}
		return idColuna;
	}

	private void print(String texto) {
		if (fullPrint == true) {
			printscr(texto);
		}
	}

	public void printscreen(String texto) {
		if (lastPrint == true || wordPrint == true) {
			printscr(texto);
		}
	}

	private void printscr(String texto) {
		String path = System.getProperty("user.dir") + File.separator + "output" + File.separator + "Evidence"
				+ File.separator + utils.dataHoje("yyyy-MM-dd") + File.separator + scenario.getName();
		File dir = new File(path);
		try {
			dir.mkdir();
			Thread.currentThread();
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String evidenceStep = path + File.separator
				+ java.time.LocalTime.now().toString().replace(":", "").replace(".", "") + "-"
				+ scenario.getStatus().toString().toUpperCase() + "-" + texto + ".png";
		File screenFile = new File(evidenceStep);
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, screenFile);
		} catch (IOException e) {
		}
		logger.info("Print Screen: " + evidenceStep);
	}

	public String printReportHtml() {
		String scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
		logger.info("Print Screen to HTML Report");
		return scrFile;
	}

	public String printReportHtml(WebDriver driver) {
		String scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
		logger.info("Print Screen to HTML Report");
		return scrFile;
	}

}
