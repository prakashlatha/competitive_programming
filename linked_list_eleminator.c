#include <stdio.h>
#include <string.h>
#include <stdlib.h>
struct linked
{
    int data;
    struct linked *next;
};
struct linked *head;
struct linked *tail;
struct linked *getspace(int data)
{
    struct linked *head;
    head = (struct linked *)malloc(sizeof(struct linked));
    head->data = data;
    head->next = NULL;
    return head;
}
void iterator()
{
    if (head == head->next)
    {
        printf("ans -> %d", head->data);
        return;
    }
    head->next = head->next->next;
    head = head->next;
    iterator();
}
int main()
{
    int number_of_inputs;
    scanf("%d", &number_of_inputs);
    tail = head;
    for (int i = 0; i < number_of_inputs; i++)
    {
        int input;
        scanf("%d", &input);
        if (i == 0)
        {
            head = getspace(input);
            tail = head;
        }
        else
        {
            tail->next = getspace(input);
            tail = tail->next;
        }
    }
    tail->next = head;
    iterator();
    return 0;
}