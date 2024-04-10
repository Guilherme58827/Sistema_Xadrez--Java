package xadrez.peças;

import boardgame.Posicao;
import boardgame.Tabuleiro;
import boardgame.TabuleiroException;
import xadrez.Cor;
import xadrez.PecaXadrez;

public class Torre extends PecaXadrez{
	public Torre(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro,cor);
	}
	
	@Override
	public String toString() {
		return "T";
	}

	@Override
	public boolean[][] movimentosPossiveis() throws TabuleiroException {
		boolean [][] mat= new boolean [getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
		
		Posicao p = new Posicao(0 ,0);
		p.setValor(posicao.getLinha()-1, posicao.getColuna());
		while(getTabuleiro().existePosicao(p) && !getTabuleiro().issoEPeca(p)) {
			mat[p.getLinha()][p.getColuna()]=true;
			p.setLinha(p.getLinha()-1);
		}
		if(getTabuleiro().existePosicao(p) && eUmaPecaOponente(p)) {
			mat[p.getLinha()][p.getColuna()]=true;
		}
		
	
		p.setValor(posicao.getLinha(), posicao.getColuna()-1);
		while(getTabuleiro().existePosicao(p) && !getTabuleiro().issoEPeca(p)) {
			mat[p.getLinha()][p.getColuna()]=true;
			p.setColuna(p.getColuna()-1);
		}
		if(getTabuleiro().existePosicao(p) && eUmaPecaOponente(p)) {
			mat[p.getLinha()][p.getColuna()]=true;
		}
		
		p.setValor(posicao.getLinha()+1, posicao.getColuna());
		while(getTabuleiro().existePosicao(p) && !getTabuleiro().issoEPeca(p)) {
			mat[p.getLinha()][p.getColuna()]=true;
			p.setLinha(p.getLinha()+1);
		}
		if(getTabuleiro().existePosicao(p) && eUmaPecaOponente(p)) {
			mat[p.getLinha()][p.getColuna()]=true;
		}
		
		p.setValor(posicao.getLinha(), posicao.getColuna()+1);
		while(getTabuleiro().existePosicao(p) && !getTabuleiro().issoEPeca(p)) {
			mat[p.getLinha()][p.getColuna()]=true;
			p.setColuna(p.getLinha()+1);
		}
		if(getTabuleiro().existePosicao(p) && eUmaPecaOponente(p)) {
			mat[p.getLinha()][p.getColuna()]=true;
		}
		
		return mat;
		
	}
}
