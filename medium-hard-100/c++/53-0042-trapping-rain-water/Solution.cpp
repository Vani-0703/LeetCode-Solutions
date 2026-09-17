class Solution{public:int trap(vector<int>&a){int l=0,r=a.size()-1,L=0,R=0,z=0;while(l<r){if(a[l]<a[r]){L=max(L,a[l]);z+=L-a[l++];}else{R=max(R,a[r]);z+=R-a[r--];}}return z;}};
