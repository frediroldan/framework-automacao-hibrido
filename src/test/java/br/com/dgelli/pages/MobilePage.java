package br.com.dgelli.pages;

import org.openqa.selenium.WebElement;

import br.com.dgelli.utils.BaseMobilePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

/**
 * @author Douglas Gelli
 * @version 1.0
 *
 */
public class MobilePage extends BaseMobilePage {

	// private Properties properties = PropertiesHelper.getProperties();

	public MobilePage(AndroidDriver<WebElement> driver) {
		super(driver);
	}

	/**************** Mapeamento *****************/

	@AndroidFindBy(xpath = "//*[@resource-id='com.google.android.calculator:id/digit_2']")
	private MobileElement dois;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/androidx.slidingpanelayout.widget.SlidingPaneLayout/android.widget.LinearLayout/android.view.ViewGroup[1]/android.widget.Button[1]")
	private MobileElement doisx;

	@AndroidFindBy(xpath = "//*[@resource-id='com.google.android.calculator:id/digit_4']")
	private MobileElement quatro;

	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='mais']")
	private MobileElement mais;

	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='igual']")
	private MobileElement igual;

	@AndroidFindBy(xpath = "//*[@resource-id='com.google.android.calculator:id/result_final']")
	private MobileElement resultado;

	@AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='nome']")
	private MobileElement nome;

	@AndroidFindBy(xpath = "//android.widget.CheckBox[@content-desc='check']")
	private MobileElement check;

	@AndroidFindBy(xpath = "//android.widget.Spinner[@content-desc=\"console\"]/android.widget.TextView")
	private MobileElement combo;

	@AndroidFindBy(xpath = "//*[@text='PS4']")
	private MobileElement combo2;

	@AndroidFindBy(xpath = "//*[@text='Clique Longo']")
	private MobileElement cliqueLongo;
	@AndroidFindBy(xpath = "//*[@text='Clique duplo']")
	private MobileElement cliqueDuplo;
	@AndroidFindBy(xpath = "//*[@text='Clique duplo lento']")
	private MobileElement cliqueDuploLento;
	@AndroidFindBy(xpath = "//*[@text='Limpar']")
	private MobileElement cliqueLimpar;

	@AndroidFindBy(xpath = "//*[@text='Formulário']")
	private MobileElement menuFormulario;

	@iOSFindBy(xpath = "Sei la")
	@AndroidFindBy(xpath = "//*[@text='Cliques']")
	private MobileElement menuCliques;

	@AndroidFindBy(xpath = "//*[@text='Alertas']")
	private MobileElement menuAlertas;

	@AndroidFindBy(xpath = "//*[@text='Swipe List']")
	private MobileElement menuSwipeList;

	@AndroidFindBy(xpath = "//*[@text='Drag and drop']")
	private MobileElement menuDragNDrop;

	@AndroidFindBy(xpath = "//*[@text='Esta']")
	private MobileElement DragNDropEsta;

	@AndroidFindBy(xpath = "//*[@text='e arraste para']")
	private MobileElement DragNDropEArrastePara;

	@AndroidFindBy(xpath = "//*[@text='Faça um clique longo,']")
	private MobileElement DragNDropFacaCliqueLongo;

	@AndroidFindBy(xpath = "//*[@text='é uma lista']")
	private MobileElement DragNDropEUmaLista;

	@AndroidFindBy(className = "android.widget.TextView")
	private MobileElement DragNDropLista;

	@AndroidFindBy(xpath = "//*[@text='Opção 3']/..")
	private MobileElement SwipeList3;

	@AndroidFindBy(xpath = "//*[@text='(+)']/..")
	private MobileElement SwipeListMais;

	@AndroidFindBy(xpath = "//*[@text='Opção 3 (+)']/..")
	private MobileElement SwipeList3Mais;

	@AndroidFindBy(xpath = "//*[@text='ALERTA SIMPLES']")
	private MobileElement alertasSimples;

	@AndroidFindBy(xpath = "//*[@text='ALERTA RESTRITIVO']")
	private MobileElement alertasRestritivo;

	@AndroidFindBy(xpath = "//*[@text='ALERTA CONFIRM']")
	private MobileElement alertasConfirma;

	@AndroidFindBy(xpath = "//*[@text='CONFIRMAR']")
	private MobileElement alertasConfirmar;

	@AndroidFindBy(xpath = "//*[@text='SAIR']")
	private MobileElement alertasSair;

	/*************** Funcoes *****************/
	
	
	public void testeapp() {
		click(menuFormulario);
		escrever(nome, "Douglas Gelli");
		isCheckboxMarcado(check);
		click(check);
		click(combo);
		click(combo2);
	}

	
	public void testeapp2() {

//		espera(1000);
//		back();
//		espera(1000);

		tap(menuCliques);
		doubleTap(cliqueDuplo);
		click(cliqueLimpar);
		longPress(cliqueLongo);

		espera(1000);
		back();
		espera(1000);
		scrollDown();
		click(menuDragNDrop);
		arrastarElemento(DragNDropEsta, DragNDropEArrastePara);
		arrastarElemento(DragNDropFacaCliqueLongo, DragNDropEUmaLista);
		espera(1000);
		back();
		espera(1000);
		scrollDown();
		click(menuSwipeList);
		swipeLeftElement(SwipeList3);
		int y = SwipeListMais.getLocation().y + (SwipeListMais.getSize().height / 2);
		int x = SwipeListMais.getLocation().x + (SwipeListMais.getSize().width / 4);
		tap(x, y);
		swipeRightElement(SwipeList3Mais);
		espera(1000);
		back();
		espera(1000);
		click(menuAlertas);
		click(alertasConfirma);
		obterTextoAlert();
		dismissAlert();
		obterTextoAlert();
		acceptAlert();
		tap(alertasSimples);
		obterTextoAlert();
		acceptAlert();
		tap(alertasRestritivo);
		obterTextoAlert();
		acceptAlert();

	}

}
