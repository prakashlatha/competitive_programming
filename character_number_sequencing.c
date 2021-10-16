#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

//time complexity will be O(n*(number_of_characters_present_int_the_string * max_space_occupied_by_them))
int main()
{
    bool indic = true;
    char *input;
    input = malloc(100 * (sizeof(char)));
    scanf("%s", input);
    int idx = 0;
    int times = 0;
    int char_to_be_printed = input[idx];
    idx++;
    int length = strlen(input);
    while (input[idx] != '\0')
    {
        if (input[idx] >= '0' && input[idx] <= '9')
        {
            int current_var = input[idx] - 48;
            times = (times * 10) + current_var;
        }
        else
        {
            int temperory = times;
            char *temprory_print;
            temprory_print = malloc(times * (sizeof(char)));
            memset(temprory_print, char_to_be_printed, ((times) * (sizeof(char))));
            printf("%s", temprory_print);
            char_to_be_printed = input[idx];
            free(temprory_print);
            times = 0;
        }
        idx++;
    }
    char *temprory_print;
    temprory_print = malloc(times * (sizeof(char)));
    memset(temprory_print, char_to_be_printed, ((times) * (sizeof(char))));
    printf("%s", temprory_print);
    char_to_be_printed = input[idx];
    free(temprory_print);
    return 0;
}
