#include <bits/stdc++.h>
using namespace std;
class Solution { public: ListNode* reverseBetween(ListNode*h,int l,int r){ListNode d(0,h),*p=&d;for(int i=1;i<l;i++)p=p->next;ListNode*q=p->next;for(int i=0;i<r-l;i++){auto x=q->next;q->next=x->next;x->next=p->next;p->next=x;}return d.next;} };
