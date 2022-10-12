package com.javatpoint.microservices.limitsservice;

public class coinChangeBottomUpTabulation {
    // The Idea to Solve this Problem is by using the Bottom Up(Tabulation). By using the linear array for space optimization.
    static long count(int coins[], int n, int sum)
    {
        // table[i] will be storing the number of solutions for
        // value i. We need sum+1 rows as the table is
        // constructed in bottom up manner using the base case
        // (sum = 0)
        int table[] = new int[sum + 1];

        // Base case (If given value is 0)
        table[0] = 1;

        // Pick all coins one by one and update the table[]
        // values after the index greater than or equal to the
        // value of the picked coin
        for (int i = 0; i < n; i++)
            for (int j = coins[i]; j <= sum; j++)
                table[j] += table[j - coins[i]];

        return table[sum];
    }

    // Driver Function to test above function
    public static void main(String args[])
    {
        int coins[] = { 1, 2, 3 };
        int n = coins.length;
        int sum = 4;
        System.out.println(count(coins, n, sum));
    }
}
