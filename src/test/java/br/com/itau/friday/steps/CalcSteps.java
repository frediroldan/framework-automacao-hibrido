package br.com.itau.friday.steps;

import br.com.itau.friday.framework.Hooks;
import br.com.itau.friday.pages.CalcPage;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class CalcSteps {
	
	
    
    private CalcPage calcPage;

    
    public CalcSteps() {
    	calcPage = new CalcPage(Hooks.driver);
    }
	
	@Dado("^que abro o programa \"([^\"]*)\"$")
	public void queAbroOPrograma(String arg1) throws Throwable {
	    calcPage.abrirAPP(arg1);
	}

	@Quando("^passo os valores$")
	public void passoOsValoresE() throws Throwable {
	    calcPage.valores();
	}

	@Entao("^resultado$")
	public void resultado() throws Throwable {
	    calcPage.resultado();
	}
}
