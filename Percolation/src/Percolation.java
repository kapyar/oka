public class Percolation extends QuickFindUF {

	private int count;
	private int size;
	private boolean[] opened;
	private int virtualTop;
	private int virtualBottom;

	public Percolation(int n) {
		// create matrix nxn
		super(n * n + 2);// add 2 virtual bottom and top

		size = n;
		int dim = n * n;
		virtualTop = dim;
		virtualBottom = dim + 1;
		opened = new boolean[dim];

	}

	// створюємо матрицю N-на-N, з усіма заблокованими об’єктами
	public int getOpenedCount() {
		return count;
	}

	// рахуємо і повертаємо кількість відкритих комірок
	// i - рядок j- стовпчик
	public void open(int i, int j) {
		int elem = getPossitionInArray(i, j);
		if (!opened[elem]) {
			opened[elem] = true;
			count++;
			// check if top righ...opened also union into one component
			int above = -1;
			int bottom = -1;
			int left = -1;
			int right = -1;
			if (i != 1) {// if not first row
				above = (i - 2) * size + j - 1;
				connect(elem, above);
			} else {
				union(elem, virtualTop);
			}
			if (i != size) {// has bottom
				bottom = i * size + j - 1;
				connect(elem, bottom);
			} else {
				union(elem, virtualBottom);
			}
			if (j != 1) {// has left
				left = (i - 1) * size + j - 2;
				connect(elem, left);
			}
			if (j != size) {// has righ
				right = (i - 1) * size + j;
				connect(elem, right);
			}

		}

	}

	// відкрити об’єкт (row i, column j) якщо він ще не відкритий
	public boolean isOpened(int i, int j) {

		return opened[getPossitionInArray(i, j)];
	}

	// чи відкитий об’єкт (row i, column j)?
	public boolean percolates() {
		return connected(virtualTop, virtualBottom);
	}

	// чи протікає система?

	private int getPossitionInArray(int row, int column) {
		return (row - 1) * size + column - 1;
	}

	private void connect(int i, int j) {
		if (j != -1 && opened[j] == true) {
			union(i, j);
		}
	}
}
