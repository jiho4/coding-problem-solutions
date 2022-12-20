/**
 * Day 15: Linked List
 * https://www.hackerrank.com/challenges/30-linked-list/submissions/code/43946342
 * solved: 2017-05-09
 */
#include <iostream>
#include <cstddef>
using namespace std;
class Node
{
    public:
        int data;
        Node *next;
        Node(int d){
            data=d;
            next=NULL;
        }
};
class Solution{
    public:
        Node* insert(Node *head,int data)
        {
            //Complete this method
            if (head == 0) {
                head = new Node(data);
            }
            else {
                Node* node = head;
                while (node->next != 0) {
                    node = node->next;
                }
                node->next = new Node(data);
            }

            return head;
        }
        void display(Node *head)
        {
            Node *start=head;
            while(start)
            {
                cout<<start->data<<" ";
                start=start->next;
            }
        }
};
int main()
{
	Node* head=NULL;
    Solution mylist;
    int T,data;
    cin>>T;
    while(T-->0){
        cin>>data;
        head=mylist.insert(head,data);
    }
	mylist.display(head);

}