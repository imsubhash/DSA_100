#include <iostream>
#include <vector>

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

vector<Node *> splitListToParts(Node *head, int k) {
    vector < Node * > parts(k, nullptr);

    // Step 1: Count total nodes
    int n = 0;
    Node *curr = head;
    while (curr) {
        n++;
        curr = curr->next;
    }

    // Step 2 & 3: Calculate size and remainder
    int baseSize = n / k;
    int remainder = n % k;

    // Step 4: Split list
    curr = head;
    for (int i = 0; i < k; ++i) {
        parts[i] = curr;
        int partSize = baseSize + (i < remainder ? 1 : 0);
        for (int j = 0; j < partSize - 1; ++j) {
            if (curr) curr = curr->next;
        }
        if (curr) {
            Node *next = curr->next;
            curr->next = nullptr; // cut the link
            curr = next;
        }
    }

    return parts;
}

int main() {
    // Create linked list: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7
    Node *head = new Node(1);
    Node *curr = head;
    for (int i = 2; i <= 7; ++i) {
        curr->next = new Node(i);
        curr = curr->next;
    }

    printList(head);
    int k = 3;

    vector < Node * > parts = splitListToParts(head, k);

    cout << "Split into " << k << " parts:\n";
    for (int i = 0; i < parts.size(); ++i) {
        cout << "Part " << i + 1 << ": ";
        printList(parts[i]);
    }

    return 0;
}