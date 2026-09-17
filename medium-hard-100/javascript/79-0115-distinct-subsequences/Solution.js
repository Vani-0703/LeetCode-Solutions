var numDistinct=function(s,t){let d=Array(t.length+1).fill(0);d[0]=1;for(let c of s)for(let j=t.length;j>0;j--)if(c==t[j-1])d[j]+=d[j-1];return d.at(-1);};
