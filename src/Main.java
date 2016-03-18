import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Main {

	Scanner sc = new Scanner(System.in);

	void displayMenu() {
		System.out.println("RAP BATTLE");
		System.out.println();
		System.out.println("1. Single Player");
		System.out.println("2. Multiplayer");
	}

	void setupRappers(Rapper[] rappers) {
		rappers[0] = new Rapper("Can't-ye East", 50);
		rappers[1] = new Rapper("Noop Dog", 60);
		rappers[2] = new Rapper("Lil' Dwayne", 70);
		rappers[3] = new Rapper("Dr. Andre", 80);
		rappers[4] = new Rapper("M and M", 90);
		rappers[5] = new Rapper("Supa Hot Fire", 95);
	}

	void setupDisses(Dis[] disses) {
		disses[0] = new Dis("Your mum", 5);
		disses[1] = new Dis("Name caller", 20);
		disses[2] = new Dis("Tease", 30);
		disses[3] = new Dis("Ender", 1000);

	}

	void yourMumDis(Rapper[] rappers, Dis[] disses, int rappersBeaten) {
		Random r = new Random();
		int hypeGained = r.nextInt(5);

		System.out.println("You rapped about his mum");
		System.out.println("You gained " + hypeGained + "% of the crowd hype");

		rappers[rappersBeaten].hypePoints -= hypeGained;

		AITurn(rappers, disses, rappersBeaten);
	}

	void callName(Rapper[] rappers, Dis[] disses, int rappersBeaten) {
		Random r = new Random();
		String adjective;
		String noun;
		int count;
		count = r.nextInt(10) + 1;

		try {
			BufferedReader adj = new BufferedReader(new FileReader(
					"adjectives.txt"));
			BufferedReader nou = new BufferedReader(new FileReader("nouns.txt"));

			for (int i = 0; i < count; i++) {
				adjective = adj.readLine();

				if (i == count - 1) {
					System.out.print("You called him a " + adjective + " ");
				}

			}

			count = r.nextInt(10) + 1;

			for (int i = 0; i < count; i++) {
				noun = nou.readLine();

				if (i == count - 1) {
					System.out.println(noun);
				}

			}
			adj.close();
			nou.close();

			int hypeGained = r.nextInt(21) + 10;

			System.out.println("You gained " + hypeGained
					+ "% of the crowd hype");

			rappers[rappersBeaten].hypePoints -= hypeGained;
			
			AITurn(rappers, disses, rappersBeaten);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	void teaseDis(Rapper[] rappers, Dis[] disses, int rappersBeaten) {

		
		AITurn(rappers, disses, rappersBeaten);
	}

	void getMenuChoice(int choice, Rapper[] rappers, Dis[] disses) {
		int rappersBeaten = 0;
		choice = sc.nextInt();

		switch (choice) {
		case 1:
			singleplayer(rappers, disses, rappersBeaten);
			break;
		case 2:
			multiplayer();
			break;
		}
	}

	void singleplayer(Rapper[] rappers, Dis[] disses, int rappersBeaten) {
		boolean beaten = false;
		boolean won;

			System.out.println("You have been challenged by "
					+ rappers[rappersBeaten].name);
			System.out.println("He has " + rappers[rappersBeaten].hypePoints
					+ "% of the crowd's hype");
			System.out.println("Dis him up to get 100% of the hype");

			won = false;

			checkIfWon(rappers, disses, rappersBeaten, won, beaten);
		
	}
	
	void checkIfWon(Rapper[] rappers, Dis[] disses, int rappersBeaten, boolean won, boolean beaten) {
		while (rappers[rappersBeaten].hypePoints > 0 && !won) {
			playGameSP(rappers, disses, rappersBeaten);

			if (rappers[rappersBeaten].hypePoints <= 0) {
				System.out.println();
				System.out.print("You beat "
						+ rappers[rappersBeaten].name + "!");
				System.out.println();
				System.out.println();
				System.out.println();
				
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				rappersBeaten++;
				won = true;
				singleplayer(rappers, disses, rappersBeaten);
			}

			if (beaten) {
				System.out.println("GAME OVER");
			}

		}
	}

	void multiplayer() {

	}

	void playGameSP(Rapper[] rappers, Dis[] disses, int rappersBeaten) {
		int choice = 0;

		System.out.println("Your hype: "
				+ (100 - rappers[rappersBeaten].hypePoints) + "%");
		System.out.println(rappers[rappersBeaten].name + "'s hype: "
				+ rappers[rappersBeaten].hypePoints + "%");
		System.out.println();
		System.out.println("What would you like to dis your opponent with?");
		System.out.println();
		System.out.println("1. Your mum dis");
		System.out.println("2. Name calling dis");
		System.out.println("3. Teasing dis");

		if (sc.hasNextInt()) {
			choice = sc.nextInt();
		} else {
			System.out.println("Okay then..");
		}
		switch (choice) {
		case 1:
			yourMumDis(rappers, disses, rappersBeaten);
			break;
		case 2:
			callName(rappers, disses, rappersBeaten);
			break;
		case 3:
			teaseDis(rappers, disses, rappersBeaten);
			break;
		}

	}

	void AITurn(Rapper[] rappers, Dis[] disses, int rappersBeaten) {
		
	}
	
	public Main() {
		Rapper[] rappers = new Rapper[6];
		Dis[] disses = new Dis[4];
		setupRappers(rappers);
		displayMenu();
		int choice = 0;
		getMenuChoice(choice, rappers, disses);

	}

	public static void main(String[] args) throws IOException {
		new Main();
	}

}
