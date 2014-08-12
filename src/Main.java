import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		print(spiralSquareNumber(11));
	}
	
	/**
	 * 
	 * @param nc It is the number of columns in the 
	 * @return
	 */

	private static int[][] spiralSquareNumber(int nc) {
		if (nc == 0) {
			return null;
		}
		int nr = nc;
		int squareNumber = nc*nc;
		int[][] a = new int[nr][nc];
		for (int i = 0; i < nr; i++) {
			Arrays.fill(a[i], -1);
		}
		int prevC = 0, prevR = 0, currentC = 0, currentR = 0, currentV = 1;
		int diff = 0;

		
		for (int i = 0; true; i++) {
			prevC = currentC;
			prevR = currentR;
			currentC = nc - i - 1;
			currentR = i;
			diff = Math.abs(currentR - prevR) + Math.abs(currentC - prevC);
			currentV += diff;
			if (currentV >= squareNumber) {
				if (a[currentR][currentC] <= 0) {
					a[currentR][currentC] = currentV;
				} 
				break;
			}
			for (int j = 0; j <= currentC; j++) {
				if (a[currentR][currentC - j] <= 0) {
					a[currentR][currentC - j] = currentV - j;
				} 
			}
			for (int j = currentR; j < nr; j++) {
				if (a[j][currentC] <= 0) {
					a[j][currentC] = currentV + j - currentR;
				} 
			}
			prevC = currentC;
			prevR = currentR;
			currentC = i;
			currentR = nr - i - 1;
			diff = Math.abs(currentR - prevR) + Math.abs(currentC - prevC);
			currentV += diff;
			for (int j = currentC; j < nc; j++) {
				if (a[currentR][j] <= 0) {
					a[currentR][j] = currentV - j + currentC;
				}
				
			}
			for (int j = 0; j <= currentR; j++) {
				if (a[currentR - j][currentC] <= 0) {
					a[currentR - j][currentC] = currentV + j;
				} 
			}
		}

		return a;
	}

	private static void print(int[][] array) {
		if (array == null || array.length == 0) {
			return;
		}
		int nr = array.length, nc = array[0].length;
		for (int i = 0; i < nr; i++) {
			for (int j = 0; j < nc; j++) {
				if (array[i][j] < 10) {
					System.out.print("0" + array[i][j] + " ");
				} else {
					System.out.print(array[i][j] + " ");
				}
			}
			System.out.println("");
		}

	}

}
