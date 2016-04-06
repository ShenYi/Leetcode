package com.yishen;

/**
 * https://leetcode.com/problems/valid-sudoku/
 * 
 * @author yishen
 *
 */
public class ValidSudoku {
	public boolean isValidSudoku(char[][] board) {
		if (board == null || board.length != 9) {
			return false;
		}

		for (int i = 0; i < 9; i++) {
			boolean[] check = new boolean[9];
			if (board[i].length != 9) {
				return false;
			}

			for (int j = 0; j < 9; j++) {
				char cur = board[i][j];
				if (cur == '.') {
					continue;
				} else {
					if (check[cur - '0' - 1]) {
						return false;
					} else {
						check[cur - '0' - 1] = true;
					}
				}
			}
		}

		for (int i = 0; i < 9; i++) {
			boolean[] check = new boolean[9];
			for (int j = 0; j < 9; j++) {
				char cur = board[j][i];
				if (cur == '.') {
					continue;
				} else {
					if (check[cur - '0' - 1]) {
						return false;
					} else {
						check[cur - '0' - 1] = true;
					}
				}
			}
		}

		for (int i = 0; i < 9; i += 3) {
			for (int j = 0; j < 9; j += 3) {
				boolean[] check = new boolean[9];
				for (int a = i; a < i + 3; a++) {
					for (int b = j; b < j + 3; b++) {
						char cur = board[a][b];
						if (cur == '.') {
							continue;
						} else {
							if (check[cur - '0' - 1]) {
								return false;
							} else {
								check[cur - '0' - 1] = true;
							}
						}
					}
				}
			}
		}
		return true;
	}
}
