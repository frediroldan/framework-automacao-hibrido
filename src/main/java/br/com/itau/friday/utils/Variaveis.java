package br.com.itau.friday.utils;

//Só exempo de como funciona
public enum Variaveis {
	
		 
	    MANHA("manhã"),
	    TARDE("tarde"),
	    NOITE("noite");
	 
	    private String descricao;
	 
	    Variaveis(String descricao) {
	        this.descricao = descricao;
	    }
	 
	    public String getDescricao() {
	        return descricao;
	    }
	
}

// Para usar o conteudo da variavel basta:

// Variaveis vv = Variaveis.MANHA;
// ou 
// String vv = Variaveis.MANHA.getDescricao();

