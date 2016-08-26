package com.company;

/**
 * Created by boyice on 8/26/2016.
 *
 */
class SpiralMatrix {
    static int getFromSpiralMatrix(int[][] matrix, int index) throws Exception {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int i, r = 0, c = 0, cursor = 0;

        /*  r - starting row index
            m - ending row index
            c - starting column index
            n - ending column index
            i - iterator
        */

        while (r < rows && c < cols)
        {
        /* Check the first row from the remaining rows */
            for (i = c; i < cols; ++i)
            {
               if (cursor == index) return matrix[r][i];
               else cursor ++;

            }
            r++;

        /* Check the last column from the remaining columns */
            for (i = r; i < rows; ++i)
            {
                if (cursor == index) return  matrix[i][cols-1];
                else cursor ++;
            }
            cols--;

        /* Check the last row from the remaining rows */
            if ( r < rows)
            {
                for (i = cols-1; i >= c; --i)
                {
                    if (cursor == index) return  matrix[rows-1][i];
                    else cursor ++;
                }
                rows--;
            }

        /* Check the first column from the remaining columns */
            if (c < cols)
            {
                for (i = rows-1; i >= r; --i)
                {
                    if (cursor == index) return  matrix[i][c];
                    else cursor ++;
                }
                c++;
            }
        }
        throw new Exception();
    }
}
