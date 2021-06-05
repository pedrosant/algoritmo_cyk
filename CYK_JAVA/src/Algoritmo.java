import java.util.Iterator;

public class Algoritmo {
	/*
	 * --------------LEGENDA------------------
	 * matrizD => Matriz onde está a gramática
	 * matrizR => Matriz onde está a resposta
	 * 
	 * */	
	
	        /*
	         *1º Ler Linguagem
			 *2º Verificar Gramática na matrizD
			 *3º Inserir respota na matrizR
			 *
	         */
	
	
	String linguagem;
	int totalLinha;
	int totalColuna;
	int totalColuna_N_matriz;
	int totalm;
	//int numeroColunasNovaMatriz;
	
	String matrizD [][];
	String matrizR [][];	
	
	
	boolean travaCriarMatrizR = false;
	boolean travaCleanMatriz = false;
	
	
	public void cyk() {
		
		
		//numeroColunasNovaMatriz = enxugarMatriz();
		//System.out.println("Número de colunas: " + numeroColunasNovaMatriz);
		
		/*Intancia matriz de Resposta*/
		if(travaCriarMatrizR == false) {
			matrizR = criarMatrizR();
			travaCriarMatrizR = true;
		}		
		
		// Faz preenchimento da primeira linha
		primeira_linha();
		
		
		/* ------------------- FUNÇÃO DA MATRIZ -----------------:
		 * W = Tamanho da Linguagem
		 * I = Posição Inicial
		 * S = Resultado de (W - I)
		 * R = Resultado de (I + 1)
		 * 
		 * Temos Então:
		 * 
		 * (W - I) = S ONDE I = 1;
		 * S + (1) = R
		 * 
		 * ONDE O |R| É O NÚMERO DE CONJUNTO PERCORRIDOS;
		 * */ 
		
		// Preenchimento da MATRIZ
		
		int w = linguagem.toCharArray().length;
		int z = 1;		
		
		int inicio = 0;
		int f = 1;
		int fim = 1;
		int q = linguagem.toCharArray().length;
		
		for(int k = 0; k < linguagem.toCharArray().length; k++) {	
			if(k+1 == q) {
			f++;	
			k = -1;
			inicio = 0;
			fim = f;
			q--;
			if(f == linguagem.toCharArray().length) {
				break;
			}			
			}else {
				String resultado = "";
				char valor = linguagem.charAt(k);
				int r = calculoDaFuncao(w, z);			
				for (int j = inicio; j < totalColuna; j++) {
					if(j >= inicio && j <= fim) {
						char v = linguagem.charAt(j);				 
					    resultado = resultado.concat(String.valueOf(v));					
					}else {
						inicio++;
						fim++;					
						break;
					}
											
					
					}
				//System.out.print(resultado);
				//System.out.println();
			}
			}
			
		}
		
	// COMPARAR LINGUAGEM COM A GRAMÁTICA
	public void Compara_L_G() {
		
	}
	
	public void primeira_linha() {
		for(int i = 0; i < linguagem.toCharArray().length; i++) {
			for (int j = 0; j < totalLinha; j++) {
				for (int j2 = 0; j2 < totalColuna; j2++) {
					String caracter = String.valueOf(linguagem.charAt(i));
					String caracter2 = matrizD[j][j2];
					if(caracter2.equals(caracter)) {
						matrizR[matrizR.length-1][i] = matrizD[j][0];
					}
				}
			}
		}
	}
	
	
	public int calculoDaFuncao(int w, int i) {
		int s = w - i;
		int r = s + 1;
		return r;
	}
	
	public int tamanhoLinguagem() {
		int contador = 0;
		for(char c : linguagem.toCharArray()) {
			contador++;
		}
		return contador;
	}	
	
	public String[][] criarMatrizR() {
		int totalLinhasColunas = tamanhoLinguagem();
		String m[][]= new String [totalLinhasColunas][totalLinhasColunas];
		return m;
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
	public void setMatrizD(String matriz[][]) {
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
	
	
	
	
	
	
   /*public int enxugarMatriz() {
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
*/
	
	
}
