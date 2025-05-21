#include "iostream"

using namespace std;

struct Node {
    int val;
    Node *next;

    Node(int data) : val(data), next(nullptr) {}
};

void printList(Node *head) {
    Node *temp = head;
    while (temp != nullptr) {
        cout << temp->val << " ";
        temp = temp->next;
    }
    cout << endl;
}

Node *reverseLinkedList(Node *head) {
    Node *prev = nullptr;
    Node *curr = head;
    Node *next = nullptr;

    while (curr != nullptr) {
        next = curr->next;
        curr->next = prev;
        prev = curr;
        curr = next;
    }

    return prev;
}

int main() {
    Node *head = new Node(1);
    head->next = new Node(2);
    head->next->next = new Node(3);
    head->next->next->next = new Node(4);

    cout << "Original List: ";
    printList(head);

    head = reverseLinkedList(head);

    cout << "Reversed List: ";
    printList(head);

}