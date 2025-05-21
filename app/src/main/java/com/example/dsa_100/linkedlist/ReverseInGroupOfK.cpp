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

int getCount(Node *head) {
    int count = 0;
    Node *p = head;
    while (p != nullptr) {
        count++;
        p = p->next;
    }
    return count;
}

void printList(Node *head) {
    Node *p = head;
    while (p != nullptr) {
        cout << p->val << " ";
        p = p->next;
    }
    cout << endl;
}

Node* createLinkedList(int arr[], int size) {
    if (size == 0) return nullptr;
    Node* head = new Node(arr[0]);
    Node* current = head;
    for (int i = 1; i < size; i++) {
        current->next = new Node(arr[i]);
        current = current->next;
    }
    return head;
}

Node *reverseLinkedListInGroup(Node *head, int k) {
    if (!head) return nullptr;
    Node *prev = nullptr;
    Node *curr = head;
    Node *next = nullptr;

    int count = 0;
    while (curr != nullptr && count < k) {
        next = curr->next;
        curr->next = prev;
        prev = curr;
        curr = next;
        count++;
    }

    if (next != nullptr) {
        if (getCount(next) >= k) {
            head->next = reverseLinkedListInGroup(next, k);
        } else {
            head->next = next;
        }
    }

    return prev;
}

int main() {
    int arr1[] = {1, 2, 3, 4, 5, 6};
    Node* head = createLinkedList(arr1, 6);
    printList(head);
    head = reverseLinkedListInGroup(head, 3);
    printList(head);
    return 0;
}

