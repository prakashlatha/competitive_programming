#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <stdbool.h>
struct linked
{
    int data;
    struct linked *next;
};
struct hashset
{
    char char_index;
    struct linked *list;
};
int main()
{
    int arr[100];
    int array_len;
    scanf("%d", &array_len);
    printf("\nenter the datas \n");
    for (int i = 0; i < array_len; i++)
    {
        scanf("%d", &arr[i]);
    }
    printf("\n");
    struct hashset *map[100];
    for (int i = 0; i < 100; i++)
    {
        map[i] = NULL;
    }
    for (int i = 0; i < array_len; i++)
    {
        char string_idx[100];
        sprintf(string_idx, "%d", arr[i]);
        if (map[string_idx[0]] == NULL)
        {
            map[string_idx[0]] = (struct hashset *)malloc(sizeof(struct hashset));
            map[string_idx[0]]->char_index = string_idx[0];
            map[string_idx[0]]->list = (struct linked *)malloc(sizeof(struct linked));
            map[string_idx[0]]->list->data = arr[i];
            continue;
        }
        struct linked *map_link = map[string_idx[0]]->list;
        if (arr[i] == map_link->data)
        {
            continue;
        }
        bool indic = false;
        while (map_link->next != NULL)
        {
            if (map_link->next->data == arr[i])
            {
                indic = true;
                break;
            }
            map_link = map_link->next;
        }
        if (indic)
        {
            continue;
        }
        struct linked *temp = (struct linked *)malloc(sizeof(struct linked));
        temp->data = arr[i];
        map_link->next = temp;
    }
    char start_num = '0';
    char end_num = '9';
    int ans = 0;
    while (start_num < end_num)
    {
        if (map[start_num] == NULL)
        {
            start_num++;
            continue;
        }
        while (map[start_num]->list != NULL)
        {
            ans += map[start_num]->list->data;
            map[start_num]->list = map[start_num]->list->next;
        }
        start_num++;
        printf("\n");
    }
    printf("\nans : %d", ans);
}
