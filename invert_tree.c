#include <stdio.h>
#include <stdlib.h>
struct tree
{
    int data;
    struct tree *left;
    struct tree *right;
};
struct tree *getspace(int data)
{
    struct tree *head;
    head = (struct tree *)malloc(sizeof(struct tree));
    head->data = data;
    head->left = NULL;
    head->right = NULL;
    return head;
}
void iterate(struct tree *head)
{
    if (head == NULL)
    {
        return;
    }
    struct tree *temp = head->left;
    head->left = head->right;
    head->right = temp;
    iterate(head->left);
    iterate(head->right);
}
void printer(struct tree *head)
{
    if (head == NULL)
    {
        return;
    }
    printf("%d ", head->data);
    printer(head->left);
    printer(head->right);
}
int main()
{
    struct tree *head = getspace(1);
    head->data = 1;
    head->left = getspace(2);
    head->right = getspace(3);
    head->left->left = getspace(4);
    head->left->right = getspace(5);
    head->right->left = getspace(6);
    head->right->right = getspace(7);
    head->left->left->left = getspace(8);
    head->left->left->right = getspace(9);
    head->left->right->left = getspace(10);
    head->left->right->right = getspace(11);
    head->right->left->left = getspace(12);
    head->right->left->right = getspace(13);
    head->right->right->left = getspace(14);
    head->right->right->right = getspace(15);
    struct tree *temp = head;
    iterate(temp);
    printer(head);
    return 0;
}