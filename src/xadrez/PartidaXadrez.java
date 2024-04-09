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
	
	private void novoLugarPeca(char coluna, int linha, PecaXadrez peca) throws TabuleiroException {
		tabuleiro.lugarPeça(peca, new PosicaoXadrez(coluna, linha).toPosicao());
	}
	
	private void formaçãoInicial() throws TabuleiroException {
		novoLugarPeca('c', 1, new Torre(tabuleiro, Cor.BRANCO));
		novoLugarPeca('c', 2, new Torre(tabuleiro, Cor.BRANCO));
		novoLugarPeca('d', 2, new Torre(tabuleiro, Cor.BRANCO));
		novoLugarPeca('e', 2, new Torre(tabuleiro, Cor.BRANCO));
		novoLugarPeca('e', 1, new Torre(tabuleiro, Cor.BRANCO));
		novoLugarPeca('d', 1, new Rei(tabuleiro, Cor.BRANCO));

		novoLugarPeca('c', 7, new Torre(tabuleiro, Cor.PRETO));
		novoLugarPeca('c', 8, new Torre(tabuleiro, Cor.PRETO));
		novoLugarPeca('d', 7, new Torre(tabuleiro, Cor.PRETO));
		novoLugarPeca('e', 7, new Torre(tabuleiro, Cor.PRETO));
		novoLugarPeca('e', 8, new Torre(tabuleiro, Cor.PRETO));
		novoLugarPeca('d', 8, new Rei(tabuleiro, Cor.PRETO));
	}
}
