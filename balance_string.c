#include <stdio.h>
#include <string.h>
#include <stdbool.h>
#define NUMBER_SIZE 10
#define ALPHABET_CASE 26
bool map_number[NUMBER_SIZE];
bool map_alphabet[ALPHABET_CASE];
bool number_morphic = false;
bool alphabet_morphic = false;
char find_next_num(char current)
{
    int idx = 0;
    while (map_number[current] == true)
    {
        idx++;
        if (idx >= NUMBER_SIZE)
        {
            number_morphic = true;
            return ' ';
        }
        if (current == '9')
        {
            current = '0';
            continue;
        }
        current++;
    }
    map_number[current] = true;
    return current;
}
char find_next_alpha(char current)
{
    int idx = 0;
    while (map_alphabet[current] == true)
    {
        idx++;
        if (idx == ALPHABET_CASE)
        {
            alphabet_morphic = true;
            return ' ';
        }
        if (current == 'z')
        {
            current = 'a';
            continue;
        }
        current++;
    }
    map_alphabet[current] = true;
    return current;
}
int main()
{

    char input[100];
    scanf("%s", input);
    for (int i = 0; i < NUMBER_SIZE; i++)
    {
        map_number[i] = false;
    }
    for (int i = 0; i < ALPHABET_CASE; i++)
    {
        map_alphabet[i] = false;
    }
    for (int i = 0; i < strlen(input); i++)
    {
        char get_char;

        if (input[i] >= '0' && input[i] <= '9')
        {
            if (number_morphic == true)
            {
                get_char = ' ';
            }
            else
            {
                get_char = find_next_num(input[i]);
            }
        }
        else
        {
            if (alphabet_morphic == true)
            {
                get_char = ' ';
            }
            else if (input[i] >= 'A' && input[i] <= 'Z')
            {
                get_char = find_next_alpha(input[i] + 32);
                get_char -= 32;
            }
            else
            {
                get_char = find_next_alpha(input[i]);
            }
        }
        input[i] = get_char;
    }
    printf("%s", input);

    return 0;
}
