#include <stdio.h>
#include <stdlib.h>
#define SIZE 40

struct linked_list
{
    int linked_data;
    struct linked_list *next;
};
struct chained_hash
{
    int data;
    int key;
    struct linked_list *datamatrix;
};
struct chained_hash *input[SIZE];
struct chained_hash *igets;

void insert(int key, int data)
{
    int hash_idx = key % SIZE;
    if (input[hash_idx] == NULL)
    {
        printf("/ yes %d /", key);
        input[hash_idx] = (struct chained_hash *)malloc(sizeof(struct chained_hash *));
        input[hash_idx]->datamatrix = (struct linked_list *)malloc(sizeof(struct linked_list *));
        input[hash_idx]->data = data;
        input[hash_idx]->key = key;
        input[hash_idx]->datamatrix->linked_data = data;
    }
    else if (input[hash_idx] != NULL)
    {
        printf("\nprint %d\n", data);
        struct linked_list *current;
        current = (struct linked_list *)malloc(sizeof(struct linked_list *));
        current = input[hash_idx]->datamatrix;
        while (current->next != NULL)
        {
            current = current->next;
        }
        struct linked_list *current2;
        current2 = (struct linked_list *)malloc(sizeof(struct linked_list *));
        current2->linked_data = data;
        current->next = current2;
    }
}
int main()
{
    insert(1, 4);
    insert(1, 5);
    insert(1, 13);
    insert(1, 133);
    insert(2, 41);
    insert(10, 60);
    insert(11, 40);
    insert(11, 44);
    insert(12, 45);
    insert(2, 4);
    insert(10, 0);
    insert(11, 40);
    printf("\n");
    for (int i = 0; i < 40; i++)
    {
        if (input[i] != NULL && input[i]->key != -1)
        {
            struct linked_list *tail;
            tail = (struct linked_list *)malloc(sizeof(struct linked_list *));
            tail = input[i]->datamatrix;
            while (tail != NULL)
            {
                printf(" %d ", tail->linked_data);
                tail = tail->next;
            }
            printf("\n");
        }
    }
    printf("\n");

    return 0;
}