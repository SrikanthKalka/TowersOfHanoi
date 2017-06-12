import java.util.Scanner;

public class TowersOfHanoi {

	public static String hanoi(int noOfDisks, int fromPeg, int toPeg) {

		if (noOfDisks == 1) {

			return " Peg " + fromPeg + " ----> " + toPeg + " Peg  ;";

		} else {

			String sol1, sol2, sol3;

			int helpPeg = 6 - fromPeg - toPeg;

			// step 1: we've to move n-1 disks from peg to help-peg.
			sol1 = hanoi(noOfDisks - 1, fromPeg, helpPeg);

			// step 2: Large desk at from-peg move or return to to-peg tower.
			sol2 = " Peg " + fromPeg + " ----> " + toPeg + " Peg ;";

			// step 3:Again move n-1 desks from help-peg to to-peg;
			sol3 = hanoi(noOfDisks - 1, helpPeg, toPeg);

			// continue until gave desks get moved and return the moves
			return sol1 + sol2 + sol3;
		}
	}

	public static void main(String[] args) {

		System.out.println("Please enter number of disks to solve \n");

		Scanner sc = new Scanner(System.in);
		int noOfDesks = sc.nextInt();
		int stepCount = 1;
		boolean isFirstStep = true;
		String stepsToSolution = hanoi(noOfDesks, 1, 3);

		for (String steps : stepsToSolution.split(";")) {

			if (!isFirstStep)
				stepCount++;
			System.out.println("Step " + stepCount + "  : " + steps);
			isFirstStep = false;
		}

		System.out
				.println("\n Minimum steps to resolve Towers of hanoi for given desks is: "
						+ stepCount);
	}

}
