package array.sample;

public class TwoArraySample {
	public void testTwoArray() {
		// 1. 2�����迭�� ���� ���۷��� ����
		int[][] tar;

		// 2. 2�����迭 ������ ���� �Ҵ�
		tar = new int[3][];

		System.out.println("tar.length : " + tar.length);

		// ���� ������ ���۷����迭 ������.
		// ���۷����������� ����
		// �ּҺ����� ���� 3���� �迭�� �Ҵ�.
		// ���� �Ҵ�� ���������� �⺻���� null��.
		for (int row = 0; row < tar.length; row++) {
			System.out.println("tar[" + row + "] : " + tar[row]);
		}

		// �� ���۷����� �ּҸ� �����
		// �� 1�����迭�� �Ҵ��ϰ� �� �ּҸ� �����
		tar[0] = new int[5];
		tar[1] = new int[4];
		tar[2] = new int[7];

		// �� ���۷����� �ּ� ��� Ȯ��
		for (int row = 0; row < tar.length; row++) {
			System.out.println("tar[" + row + "] : " + tar[row].hashCode());
		}

		// �� 1�����迭�� �� ���
		for (int r = 0; r < tar.length; r++) {
			// �� ���۷����� �����ϴ� 1�����迭�� ó��
			System.out.println("tar[" + r + "].length : " + tar[r].length);
			for (int c = 0; c < tar[r].length; c++) {
				tar[r][c] = (int) (Math.random() * 100) + 1;
			}
		}

		// 2�����迭 �� ���� �� Ȯ��
		for (int i = 0; i < tar.length; i++) {
			for (int j = 0; j < tar[i].length; j++) {
				System.out.print(tar[i][j] + "   ");
			}
			System.out.println();
		}
	}

	// �����迭 : �� �ະ �������� �Ȱ��� ��
	public void testTwoArray2() {
		int[][] tar = new int[3][5];

		System.out.println(tar.length);
		System.out.println(tar[0].length);
		System.out.println(tar[1].length);
		System.out.println(tar[2].length);

		// 2�����迭 �� ���� �� Ȯ��
		for (int i = 0; i < tar.length; i++) {
			for (int j = 0; j < tar[i].length; j++) {
				System.out.print(tar[i][j] + "   ");
			}
			System.out.println();
		}
	}
}
