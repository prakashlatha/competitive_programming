#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main()
{
    char *input;
    input = malloc(100 * (sizeof(char)));
    scanf("%s", input);
    int *input_index;
    int input_len = strlen(input);
    input_index = malloc(input_len * (sizeof(int)));
    void *mymemset(void *, int, int, void *);
    mymemset(input_index, 1, input_len, input);
    input_index[0] = 0;
    input_index[strlen(input) - 1] = 0;
    int temp_idx;
    for (int idx = 1; idx < strlen(input) - 1; idx++)
    {
        if (input[idx] == ')')
        {
            int current_idx = idx - 1;

            while (current_idx > 0 && input_index[current_idx] == 0)
            {
                current_idx--;
            }
            if (current_idx > 0 && input_index[current_idx] == 1 && input[current_idx] == '(')
            {
                input_index[idx] = 0;
                input_index[current_idx] = 0;
            }
        }
    }
    printf("\n\n");
    for (int i = 0; i < strlen(input); i++)
    {
        if (input_index[i] == 0)
        {
            printf("%c", input[i]);
        }
    }
    free(input);
    free(input_index);
}
void *mymemset(void *ptr, int c, int len, void *ptr2)
{
    int *current = ptr;
    char *current2 = ptr2;
    while (len >= 0)
    {
        if (*current2 >= 'a' && *current2 <= 'z')
        {
            *current = 0;
        }
        else
        {
            *current = 1;
        }
        current++;
        current2++;
        len--;
    }
    return ptr;
}
