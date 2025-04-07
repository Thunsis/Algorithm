#include<stdio.h>
#define MAX_SIZE 101
int A[MAX_SIZE];
int top = -1;

void Push(int x) {
    if (top == MAX_SIZE - 1) {
        printf("Error: Stack overflow\n");
        return;
    } 
    A[++top] = x;
}

void Pop() {
    if (top == -1) {
        printf("There is no element to pop./n");
        return;
    }
    top--;
}

int Top() {
    return A[top];
}

bool IsEmpty() {
    return top == -1;
}

void Print() {
    printf("Stack: ");
    for (int i = 0; i <= top; i++) {
        printf("%d ", A[i]);
    }
    printf("\n");
}

int main() {

    Push(2); Print();
    Push(3); Print();
    Push(4); Print();
    Push(5); Print();

    Pop(); Print();
    Pop(); Print();
    printf("%d", Top());

}