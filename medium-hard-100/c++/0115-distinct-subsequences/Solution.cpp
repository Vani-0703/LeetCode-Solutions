class Solution{public:int numDistinct(string s,string t){vector<unsigned long long>d(t.size()+1);d[0]=1;for(char c:s)for(int j=t.size();j>0;j--)if(c==t[j-1])d[j]+=d[j-1];return d.back();}};
