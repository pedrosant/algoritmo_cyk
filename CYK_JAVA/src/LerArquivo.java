import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class LerArquivo {
	//ArrayList <ArrayList> matriz = new ArrayList< ArrayList>();		
	int contador = 0;
	int totalLinha = 0;
	int totalColunas = 0;
	boolean travaCriarMatriz = false;
	boolean travaPreencherMatriz = false;
	boolean travaintanciarMatriz = false;
	char [][] mat;
	char [][] matrizLimpa;
	int linhaMat = 0;
	int colunaMat = 0;
	public void ler(String caminhoArquivo) {
		
		try {
			BufferedReader bufr = new BufferedReader(new FileReader(caminhoArquivo));
			
			String linha = "";
		//	Runtime.getRuntime().exec("explorer.exe");
			
			if(travaCriarMatriz == false) {
				while(true) {
					linha = bufr.readLine();
					if(linha != null) {					
						tamanhodaMatriz(linha);
					}else{							
						linha = bufr.readLine();
						if(linha == null) {
							break;
						}
					}				
				}
				travaCriarMatriz = true;
			}else {
				while(true) {
					linha = bufr.readLine();
					if(linha != null) {					
						pegarLinha(linha);
					}else{							
						linha = bufr.readLine();
						if(linha == null) {
							break;
						}
					}				
				}
			}
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	public void tamanhodaMatriz(String linha) {
		// Separar por =>
				String linhacompleta = linha;				
				// Obtém maior número de colunas
				if(totalColunas < linhacompleta.toCharArray().length) {
					totalColunas = linhacompleta.toCharArray().length;
				}				
				// Obtém maior número de linhas
				totalLinha++;					
	}
	
	public void pegarLinha(String linha) {		
		String linhacompleta = linha;		
		for(char c : linhacompleta.toCharArray()) {
			//System.out.print(c);
			preencherMatriz(c);
			colunaMat++;
		}		
		linhaMat++;
		colunaMat = 0;
	}
	
	public char[][] criarMatriz() {
		char matriz [][] = new char[totalLinha][totalColunas];			
		return matriz;
	}
	
	public void preencherMatriz(char caracter) {		
		if(travaintanciarMatriz == false) {
			 mat = criarMatriz();
			travaintanciarMatriz = true;
		}
		mat[linhaMat][colunaMat] = caracter;					
	}
	
	public void imprimirMatriz() {
		System.out.println("--------MATRIZ DA GRAMÁTICA---------");
		for (int i = 0; i < totalLinha; i++) {
			for (int j = 0; j < totalColunas; j++) {
				System.out.print(mat[i][j]);
			}
			System.out.println();
		}
	}
	
	public String identificarCaracter(String linha, String caracter, int local) {
		String vetor [] = linha.split(caracter);		
		return vetor[local];
	}
	
	public void limparMatriz() {		
		
		for (int i = 0; i < totalLinha; i++) {
			for (int j = 0; j < totalColunas; j++) {
				if(mat[i][j] == '=' ||mat[i][j] == '>' || mat[i][j] == '|' || mat[i][j] == ' '){
					mat[i][j] = '*';					
				}
			}
		}
	}
	
	
	// Getts e Setts
	public char[][] getMatriz() {
		limparMatriz();
		return mat;
	}
	
	public int getLinha() {
		return totalLinha;
	}
	
	public int getColuna() {
		return totalColunas;
	}
	
	
	
}
