package br.com.itau.friday.steps;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import br.com.itau.friday.framework.DriverFactory;
import br.com.itau.friday.framework.Hooks;
import br.com.itau.friday.framework.PropertiesHelper;
import br.com.itau.friday.pages.LoginGridPage;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.AfterStep;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Classe Login, to use with GRID.
 * 
 * @author Douglas Gelli
 * @version 2.0
 * 
 */

public class LoginGridSteps {

	private static Properties properties = PropertiesHelper.getProperties();
	private LoginGridPage loginGridPage;
	protected WebDriver driver;
	Hooks hooks = new Hooks();

	public LoginGridSteps() {
		loginGridPage = new LoginGridPage(this.driver);
	}

	static String idThread = "Thread";
	String idEndThread;

	@Before("@gridchrome")
	public void Start_driverChrome(Scenario s) throws Exception {
		System.out.println(this.getClass().getName());
		if (s.getSourceTagNames().toString().toUpperCase().contains("GRID")) {
			if (this.getClass().getName().contains("LoginGridSteps")) {
				this.driver = DriverFactory.startDriver(DriverFactory.Browsers.CHROME);
				loginGridPage.start(driver);
				idThread = idThread + "-" + Thread.currentThread().getId();
				System.out.println(idThread);
			}
		}
	}

	@Before("@gridfirefox")
	public void Start_driverFirefox(Scenario s) throws Exception {
		System.out.println(this.getClass().getName());
		if (s.getSourceTagNames().toString().toUpperCase().contains("GRID")) {
			if (this.getClass().getName().contains("LoginGridSteps")) {
				this.driver = DriverFactory.startDriver(DriverFactory.Browsers.FIREFOX);
				loginGridPage.start(driver);
				idThread = idThread + "-" + Thread.currentThread().getId();
				System.out.println(idThread);
			}
		}
	}

	@Before("@gridedge")
	public void Start_driverEdge(Scenario s) throws Exception {
		System.out.println(this.getClass().getName());
		if (s.getSourceTagNames().toString().toUpperCase().contains("GRID")) {
			if (this.getClass().getName().contains("LoginGridSteps")) {
				this.driver = DriverFactory.startDriver(DriverFactory.Browsers.EDGE);
				loginGridPage.start(driver);
				idThread = idThread + "-" + Thread.currentThread().getId();
				System.out.println(idThread);
			}
		}
	}

	@AfterStep(order = 1)
	public void print(Scenario s) {
		if (s.isFailed()) {
			if (s.getSourceTagNames().toString().toUpperCase().contains("GRID")) {
				if (this.getClass().getName().contains("LoginGridSteps")) {
					try {
						hooks.print(loginGridPage.printReportHtml(this.driver));
					} catch (Exception e) {
					}
				}
			}
		}
	}

	@After()
	public void finished(Scenario s) throws IOException {
		if (s.getSourceTagNames().toString().toUpperCase().contains("GRID")) {
			if (this.getClass().getName().contains("LoginGridSteps")) {
				idEndThread = Long.toString(Thread.currentThread().getId());
				this.driver.quit();
			}
		}
	}

	/****************** Steps ****************************/

	@Given("^que estou na pagina de login atraves da url em Grid$")
	public void que_estou_na_pagina_de_login_atraves_da_url_em_Grid() {
		loginGridPage.setUrl(properties.getProperty("urlLogin"));
	}

	@When("^preencho o campo login \"([^\"]*)\" em Grid$")
	public void preencho_o_campo_login_em_Grid(String login) {
		loginGridPage.setFieldMail(login);
	}

	@When("^preencho o campo password \"([^\"]*)\" em Grid$")
	public void preenchoCampoPassword_em_Grid(String password) {
		loginGridPage.setFieldPassword(password);
	}

	@When("^clico no botao Signin em Grid$")
	public void clicoBotaoSignin_em_Grid() {
		loginGridPage.submitFieldLogin();
	}

	@Then("^a aplicacao exibe a mensagem \"([^\"]*)\" de bem vindo em Grid$")
	public void aplicacaoExibeMensagemBemVindo_em_Grid(String mensagem) throws Throwable {
		assertEquals(mensagem, loginGridPage.getMessageLoginSuccess());
	}

	@Then("^clico no botao Sair em Grid$")
	public void clicoBotaoSair_em_Grid() {
		loginGridPage.submitFieldLogout();
	}

}
