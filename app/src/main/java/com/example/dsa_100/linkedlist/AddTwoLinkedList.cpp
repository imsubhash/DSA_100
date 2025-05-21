#include "iostream"

using namespace std;

struct Node {
    int val;
    Node *next;

    Node(int data) {
        this->val = data;
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

Node *createList(Node *head, int data) {
    Node *temp = head;
    Node *p = new Node(data);

    if (head == nullptr) {
        head = p;
    } else {
        while (temp->next != nullptr) {
            temp = temp->next;
        }
        temp->next = p;
    }
    return head;
}

Node *addTwoLists(Node *l1, Node *l2) {
    l1 = reverseList(l1);
    l2 = reverseList(l2);
    Node *l3 = nullptr;
    int sum = 0;
    int carry = 0;

    while (l1 || l2) {
        sum = (l1 ? l1->val : 0) + (l2 ? l2->val : 0) + carry;
        carry = sum / 10;
        l3 = createList(l3, sum % 10);
        if (l1) {
            l1 = l1->next;
        }
        if (l2) {
            l2 = l2->next;
        }
    }
    if (carry > 0) {
        l3 = createList(l3, carry);
    }
    return reverseList(l3);
}

int main() {

    Node *l1 = new Node(3);
    l1->next = new Node(4);
    l1->next->next = new Node(2);

    // Create second number: 465 (4 -> 6 -> 5)
    Node *l2 = new Node(4);
    l2->next = new Node(6);
    l2->next->next = new Node(5);

    cout << "First list: ";
    printList(l1);

    cout << "Second list: ";
    printList(l2);

    Node *result = addTwoLists(l1, l2);

    cout << "Result list: ";
    printList(result);

    return 0;

}