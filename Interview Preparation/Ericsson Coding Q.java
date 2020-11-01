public class Ericsson {
	private static final String L = "L", NEW_LINE_L = "\n" + L;
	private static final char NEW_LINE = '\n';

	public String drawL(int N) {
		return L.repeat(Math.max(0, N)) + NEW_LINE_L.repeat(Math.max(0, N - 1));
	}

	public String drawChar(int N, char charToPrint) {
		String newLinePrinter = new String(new char[]{NEW_LINE, charToPrint});
		return String.valueOf(charToPrint).repeat(Math.max(0, N)) + newLinePrinter.repeat(Math.max(0, N - 1));
	}

	private static final String[] NUMBERS = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

	public int sum(int numInt, String numString) {
		int sum = 0;
		for (int i = 0; i < NUMBERS.length; i++)
			if (NUMBERS[i].equalsIgnoreCase(numString)) sum = numInt * (i + 1);
		return sum;
	}

	private static final String[] DAYS = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

	public String getDay(final String day, final int num) {
		for (int i = 0; i < DAYS.length; i++)
			if (DAYS[i].equalsIgnoreCase(day)) return DAYS[(i + num) % 7];
		return day;
	}

	public String buildPositiveAndNegativeLine(final int length) {
		StringBuilder sb = new StringBuilder();
		sb.append("+-".repeat(Math.max(0, length / 2)));
		if (length % 2 == 1) sb.append('+');
		return sb.toString();
	}

	public int maximumNumber(int number, int replacer) {
		int max = number;
		String base = Integer.toString(number);
		char replacerChar = (char) (replacer + '0');
		for (int i = 0; i < base.length(); i++) {
			if (base.charAt(i) >= replacerChar) continue;
			int newNumber = getNewNumber(base, replacerChar, i);
			if (newNumber > max) max = newNumber;
		}
		return max;
	}

	//  Helper for maximumNumber
	private int getNewNumber(String base, char replacerChar, int i) {
		StringBuilder newNumberStr = new StringBuilder(base);
		newNumberStr.setCharAt(i, replacerChar);
		return Integer.parseInt(newNumberStr.toString());
	}

	public static void main(String... args) {
		System.out.println(new Ericsson().drawChar(5, 'L'));
		System.out.println(new Ericsson().drawL(2));
		System.out.println(new Ericsson().sum(5, "two"));
		System.out.println(new Ericsson().getDay("tuesday", 21));
		System.out.println(new Ericsson().maximumNumber(7263, 4));
		System.out.println(new Ericsson().maximumNumber(7263, 8));
		System.out.println(new Ericsson().buildPositiveAndNegativeLine(7));
	}
}
