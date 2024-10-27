package com.epam.rd.autotasks;

class Spiral {
    static int[][] spiral(int rows, int columns) {
        int[][] matrix = new int[rows][columns];
        int i = 0, j = -1;
        int num = 1;
        int d_row = 0; // -1: up; 0: static; 1: down;
        int d_col = 1; // -1: left; 0: static; 1: right;

        while (num <= rows * columns) {
            int x = d_row + i;
            int y = d_col + j;
            if (((x >= 0) && (x < rows)) && ((y >= 0) && (y < columns)) && (matrix[x][y] == 0)) {
                i += d_row;
                j += d_col;
                matrix[i][j] = num;
                num++;
            } else {
                if (d_col == 1) {
                    d_col = 0;
                    d_row = 1;
                } else if (d_row == 1) {
                    d_col = -1;
                    d_row = 0;
                } else if (d_col == -1) {
                    d_col = 0;
                    d_row = -1;
                } else if (d_row == -1) {
                    d_col = 1;
                    d_row = 0;
                }
            }
        }

        return matrix;
    }

//    solution 2
//    static int[][] spiral(int rows, int columns) {
//        int[][] matrix = new int[rows][columns];
//        int num = 1;
//        int i = 0, j = 0;
//        int d_row = 0, d_col = 1;
//
//        while (num <= rows * columns) {
//            matrix[i][j] = num++;
//            int next_i = i + d_row;
//            int next_j = j + d_col;
//
//            if (next_i < 0 || next_i >= rows || next_j < 0 || next_j >= columns || matrix[next_i][next_j] != 0) {
//                // Change direction
//                if (d_col == 1) { // right to down
//                    d_col = 0;
//                    d_row = 1;
//                } else if (d_row == 1) { // down to left
//                    d_col = -1;
//                    d_row = 0;
//                } else if (d_col == -1) { // left to up
//                    d_col = 0;
//                    d_row = -1;
//                } else if (d_row == -1) { // up to right
//                    d_col = 1;
//                    d_row = 0;
//                }
//            }
//
//            i += d_row;
//            j += d_col;
//        }
//
//        return matrix;
//    }
}
