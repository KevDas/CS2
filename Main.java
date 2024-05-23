/* COP 3503C Assignment 1
 * This program is written by: Kevin Dasrath
 */


import java.util.Scanner;
import java.util.HashSet;


public class Main {

    static Scanner scan;
    public static int MAX = 20;

    public static int[] getCandidatePair(int A[], int target){
            

            int n1 = 2;
            int n2 = target - 1;
            int pair[] = {-1 , -1};
            while (n1 < n2){

                int res = A[n1] + A[n2];


    

                if (res == A[target]){
                    pair[0] = A[n1];
                    pair[1] = A[n2];
                    return pair;
                }
                else if (res > A[target])
                    n2--;
                else if (res < A[target])
                    n1++;
                    

            }
            return pair;
    }
   

    public static int[] unsortedGetCandidatePair(int A[], int target){

        HashSet<Integer> values = new HashSet<Integer>();
            int n = A[1];
            int[] pair = {-1, -1};

            for (int i = 2; i < 2 + n; ++i){
            
                if (values.contains(A[target] - A[i])){
                    pair[0] = A[target] - A[i];
                    pair[1] = A[i];
                }
                else values.add(A[i]);
            }
            

        return pair;


    }

    public static void main(String[] args){

        
        scan = new Scanner(System.in);
        // n represents the number of test cases to be processed
        int n = scan.nextInt();

        // creates an array that contains n sub-arrays of size 20;
        int[][] array = new int[n][MAX];
        // array of target values
        int[] target = new int[n];

        // pair array (array of size 2, where pair[0] is the first 
        // element and pair[1] is the second element)
        int[] pair = new int[1];

        int j;


        for (int i = 0; i < n; i++){
            array[i][0] = scan.nextInt();
            array[i][1] = scan.nextInt();
            for (j = 2; j < 2 + array[i][1]; ++j){
                array[i][j] = scan.nextInt();
            }
            
            array[i][j] = scan.nextInt();
            target[i] = j;
        }

        for (int i = 0; i < n; i++){

            if (array[i][0] == 1){
                pair = getCandidatePair(array[i], target[i]);
                if (pair[0] == -1 && pair[1] == -1){
                    System.out.println("Test case #" + (i+1) + ": No way you can spend exactly " + array[i][target[i]] + "points.");
                }
                else {
                    System.out.println("Test case #" + (i+1) + ": Spend " + array[i][target[i]] + " points by playing games with " + pair[0] + " points and " + pair[1] + " points.");
                }
            }
            else if (array[i][0] == 0){
                pair = unsortedGetCandidatePair(array[i], target[i]);
                if (pair[0] == -1 && pair[1] == -1){
                    System.out.println("Test case #" + (i+1) + ": No way you can spend exactly " + array[i][target[i]] + " points.");
                }
                else {
                    System.out.println("Test case #" + (i+1) + ": Spend " + array[i][target[i]] + " points by playing games with " + pair[0] + " points and " + pair[1] + " points.");
                }

            }
            else {
                System.out.println("Invalid Entry");
                return;
            }
        }

        /*for (int i = 0; i < n; ++i){

            int sort = scan.nextInt();
            int size = scan.nextInt();

            int array[][];
            int pair[];
            pair = new int[1];
            array = new int[n][3 + size];
            array[0] = sort;
            array[1] = size;
            int j;
            for (j = 2; j < size; ++j){
                array[i][j] = scan.nextInt();
            }

            if (sort == 1)
                 pair = getCandidatePair(array, array[j]);
            
               

        }
        */

    }

}



// check for amount of arrays to create
    // create the first array, with:
        //its first value being if its sorted
        // its second value being the amount of elements contained (n)
        // its 3rd through n elements being the values to check through
        // its n + 1th value being the target value


