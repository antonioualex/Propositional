package horn;
//Kotsomitopoulos Stavros 3150086

//Antoniou Alexandros 3140248

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ClauseHorn {
	private List<String> symbols = new ArrayList<String>(10);

	public void add(String s) {
		symbols.add(s);
	}

	public List<String> getSymbols() {
		return symbols;
	}

	public boolean contains(String symbol) {
		for (int i = 0; i < symbols.size(); i++) {
			if (symbols.get(i).equals(symbol)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "HornClause [symbols=" + symbols + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(symbols);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClauseHorn other = (ClauseHorn) obj;
		if (symbols == null) {
			if (other.symbols != null)
				return false;
		} else if (!symbols.equals(other.symbols))
			return false;
		return true;
	}

}
