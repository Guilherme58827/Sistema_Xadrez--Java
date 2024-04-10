package xadrez;

import boardgame.Peca;
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
	public PecaXadrez fazerMovimentoXadrez(PosicaoXadrez posicaoInicio, PosicaoXadrez posicaoDestino) throws TabuleiroException {
		Posicao inicio = posicaoInicio.toPosicao();
		Posicao destino =posicaoDestino.toPosicao();
		validarPosicao(inicio);
		validarPosicaoDestino(inicio, destino);
		Peca pecaCapturada = mover(inicio,destino);
		return (PecaXadrez)pecaCapturada;	
	}
	private Peca mover(Posicao inicio, Posicao destino) throws TabuleiroException {
		Peca p = tabuleiro.removerPeca(inicio);
		Peca pCapturada =tabuleiro.removerPeca(destino);
		tabuleiro.lugarPeça(p, destino);
		return pCapturada;
		
	}
	private void validarPosicao(Posicao posicao) throws TabuleiroException {
		
		if (!tabuleiro.issoEPeca(posicao)) {
			throw new XadrezException("não existe uma peça nessa posição de origem.");
		}
		if (tabuleiro.peca(posicao).existeAlgumMovimento()==false) {
			throw new XadrezException("nenhum movimento é possivel.");
		}
	}
	private void validarPosicaoDestino(Posicao inicio, Posicao destino) throws XadrezException, TabuleiroException {
		 if (!tabuleiro.peca(inicio).movimentoPossivel(destino)) {
			 throw new XadrezException("posição não é alcançavel.");
		 }
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
