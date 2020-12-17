package br.com.dgelli.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

public class ArquivoLog {

	File arquivo;
	FileReader fileReader;
	BufferedReader bufferedReader;
	FileWriter fileWrite;
	BufferedWriter bufferedWrite;
	Utils utils = new Utils();

	public void ArquivosLog(String log) {
		logWrite(log);
	}
	
	public void logWrite(String log) {
		log = utils.dataHoje("dd/MM/yyyy HH:mm:ss") + " " + log;
		try {
			arquivo = new File("Log/log.log");
			fileReader = new FileReader(arquivo);
			bufferedReader = new BufferedReader(fileReader);
			Vector<Object> texto = new Vector<>();
			while (bufferedReader.ready()) {
				texto.add(bufferedReader.readLine());
			}
			fileWrite = new FileWriter(arquivo);
			bufferedWrite = new BufferedWriter(fileWrite);
			for (int i = 0; i < texto.size(); i++) {
				bufferedWrite.write(texto.get(i).toString());
				bufferedWrite.newLine();
			}
			bufferedWrite.write(log);
			bufferedReader.close();
			bufferedWrite.close();
		} catch (FileNotFoundException e) {
			try {
				arquivo.createNewFile();
				logWrite(log);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} catch (IOException e) {
			System.exit(0);
		}
	}

	public boolean logRead(String wordFind) {
		boolean encontradoErro = false;
		try {
			arquivo = new File("Log/log.log");
			fileReader = new FileReader(arquivo);
			Scanner myReader = new Scanner(fileReader);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        encontradoErro = data.contains(wordFind);
		        if (encontradoErro == true) {
		        	break;
		        }
		      }
		      myReader.close();
			
		} catch (FileNotFoundException e) {

		} 
		return encontradoErro;
	}
}
