#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int comparator(const void *p1, const void *p2)
{
    return (*(int *)p1) - (*(int *)p2);
}

int main()
{
    int *input1;
    int input1_size;
    scanf("%d", &input1_size);
    input1 = malloc(input1_size * (sizeof(int)));
    int input2_size;
    scanf("%d", &input2_size);
    int *input2;
    input2 = malloc(input2_size * (sizeof(int)));
    for (int i = 0; i < input1_size; i++)
    {
        scanf("%d", &input1[i]);
    }
    for (int i = 0; i < input2_size; i++)
    {
        scanf("%d", &input2[i]);
    }
    qsort(input1, input1_size, sizeof(int), comparator);
    qsort(input2, input2_size, sizeof(int), comparator);
    int start1 = 0;
    int start2 = 0;
    while (input1[start1] != '\0' && input2[start2] != '\0')
    {
        if (input1[start1] == input2[start2])
        {
            printf("%d ", input1[start1]);
            start1++;
            start2++;
        }
        else if (input1[start1] > input2[start2])
        {
            printf("%d ", input2[start2]);
            start2++;
        }
        else
        {
            printf("%d ", input1[start1]);
            start1++;
        }
    }
    while (input1[start1] != '\0')
    {
        printf("%d ", input1[start1]);
        start1++;
    }
    while (input2[start2] != '\0')
    {
        printf("%d ", input2[start2]);
        start2++;
    }
    return 0;
}
