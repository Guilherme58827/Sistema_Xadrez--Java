package boardgame;

public class Tabuleiro {
	private int linhas;
	private int colunas;
	private Peca[][]peças;
	public Tabuleiro(int linhas, int colunas) {
		
		this.linhas = linhas;
		this.colunas = colunas;
		peças = new Peca[linhas][colunas];
	}
	public int getLinhas() {
		return linhas;
	}
	public void setLinhas(int linhas) {
		this.linhas = linhas;
	}
	public int getColunas() {
		return colunas;
	}
	public void setColunas(int colunas) {
		this.colunas = colunas;
	}
	public Peca peca(int linhas, int colunas) {
		return peças[linhas][colunas];
	}
	
	public Peca peca(Posicao posicao) {
		return peças[posicao.getLinha()][posicao.getColuna()];
	}

	
	
	
}
