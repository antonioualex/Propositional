package resolution;
//Kotsomitopoulos Stavros 3150086

//Antoniou Alexandros 3140248

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubClause {
	// The literals contained in the clause
	private Set<Literal> literals;

	public SubClause() {
		literals = new HashSet<Literal>();
	}

	public Set<Literal> getLiterals() {
		return literals;
	}

	public boolean isEmpty() {
		return literals.isEmpty();
	}

	public void print() {
		System.out.println("*************************");

		for (Literal l : getLiterals())
			l.print();

		System.out.println("*************************\n");
	}

	/*
	 * Applies resolution on two CNFSubClauses The resulting clause will contain
	 * all the literals of both CNFSubclauses except the pair of literals that
	 * are a negation of each other.
	 */
	public static List<SubClause> resolution(SubClause CNF_SC_1, SubClause CNF_SC_2) {
		List<SubClause> newClauses = new ArrayList<SubClause>();

		// The iterator goes through all Literals of the first clause
		for (Literal l : CNF_SC_1.getLiterals()) {
			Literal m = new Literal(l.getName(), !l.getNeg());

			// If the second clause contains the negation of a Literal in the
			// first clause
			if (CNF_SC_2.getLiterals().contains(m)) {
				// We construct a new clause that contains all the literals of
				// both CNFSubclauses...
				SubClause newClause = new SubClause();

				// ...except the pair the literals that were a negation of one
				// another
				Set<Literal> CNF_SC_1_Lits = new HashSet<Literal>(CNF_SC_1.getLiterals());
				Set<Literal> CNF_SC_2_Lits = new HashSet<Literal>(CNF_SC_2.getLiterals());
				CNF_SC_1_Lits.remove(l);
				CNF_SC_2_Lits.remove(m);

				// Normally we have to remove duplicates of the same literal;
				// the new clause must not contain the same literal more than
				// once
				// But since we use HashSet only one copy of a literal will be
				// contained anyway

				newClause.getLiterals().addAll(CNF_SC_1_Lits);
				newClause.getLiterals().addAll(CNF_SC_2_Lits);

				newClauses.add(newClause);
			}
		} // The loop runs for all literals, producing a different new clause
			// for each different pair of literals that negate each other

		return newClauses;
	}

	@Override
	public boolean equals(Object obj) {
		SubClause l = (SubClause) obj;

		if (l.getLiterals().size() != this.getLiterals().size())
			return false;

		for (Literal lit : l.getLiterals()) {
			if (!this.getLiterals().contains(lit))
				return false;
		}

		return true;
	}

	@Override
	public int hashCode() {

		int code = 0;

		for (Literal lit : getLiterals()) {
			code = code + lit.hashCode();
		}

		return code;
	}

}
