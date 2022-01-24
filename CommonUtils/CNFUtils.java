package CommonUtils;
//Kotsomitopoulos Stavros 3150086

//Antoniou Alexandros 3140248

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import horn.ClauseHorn;
import horn.KB;
import resolution.CNFClause;
import resolution.Literal;
import resolution.SubClause;

/*
 * Contains useful functions to read files
 */
public class CNFUtils {

	private static CNFUtils instance = null;

	private CNFUtils() {
	}

	public static CNFUtils getInstance() {
		if (instance == null) {
			instance = new CNFUtils();
		}
		return instance;
	}

	/**
	 * Read CNF Clauses from a file
	 */
	public CNFClause readCNFClauses(File file) {
		List<SubClause> subClauses = new ArrayList<SubClause>();
		Set<Literal> literals = new HashSet<Literal>();

		CNFClause clause = new CNFClause();

		try {

			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			int cl = 0;
			String line = reader.readLine();

			while (line != null) {
				line = line.trim();

				int counter = 0;
				int k = 0;

				while (counter < line.length()) {
					if (line.charAt(counter) == '-') {
						counter++;

						k = counter;

						while (counter < line.length() && line.charAt(counter) != ' ') {
							counter++;
						}

						if (counter == line.length() - 1) {
							literals.add(new Literal(line.substring(k, counter + 1), true));
						} else {
							literals.add(new Literal(line.substring(k, counter), true));
						}

						k = counter + 1;
					} else if (line.charAt(counter) == ' ' || counter == line.length() - 1) {
						if (counter == line.length() - 1) {
							literals.add(new Literal(line.substring(k, counter + 1), false));
						} else {
							literals.add(new Literal(line.substring(k, counter), false));
						}

						k = counter + 1;
					}

					counter++;
				}

				subClauses.add(new SubClause());

				for (Literal literal : literals) {
					subClauses.get(cl).getLiterals().add(literal);
				}

				literals.clear();
				cl++;

				line = reader.readLine();
			}

			for (SubClause SubClause : subClauses) {
				clause.getSubclauses().add(SubClause);
			}

			reader.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			System.err.println("Error occured.");
			System.exit(0);
		}

		return clause;
	}

	/**
	 * Read CNF Horn Clauses from a file
	 */
	public KB readCNFHornClauses(File file) {
		KB kb = null;
		List<String> facts = new ArrayList<String>();
		List<ClauseHorn> clauses = new ArrayList<ClauseHorn>();

		try {

			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			int i = 0;
			String line = reader.readLine();

			while (line != null) {
				ClauseHorn cl = new ClauseHorn();

				if (line.length() == 1) {
					facts.add(String.valueOf(line.charAt(0)));
				} else if (line.length() == 2) {
					facts.add(String.valueOf(line.charAt(1)));
				} else {
					i = 0;

					while (i <= line.length() - 1) {
						// and
						if (line.charAt(i) == ' ') {
							if (i >= 2) {
								cl.add(String.valueOf(line.charAt(i - 2)));
							} else {
								cl.add(String.valueOf(line.charAt(i - 1)));
							}
						} else if (line.charAt(i) == '=') {
							cl.add(String.valueOf(line.charAt(i - 1)));

							i++;

							cl.add(String.valueOf(line.charAt(i + 1)));
						}

						i++;
					}

					clauses.add(cl);
				}

				line = reader.readLine();
			}

			kb = new KB(clauses, facts);

			reader.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			System.err.println("Error occured.");
			System.exit(0);
		}

		return kb;
	}

}
