package application;

import java.util.Scanner;

import boardgame.TabuleiroException;
import xadrez.PartidaXadrez;

public class Program {

	public static void main(String[] args) throws TabuleiroException {
		Scanner sc = new Scanner(System.in);
		PartidaXadrez x = new PartidaXadrez();
		UI.printTabuleiro(x.getPeças());
		
		
		sc.close();
}

}
