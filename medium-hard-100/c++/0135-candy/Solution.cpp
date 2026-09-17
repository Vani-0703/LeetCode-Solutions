class Solution{public:int candy(vector<int>&a){int n=a.size(),z=n;for(int i=1,c=1;i<n;i++)z+=a[i]>a[i-1]?c++:c=1;for(int i=n-2,c=1;i>=0;i--)if(a[i]>a[i+1])z+=max(++c-1,0);return z;}};
