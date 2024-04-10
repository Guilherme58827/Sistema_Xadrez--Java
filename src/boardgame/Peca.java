package boardgame;

public abstract class  Peca {
	protected Posicao posicao;
	private Tabuleiro tabuleiro;
	
	public Peca(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
		posicao =null;
	}

	protected Tabuleiro getTabuleiro() {
		return tabuleiro;
	}
	public abstract boolean[][] movimentosPossiveis() throws TabuleiroException;
	
	public boolean movimentoPossivel(Posicao posicao) throws TabuleiroException {
		return movimentosPossiveis()[posicao.getLinha()][posicao.getColuna()];
		
	}
	public boolean existeAlgumMovimento() throws TabuleiroException {
		boolean[][] mat  = movimentosPossiveis();
		for(int i=0; i< mat.length;i++) {
			for(int j=0; j<mat.length;j++) {
				if(mat[i][j] == true) {
					return true;
				}
				
			}
			
		}
		return false;
	}
		
	

	
	

	

}
