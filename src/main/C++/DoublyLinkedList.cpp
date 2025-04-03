#include<stdio.h>

struct Node
{
    /* data */
    int data;
    Node* prev;
    Node* next;
};

struct Node* GetNewNode(int data) {
    Node* newNodePointer = new Node(); // reserve memory from heap
    newNodePointer->data = data;
    newNodePointer->prev = NULL;
    newNodePointer->next = NULL;
    return newNodePointer;
}
void Insert(Node** head, int pos, int data) {
    Node* temp1 = GetNewNode(data);
    if (pos == 1 && *head == NULL) {
        *head = temp1;
    }
    else if (pos == 1 && *head != NULL) {
        temp1->next = *head;
        temp1->next->prev = temp1;
        *head = temp1;
    }
    else {
        Node* temp2 = *head;
        for (int i = 1; i < pos-1; i++) {
            temp2 = temp2->next;
        }
        temp1->next = temp2->next;
        temp1->next->prev = temp1;
        temp2->next = temp1;
        temp2->next->prev = temp2;
    }
}

int main() {
    Node* head = NULL; // 头节点
    Insert(&head, 1, 1);
    Insert(&head, 1, 2);
    Insert(&head, 1, 3);
    Insert(&head, 1, 4);
    Insert(&head, 1, 5);


}