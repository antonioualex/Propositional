package resolution;
// Kotsomitopoulos Stavros 3150086

// Antoniou Alexandros 3140248

import java.util.ArrayList;
import java.util.List;

/*
 * A CNFClause consists of a conjunction of CNFSubClauses
 * And each CNFSubClause in turn consists of a disjunction of Literals
 */
public class CNFClause {
	public List<SubClause> theClauses = new ArrayList<SubClause>();
	public int numberOfClauses;

	public int getNumberOfClauses() {
		return numberOfClauses;
	}

	public void setNumberOfClauses(int numberOfClauses) {
		this.numberOfClauses = numberOfClauses;
	}

	public List<SubClause> getSubclauses() {
		return theClauses;
	}

	public boolean contains(SubClause newS) {
		for (SubClause subClause : theClauses)
			if (subClause.getLiterals().equals(newS.getLiterals()))
				return true;

		return false;
	}

	public void print() {
		for (SubClause subClause : theClauses) {
			subClause.print();
		}
	}
}
