package br.com.dgelli.utils;

import java.util.Random;



public class GeradorDeCodigoDeBarras {

	public enum Convenio {
		SABESP(2, new int[] { 0, 0, 9, 7 }, 4, 8), 
		ELETROPAULO(3, new int[] { 0, 0, 4, 8 }, 4, 8), 
		IPVASP(5, new int[] { 0, 0, 2, 5 }, 4, 8), 
		DARE(5, new int[] { 0, 0, 2, 4 }, 4, 8), 
		GAS(3, new int[] { 0, 0, 5, 7 }, 4, 8), 
		TELEFONE(3, new int[] { 0, 0, 5, 7 }, 4, 8), 
		PMSP(1, new int[] { 5, 7, 0, 1 }, 4, 8), 
		DPVAT(6, new int[] { 0, 9, 2, 4 }, 4, 8), 
		IPVAMG(5, new int[] { 0, 0, 6, 1 }, 4, 8), 
		IPTU(1, new int[] { 5, 8, 8, 9 }, 4, 8), 
		MULTATRANSITO(7, new int[] { 4, 4, 9, 1 }, 4, 8), 
		GPS(5, new int[] { 0, 2, 7, 0 }, 4, 8), 
		DARF(5, new int[] { 0, 0, 6, 4 }, 4, 8), 
		DAR(5, new int[] { 0, 1, 8, 6 }, 4, 8), 
		DAE(2, new int[] { 0, 0, 2, 9 }, 4, 8);

		private int segmento;
		private int[] empresa;
		private int versao;
		private int moeda;

		private Convenio(int segmento, int[] empresa, int versao, int moeda) {
			this.segmento = segmento;
			this.empresa = empresa;
			this.versao = versao;
			this.moeda = moeda;
		}

		private int getSegmento() {
			return segmento;
		}

		private int[] getEmpresa() {
			return empresa;
		}

		private int getVersao() {
			return versao;
		}

		private int getMoeda() {
			return moeda;
		}
	}

	public String[] geraCodigoDeBarrasContaConsumoDividido(Convenio convenio) {
		int[] codigo = geraArrayDeCodigoDeBarras(convenio);
		String c1 = "";
		String c2 = "";
		String c3 = "";
		String c4 = "";

		for (int i = 0; i < 12; i++) {
			c1 += String.valueOf(codigo[i]);
		}
		for (int i = 12; i < 24; i++) {
			c2 += String.valueOf(codigo[i]);
		}
		for (int i = 24; i < 36; i++) {
			c3 += String.valueOf(codigo[i]);
		}
		for (int i = 36; i < 48; i++) {
			c4 += String.valueOf(codigo[i]);
		}

		return new String[] { c1, c2, c3, c4 };
	}

	public String geraCodigoDeBarras(Convenio convenio) {
		int[] codigo = geraArrayDeCodigoDeBarras(convenio);
		String c = "";

		for (int i = 0; i < codigo.length; i++) {
			c += String.valueOf(codigo[i]);
		}

		return c;
	}

	public int[] geraArrayDeCodigoDeBarras(Convenio convenio) {
		int[] codigo = new int[48];
		codigo[0] = 8;
		codigo[1] = convenio.getSegmento();
		codigo[2] = convenio.getMoeda();
		codigo = geraValor(codigo);
		codigo[16] = convenio.getEmpresa()[0];
		codigo[17] = convenio.getEmpresa()[1];
		codigo[18] = convenio.getEmpresa()[2];
		codigo[19] = convenio.getEmpresa()[3];
		codigo[20] = geraInteiroAleatorioDeZeroANove();
		codigo[21] = geraInteiroAleatorioDeZeroANove();
		codigo[22] = geraInteiroAleatorioDeZeroANove();
		for (int i = 24; i <= 34; i++) {
			codigo[i] = geraInteiroAleatorioDeZeroANove();
		}
		for (int i = 36; i <= 46; i++) {
			codigo[i] = geraInteiroAleatorioDeZeroANove();
		}

		codigo[3] = geraDigitoAPartirDoModulo(geraPrimeiroModulo(convenio, codigo));
		codigo[11] = geraDigitoAPartirDoModulo(geraSegundoModulo(convenio, codigo));
		codigo[23] = geraDigitoAPartirDoModulo(geraTerceiroModulo(convenio, codigo));
		codigo[35] = geraDigitoAPartirDoModulo(geraQuartoModulo(convenio, codigo));
		codigo[47] = geraDigitoAPartirDoModulo(geraQuintoModulo(convenio, codigo));

		return codigo;
	}

	private int geraDigitoAPartirDoModulo(int modulo) {
		if (modulo == 0 || modulo == 1)
			return 0;
		else {
			if (modulo == 10)
				return 1;
			else
				return 11 - modulo;
		}
	}

