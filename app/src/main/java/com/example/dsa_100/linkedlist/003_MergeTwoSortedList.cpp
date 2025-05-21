
#include "iostream"

using namespace std;

struct Node {
    int val;
    struct Node *next;

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


Node* mergeTwoLists(Node* list1, Node* list2) {
    if (!list1) return list2;
    if (!list2) return list1;

    if (list1->val < list2->val) {
        list1->next = mergeTwoLists(list1->next, list2);
        return list1;
    } else {
        list2->next = mergeTwoLists(list1, list2->next);
        return list2;
    }
}

Node *mergeTwoSortedList(Node *head1, Node *head2) {
    Node *dummy = new Node(0);
    Node *current = dummy;

    while (head1 && head2) {
        if (head1->val <= head2->val) {
            current->next = head1;
            head1 = head1->next;
        } else {
            current->next = head2;
            head2 = head2->next;
        }
        current = current->next;
    }

    if (head1) {
        current->next = head1;
    } else {
        current->next = head2;
    }

    Node *head = dummy->next;
    delete dummy;
    return head;
}

int main() {

    Node *head1 = new Node(1);
    head1->next = new Node(3);
    head1->next->next = new Node(5);
    head1->next->next->next = new Node(7);

    Node *head2 = new Node(2);
    head2->next = new Node(4);
    head2->next->next = new Node(6);
    head2->next->next->next = new Node(8);

    cout << "List 1: ";
    printList(head1);

    cout << "List 2: ";
    printList(head2);


    Node *head3 = mergeTwoLists(head1, head2);


    cout << "Merged List : ";
    printList(head3);

    return 0;
}