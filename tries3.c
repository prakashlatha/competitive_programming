#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <stdbool.h>
#define SIZE 30
struct tries
{
    char data;
    struct tries *children[30];
};
struct tries *getspace()
{
    struct tries *head;
    head = (struct tries *)malloc(sizeof(struct tries));
    head->data = 0;
    for (int i = 0; i < SIZE; i++)
    {
        head->children[i] = NULL;
    }
    return head;
};
void traverse(int index, struct tries *head, char *str)
{
    struct tries *copy = head;
    for (int idx = index; idx < strlen(str); idx++)
    {
        int array_idx = 0;
        bool indic = false;
        while (copy->children[array_idx] != NULL)
        {
            if (copy->children[array_idx]->data == str[idx])
            {
                indic = true;
                copy = copy->children[array_idx];
                break;
            }
            array_idx++;
        }
        if (!indic)
        {
            copy->children[array_idx] = getspace();
            copy->children[array_idx]->data = str[idx];
            copy = copy->children[array_idx];
        }
    }
}
void insert(struct tries *head, char *str)
{
    for (int i = 0; i < strlen(str); i++)
    {
        traverse(i, head, str);
    }
}
void iterator(struct tries *head, int idx)
{
    for (int i = 0; head->children[i] != NULL; i++)
    {
        printf("%c ", head->children[i]->data);
        iterator(head->children[i], 0);
    }
}
bool contains(struct tries *head, char *str)
{
    struct tries *temp;
    temp = head;
    for (int i = 0; i < strlen(str); i++)
    {
        int idx = 0;
        bool indic = false;
        while (temp->children[idx] != NULL)
        {
            if (temp->children[idx]->data == str[i])
            {
                temp = temp->children[idx];
                indic = true;
                break;
            }
            idx++;
        }
        if (!indic)
        {
            return false;
        }
    }
    return true;
}
int main()
{
    struct tries *head;
    head = getspace();
    head->data = '*';
    insert(head, "triesdatastructure");
    insert(head, "computerscience");
    if (contains(head, "astruc"))
    {
        printf("yes available\n");
    }
    else
    {
        printf("no notavailable\n");
    }

    if (contains(head, "mmmmm"))
    {
        printf("yes available");
    }
    else
    {
        printf("no notavailable");
    }
}