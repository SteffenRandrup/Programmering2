public class AddressBookTest {
	public static void main(String[] args) {
		AddressBookDemoText text = new AddressBookDemoText();
		AddressBookDemoGUI gui = new AddressBookDemoGUI();

		if (args.length > 0) {
			if (args[0].equals("gui")) {
				gui.showInterface();
			} else if (args[0].equals("-h")) {
				System.out.println("For graphical interface parse gui");
				System.out.println("For text based interface use no parameters");
			} else {
				System.out.println("Invalid parameter");
				System.out.println("for a list of commands use -h");
			}
		} else {
			text.showInterface();
		}
	}
}
