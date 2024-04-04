package boardgame;

public class Tabuleiro {
	private int linhas;
	private int colunas;
	private Peca[][]peças;
	public Tabuleiro(int linhas, int colunas) throws TabuleiroException {
		if (linhas<1 || colunas<1) {
			throw new TabuleiroException("erro de criação de tabuleiro: necessário pelo menos 1 linha e 1 coluna.");
		}
		
		this.linhas = linhas;
		this.colunas = colunas;
		peças = new Peca[linhas][colunas];
	}
	public int getLinhas() {
		return linhas;
	}
	public int getColunas() {
		return colunas;
	}
	
	public Peca peca(int linhas, int colunas) throws TabuleiroException {
		
		if(!existePosicao(linhas , colunas)) {
			throw new TabuleiroException("erro de posição: a posição dessa peça não existe.");
			
		}
	
		return peças[linhas][colunas];
	}
	
	public Peca peca(Posicao posicao) throws TabuleiroException {
		if(!existePosicao(posicao)) {
			throw new TabuleiroException("erro de posição: a posição dessa peça não existe.");
			
		}
		
		return peças[posicao.getLinha()][posicao.getColuna()];
	}
	public void lugarPeça( Peca peça, Posicao posicao) throws TabuleiroException {
		if(issoEPeca(posicao)) {
			throw new TabuleiroException("erro de posição: a posição já está ocupada.");
			
		}
		peças[posicao.getLinha()][posicao.getColuna()]= peça;
		peça.posicao=posicao;
	}
	private boolean existePosicao(int linha, int coluna) {
		return linha >=0 && linha <linhas && coluna >=0 && coluna<colunas;
		}
	
	public boolean existePosicao(Posicao posicao) {
		return existePosicao(posicao.getLinha(), posicao.getColuna());
	}
	public boolean issoEPeca(Posicao posicao) throws TabuleiroException {
		if(!existePosicao(posicao)) {
			throw new TabuleiroException("erro de posição: a posição dessa peça não existe.");
			
		}
		return peca(posicao)!= null;
	}
	
	
	
}
