#include <bits/stdc++.h>
using namespace std;
class Solution { public: ListNode* deleteDuplicates(ListNode*h){ListNode d(0,h),*p=&d;while(p->next){auto x=p->next;bool dup=0;while(x->next&&x->next->val==x->val)dup=1,x=x->next;if(dup)p->next=x->next;else p=p->next;}return d.next;} };
