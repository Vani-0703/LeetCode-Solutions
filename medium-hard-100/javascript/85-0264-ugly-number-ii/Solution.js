var nthUglyNumber=function(n){let d=[1],i=0,j=0,k=0;while(d.length<n){let x=Math.min(d[i]*2,d[j]*3,d[k]*5);d.push(x);if(x==d[i]*2)i++;if(x==d[j]*3)j++;if(x==d[k]*5)k++;}return d[n-1];};
