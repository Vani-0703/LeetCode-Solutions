#include <bits/stdc++.h>
using namespace std;
class Solution { public:
 ListNode* mergeKLists(vector<ListNode*>&a){priority_queue<ListNode*,vector<ListNode*>,greater<ListNode*>>q;for(auto x:a)if(x)q.push(x);ListNode d(0),*c=&d;while(!q.empty()){auto x=q.top();q.pop();c->next=x;c=c->next;if(x->next)q.push(x->next);}return d.next;}
};
