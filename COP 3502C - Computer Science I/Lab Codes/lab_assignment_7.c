#include <stdio.h>
#include <stdlib.h>

int main(){

    int arr[] = {97, 16, 45, 63, 13, 22, 7, 58, 72};
    int n = 9;
    int arr2[n][2];

    printf("\nOriginal list: ");

    for (int i = 0; i < n; i++)
    {
        printf("%d ", arr[i]);     
    }

    printf("\n");

    int count = 0;
    for (int i = 0; i < n; i++)
    {
        arr2[i][0] = arr[i];
    }

    printf("\n");
    int i, j,temp;

    for (i = 0; i < n-1; i++)
    {       
        count = 0;
            for (j = 0; j < n-i-1; j++)
            {           
                if (arr[j] > arr[j+1])
                    {
                        count += 1;
                        temp = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] = temp;
                        arr2[i][1] = count;
                    }

            }
    }
    

    printf("New List: ");
    for (int i = 0; i < n; i++)
    {
        printf("%d ", arr[i]);
    }
    
    printf("\n\n");
    for (int i = 0; i < n; i++)
    {    
        printf("Value %d took %d swaps\n", arr2[i][0], arr2[i][1]);
    }
}