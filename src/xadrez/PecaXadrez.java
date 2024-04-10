package xadrez;

import boardgame.Peca;
import boardgame.Posicao;
import boardgame.Tabuleiro;
import boardgame.TabuleiroException;

public abstract class PecaXadrez extends Peca {
	private Cor cor;
	
	
	public PecaXadrez(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro);
		this.cor = cor;
	}


	public Cor getCor() {
		return cor;
	}
	protected boolean eUmaPecaOponente(Posicao posicao) throws TabuleiroException {
		PecaXadrez p = (PecaXadrez)getTabuleiro().peca(posicao);
		return p !=null && p.getCor() != cor;
	}
	


	
	
	
}
