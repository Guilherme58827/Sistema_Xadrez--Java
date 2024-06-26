package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import boardgame.TabuleiroException;
import xadrez.Cor;
import xadrez.PartidaXadrez;
import xadrez.PecaXadrez;
import xadrez.PosicaoXadrez;
import xadrez.XadrezException;

public class UI {
	// https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
	public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
	public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
	public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

	public static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
		
	}

	public static PosicaoXadrez lerPosicaoXadrez(Scanner sc) throws XadrezException {
		try {

			String s = sc.nextLine().trim();
			char coluna = s.charAt(0);
			int linha = Integer.parseInt(s.substring(1));
			return new PosicaoXadrez(coluna, linha);
		} catch (RuntimeException e) {
			throw new InputMismatchException("erro ao ler os dados: valor aceitavel de a1 até h8");
		}
	}
	
	public static void printPartida(PartidaXadrez partidaXadrez) throws TabuleiroException {
		printTabuleiro(partidaXadrez.getPeças());
		System.out.println();
		System.out.println("turno: " + partidaXadrez.getTurno());
		System.out.println("Jogada do jogador " + partidaXadrez.getJogadorAtual());
		
	}

	public static void printTabuleiro(PecaXadrez[][] peças) {
		for (int i = 0; i < peças.length; i++) {
			System.out.print((8 - i) + " ");
			for (int j = 0; j < peças.length; j++) {
				printPeça(peças[i][j], false);

			}
			System.out.println();
		}
		System.out.println("  a b c d e f g h");
	}
	public static void printTabuleiro(PecaXadrez[][] peças, boolean [][] movPossiveis) {
		for (int i = 0; i < peças.length; i++) {
			System.out.print((8 - i) + " ");
			for (int j = 0; j < peças.length; j++) {
				printPeça(peças[i][j], movPossiveis[i][j]==true);

			}
			System.out.println();
		}
		System.out.println("  a b c d e f g h");
	}

	private static void printPeça(PecaXadrez peça, boolean corDeFundo) {
		if(corDeFundo== true) {
			System.out.print( ANSI_GREEN_BACKGROUND );
		}
		if (peça == null) {
			System.out.print("-" + ANSI_RESET);
		} else {
			if (peça.getCor() == Cor.BRANCO) {
				System.out.print(ANSI_WHITE + peça + ANSI_RESET);
			} else {
				System.out.print(ANSI_YELLOW + peça + ANSI_RESET);
			}
		}
		System.out.print(" ");
	}
}
