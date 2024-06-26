package xadrez;

import boardgame.Posicao;

public class PosicaoXadrez {
	private char coluna;
	private int linha;
	public PosicaoXadrez(char coluna, int linha) throws XadrezException {
		if (coluna < 'a' || coluna>'h' || linha<1 || linha>8) {
			throw new XadrezException("posição inválida, posições apenas compreendem  de a1 até h8");
		}
		this.coluna = coluna;
		this.linha = linha;
	}
	public char getColuna() {
		return coluna;
	}
	
	public int getLinha() {
		return linha;
	}
	protected Posicao toPosicao() {
		return new Posicao(8-linha, coluna -'a');
	}
	protected static PosicaoXadrez fromPosicao(Posicao posicao) throws XadrezException {
		return new PosicaoXadrez((char)('a' -posicao.getColuna()), 8- posicao.getLinha() );
}
	@Override
	public String toString() {
		return ""+coluna+linha;
	}
	
	
}