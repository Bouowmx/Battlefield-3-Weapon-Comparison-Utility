import java.math.BigDecimal;

public class Round {
	public static Number removeTrailingZero(double number) { //For numbers with one significant digit after the decimal
		String s = String.valueOf(number);
		if ((s.substring(s.indexOf('.') + 1, s.length()).length() == 1) && (s.charAt(s.indexOf('.') + 1) == '0')) {return (long) number;}
		else {return number;}
	}
	
	public static Number removeTrailingZeros(double number) {
		String s = String.valueOf(number);
		boolean trailingZeros = true;
		while (trailingZeros) {
			if (s.charAt(s.length() - 1) != '0') {trailingZeros = false;}
			else {
				if (s.charAt(s.length() - 2) == '.') {
					s = s.substring(0, s.length() - 2);
					trailingZeros = false;
				}
				else {s = s.substring(0, s.length() - 1);}
			}
		}
		if (s.indexOf('.') == -1) {return Long.valueOf(s);}
		else {return Double.valueOf(s);}
	}
	
	public static double round(double number, int places) { //Java needs Python's round(number, places) method. Seriously.
		if (places < 0) {throw new IllegalArgumentException("Places must be greater than or equal to 0.");}
		
		BigDecimal bd = new BigDecimal(number);
		bd = bd.setScale(places, BigDecimal.ROUND_HALF_UP);
		return bd.doubleValue();
	}
	
	public static Number roundToOnePlaceAndRemoveTrailingZero(double number) {return removeTrailingZero(round(number, 1));}
}
