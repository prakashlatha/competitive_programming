#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#define SIZE 300
struct tries
{
    char character;
    struct tries *child[SIZE];
};
struct tries *getspace(char data)
{
    struct tries *head;
    head = (struct tries *)malloc(sizeof(struct tries));
    head->character = data;
    for (int i = 0; i < SIZE; i++)
    {
        head->child[i] = NULL;
    }
    return head;
}
struct tries *getemptyspace()
{
    struct tries *head;
    head = (struct tries *)malloc(sizeof(struct tries));
    for (int i = 0; i < SIZE; i++)
    {
        head->child[i] = NULL;
    }
    return head;
}
struct tries *matches_main;
void match_maker(int idx, char *input)
{
    struct tries *matches;
    matches = matches_main;
    for (int i = idx; i < strlen(input); i++)
    {
        if (matches->child[input[i]] == NULL)
        {
            matches->child[input[i]] = getspace(input[i]);
            matches = matches->child[input[i]];
        }
        else
        {
            matches = matches->child[input[i]];
        }
    }
}
bool present(char *input)
{
    struct tries *matches;
    matches = matches_main;
    for (int i = 0; i < strlen(input); i++)
    {
        if (matches->child[input[i]] == NULL)
        {
            return false;
        }
    }
    return true;
}
int main()
{
    char input[100] = "prakashpsakjba";
    matches_main = getspace('*');
    for (int i = 0; i < strlen(input); i++)
    {
        match_maker(i, input);
    }
    if (present("zkl"))
    {
        printf("yes present");
    }
    else
    {
        printf("not present");
    }
}
