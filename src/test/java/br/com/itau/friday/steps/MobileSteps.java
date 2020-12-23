package br.com.itau.friday.steps;

import br.com.itau.friday.framework.Hooks;
import br.com.itau.friday.pages.MobilePage;
import cucumber.api.java.pt.Dado;

public class MobileSteps {

	private MobilePage mob;

	public MobileSteps() {
		mob = new MobilePage(Hooks.androidDriver);
	}

	@Dado("^que realizo algumas funcoes$")
	public void que_realizo_algumas_funcoes() throws Throwable {
		mob.testeapp();
	}

	@Dado("^que abro o app e ja faz tudo$")
	public void que_abro_o_app_e_ja_faz_tudo() throws Throwable {
		mob.testeapp2();
	}


	
}
