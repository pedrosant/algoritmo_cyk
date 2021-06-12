
public class CYK {

	public static void main(String[] args) {
		
		String caminho = "D:\\8º Período\\LFA\\2º Unidade\\arquivoTeste.txt";
		String linguagem = "abaab";
		
		LerArquivo arquivo  = new LerArquivo();
		Algoritmo al = new Algoritmo();
		
		int linha;
		int coluna;
		String matriz[][];		
		
		
		// INSPECIONA ARQUIVO
		arquivo.ler(caminho);
		// COLOCA DADOS DO ARQUIVO EM UMA MATRIZ
		arquivo.ler(caminho);	
		
		// Captura a matriz preenchida
		linha = arquivo.getLinha();
		coluna = arquivo.getColuna();
		matriz = arquivo.getMatriz();
		
		// Manda para cyk matriz preenchida
		al.setTotalLinha(linha);
		al.setTotalColuna(coluna);		
		al.setMatrizD(matriz);
		al.setLiguagem(linguagem);
		
		
		arquivo.imprimirMatriz();
		al.cyk();
		//al.imprimirMatrizD();
		al.imprimirMatrizR();
		
		
	}

}
