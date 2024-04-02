package application;

import java.util.Scanner;

import xadrez.PartidaXadrez;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PartidaXadrez x = new PartidaXadrez();
		UI.printTabuleiro(x.getPeças());
		
		
		sc.close();
}

}
