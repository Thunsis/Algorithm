#include<iostream>
#include<stack>
using namespace std;

struct Node
{
    /* head */
    int data;
    Node* next;
};

/* 在头部插入节点 main 方法的 head 不在 Insert和Print函数的作用域内无法被直接访问，所以需要传参数进去 */
void Insert(Node** head, int x) { // pass in the pointer of head, not actually the head node
    Node* temp = new Node();
    temp->data = x;
    temp->next = *head;
    *head = temp;
}

void Insert(Node** head, int pos, int x) {
    Node* temp1 = new Node();
    temp1->data = x;
    temp1->next = NULL;
    if ( pos == 1 ) {
        temp1->next = *head;
        *head = temp1;
        return;
    }
    Node* temp2 = *head;
    for ( int i = 0; i < pos - 2; i++ ) {
        temp2 = temp2->next;
    }
    temp1->next = temp2->next;
    temp2->next = temp1;
}


void Delete(Node** head, int pos) {
    Node* temp1 = *head;
    if ( pos == 1 ) {
        *head = temp1->next;
        delete temp1; // 释放内存
        return;
    }
    for ( int i = 0; i < pos - 2; i++ ) {
        temp1 = temp1->next;
    }
    Node* temp2 = temp1->next;
    temp1->next = temp2->next;
    delete temp2; // 释放内存
}




void Reverse(Node** head) {
    Node* prev = NULL;
    Node* current = *head;
    Node* next = NULL;
    while (current != NULL) {
        next = current->next;
        current->next = prev;
        prev=current;
        current=next;
    }
    *head = prev; 
}

// void ReverseRecursion(Node** head) {
//     Node* prev = NULL;
//     Node* current = *head;
//     Node* next = NULL;
//     if (current == NULL) {
//         *head = prev;
//         return;
//     }
//     next = current->next;
//     ReverseRecursion(&next);
//     current->next = prev;
//     prev=current;
//     current=next;
// }

void ReverseRecursion(Node** p) {
    // Base cases
    if (*p == NULL || (*p)->next == NULL) {
        return;
    }
    
    // Store the second node
    /*
        the last time that rest be assign value is in the deepest recursion, 
        where rest is the last node, rest won't be changed after that.
        So we can use rest to point to the last node
    */ 
    Node* rest = (*p)->next; 

    // Recursive call to reverse the rest of the list
    /*
        all the above will be executed before get returned from the deepest recursion
    */

    /* 
        the rest here will be passed to *p and are the previously passed rest values in stack, 
        after get returned from the deepest recursion, 
        *p is the historical rest value in the current recursion
        and the current rest is unchanged, always point to the last node
    */
    ReverseRecursion(&rest);          

    /*
        all the following will be executed after get returned from the deepest recursion
    */ 
    
    // Set the second node's next to point to first node
    /*
        *p is the historical rest value in the current recursion
    */
    (*p)->next->next = *p;
    
    // Set first node's next to NULL
    /*
        *p is the historical rest value in the current recursion
    */ 
    (*p)->next = NULL;
    
    // Update head to point to the last node
    /*
        *p is the historical rest value in the current recursion, 
        assign the value of the currect rest to *p, 
        so that the head can point to the last node
    */ 
    *p = rest;
}
// iteration迭代（循环）只需要一个临时变量，相对于recursion（递归）占用过多的stack空间，更推荐使用iteration迭代（循环）

void Print(Node* head) {
    Node* temp = head; // 临时节点遍历得到当前尾节点，不直接用head是不想失去头节点的引用
    printf("List is:");
    while ( temp != NULL ) {
        printf(" %d", temp->data);
        temp = temp->next;
    }
    printf("\n");
}

// reverse print 本身需要额外空间来存储所有元素，所以用递归是可以的，其他情况下，因为递归会占用过多的stack空间，不推荐使用

void ReversePrint(Node* p) {
    if ( p == NULL ){
        return;
    }
    ReversePrint(p->next);
    printf("%d ", p->data);
}

void ReverseByStack(Node** head) {
    if (*head == NULL) {
        return;
    }
    stack<Node*> S;
    Node* temp = *head;
    while (temp != NULL) {
        S.push(temp);
        temp = temp->next;
    }
    temp = S.top();
    *head = temp;
    S.pop();
    while (!S.empty()) {
        temp->next = S.top();
        S.pop();
        temp = temp->next;
    }
    temp->next = NULL;

}



int main()
{
    Node* head = NULL; // 头节点
    // printf("How many numbers?\n");
    // int n, x;
    // scanf("%d", &n);
    // for ( int i = 0; i < n; i++ ) {
    //     printf("Enter the number \n");
    //     scanf("%d", &x);
    //     Insert(&head, x); // pass in the pointer of head, not actually the head node
    //     Print(head);
    // }
    // int pos;
    // printf("Where is the insert pos?\n");
    // scanf("%d", &pos);
    // printf("Enter the number \n");
    // scanf("%d", &x);

    Insert(&head, 1, 1);
    Insert(&head, 1, 2);
    Insert(&head, 1, 3);
    Insert(&head, 1, 4);
    Insert(&head, 1, 5);
    Print(head);

    Delete(&head, 1);

    Print(head);
    Reverse(&head);
    Print(head);

    ReverseRecursion(&head);
    Print(head);

    ReverseByStack(&head);
    Print(head);

}