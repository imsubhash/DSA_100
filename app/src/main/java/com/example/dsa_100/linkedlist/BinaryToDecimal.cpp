#include "iostream"
#include "math.h"

using namespace std;

struct Node {
    int val;
    Node *next;

    Node(int data) {
        this->val = data;
        this->next = nullptr;
    }
};

void printList(Node *head) {
    Node *p = head;
    while (p != nullptr) {
        cout << p->val << " ";
        p = p->next;
    }
    cout << endl;
}

int getCount(Node *head) {
    int count = 0;
    Node *p = head;
    while (p != nullptr) {
        count++;
        p = p->next;
    }
    return count;
}

int binaryToDecimal(Node *head) {
    int count = getCount(head);
    int result = 0;
    int position = count - 1;
    Node *temp = head;
    while (temp != nullptr) {
        result += temp->val * pow(2, position);
        temp = temp->next;
        position--;
    }
    return result;
}

int main() {
    Node *head = new Node(1);
    head->next = new Node(0);
    head->next->next = new Node(1);
    printList(head);
    int result = binaryToDecimal(head);
    cout << result << endl;
    return 0;
}