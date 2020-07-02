package dataBaseA;

public class MainRunner {

	public static void main(String[] args) {
		MainRunner myRunner = new MainRunner();
		myRunner.run(args);

	}

	private void run(String[] args) {
		new LoginFrame();
		DBConnection.getInstance();
	}

}
