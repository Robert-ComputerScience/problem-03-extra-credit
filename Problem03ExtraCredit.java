

public class Problem03ExtraCredit
{

    public static void main(String[] args) {
        long rowCount = 1000000000;
        long count = countNonDivisibleBySeven(rowCount);
        System.out.println("Number of entries not divisible by 7 in the first 10^9 rows: " + count);
    }

    public static long countNonDivisibleBySeven(long rowCount) {
        long count = 0;
        long[][] binomialCoefficients = new long[7][7];

        for (int n = 0; n < 7; n++) {
            binomialCoefficients[n][0] = 1;
            for (int k = 1; k <= n; k++) {
                binomialCoefficients[n][k] = (binomialCoefficients[n - 1][k - 1] + binomialCoefficients[n - 1][k]) % 7;
            }
        }

        for (int row = 0; row < rowCount; row++) {
            for (int col = 0; col <= row; col++) {
                if (binomialCoefficients[row % 7][col % 7] != 0) {
                    count++;
                }
            }
        }

        return count;
        /*
        Time Complexity: O(n^2) where n is the number of rows of Pascal's triangle considered.
        Space Complexity: O(1)
         */
    }




}
