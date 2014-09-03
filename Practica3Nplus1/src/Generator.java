public class Generator {

	private int holder[] = new int[10000];

	/*
	 * 1. input n 2. print n 3. if n = 1 then STOP 4. if n is odd then n = 3 * n
	 * + 1 5. else n = n / 2 6. GOTO 2
	 */

	public int generator(int n, int m) {

		while (n <= m) {
			int counterSteps = 0;
			int temp = n;
			// System.out.print("Number: " + temp + " [");
			boolean flag = false;
			while (!flag) {
				++counterSteps;// how many steps we already done
				if (temp % 2 == 1) {
					if (holder[temp] == 0) {
						holder[temp] = counterSteps;
						if (temp == 1) {
							flag = true;
							break;
						}
					} else if (counterSteps > holder[temp]) {
						holder[temp] = counterSteps;
						if (temp == 1)
							break;
					} else {
						break;
					}
					temp = 3 * temp + 1;
				} else {
					if (holder[temp] == 0) {
						holder[temp] = counterSteps;
						if (temp == 1) {
							flag = true;
							break;
						}
					} else if (counterSteps > holder[temp]) {
						holder[temp] = counterSteps;
						if (temp == 1) {
							flag = true;
							break;
						}

					} else {
						break;
					}

					temp /= 2;
				}
				// System.out.print(temp + ", ");
			}
			// System.out.println("]\n");
			n++;// increase left bound
		}
		return holder[1];
	}

	public void printAlgo(int temp) {
		System.out.print("Number: " + temp + "[ ");
		int i = 1;
		while (temp != 1) {
			++i;
			if (temp % 2 == 1) {
				temp = 3 * temp + 1;
			} else {
				temp /= 2;
			}
			System.out.print(temp + ", ");
		}
		System.out.println(" ]: " + i);
	}
}
