package horn;
//Kotsomitopoulos Stavros 3150086

//Antoniou Alexandros 3140248

import java.io.File;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;
import CommonUtils.CNFUtils;

public class MainHorn {
	public static void main(String[] args) {

		try {
			File kbhFile = new File("KnowledgeBaseHorn.txt");

			if (kbhFile == null || !kbhFile.exists()) {
				System.out.println("File not found");
				System.exit(0);
			}

			while (true) {

				Scanner scanner = new Scanner(System.in);

				System.out.print("Write a symbol or \"q!\" to quit: ");

				String symbol = scanner.nextLine();

				if (symbol.equals("q!"))
					break;

				KB kb = CNFUtils.getInstance().readCNFHornClauses(kbhFile);

				boolean b = HornAlgorithm(kb, symbol);

				System.out.println(symbol + " is " + b + ".");
				System.out.println();
			}
			System.out.println("Terminated successfully.");
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public static boolean HornAlgorithm(KB KB, String q) {
		List<String> symbols = KB.getSymbols(); // symbols of kb
		List<String> agenta = KB.getFacts();
		List<ClauseHorn> clauses = KB.getClauses(); // clauses of kb

		List<Boolean> inferred = new Vector<Boolean>();
		for (String s : symbols) {
			inferred.add(false);
		}

		Vector<Integer> count = new Vector<Integer>();
		for (ClauseHorn clause : clauses) {
			count.addElement(clause.getSymbols().size());
		}

		String p;
		while (agenta.size() != 0) {
			p = agenta.remove(agenta.size() - 1);

			if (p.equals(q))
				return true;

			int c = 0;
			for (int i = 0; i < symbols.size(); i++) {
				if (symbols.get(i).equals(p)) {
					c = i;
					break;
				}
			}

			if (!inferred.get(c)) {
				inferred.set(c, true);

				for (int i = 0; i < clauses.size(); i++) {
					if (clauses.get(i).contains(p)) {
						count.set(i, count.get(i) - 1);

						if (count.get(i) == 1) {
							agenta.add(clauses.get(i).getSymbols().get(clauses.get(i).getSymbols().size() - 1));
						}
					}
				}
			}

		}

		return false;
	}
}
