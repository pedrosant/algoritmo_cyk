import java.util.Iterator;

public class Algoritmo {
	/*LEGENDA
	 * matrizD => Matriz onde está a gramática
	 * matrizR => Matriz onde está a resposta
	 * 
	 * */	
	
	String linguagem;
	int totalLinha;
	int totalColuna;
	int totalColuna_N_matriz;
	int totalm;
	int numeroColunasNovaMatriz;
	
	char matrizD [][];
	char matrizR [][];	
	
	
	boolean travaCriarMatrizR = false;
	boolean travaCleanMatriz = false;
	
	
	public void cyk() {
		
		
		numeroColunasNovaMatriz = enxugarMatriz();
		System.out.println("Número de colunas: " + numeroColunasNovaMatriz);
		
		/*Intancia matriz de Resposta*/
		if(travaCriarMatrizR == false) {
			matrizR = criarMatrizR();
			travaCriarMatrizR = true;
		}		
		
		// Preenchimento da primeira parte
		for(int i = 0; i < linguagem.toCharArray().length; i++) {			
			char valor = linguagem.charAt(i);
			for (int j = 0; j < totalLinha; j++) {
				for (int k = 0; k < totalColuna; k++) {
					if(matrizD[j][k] == valor) {
						 matrizR[matrizR.length-1][i] = matrizD[j][0]; 
					}
				}
			}
			
		}
		
		
		
		
		// 1º Ler Linguagem
		// 2º Verificar Gramática na matrizD
		// 3º Inserir respota na matrizR
		
		/*for(char c : linguagem.toCharArray()) {
			
		}*/
	}	
	
	public int tamanhoLinguagem() {
		int contador = 0;
		for(char c : linguagem.toCharArray()) {
			contador++;
		}
		return contador;
	}	
	
	
	public char[][] criarMatrizR() {
		int totalLinhasColunas = tamanhoLinguagem();
		char m[][]= new char [totalLinhasColunas][totalLinhasColunas];
		return m;
	}
    
	public int enxugarMatriz() {
		// Enxugar Matriz para ficar com dados realmente necessários
		
		// Descobre quantidade de colunas da nova matriz
	   if(travaCleanMatriz == false) {		   
		  totalColuna_N_matriz = 0;
		  totalm = 0;
		   for (int i = 0; i < totalLinha; i++) {
			 for (int j = 0; j < totalColuna; j++) {
			    if(matrizD[i][j] != '*') {
			    	if(j+1 <= totalColuna) {
			    		if(j+1 == totalColuna) {
			    			totalColuna_N_matriz++;
			    		}else {
			    			if(matrizD[i][j+1] != '*') {
					    		totalColuna_N_matriz++;
					    		j++;
					    	}else {
					    		totalColuna_N_matriz++;
					    	}
			    		}		    		
			    		
			    	}
			    }
		     }
			 if(totalm < totalColuna_N_matriz) {
				 totalm = totalColuna_N_matriz;
			 }
			 totalColuna_N_matriz = 0;
		   }		  
	   }				
		return totalm;		
	}
    
	
	public void imprimirMatrizD() {
		System.out.println("--------MATRIZ DA GRAMÁTICA---------");
		for (int i = 0; i < totalLinha; i++) {
			for (int j = 0; j < totalColuna; j++) {
				System.out.print(matrizD[i][j] + "");
			}
			System.out.println();
		}
	}

	public void imprimirMatrizR() {
		int tamanho = tamanhoLinguagem();
		System.out.println("--------MATRIZ CYK---------");
		for (int i = 0; i < tamanho; i++) {
			for (int j = 0; j < tamanho; j++) {				
				System.out.print(matrizR[i][j] + "");
			}
			System.out.println();
		}
	}
	
	public void inserirResposta() {
		
	}
	
	
	
	
	// Getts e Setts
	public void setMatrizD(char matriz[][]) {
		matrizD = matriz;
	}
	
	public void setLiguagem(String linguagem) {
		this.linguagem = linguagem;
	}

	
	public void setTotalLinha(int linha) {
		totalLinha = linha;
	}
	
	public void setTotalColuna(int coluna) {
		totalColuna = coluna;
	}
	
}
