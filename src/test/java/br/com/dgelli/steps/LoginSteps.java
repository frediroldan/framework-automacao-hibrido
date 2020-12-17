package br.com.dgelli.steps;

import static org.junit.Assert.assertEquals;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import br.com.dgelli.framework.Hooks;
import br.com.dgelli.framework.PropertiesHelper;
import br.com.dgelli.pages.LoginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Classe Login, to not use with GRID.
 * 
 * @author Douglas Gelli
 * @version 2.0
 * 
 */

public class LoginSteps {

	private static Properties properties = PropertiesHelper.getProperties();
	private LoginPage loginPage;
	protected static WebDriver driver;

	public LoginSteps() {

		loginPage = new LoginPage(Hooks.driver);
	}

	static String idThread = "Thread";
	String idEndThread;

	/****************** Steps ****************************/

	@Given("^que estou na pagina de login atraves da url$")
	public void que_estou_na_pagina_de_login_atraves_da_url() {
		loginPage.setUrl(properties.getProperty("urlLogin"));
	}

	@When("^preencho o campo login \"([^\"]*)\"$")
	public void preencho_o_campo_login(String login) {
		loginPage.setFieldMail(login);
	}

	@When("^preencho o campo password \"([^\"]*)\"$")
	public void preenchoCampoPassword(String password) {
		loginPage.setFieldPassword(password);
	}

	@When("^clico no botao Signin$")
	public void clicoBotaoSignin() {
		loginPage.submitFieldLogin();
	}

	@Then("^a aplicacao exibe a mensagem \"([^\"]*)\" de bem vindo$")
	public void aplicacaoExibeMensagemBemVindo(String mensagem) throws Throwable {
		assertEquals(mensagem, loginPage.getMessageLoginSuccess());
	}

	@Then("^clico no botao Sair$")
	public void clicoBotaoSair() {
		loginPage.submitFieldLogout();
	}

}
