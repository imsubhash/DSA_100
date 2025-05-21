
#include "iostream"

using namespace std;

struct Node {
    int val;
    Node *next;

    Node(int info) {
        this->val = info;
        this->next = nullptr;
    }
};

Node *reverseList(Node *head) {
    Node *curr = head;
    Node *prev = nullptr;
    Node *next = nullptr;

    while (curr) {
        next = curr->next;
        curr->next = prev;
        prev = curr;
        curr = next;
    }

    return prev;
}

void printList(Node *head) {
    Node *p = head;
    while (p != nullptr) {
        cout << p->val << " ";
        p = p->next;
    }
    cout << endl;
}

Node *addOne(Node *head) {
    Node *curr = head;
    int carry = 1;
    while (curr) {
        int sum = curr->val + carry;
        curr->val = sum % 10;
        carry = sum / 10;

        if (curr->next == nullptr && carry > 0) {
            curr->next = new Node(carry);
            break;
        }
        curr = curr->next;
    }

    return head;
}


int main() {
    Node *head = new Node(5);
    head->next = new Node(6);
    head->next->next = new Node(3);
    head->next->next->next = new Node(4);

    head = reverseList(head);
    head = addOne(head);
    head = reverseList(head);
    printList(head);


    return 0;
}