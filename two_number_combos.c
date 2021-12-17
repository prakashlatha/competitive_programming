#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#define Max_len 4
#define main_one "3"
#define main_two "4"
void operate(char *number)
{
    if (strlen(number) >= Max_len)
    {
        return;
    }
    char operated1[100];
    strcpy(operated1, number);
    strcat(operated1, main_one);
    printf("%s\n", operated1);
    operate(operated1);
    char operated2[100];
    strcpy(operated2, number);
    strcat(operated2, main_two);
    printf("%s\n", operated2);
    operate(operated2);
}
int main()
{
    char char_1[1] = "";
    operate(char_1);
    printf("\n\n\n");
}