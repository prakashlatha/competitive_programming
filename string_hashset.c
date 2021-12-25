#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#define SIZE 300
struct hashstring
{
    int current_idx;
    char table[1000][100];
};
struct hashstring *map[100];
struct hashstring *getspace()
{
    struct hashstring *head;
    head = (struct hashstring *)malloc(sizeof(struct hashstring));
    head->current_idx = 0;
    return head;
}
void import(char *input)
{
    if (map[input[0]] == NULL)
    {
        map[input[0]] = getspace();
        strcpy(map[input[0]]->table[0], input);
        map[input[0]]->current_idx++;
    }
    else
    {
        strcpy(map[input[0]]->table[map[input[0]]->current_idx], input);
        map[input[0]]->current_idx++;
    }
}
int main()
{
    int number_of_inputs;
    for (int i = 0; i < SIZE; i++)
    {
        map[i] = NULL;
    }
    scanf("%d", &number_of_inputs);
    for (int i = 0; i < number_of_inputs; i++)
    {
        char input[100];
        scanf("%s", input);
        import(input);
    }
    printf("\n");
    for (int i = 'a'; i <= 'z'; i++)
    {
        if (map[i] != NULL)
        {
            int idx = map[i]->current_idx;
            for (int j = 0; j < idx; j++)
            {
                printf("%s\n", map[i]->table[j]);
            }
        }
    }
    return 0;
}