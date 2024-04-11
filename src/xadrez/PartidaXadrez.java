package xadrez;

import boardgame.Peca;
import boardgame.Posicao;
import boardgame.Tabuleiro;
import boardgame.TabuleiroException;
import xadrez.peças.Rei;
import xadrez.peças.Torre;

public class PartidaXadrez {
	private Tabuleiro tabuleiro;
	private Cor jogadorAtual;
	private int turno;

	public PartidaXadrez() throws TabuleiroException {
		super();
		turno = 1;
		jogadorAtual = Cor.BRANCO;
		tabuleiro = new Tabuleiro(8, 8);
		formaçãoInicial();
	}

	public int getTurno() {
		return turno;
	}

	public Cor getJogadorAtual() {
		return jogadorAtual;
	}

	public PecaXadrez[][] getPeças() throws TabuleiroException {
		PecaXadrez[][] matriz = new PecaXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];
		for (int i = 0; i < tabuleiro.getLinhas(); i++) {
			for (int j = 0; j < tabuleiro.getColunas(); j++) {
				matriz[i][j] = (PecaXadrez) tabuleiro.peca(i, j);
			}
		}
		return matriz;
	}

	public PecaXadrez fazerMovimentoXadrez(PosicaoXadrez posicaoInicio, PosicaoXadrez posicaoDestino)
			throws TabuleiroException {
		Posicao inicio = posicaoInicio.toPosicao();
		Posicao destino = posicaoDestino.toPosicao();
		validarPosicao(inicio);
		validarPosicaoDestino(inicio, destino);
		Peca pecaCapturada = mover(inicio, destino);
		trocarTurno();
		return (PecaXadrez) pecaCapturada;
	}

	private Peca mover(Posicao inicio, Posicao destino) throws TabuleiroException {
		Peca p = tabuleiro.removerPeca(inicio);
		Peca pCapturada = tabuleiro.removerPeca(destino);
		tabuleiro.lugarPeça(p, destino);
		return pCapturada;

	}

	public boolean[][] movimentosPossiveis(PosicaoXadrez posicaoInicio) throws TabuleiroException {
		Posicao posicao = posicaoInicio.toPosicao();
		validarPosicao(posicao);
		return tabuleiro.peca(posicao).movimentosPossiveis();

	}

	private void validarPosicao(Posicao posicao) throws TabuleiroException {

		if (!tabuleiro.issoEPeca(posicao)) {
			throw new XadrezException("não existe uma peça nessa posição de origem.");
		}
		if(jogadorAtual!= ((PecaXadrez)tabuleiro.peca(posicao)).getCor()) {
			throw new XadrezException("Cor de peça errada para o turno da jogada.");
		}
		if (tabuleiro.peca(posicao).existeAlgumMovimento() == false) {
			throw new XadrezException("nenhum movimento é possivel.");
		}
	}

	private void validarPosicaoDestino(Posicao inicio, Posicao destino) throws XadrezException, TabuleiroException {
		if (!tabuleiro.peca(inicio).movimentoPossivel(destino)) {
			throw new XadrezException("posição não é alcançavel.");
		}
	}

	public void trocarTurno() {
		turno++;
		if (jogadorAtual == Cor.BRANCO) {
			jogadorAtual = Cor.PRETO;
		}
		else {
		jogadorAtual = Cor.BRANCO;
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
