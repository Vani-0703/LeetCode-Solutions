var findTargetSumWays=function(a,t){let m=new Map([[0,1]]);for(let x of a){let n=new Map();for(let [s,c] of m){n.set(s+x,(n.get(s+x)||0)+c);n.set(s-x,(n.get(s-x)||0)+c);}m=n;}return m.get(t)||0;};
