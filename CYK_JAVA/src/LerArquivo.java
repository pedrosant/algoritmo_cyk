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
	int totalColunasV = 0;	
	boolean travaCriarMatriz = false;
	boolean travaPreencherMatriz = false;
	boolean travaintanciarMatriz = false;
	String [][] mat;
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
		String elemento = "";
		// Separar por =>
				String linhacompleta = linha;				
				// Obtém maior número de colunas
				linhacompleta =  linhacompleta.replace("=>", "");
				linhacompleta =  linhacompleta.replace("|", "");
				linhacompleta =  linhacompleta.replace("  ", " ");				
				
				for (int i = 0; i < linhacompleta.toCharArray().length; i++) {
					char caracter = linhacompleta.charAt(i);
					String valor = String.valueOf(caracter);
					if(valor.equals(" ")) {
						
					}else {
						elemento = elemento.concat(valor);
						if(i+1 < linhacompleta.toCharArray().length) {
							char c = linhacompleta.charAt(i+1);
							String v = String.valueOf(c);
							if(v.equals(" ")) {
								totalColunasV ++;
							}
						}else {
							totalColunasV ++;
						}
						
						
					}
				}	
				
				if(totalColunas < totalColunasV) {
					totalColunas = totalColunasV;
				}	
				totalColunasV = 0;
				// Obtém maior número de linhas
				totalLinha++;					
	}
	
	public void pegarLinha(String linha) {	
		
		String elemento = "";
		// Separar por =>
				String linhacompleta = linha;				
				// Obtém maior número de colunas
				linhacompleta =  linhacompleta.replace("=>", "");
				linhacompleta =  linhacompleta.replace("|", "");
				linhacompleta =  linhacompleta.replace("  ", " ");				
				
				for (int i = 0; i < linhacompleta.toCharArray().length; i++) {
					char caracter = linhacompleta.charAt(i);
					String valor = String.valueOf(caracter);
					if(valor.equals(" ")) {
						
					}else {
						elemento = elemento.concat(valor);
						if(i+1 < linhacompleta.toCharArray().length) {
							char c = linhacompleta.charAt(i+1);
							String v = String.valueOf(c);
							if(v.equals(" ")) {								
								preencherMatriz(elemento);
								colunaMat++;
								elemento = "";
							}
						}						
						
					}
				}
				preencherMatriz(elemento);
				linhaMat++;
				colunaMat = 0;
		/*String linhacompleta = linha;		
		for(char c : linhacompleta.toCharArray()) {
			//System.out.print(c);
			preencherMatriz(c);
			colunaMat++;
		}*/
	}
	
	public String[][] criarMatriz() {
		String matriz [][] = new String[totalLinha][totalColunas];			
		return matriz;
	}
	
	public void preencherMatriz(String caracter) {		
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
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public String identificarCaracter(String linha, String caracter, int local) {
		String vetor [] = linha.split(caracter);		
		return vetor[local];
	}
	
	
	
	// Getts e Setts
	public String[][] getMatriz() {
		//limparMatriz();
		return mat;
	}
	
	public int getLinha() {
		return totalLinha;
	}
	
	public int getColuna() {
		return totalColunas;
	}
	
	/*public void limparMatriz() {		
	
	for (int i = 0; i < totalLinha; i++) {
		for (int j = 0; j < totalColunas; j++) {
			if(mat[i][j] == '=' ||mat[i][j] == '>' || mat[i][j] == '|' || mat[i][j] == ' '){
				mat[i][j] = '*';					
			}
		}
	}
}*/
	
}
