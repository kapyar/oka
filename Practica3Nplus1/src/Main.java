import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;

import java.io.FileOutputStream;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	class Generator {

		private short holder[] = new short[3000000];

		public int generator(int n, int m) {

			while (n <= m) {
				short counterSteps = 0;
				int temp = n;

				while (true) {

					++counterSteps;// how many steps we already done

					if (counterSteps > holder[temp]) {
						holder[temp] = counterSteps;
						if (temp == 1)
							break;

						if (temp % 2 == 1) {
							temp = 3 * temp + 1;
						} else {
							temp /= 2;
						}
					} else {
						break;
					}

				}

				n++;
			}

			return holder[1];
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(
				new FileInputStream(new File("input.txt"))));

		String line = null;
		line = br.readLine();
		String[] numbers = line.split(" ");

		br.close();

		int first = Integer.valueOf(numbers[0]);
		int second = Integer.valueOf(numbers[1]);
		Main m = new Main();
		Main.Generator g = m.new Generator();
		int result = g.generator(first, second);

		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream(new File("output.txt"))));
		writer.write(String.valueOf(first) + ' ' + String.valueOf(second) + ' '
				+ String.valueOf(result));

		writer.close();

	}
}