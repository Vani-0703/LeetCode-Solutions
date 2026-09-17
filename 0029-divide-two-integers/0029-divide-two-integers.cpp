#include <bits/stdc++.h>
using namespace std;
class Solution { public: int divide(int a,int b){if(a==INT_MIN&&b==-1)return INT_MAX;long long x=llabs((long long)a),y=llabs((long long)b),r=0;while(x>=y){long long q=y,c=1;while((q<<1)<=x)q<<=1,c<<=1;x-=q;r+=c;}return (a<0)^(b<0)?-r:r;} };
