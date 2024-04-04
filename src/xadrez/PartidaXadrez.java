package xadrez;

import boardgame.Posicao;
import boardgame.Tabuleiro;
import boardgame.TabuleiroException;
import xadrez.peças.Rei;
import xadrez.peças.Torre;

public class PartidaXadrez {
	private Tabuleiro tabuleiro;

	public PartidaXadrez() throws TabuleiroException {
		super();
		tabuleiro = new Tabuleiro(8, 8);
		formaçãoInicial();
	}
	public PecaXadrez[][]getPeças() throws TabuleiroException{
		 PecaXadrez[][] matriz =new PecaXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];
		for(int i=0; i<tabuleiro.getLinhas(); i++) {
			for(int j=0; j<tabuleiro.getColunas(); j++) {
				matriz[i][j]= (PecaXadrez)tabuleiro.peca(i, j);
			}
		}
		return matriz;
	}
	private void formaçãoInicial() throws TabuleiroException {
		tabuleiro.lugarPeça(new Torre(tabuleiro, Cor.BRANCO), new Posicao(2, 2));
		tabuleiro.lugarPeça(new Rei(tabuleiro, Cor.PRETO), new Posicao(2, 2));
		tabuleiro.lugarPeça(new Torre(tabuleiro, Cor.PRETO), new Posicao(0, 4));
	}
}
