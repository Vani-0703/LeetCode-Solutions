#include <bits/stdc++.h>
using namespace std;
class Solution { public:
 ListNode* reverseKGroup(ListNode*h,int k){ListNode d(0,h),*g=&d;while(1){ListNode*e=g;for(int i=0;i<k&&e;i++)e=e->next;if(!e)break;ListNode*n=g->next,*c=n->next;for(int i=1;i<k;i++){n->next=c->next;c->next=g->next;g->next=c;c=n->next;}g=n;}return d.next;}
};
