package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import boardgame.TabuleiroException;
import xadrez.PartidaXadrez;
import xadrez.PecaXadrez;
import xadrez.PosicaoXadrez;
import xadrez.XadrezException;

public class Program {

	public static void main(String[] args) throws TabuleiroException {
		Scanner sc = new Scanner(System.in);
		PartidaXadrez x = new PartidaXadrez();

		while (true) {
			try {
				UI.clearScreen();
				UI.printTabuleiro(x.getPeças());

				System.out.print("Origem: ");
				PosicaoXadrez i = UI.lerPosicaoXadrez(sc);
				System.out.println();
				System.out.print("Destino: ");
				PosicaoXadrez d = UI.lerPosicaoXadrez(sc);
				sc.nextLine();
				@SuppressWarnings("unused")
				PecaXadrez pecaCapturada = x.fazerMovimentoXadrez(i, d);
			} catch (XadrezException e) {
				System.out.println(e.getMessage());
				sc.nextLine();}
				catch (InputMismatchException e) {
					System.out.println(e.getMessage());
					sc.nextLine();
			}

		}

	}

}
