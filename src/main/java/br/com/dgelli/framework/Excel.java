package br.com.dgelli.framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.Normalizer;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.format.CellNumberFormatter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



/**
 * Clase que encapsula as operações com Excel
 * 
 * Use a função abrePlanilha use as funções get ou set ao final salvaPlanilha ou
 * fechaPlanilha
 * 
 * @author Douglas Gelli
 * 
 */
public class Excel {

	private Workbook[] wb = new Workbook[] { new HSSFWorkbook(), new XSSFWorkbook() };
	private Sheet planilha;
	private static FileInputStream arquivoEntrada;
	private static int wbIndex;
	public Iterator<Row> iterator;
	Logger logger = Logger.getLogger(getClass().getName());

	/**
	 * Método que retorna o objeto manipulador de arquivos do excel
	 * 
	 * @return atributo do tipo XSSFSheet {@link XSSFSheet}
	 */
	public Sheet getPlanilha() {
		return this.planilha;
	}

	/**
	 * Método que retorna a planilha aberta
	 * 
	 * @return atributo do tipo XSSFWorkbook {@link XSSFWorkbook}
	 */
	public Workbook getWorkBook() {
		return this.wb[wbIndex];
	}

	/**
	 * Método que abre a planilha
	 */

	public void abrePlanilha(File fileName, String workSheet) {
		logger.info("Abrir Excel: " + fileName);

		try {
			try {
				arquivoEntrada = new FileInputStream(fileName);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			this.wb[1] = new XSSFWorkbook(arquivoEntrada);
			// System.out.print("instanceof HSSFWorkbook: ");
			// System.out.println(this.wb[0] instanceof XSSFWorkbook);
			wbIndex = 1;

		} catch (IOException e) {
			logger.error("Falha ao abir Workbook xlsx: " + e);

			try {
				// System.out.println("Testando xls");
				try {
					arquivoEntrada = new FileInputStream(fileName);
				} catch (FileNotFoundException ee) {
					ee.printStackTrace();
				}

				this.wb[0] = new HSSFWorkbook(arquivoEntrada);
				// System.out.print("instanceof XSSFWorkbook: ");
				// System.out.println(wb[1] instanceof HSSFWorkbook);
				wbIndex = 0;
			} catch (Exception e1) {
				logger.error("Falha ao abir Workbook xls");
			}
		}

		// System.out.println(this.getWorkBook().getNumberOfSheets());
		// this.planilha = this.getWorkBook().getSheetAt(0);
		this.planilha = this.getWorkBook().getSheet(workSheet);
		iterator = planilha.iterator();
		logger.info("Total de linhas da planilha: " + this.planilha.getPhysicalNumberOfRows());
	}

	/**
	 * Método que grava as alterações efetuadas na planilha
	 */
	public void salvaPlanilha(File fileName) {
		FileOutputStream arquivoSaida = null;
		try {
			arquivoSaida = new FileOutputStream(fileName);

			this.getWorkBook().write(arquivoSaida);
			arquivoSaida.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		logger.info("Salvar Excel");
	}

	public void fechaPlanilha() {
		try {
			arquivoEntrada.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		logger.info("Fechar Excel");
	}

	/**
	 * Método que pega o valor de uma célula em texto
	 * 
	 * @param linha
	 *            inteiro que representa a linha da célula desejada, iniciando em 0
	 * @param coluna
	 *            inteiro que representa a coluna da célula desejada, iniciando em 0
	 * @param fileName
	 *            String com o caminho do arquivo
	 * @param workSheet
	 *            String com nome da worksheet dentro da planilha
	 * @return String com o texto contido na célula encontrada
	 */
	public String getTextoCelula(int linha, int coluna) {
		// abrePlanilha(fileName, workSheet);
		String textoCelula;
		try {
			this.getPlanilha().getRow(linha).getRowNum();
		} catch (NullPointerException e) {
			this.getPlanilha().createRow(linha);
		}
		try {
			this.getPlanilha().getRow(linha).getCell(coluna).getColumnIndex();
		} catch (NullPointerException e) {
			this.getPlanilha().getRow(linha).createCell(coluna).setCellValue("");
			textoCelula = this.getPlanilha().getRow(linha).getCell(coluna).getStringCellValue();
		}
		try {
			textoCelula = this.getPlanilha().getRow(linha).getCell(coluna).getStringCellValue();
		} catch (Exception ex) {
			textoCelula = Integer
					.toString((int) this.getPlanilha().getRow(linha).getCell(coluna).getNumericCellValue());
		}
		logger.info("Excel Get Texto Linha: " + linha + " Coluna: " + coluna + " = " + textoCelula);
		return textoCelula;
	}

	public String getTextoCelulaFormatada(int linha, int coluna) {
		// abrePlanilha(fileName, workSheet);
		DataFormatter dataFormatter = new DataFormatter();
		Cell cell = this.getPlanilha().getRow(linha).getCell(coluna);
		String retorno = dataFormatter.formatCellValue(cell);
		// fechaPlanilha();
		return retorno;
	}

	/**
	 * Método que pega o texto absoluto de uma célula
	 * 
	 * @param linha
	 *            inteiro que representa a linha da célula desejada, iniciando em 0
	 * @param coluna
	 *            inteiro que representa a coluna da célula desejada, iniciando em 0
	 * @return String com o texto absoluto contido na célula encontrada
	 */

	public String getTextoSimplesCelula(int linha, int coluna) {
		// abrePlanilha(fileName, workSheet);
		String textoCelula;
		textoCelula = this.getPlanilha().getRow(linha).getCell(coluna).getStringCellValue();
		String stringFormat = this.getPlanilha().getRow(linha).getCell(coluna).getCellStyle().getDataFormatString();
		CellNumberFormatter fmt = new CellNumberFormatter(stringFormat);
		textoCelula = fmt.format(this.getPlanilha().getRow(linha).getCell(coluna).getNumericCellValue());
		// fechaPlanilha();
		logger.info("Excel Get Texto Simples Linha: " + linha + " Coluna: " + coluna + " = " + textoCelula);
		return textoCelula;
	}

	/**
	 * Método que pega o valor da célula em Double
	 * 
	 * @param linha
	 *            inteiro que representa a linha da célula desejada, iniciando em 0
	 * @param coluna
	 *            inteiro que representa a coluna da célula desejada, iniciando em 0
	 * @return Double com o valor contido na célula encontrada
	 */

	public double getValorCelulaDouble(int linha, int coluna) {
		// abrePlanilha(fileName, workSheet);
		double valorCelula;
		try {
			valorCelula = this.getPlanilha().getRow(linha).getCell(coluna).getNumericCellValue();
		} catch (Exception ex) {
			valorCelula = Double.parseDouble(this.getPlanilha().getRow(linha).getCell(coluna).getStringCellValue());
		}
		logger.info("Excel Get Valor Linha: " + linha + " Coluna: " + coluna + " = " + valorCelula);
		return valorCelula;

	}

	/**
	 * Método que pega o valor da célula em int
	 * 
	 * @param linha
	 *            inteiro que representa a linha da célula desejada, iniciando em 0
	 * @param coluna
	 *            inteiro que representa a coluna da célula desejada, iniciando em 0
	 * @return inteiro com o valor contido na célula encontrada
	 */
	public int getValorCelulaInt(int linha, int coluna) {
		// abrePlanilha(fileName, workSheet);
		int valorCelula;
		try {
			valorCelula = (int) this.getPlanilha().getRow(linha).getCell(coluna).getNumericCellValue();
		} catch (Exception ex) {
			valorCelula = Integer.parseInt(this.getPlanilha().getRow(linha).getCell(coluna).getStringCellValue());
		}
		// fechaPlanilha();
		logger.info("Excel Get Int Linha: " + linha + " Coluna: " + coluna + " = " + valorCelula);
		return valorCelula;
	}

	/**
	 * Método que insere o valor em texto em uma célula
	 * 
	 * @param linha
	 *            inteiro que representa a linha da célula desejada, iniciando em 0
	 * @param coluna
	 *            inteiro que representa a coluna da célula desejada, iniciando em 0
	 * @param value
	 *            String com o texto a ser inserido na célula
	 * @param fileName
	 *            String com o caminho do arquivo
	 * @param workSheet
	 *            String com nome da worksheet dentro da planilha
	 */

	public void setTextoCelula(int linha, int coluna, String value) {
		// abrePlanilha(fileName, workSheet);
		try {
			this.getPlanilha().getRow(linha).getRowNum();
		} catch (NullPointerException e) {
			this.getPlanilha().createRow(linha);
		}
		try {
			this.getPlanilha().getRow(linha).getCell(coluna).getColumnIndex();
		} catch (NullPointerException e) {
			this.getPlanilha().getRow(linha).createCell(coluna);
		}
		this.getPlanilha().getRow(linha).getCell(coluna).setCellValue(value);
		logger.info("Excel Set Texto Linha: " + linha + " Coluna: " + coluna + " = " + value);
		// salvaPlanilha(fileName);
	}

	/**
	 * Método que insere o valor em int em uma célula.
	 * 
	 * @param linha
	 *            inteiro que representa a linha da célula desejada, iniciando em 0.
	 * @param coluna
	 *            inteiro que representa a coluna da célula desejada, iniciando em
	 *            0.
	 * @param value
	 *            int com o valor a ser inserido na célula.
	 */
	public void setTextoCelula(int linha, int coluna, int value) {
		this.setTextoCelula(linha, coluna, Integer.toString(value));
	}

	/**
	 * Método que insere o valor em float em uma célula.
	 * 
	 * @param linha
	 *            inteiro que representa a linha da célula desejada, iniciando em 0.
	 * @param coluna
	 *            inteiro que representa a coluna da célula desejada, iniciando em
	 *            0.
	 * @param value
	 *            float com o valor a ser inserido na célula.
	 */
	public void setTextoCelula(int linha, int coluna, float value) {
		this.setTextoCelula(linha, coluna, Float.toString(value));
	}

	/**
	 * Método que insere o valor de uma {@link Enum} em uma célula.
	 * 
	 * @param linha
	 *            inteiro que representa a linha da célula desejada, iniciando em 0.
	 * @param coluna
	 *            inteiro que representa a coluna da célula desejada, iniciando em
	 *            0.
	 * @param value
	 *            {@link Enum} com o name a ser inserido na célula.
	 */
	public void setTextoCelula(int linha, int coluna, Enum<?> enumValue) {
		if (enumValue == null)
			this.setTextoCelula(linha, coluna, "");
		else
			this.setTextoCelula(linha, coluna, enumValue.name());
	}

	/**
	 * Método que insere a data de um {@link LocalDate} em uma célula.
	 * 
	 * @param linha
	 *            inteiro que representa a linha da célula desejada, iniciando em 0.
	 * @param coluna
	 *            inteiro que representa a coluna da célula desejada, iniciando em
	 *            0.
	 * @param value
	 *            {@link LocalDate} com a data a ser inserido na célula.
	 */
	public void setTextoCelula(int linha, int coluna, LocalDate localDate) {
		this.setTextoCelula(linha, coluna, localDate.toString());
	}

	/**
	 * Método que insere o valor em Double em uma célula
	 * 
	 * @param linha
	 *            inteiro que representa a linha da célula desejada, iniciando em 0
	 * @param coluna
	 *            inteiro que representa a coluna da célula desejada, iniciando em 0
	 * @param value
	 *            Double com o valor a ser inserido na célula
	 */

	public void setValorCelulaDouble(int linha, int coluna, double value) {
		this.getPlanilha().getRow(linha).getCell(coluna).setCellValue(value);
	}

	/**
	 * Método que insere o valor em int em uma célula
	 * 
	 * @param linha
	 *            inteiro que representa a linha da célula desejada, iniciando em 0
	 * @param coluna
	 *            inteiro que representa a coluna da célula desejada, iniciando em 0
	 * @param value
	 *            int ocm o valor a ser inserido na célula
	 */

	public void setValorCelulaInt(int linha, int coluna, int value) {

		try {
			this.getPlanilha().getRow(linha).getRowNum();
		} catch (NullPointerException e) {
			this.getPlanilha().createRow(linha);
		}
		try {
			this.getPlanilha().getRow(linha).getCell(coluna).getColumnIndex();
		} catch (NullPointerException e) {
			this.getPlanilha().getRow(linha).createCell(coluna);
		}
		this.getPlanilha().getRow(linha).getCell(coluna).setCellValue(value);
		logger.info("Excel Set Int Linha: " + linha + " Coluna: " + coluna + " = " + value);
	}

	/**
	 * Método que retorna lista com os itens de uma coluna
	 * 
	 * @param coluna
	 *            índice da coluna desejada
	 * @return List com os valores encontrados na coluna
	 */

	public List<String> itensColuna(Integer coluna) {
		List<String> valores = new ArrayList<String>();
		for (Row r : this.getWorkBook().getSheetAt(0)) {
			Cell c = r.getCell(coluna);
			if (c != null) {
				valores.add(c.getStringCellValue());
			}
		}
		return valores;
	}

	/**
	 * Método que procura um texto em uma planilha, e retorna o índice da linha onde
	 * o texto foi encontrado
	 * 
	 * @param textoCelula
	 *            valor a ser encontrado em uma célula
	 * @return número da linha onde o texto foi encontrado. Caso o texto não tenha
	 *         sido encontrado, retorna 1
	 */

	/*
	 * public int achaLinhaPorTexto(String textoCelula) { for (Row linha :
	 * this.getWorkBook().getSheetAt(0)) { for (Cell celula : linha) { if
	 * (celula.getCellType() == Cell.CELL_TYPE_STRING) { if
	 * (celula.getRichStringCellValue().getString().trim().equals(textoCelula)) {
	 * return linha.getRowNum(); } } } } return 1; }
	 */

	/*
	 * public int achaLinhaPorTextoR(String textoCelula) { for (Row linha :
	 * this.getWorkBook().getSheetAt(0)) { for (Cell celula : linha) { if
	 * (celula.getCellType() == Cell.CELL_TYPE_STRING) { if
	 * (celula.getRichStringCellValue().getString().trim().equals(textoCelula)) {
	 * return linha.getRowNum(); } }
	 */
	/*
	 * } } return -1; }
	 */

	/**
	 * Método que retorna o número de linhas em uma planilha
	 * 
	 * Roberto Böker 12/09/2018
	 */

	public int getNumeroDeLinhas() {
		return this.getWorkBook().getSheetAt(0).getPhysicalNumberOfRows();
	}

	/**
	 * Método que remove uma linha inteira de uma planilha.
	 * 
	 * @param linha
	 *            inteiro que representa a linha da célula desejada, iniciando em 0
	 *
	 *            Roberto Böker 19/09/2018
	 */
	public void removeLinha(int linha) {

		try {
			this.getPlanilha().getRow(linha).getRowNum();

		} catch (NullPointerException e) {
			this.getPlanilha().createRow(linha);

		}

		this.getPlanilha().removeRow(this.getPlanilha().getRow(linha));
	}

	public void apagaPlanilha(Excel planilha) {
		int linhas_cont = planilha.getNumeroDeLinhas();
		for (int i = 0; i < linhas_cont; i++) {
			planilha.removeLinha(i);
		}
	}

	public int pegaTotalDeLinhas() {
		return this.planilha.getPhysicalNumberOfRows();
	}

	public String removeAcentos(String texto) {
		return Normalizer.normalize(texto, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
	}

	public void setFormulaCelula(int linha, int coluna, String value) {

		try {
			this.getPlanilha().getRow(linha).getRowNum();
		} catch (NullPointerException e) {
			this.getPlanilha().createRow(linha);
		}
		try {
			this.getPlanilha().getRow(linha).getCell(coluna).getColumnIndex();
		} catch (NullPointerException e) {
			this.getPlanilha().getRow(linha).createCell(coluna);
		}
		this.getPlanilha().getRow(linha).getCell(coluna).setCellFormula(value);
		logger.info("Excel Set Formula Linha: " + linha + " Coluna: " + coluna + " = " + value);

	}

	// public static void abreStream() {
	// try {
	// arquivoEntrada = new FileInputStream(fileName);
	// } catch (FileNotFoundException e) {
	// e.printStackTrace();
	// }
	// }
}