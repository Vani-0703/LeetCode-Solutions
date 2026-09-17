#include <bits/stdc++.h>
using namespace std;
class Solution { public:
 double findMedianSortedArrays(vector<int>& a, vector<int>& b){ if(a.size()>b.size()) return findMedianSortedArrays(b,a); int m=a.size(),n=b.size(),l=0,r=m; while(l<=r){int i=(l+r)/2,j=(m+n+1)/2-i;int A=i? a[i-1]:INT_MIN,B=i<m?a[i]:INT_MAX,C=j?b[j-1]:INT_MIN,D=j<n?b[j]:INT_MAX;if(A<=D&&C<=B)return (m+n)%2?max(A,C):(max(A,C)+min(B,D))/2.0;if(A>D)r=i-1;else l=i+1;}return 0;}
};
