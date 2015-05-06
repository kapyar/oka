/**
 * Мама попросила Васю полити всі молоді деревця у саду. Вася знає, що поки
 * дерева маленькі, їх потрібно дуже добре поливати. А ось скільки поливати -
 * невідомо. Але Вася - дуже розумний хлопчик. Він уважно прочитав весь
 * підручник ботаніки для середньої школи і вияснив, що полив прямо пропорційний
 * кількості листочків на дереві. Для гарного росту дерев достатньо виливати під
 * дерево щоденно по одному літру води для кожного листка.
 * 
 * На щастя Васі виявилось, що листки на деревах ростуть ярусами, причому на
 * верхньому ярусі два листка, на другому - чотири, на наступному - шість, і так
 * далі, на кожному наступному ярусі на два листки більше у порівнянні з
 * попереднім. А на самій верхушці росте ще один листочок. Хитрий Вася послав
 * молодшу сестричку Машеньку підрахувати кількість ярусів на кожному дереві, а
 * Вас просить написати програму, яка для кожного дерева обрахує кількість
 * літрів води для його поливу.
 * 
 * @author YK
 *
 */

public class Planter {

	private static int[] holder = new int[1001];// index is number of tier
												// values liters starts with 1
												// -first tier
	private int lastCounted;

	public Planter() {
		holder[0] = 1;
		lastCounted = 1;
	}

	public int countLiters(int tier) {

		if (holder[tier] == 0) {
			for (int i = lastCounted; i <= tier; ++i) {
				holder[i] = i * 2 + holder[i - 1];
			}
			lastCounted = tier;

		}
		return holder[tier];

	}

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		Planter t = new Planter();
		System.out.println(t.countLiters(1000));
		System.out.println(t.countLiters(3));
		System.out.println(t.countLiters(2));
		System.out.println(t.countLiters(1));
		long endTime = System.currentTimeMillis();
		System.out.println("Spend time: " + (endTime - startTime) + " ms");
	}
}
