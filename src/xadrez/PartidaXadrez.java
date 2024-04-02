package xadrez;

import boardgame.Tabuleiro;

public class PartidaXadrez {
	private Tabuleiro tabuleiro;

	public PartidaXadrez() {
		super();
		tabuleiro = new Tabuleiro(8, 8);
	}
	public PecaXadrez[][]getPeças(){
		 PecaXadrez[][] matriz =new PecaXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];
		for(int i=0; i<tabuleiro.getLinhas(); i++) {
			for(int j=0; j<tabuleiro.getColunas(); j++) {
				matriz[i][j]= (PecaXadrez)tabuleiro.peca(i, j);
			}
		}
		return matriz;
	}
}
