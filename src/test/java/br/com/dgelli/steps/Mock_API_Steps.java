package br.com.dgelli.steps;

import br.com.dgelli.pages.Mock_API_Controller;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Mock_API_Steps {

	private Mock_API_Controller mock;

	public Mock_API_Steps() {
		this.mock = new Mock_API_Controller();
	}

	//@Dado("^que faco uma requisicao GET$")
	@Given("que faco uma requisicao GET")
	public void que_faco_uma_requisicao_GET() {
		this.mock.getfirst();
	}
	
	@When("valido status response {int}")
	public void valido_status_response(Integer Status) {
		this.mock.checkStatus(Status);
	}

	//@Entao("^retona status e conteudo$")
	@Then("retona status e conteudo")
	public void retona_status_e_conteudo() {
		mock.validagetfirst();
	}

	//@Dado("^que faco uma requisicao GET com filtro$")
	@Given("que faco uma requisicao GET com filtro")
	public void que_faco_uma_requisicao_GET_com_filtro() throws Throwable {
		mock.getfilter();
	}

	//@Entao("^retona status e conteudo filtrado$")
	@Then("retona status e conteudo filtrado")
	public void retona_status_e_conteudo_filtrado() throws Throwable {
		mock.validagetfilter();
	}

	//@Dado("^que faco uma requisicao Post$")
	@Given("que faco uma requisicao Post")
	public void que_faco_uma_requisicao_Post() throws Throwable {
		mock.post();
	}

	//@Entao("^retona status e conteudo do Post$")
	@Then("retona status e conteudo do Post")
	public void retona_status_e_conteudo_do_Post() throws Throwable {
		mock.validaPost();
		this.mock.get();
		mock.validaget();
	}

	//@Dado("^que faco uma requisicao Put$")
	@Given("que faco uma requisicao Put")
	public void que_faco_uma_requisicao_Put() throws Throwable {
		mock.put();
	}

	//@Entao("^retona status e conteudo do Put$")
	@Then("retona status e conteudo do Put")
	public void retona_status_e_conteudo_do_Put() throws Throwable {
		mock.validaPut();
		this.mock.get();
		mock.validaget();
	}

	//@Dado("^que faco uma requisicao Delete$")
	@Given("que faco uma requisicao Delete")
	public void que_faco_uma_requisicao_Delete() throws Throwable {
		mock.delete();
	}

	//@Entao("^retona status e conteudo do Delete$")
	@Then("retona status e conteudo do Delete")
	public void retona_status_e_conteudo_do_Delete() throws Throwable {
		mock.validaDelete();
		this.mock.get();
		mock.validaget();
	}
}
