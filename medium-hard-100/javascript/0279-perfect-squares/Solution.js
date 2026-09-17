var numSquares=function(n){let d=Array(n+1).fill(Infinity);d[0]=0;for(let i=1;i<=n;i++)for(let j=1;j*j<=i;j++)d[i]=Math.min(d[i],d[i-j*j]+1);return d[n];};
