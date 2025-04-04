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

void InsertAtHead(Node** head, int data) {
    Node* temp = GetNewNode(data);
    if (*head == NULL) {
        *head = temp;
    }
    else {
        (*head)->prev = temp;
        temp->next = *head;
        *head = temp;
    }
}

void InsertAtTail(Node** head, int data) {
    Node* temp1 = GetNewNode(data);
    if (*head == NULL) {
        InsertAtHead(head, data);

    } else {
        Node* temp2 = *head;
        while (temp2->next != NULL) {
            temp2 = temp2->next;
        }
        temp1->prev = temp2;
        temp2->next = temp1;
    }
}


void Print(Node* head) {
    Node* temp = head;
    while (temp != NULL) {
        printf("%d ", temp->data);
        temp = temp->next;
    }
    printf("\n");
}

void ReversePrint(Node* head) {
    Node* temp = head;
    if (temp == NULL) {
        return;
    }
    /* 遍历到最后一个节点 */
    while (temp->next != NULL) {
        temp = temp->next;
    }
    /* 从最后一个节点开始向前打印 */
    while (temp != NULL) {
        printf("%d ", temp->data);
        temp = temp->prev;
    }  
    printf("\n");
}

void Insert(Node** head, int pos, int data) {
    Node* temp1 = GetNewNode(data);
    if (pos == 1) {
        InsertAtHead(head, data);
    }
    else {
        Node* temp2 = *head;
        for (int i = 1; i < pos-1; i++) {
            temp2 = temp2->next;
        }
        if (temp2->next != NULL) {
            temp1->prev = temp2;
            temp1->next = temp2->next;
            temp2->next->prev = temp1;
            temp2->next = temp1;
        } else {
            InsertAtTail(head, data);
        }
    }
}

int main() {
    Node* head = NULL; // 头节点
    InsertAtHead(&head, 1);
    InsertAtHead(&head, 2);
    InsertAtHead(&head, 3);
    InsertAtHead(&head, 4);
    InsertAtHead(&head, 5);
    Insert(&head, 6, 6);
    Print(head);
    ReversePrint(head);


}
