#include "iostream"

using namespace std;

struct Node {
    int val;
    struct Node *next;

    Node(int data) : val(data), next(nullptr) {}
};

bool hasCycle(Node *head) {
    if (head == nullptr) return false;

    Node *slow = head;
    Node *fast = head;

    while (fast && fast->next) {
        slow = slow->next;
        fast = fast->next->next;
        if (fast == slow) return true;
    }
    return false;
}

int main() {
    Node* head = new Node(1);
    Node* second = new Node(2);
    Node* third = new Node(3);
    Node* fourth = new Node(4);

    head->next = second;
    second->next = third;
    third->next = fourth;
    fourth->next = second;

    if (hasCycle(head)) {
        cout << "Cycle detected!" << endl;
    } else {
        cout << "No cycle detected." << endl;
    }
}