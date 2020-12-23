package br.com.itau.friday.utils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.math3.util.Precision;

/**
 * Classe que facilita a conversao entre Integer e String
 * 
 * @author Douglas Gelli
 *
 */
public class NumberUtils {

	public static String converteIntegerParaString(int value) {
		return Integer.toString(value);
	}

	public static int converteStringParaInteger(String value) {
		int retorno = 0;

		if ((!value.equals("-")) || (!value.isEmpty())) {
			try {
				retorno = Integer.parseInt(value);
			} catch (NumberFormatException ex) {
				System.out.println("Erro na conversão de String para integer");
				System.out.println("Erro: " + ex.toString());
			}
		}

		return retorno;
	}

	public static String converteFloatParaString(float value) {
		return Float.toString(value);
	}

	public static float converteStringParaFloat(String value) {
		float retorno = 0;
		value = removeCaracteresFloat(value);

		if ((!value.equals("-")) || (!value.isEmpty())) {
			try {
				retorno = Float.parseFloat(value);
			} catch (NumberFormatException ex) {
				System.out.println("Erro na conversão de String para float");
				System.out.println("Erro: " + ex.toString());
			}
		}

		return retorno;
	}

	public static Double converteStringParaDouble(String value) {
		double retorno = 0;
		value = removeCaracteresFloat(value);
		value = transformaVirgulaEmPonto(value);

		if ((!value.equals("-")) || (!value.isEmpty())) {
			try {
				retorno = Double.parseDouble(value);
			} catch (NumberFormatException ex) {
				System.out.println("Erro na conversão de String para double");
				System.out.println("Erro: " + ex.toString());
			}
		}

		return retorno;
	}

	public static String converteDoubleParaString(double valorDouble) {
		int valorInt = Double.valueOf(valorDouble).intValue();

		return Integer.valueOf(valorInt * 100).toString();
	}

	/**
	 * Método que trata e soma valores em um ArrayList de String
	 * 
	 * @param listaItens
	 *            ArrayList com os valores em String
	 * @return String com os valores somados
	 */
	public static String somaItemsListaString(List<String> listaItens) {
		List<Integer> listaNumeros = new ArrayList<Integer>();

		for (String item : listaItens) {
			listaNumeros.add(NumberUtils.converteStringParaInteger(item));
		}

		int soma = 0;

		for (Integer numero : listaNumeros) {
			soma += numero;
		}

		return NumberUtils.converteIntegerParaString(soma);
	}

	/**
	 * Método que trata e soma valores em um ArrayList de Strings
	 * 
	 * @param listaItens
	 *            ArrayList com os valores em String
	 * @return int com os valores somados
	 */
	public static int somaItemsListaInt(List<String> listaItens) {
		List<Integer> listaNumeros = new ArrayList<Integer>();

		for (String item : listaItens) {
			listaNumeros.add(NumberUtils.converteStringParaInteger(item));
		}

		int soma = 0;

		for (Integer numero : listaNumeros) {
			soma += numero;
		}

		return soma;
	}

	public static float arredondaDuasCasas(float value) {
		BigDecimal bd = new BigDecimal(Float.toString(value));
		bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
		return bd.floatValue();
	}

	public static float arredondaNumero(float value, int casasDecimais) {
		BigDecimal retorno = new BigDecimal(value).setScale(casasDecimais, BigDecimal.ROUND_HALF_UP);
		return retorno.floatValue();
	}

	public static double arredondaNumero(double value, int casasDecimais) {
		BigDecimal retorno = new BigDecimal(value).setScale(casasDecimais, BigDecimal.ROUND_HALF_UP);
		return retorno.doubleValue();
	}

	public static float converteParaPorcentagem(float valor) {
		float retorno = Precision.round(valor, 2) * 100;

		return retorno;
	}

	public static String removeCaracteres(String texto) {
		return texto.replaceAll("\\D+", "");
	}

	public static String removeCaracteresFloat(String texto) {
		return texto.replaceAll("%", "");
	}

	public static String transformaVirgulaEmPonto(String texto) {
		if (!texto.contains(","))
			return texto;

		texto = texto.replace(".", ";");
		texto = texto.replace(",", ".");
		texto = texto.replace(";", ",");

		return texto;
	}

	/**
	 * Método que gera números inteiros aleatórios.
	 * 
	 * @return int com valor entre 1 e 100.
	 */
	public static int pegaNumeroAleatorio() {
		int retorno = ThreadLocalRandom.current().nextInt(1, 101);
		return retorno;
	}

	/**
	 * Método que gera números inteiros aleatórios.
	 * 
	 * @param valorMinimo
	 *            valor mínimo a ser gerado
	 * @param valorMaximo
	 *            valor máximo a ser gerado (inclusivo)
	 * @return int com valor aleatório entre os dois valores enviados como
	 *         parâmetro.
	 */
	public static int pegaNumeroAleatorio(int valorMinimo, int valorMaximo) {
		int retorno = ThreadLocalRandom.current().nextInt(valorMinimo, valorMaximo + 1);
		return retorno;
	}

	/**
	 * Método que gera números inteiros aleatórios.
	 * 
	 * @param valorMinimo
	 *            valor mínimo a ser gerado
	 * @param valorMaximo
	 *            valor máximo a ser gerado (inclusivo)
	 * @return long com valor aleatório entre os dois valores enviados como
	 *         parâmetro.
	 */
	public static long pegaNumeroAleatorio(long valorMinimo, long valorMaximo) {
		long retorno = ThreadLocalRandom.current().nextLong(valorMinimo, valorMaximo + 1);
		return retorno;
	}

}
