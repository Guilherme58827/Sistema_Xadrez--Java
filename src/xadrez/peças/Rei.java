package xadrez.peças;

import boardgame.Posicao;
import boardgame.Tabuleiro;
import boardgame.TabuleiroException;
import xadrez.Cor;
import xadrez.PecaXadrez;

public class Rei extends PecaXadrez {

	public Rei(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);

	}

	@Override
	public String toString() {
		return "R";
	}

	public boolean podeMover(Posicao posicao) throws TabuleiroException {

		
		return !getTabuleiro().issoEPeca(posicao) || eUmaPecaOponente(posicao);
	}

	@Override
	public boolean[][] movimentosPossiveis() throws TabuleiroException {
		boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
		Posicao p = new Posicao(0, 0);
		// acima
		p.setValor(posicao.getLinha() - 1, posicao.getColuna());
		if (getTabuleiro().existePosicao(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		// abaixo
		p.setValor(posicao.getLinha() + 1, posicao.getColuna());
		if (getTabuleiro().existePosicao(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		// direita
		p.setValor(posicao.getLinha(), posicao.getColuna() + 1);
		if (getTabuleiro().existePosicao(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		// esquerda
		p.setValor(posicao.getLinha(), posicao.getColuna() - 1);
		if (getTabuleiro().existePosicao(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		// diagonal cima-esquerda
		p.setValor(posicao.getLinha() - 1, posicao.getColuna() - 1);
		if (getTabuleiro().existePosicao(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		// diagonal cima-direita
		p.setValor(posicao.getLinha() - 1, posicao.getColuna() + 1);
		if (getTabuleiro().existePosicao(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		// diagonal baixo-esquerda
		p.setValor(posicao.getLinha() + 1, posicao.getColuna() - 1);
		if (getTabuleiro().existePosicao(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		// diagonal baixo-direita
		p.setValor(posicao.getLinha() +1, posicao.getColuna() + 1);
		if (getTabuleiro().existePosicao(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}

		return mat;
	}

}
