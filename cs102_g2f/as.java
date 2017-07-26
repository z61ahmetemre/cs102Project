package cs102_g2f;

public class as {

	public static void main(String[] args) {
	String a,b;
	a="PD 1123.B4 1980";
	b="PE 1126.G74 1990";
	
	
	
	AlphanumericComparator c = new AlphanumericComparator();
	System.out.println(c.compare(a, b));
	
	
	
	}

}
