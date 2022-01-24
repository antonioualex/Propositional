package resolution;
//Kotsomitopoulos Stavros 3150086

//Antoniou Alexandros 3140248

import java.util.Objects;

/*
 * Represents a literal; a variable
 */

public class Literal implements Comparable<Literal> {
	// The name of the literal
	private String name;
	// Whether or not the literal is negated; if negation is true then it is
	// negated
	private boolean negation;

	public Literal(String n, boolean neg) {
		this.name = n;
		this.negation = neg;
	}

	public void print() {
		if (negation)
			System.out.println("NOT_" + name);
		else
			System.out.println(name);
	}

	public void setName(String n) {
		this.name = n;
	}

	public String getName() {
		return this.name;
	}

	public void setNeg(boolean b) {
		this.negation = b;
	}

	public boolean getNeg() {
		return this.negation;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, negation);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (obj == null)
			return false;

		if (getClass() != obj.getClass())
			return false;

		Literal other = (Literal) obj;

		if (name == null) {
			if (other.name != null)
				return false;

		} else if (!name.equals(other.name))
			return false;

		if (negation != other.negation)
			return false;

		return true;
	}

	@Override
	public int compareTo(Literal x) {
		int a = 0;
		int b = 0;

		if (x.getNeg())
			a = 1;

		if (this.getNeg())
			b = 1;

		return x.getName().compareTo(name) + a - b;
	}
}
