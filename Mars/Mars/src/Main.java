/**
 * Якось нарешті жителі планети Земля знайшли заселену планету, назвали її ТТВ,
 * і відправили разом з кораблем туди одного кролика. Кролику сподобався клімат
 * нової планети і через місяць він народив на світ ще одного кролика. Відомо,
 * що кожен місяц кожен кролик, який був присутніс на планеті, відтворював на
 * світ ще одного кролика. На планеті звідкілясь завіся монстр, який на початку
 * місяця з'їдав k кроликів, як тільки їх ставало строго більше k. У задачі
 * необхідно визначити кількість кроликів, яка буде на планеті через n місяців
 * після прибуття на неї космічного корабля з першим кроликом.
 * 
 * 
 * Технічні умови Вхідні дані
 * 
 * Перший рядок містить кількість місяців n (0 ≤ n ≤ 100), другий - число
 * кроликів k (0 ≤ k ≤ 10000), яких з'їдав монстр.
 * 
 * Вихідні дані
 * 
 * Визначіть кількість кроликів, які будуть знаходитись на планеті ТТВ через n
 * місяців після поселення на неї першого кролика. Відомо, що результат для
 * довільного тесту завжди не перевищує 2*109.
 * 
 * @author 123ka_000
 *
 */
public class Main {

	private static int rabitsStart;
	private static int amountRabit = 1;;

	public static void doCount(int month, int eatenRabbints) {

		for (int i = 0; i < month; ++i) {
			if (amountRabit > eatenRabbints) {
				amountRabit -= eatenRabbints;
			} else {
				amountRabit += amountRabit;
			}
		}
		System.out.println("Amount of rabbits is: " + amountRabit + " in "
				+ month + " months");

	}

	public static void main(String[] args) {
		doCount(0, 10);
		doCount(1, 10);
		doCount(5, 10);

	}

}
