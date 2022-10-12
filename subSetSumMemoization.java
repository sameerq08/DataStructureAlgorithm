package com.javatpoint.microservices.limitsservice;
public class subSetSumMemoization {
    static int subsetSum(int a[], int n, int sum)
    {
        // Storing the value -1 to the matrix
        int tab[][] = new int[n + 1][sum + 1]; // We took sum+1 and n+1 because we have to fill initial columns and rows
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                tab[i][j] = -1;
            }
        }
        // If the sum is zero it means
        // we got our expected sum
        if (sum == 0)
            return 1;
        if (n <= 0)
            return 0;
        // If the value is not -1 it means it
        // already call the function
        // with the same value.
        // it will save our from the repetition.
        if (tab[n - 1][sum] != -1)
            return tab[n - 1][sum];
        // if the value of a[n-1] is
        // greater than the sum.
        // we call for the next value
        if (a[n - 1] > sum)
            return tab[n - 1][sum] = subsetSum(a, n - 1, sum);
        else {
            // Here we do two calls because we
            // don't know which value is
            // full-fill our criteria
            // that's why we doing two calls one call will be False and one would be True
            if (subsetSum(a, n - 1, sum) != 0 || subsetSum(a, n - 1, sum - a[n - 1])
                    != 0) { // it will reduce sum value as long we traverse the Array
                return tab[n - 1][sum] = 1;
            }
            else
                return tab[n - 1][sum] = 0;
        }
    }
    //12 - 4 = sum 8 then 7 - 8 = sum 1 then if(a[n-1] > sum True then it will just check next value which is 5 then check next which is 1 then move to else condition

    // Driver Code
    public static void main(String[] args)
    {

        int n = 5;
        int a[] = { 1, 5, 3, 7, 4 };
        int sum = 12;

        if (subsetSum(a, n, sum) != 0) {
            System.out.println("YES\n");
        }
        else
            System.out.println("NO\n");
    }
}
