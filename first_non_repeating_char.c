#include <stdio.h>
#include <stdlib.h>
#define SIZE 257
struct char_map
{
    char character;
    int count;
    int idx;
};
struct char_map *getspace()
{
    struct char_map *map;
    map = (struct char_map *)malloc(sizeof(struct char_map));
    map->count = 0;
    map->idx = SIZE;
    return map;
}
int main()
{
    struct char_map *map[SIZE];
    for (int i = 0; i < SIZE; i++)
    {
        map[i] = getspace();
    }
    char input[100];
    scanf("%s", input);
    for (int i = 0; input[i] != '\0'; i++)
    {
        int idx = input[i];
        map[idx]->character = input[i];
        map[idx]->count += 1;
        if (map[idx]->idx == SIZE)
        {
            map[idx]->idx = i;
        }
    }
    int idx = SIZE;
    for (int i = 0; i < SIZE; i++)
    {
        if (map[i]->count == 1 && idx > map[i]->idx)
        {
            idx = map[i]->idx;
        }
    }
    if (idx == SIZE)
    {
        printf("No character is repeated");
    }
    else
    {
        printf("the repeated character is %c", input[idx]);
    }
}