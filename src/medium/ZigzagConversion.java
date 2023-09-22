package medium;

import java.util.Arrays;

public class ZigzagConversion {
    public static void main(String[] args) {
//        convert("PAYPALISHIRING", 3);
//        convert("PAYPALISHIRING", 4);
//        convert("A", 1);
//        convert("ABC", 2);
//        convert("ABC", 2);
//        convert("ABCDEF", 2);
        convert("PAYPALISHIRING", 5);
    }

    public static String convert(String s, int numRows) {
        /**
         * numRows = 2 => better is to concatenate the even and then odd indexes of s;
         */
        if (numRows == 1) return s;
        if (numRows == 2) {
            StringBuilder fastestWayBuilder = new StringBuilder();
            for (int i = 0; i < s.length(); i+=2) {
                fastestWayBuilder.append(s.charAt(i));
            }
            for (int i = 1; i < s.length(); i+=2) {
                fastestWayBuilder.append(s.charAt(i));
            }
            System.out.println(fastestWayBuilder.toString());
            return fastestWayBuilder.toString();
        }

        /**
         * attempt to calculate boundaries of zigzag double dimension array
         * numRows => rows of matrix
         * cols => cols of matrix
         * diagonal => we always start printing chars in diagonal from numRows - 1 (level above of bottom boundary) and to the top - 1 (level below of top boundary)
         */
        int cols = 0;
        int diagonal = numRows - 2;

        /**
         * if flip = true => count printing in the column
         * if flip = false => count printing in the diagonal
         * at the end we will get cols number
         */
        int i = 0;
        boolean flip = true;
        while (i < s.length()) {
            if (flip) {
                cols++;
                i += numRows;
            } else {
                cols += diagonal;
                i += diagonal;
            }
            flip = !flip;
        }

        /**
         * if flip = true => print only in the column (changing rowCursor, fix colCursor)
         * if flip => false => print only in the diagonal (changing rowCursor, fixCursor)
         *      should take step above of bottom matrix (numRows - countDiagonalWrite - 1)
         *      and print until one level from top matrix
         *      (if only one char in diagonal, so it will be executed once
         *      if more chars in diagonal, countDiagonalWrite will write it one by one each level above and shift colCursor)
         */
        char[][] zigzagDimension = new char[numRows][cols];
        int rowCursor = 0;
        int colCursor = 0;
        int countDiagonalWrite = 0;
        flip = true;
        for (i = 0; i < s.length(); i++) {
            if (flip) {
                zigzagDimension[rowCursor][colCursor] = s.charAt(i);
                rowCursor++;
            } else {
                countDiagonalWrite++;
                zigzagDimension[numRows-countDiagonalWrite-1][colCursor] = s.charAt(i);
                colCursor++;
            }
            if (rowCursor == numRows) {
                flip = !flip;
                rowCursor = 0;
                colCursor++;
            }
            if (countDiagonalWrite == diagonal) {
                flip = !flip;
                countDiagonalWrite = 0;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (i = 0; i < numRows; i++) {
            for (int j = 0; j < cols; j++) {
                sb.append((int) zigzagDimension[i][j] != 0 ? zigzagDimension[i][j] : "");
            }
        }
        System.out.println(Arrays.deepToString(zigzagDimension));
        System.out.println(sb.toString());
        return sb.toString();
    }
}
