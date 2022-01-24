package horn;
//Kotsomitopoulos Stavros 3150086

//Antoniou Alexandros 3140248

import java.util.List;
import java.util.ArrayList;

public class KB {
	private List<ClauseHorn> clauses = new ArrayList<ClauseHorn>();
	private List<String> facts = new ArrayList<String>();

	public KB(List<ClauseHorn> clauses, List<String> facts) {
		this.clauses = clauses;
		this.facts = facts;
	}

	public void setClauses(List<ClauseHorn> clauses) {
		this.clauses = clauses;
	}

	public void setFacts(List<String> facts) {
		this.facts = facts;
	}

	public List<ClauseHorn> getClauses() {
		return clauses;
	}

	public List<String> getFacts() {
		return facts;
	}

	@Override
	public String toString() {
		return "KnowledgeBase [clauses=" + clauses + ", facts=" + facts + "]";
	}

	public List<String> getSymbols() {
		List<String> symbols = new ArrayList<String>();

		for (String fact : facts)
			symbols.add(fact);

		for (ClauseHorn clause : clauses) {
			for (String symbol : clause.getSymbols()) {
				boolean found = false;
				for (int i = 0; i < symbols.size(); i++) {
					if (symbols.get(i).equals(symbol)) {
						found = true;
					}
				}
				if (!found)
					symbols.add(symbol);
			}
		}

		return symbols;
	}

}
