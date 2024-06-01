/* COP 3503C Assignment 2
This program is written by: Kevin Dasrath */

import java.util.Scanner;
import java.util.*;
import java.io.*;
import java.util.Arrays;


public class Main {

    
    static Scanner scan = new Scanner(System.in);
    static int M, N, S;
    static char[][] array;
    static String[] words;
    static char[][] charWords;
 




    void printSolution(char sol[][])
    {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(sol[i][j] + ", ");
            System.out.println();
        }
    }



            boolean isSafe(int x, int y)
            {
              if (x >= 0 && x < M && y >= 0 && y < N)
                return true;
              
              return false;
            }

    boolean getSolution(char[] word)
    {
        char sol[][] = new char[M][N];
        
        for (int i = 0; i < M; ++i)
        {
            for (int j = 0; j < N; ++j) 
            {
                sol[i][j] = '_';
            }
        }
        boolean isPath = false;
        while (isPath == false){
            for (int i = 0; i < M; ++i){
                for (int j = 0; j < N; ++j){
                    isPath = findPath(sol, i, j, word, 0);
                }
            }
            System.out.print("Solution doesn't exist");
            return false;
        

        }
         
        printSolution(sol);
        return true;

    }
    boolean findPath(char[][] sol, int x, int y, char[] word, int idx)
    {
        if (x == N - 1 && y == N - 1 && array[x][y] == word[idx]) {
            sol[x][y] = array[x][y];
            return true;
        } 
         // Check if it is safe to go to maze[x][y]
        if (isSafe(x, y) == true) {

            if (findPath(sol, x-1, y-1, word, idx++)) return true;
            if (findPath(sol, x-1, y, word, idx++)) return true;
            if (findPath(sol, x-1, y+1, word, idx++)) return true;
            if (findPath(sol, x, y+1, word, idx++)) return true;
            if (findPath(sol, x+1, y+1, word, idx++)) return true;
            if (findPath(sol, x+1, y, word, idx++)) return true;
            if (findPath(sol, x+1, y-1, word, idx++)) return true;
            if (findPath(sol, x, y-1, word, idx++)) return true;
            
                      
            /* If none of the above movements works then
            BACKTRACK: unmark x, y as part of solution
            path */
            sol[x][y] = '_';
            return false;
        } 
        return false;
    }




    void fillArray(){
        for (int i = 0; i < M; ++i)
        {
            for (int j = 0; j < N; ++j)
                array[i][j] = scan.next().charAt(0);
        }
    } 

    void getWords(){
        
        for (int i = 0; i < S; ++i){
            words[i] = scan.next();
            charWords[i] = words[i].toCharArray();
        }
    }

    public static void main(String[] args) {
        
        Main matrix = new Main();

        M = scan.nextInt();
        N = scan.nextInt();
        S = scan.nextInt();


        
        matrix.fillArray(0);
        matrix.getWords();

        for (int i = 0; i < S; ++i)
            matrix.getSolution(charWords[S]);
       
    
       
        

        }
    }





    /*  (for int i = 0; i < S; ++i){
        int array[S][][] = checkForWordFunc(array[M][N], word S, int i, strlen);
    }*/

    /*int** checkForWordFunc(double array, string S){
     
        //for any letter, we want to check if any of it adjacent spots have the next letter
        
        if the array entry is equal to the string index, we record that to a new array and check
        each position adjacent 

        checkForWordFunc(diagonal left up, string, i+1, strlen)
        checkForWordFunc(up, string, i+1, strlen)
        checkForWordFunc(diagonal right up, string, i+1, strlen)
        checkForWordFunc(right, string, i+1, strlen)
        checkForWordFunc(diagonal right down, string, i+1, strlen)
        checkForWordFunc(down, string, i+1, strlen)
        checkForWordFunc(diagonal left down, string, i+1, strlen)
        checkForWordFunc(left, string, i+1, strlen)



        

    */




    /*
     
        check word(array, word){
            points in order[S][2]

            for each letter in matrix(check if letter)
                if letter, 
                    points in order[i][2] = check word(array[diagonal left up], word)
                    points in order[i][2] = check word(array[up], word)
                    points in order[i][2] = check word(array[diagonal right up], word)
                    points in order[i][2] = check word(array[right], word)
                    points in order[i][2] = check word(array[diagonal right down], word)
                    points in order[i][2] = check word(array[down], word)
                    points in order[i][2] = check word(array[diagonal left down], word)
                    points in order[i][2] = check word(array[left], word)
                else 
                    check word(array[next] word)
        }









     */