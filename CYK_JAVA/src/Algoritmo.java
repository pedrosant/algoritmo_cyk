import java.util.Iterator;

public class Algoritmo {
	/*LEGENDA
	 * matrizD => Matriz onde est� a gram�tica
	 * matrizR => Matriz onde est� a resposta
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
		//System.out.println("N�mero de colunas: " + numeroColunasNovaMatriz);
		
		/*Intancia matriz de Resposta*/
		if(travaCriarMatrizR == false) {
			matrizR = criarMatrizR();
			travaCriarMatrizR = true;
		}		
		
		/* ------------------- FUN��O DA MATRIZ -----------------:
		 * W = Tamanho da Linguagem
		 * I = Posi��o Inicial
		 * S = Resultado de (W - I)
		 * R = Resultado de (I + 1)
		 * 
		 * Temos Ent�o:
		 * 
		 * (W - I) = S ONDE I = 1;
		 * S + (1) = R
		 * 
		 * ONDE O |R| � O N�MERO DE CONJUNTO PERCORRIDOS;
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
			}
			}
			
		}
		
	public int calculoDaFuncao(int w, int i) {
		int s = w - i;
		int r = s + 1;
		return r;
	}
		
		
		// 1� Ler Linguagem
		// 2� Verificar Gram�tica na matrizD
		// 3� Inserir respota na matrizR
		
		/*for(char c : linguagem.toCharArray()) {
			
		}*/
	
	
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
		// Enxugar Matriz para ficar com dados realmente necess�rios
		
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
		System.out.println("--------MATRIZ DA GRAM�TICA---------");
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
