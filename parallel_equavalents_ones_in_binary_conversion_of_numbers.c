#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <math.h>
int main()
{
    int n;
    scanf("%d", &n);
    int binary_digits = 1;
    while (n > 1)
    {
        binary_digits *= 10;
        n--;
    }
    char converted_binary_number[100];
    sprintf(converted_binary_number, "%d", binary_digits);
    int pover = strlen(converted_binary_number) - 1;
    int actual_length = pover + 1;
    int first_integer = 0;
    for (int i = 0; converted_binary_number[i] != '\0'; i++)
    {
        int current_number = ((int)converted_binary_number[i]) - 48;
        current_number = current_number * pow(2, pover);
        pover--;
        first_integer += current_number;
    }
    bool cond = true;
    char *binary_digit_conversion(int, int);
    int count = 0;
    while (cond)
    {
        int current_number = first_integer + 1;
        char *binary_digits_current;
        binary_digits_current = malloc(100 * (sizeof(char)));
        binary_digits_current = binary_digit_conversion(current_number, actual_length);
        if (strlen(binary_digits_current) != actual_length)
        {
            cond = false;
        }
        else
        {
            int i = 0, j = actual_length - 1;
            int left_orgins = 0;
            int right_orgin = 0;
            while (i < j)
            {
                if (*(binary_digits_current + i) == '1')
                {
                    left_orgins++;
                }
                if (*(binary_digits_current + j) == '1')
                {
                    right_orgin++;
                }
                i++;
                j--;
            }
            if (left_orgins == right_orgin)
            {
                printf("\n %s\n", binary_digits_current);
            }
        }
        first_integer++;
        count++;
    }
    return 0;
}

char *binary_digit_conversion(int number, int length)
{
    char *retans;
    retans = malloc(50 * (sizeof(char)));
    int idx = -1;
    int number_int = 0;
    while (number >= 1)
    {
        idx++;
        int temp_int = number % 2;
        *(retans + idx) = (temp_int == 1) ? '1' : '0';
        number /= 2;
    }
    return retans;
}
