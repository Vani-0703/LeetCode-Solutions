var subarraySum=function(a,k){let m=new Map([[0,1]]),s=0,z=0;for(let x of a){s+=x;z+=m.get(s-k)||0;m.set(s,(m.get(s)||0)+1);}return z;};