	private int geraPrimeiroModulo(Convenio convenio, int[] codigo) {
		if (convenio.getVersao() == 4) {
			int soma = 0;
			int fator = 2;

			// para cada digito do codigo de barras
			for (int i = 46; i >= 0; i--) {
				// exceto estes
				if (i == 35 || i == 23 || i == 11 || i == 3) {
					continue;
				}
				// acumula a soma dos produtos de cada digito por 2, 3, 4, ..., 9
				soma += (codigo[i] * fator);

				fator++;
				// depois do 9, volta ao 2
				if (fator > 9) {
					fator = 2;
				}
			}
			// retorna o modulo da soma acumulada por onze
			return (soma % 11);
		} else {
			throw new IllegalArgumentException(
					"Não há um algoritmo definido para versões de convênio diferentes de 4 ...");
		}
	}

	private int geraSegundoModulo(Convenio convenio, int[] codigo) {
		if (convenio.getVersao() == 4) {
			int soma = 0;
			int fator = 2;

			// para cada digito do codigo de barras
			for (int i = 10; i >= 0; i--) {
				// acumula a soma dos produtos de cada digito por 2, 3, 4, ..., 9
				soma += (codigo[i] * fator);

				fator++;
				// depois do 9, volta ao 2
				if (fator > 9) {
					fator = 2;
				}
			}
			// retorna o modulo da soma acumulada por onze
			return (soma % 11);
		} else {
			throw new IllegalArgumentException(
					"Não há um algoritmo definido para versões de convênio diferentes de 4 ...");
		}
	}

	private int geraTerceiroModulo(Convenio convenio, int[] codigo) {
		if (convenio.getVersao() == 4) {
			int soma = 0;
			int fator = 2;

			// para cada digito do codigo de barras
			for (int i = 22; i >= 12; i--) {
				// acumula a soma dos produtos de cada digito por 2, 3, 4, ..., 9
				soma += (codigo[i] * fator);

				fator++;
				// depois do 9, volta ao 2
				if (fator > 9) {
					fator = 2;
				}
			}
			// retorna o modulo da soma acumulada por onze
			return (soma % 11);
		} else {
			throw new IllegalArgumentException(
					"Não há um algoritmo definido para versões de convênio diferentes de 4 ...");
		}
	}

	private int geraQuartoModulo(Convenio convenio, int[] codigo) {
		if (convenio.getVersao() == 4) {
			int soma = 0;
			int fator = 2;

			// para cada digito do codigo de barras
			for (int i = 34; i >= 24; i--) {
				// acumula a soma dos produtos de cada digito por 2, 3, 4, ..., 9
				soma += (codigo[i] * fator);

				fator++;
				// depois do 9, volta ao 2
				if (fator > 9) {
					fator = 2;
				}
			}
			// retorna o modulo da soma acumulada por onze
			return (soma % 11);
		} else {
			throw new IllegalArgumentException(
					"Não há um algoritmo definido para versões de convênio diferentes de 4 ...");
		}
	}

	private int geraQuintoModulo(Convenio convenio, int[] codigo) {
		if (convenio.getVersao() == 4) {
			int soma = 0;
			int fator = 2;

			// para cada digito do codigo de barras
			for (int i = 46; i >= 36; i--) {
				// acumula a soma dos produtos de cada digito por 2, 3, 4, ..., 9
				soma += (codigo[i] * fator);

				fator++;
				// depois do 9, volta ao 2
				if (fator > 9) {
					fator = 2;
				}
			}
			// retorna o modulo da soma acumulada por onze
			return (soma % 11);
		} else {
			throw new IllegalArgumentException(
					"Não há um algoritmo definido para versões de convênio diferentes de 4 ...");
		}
	}

	// 11 digitos 4-10, 12-15
	private int[] geraValor(int[] codigo) {
		codigo[4] = 0;
		codigo[5] = 0;
		codigo[6] = 0;
		codigo[7] = 0;
		codigo[8] = 0;
		codigo[9] = 0;
		codigo[10] = 0;
		codigo[12] = geraInteiroAleatorio(1, 3);
		codigo[13] = geraInteiroAleatorioDeZeroANove();
		codigo[14] = geraInteiroAleatorioDeZeroANove();
		codigo[15] = geraInteiroAleatorioDeZeroANove();
		return codigo;
	}

	private int geraInteiroAleatorioDeZeroANove() {
		return geraInteiroAleatorio(0, 10);
	}

	private int geraInteiroAleatorio(int limiteInferior, int limiteSuperior) {
		Random rand = new Random();
		return limiteInferior + rand.nextInt(limiteSuperior - limiteInferior);
	}
}
