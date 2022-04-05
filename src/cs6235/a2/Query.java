package cs6235.a2;

public class Query {
	private String lhs;
	private String rhs;
	public String getLhs() {
		return lhs;
	}
	public String getRhs() {
		return rhs;
	}
	
	public Query(String lhs, String rhs) {
		this.lhs = lhs;
		this.rhs = rhs;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(lhs).append(" MHP ").append(rhs).append(" ?");
		return sb.toString();
	}
}
