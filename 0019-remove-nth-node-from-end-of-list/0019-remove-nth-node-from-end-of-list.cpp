#include <bits/stdc++.h>
using namespace std;
class Solution { public:
 ListNode* removeNthFromEnd(ListNode* h,int n){ListNode d(0,h),*a=&d,*b=&d;while(n--)b=b->next;while(b->next)a=a->next,b=b->next;a->next=a->next->next;return d.next;}
};
