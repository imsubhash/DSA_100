#include "iostream"

using namespace std;

struct Node {
    int val;
    Node *next;

    Node(int val) {
        this->val = val;
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

Node *deleteFromList(Node *head, int val) {
    if (head->val == val) return head->next;
    Node *p = head;

    while (p->next != nullptr) {
        if (p->next->val == val) {
            Node *temp = p->next;
            p->next = p->next->next;
            delete temp;
        } else {
            p = p->next;
        }
    }
    return head;
}

int main() {
    Node *head = new Node(1);
    head->next = new Node(2);
    head->next->next = new Node(3);
    head->next->next->next = new Node(4);

    printList(head);
    head = deleteFromList(head, 4);
    printList(head);
    return 0;
}
