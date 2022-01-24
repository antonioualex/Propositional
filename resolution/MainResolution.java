package resolution;
//Kotsomitopoulos Stavros 3150086

//Antoniou Alexandros 3140248

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import CommonUtils.CNFUtils;

public class MainResolution {
	public static void main(String[] args) {

		try {
			File kbFile = new File("KnowledgeBaseRes.txt");
			File clauseRefFile = new File("clauseRef.txt");

			if (kbFile == null || clauseRefFile == null || !kbFile.exists() || !clauseRefFile.exists()) {
				System.out.println("File not found");
				System.exit(0);
			}

			CNFClause kb = CNFUtils.getInstance().readCNFClauses(kbFile);
			CNFClause clauseRef = CNFUtils.getInstance().readCNFClauses(clauseRefFile);

			boolean b = PL_Resolution(kb, clauseRef);

			System.out.println("The refusal of :");
			clauseRef.print();
			System.out.println("is " + b + ".");

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	// The resolution algorithm
	public static boolean PL_Resolution(CNFClause KB, CNFClause clauseRef) {
		// We create a CNFClause that contains all the clauses of our Knowledge
		// Base
		CNFClause clauses = new CNFClause();
		clauses.getSubclauses().addAll(KB.getSubclauses());
		clauses.getSubclauses().addAll(clauseRef.getSubclauses());

		boolean stop = false;

		// We will try resolution till either we reach a contradiction or cannot
		// produce any new clauses
		while (!stop) {
			List<SubClause> newsubclauses = new ArrayList<SubClause>();
			List<SubClause> subclauses = clauses.getSubclauses();

			// For every pair of clauses Ci, Cj...
			for (int i = 0; i < subclauses.size(); i++) {
				SubClause Ci = subclauses.get(i);

				for (int j = i + 1; j < subclauses.size(); j++) {
					SubClause Cj = subclauses.get(j);

					// ...we try to apply resolution and we collect any new
					// clauses
					List<SubClause> new_subclauses_for_ci_cj = SubClause.resolution(Ci, Cj);

					// We check the new subclauses...
					for (int k = 0; k < new_subclauses_for_ci_cj.size(); k++) {
						SubClause newsubclause = new_subclauses_for_ci_cj.get(k);

						// ...and if an empty subclause has been generated we
						// have reached contradiction; and the literal has been
						// proved
						if (newsubclause.isEmpty()) {
							return true;
						}

						// All clauses produced that don't exist already are
						// added
						if (!newsubclauses.contains(newsubclause) && !clauses.contains(newsubclause)) {
							newsubclauses.add(newsubclause);
						}
					}
				}
			}

			boolean newClauseFound = false;

			// Check if any new clauses were produced in this loop
			for (int i = 0; i < newsubclauses.size(); i++) {
				if (!clauses.contains(newsubclauses.get(i))) {
					clauses.getSubclauses().addAll(newsubclauses);
					newClauseFound = true;
				}
			}

			// If not then Knowledge Base does not logically infer the literal
			// we wanted to prove
			if (!newClauseFound) {
				stop = true;
			}
		}
		return false;
	}
}
