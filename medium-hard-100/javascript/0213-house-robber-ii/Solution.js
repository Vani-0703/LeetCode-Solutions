var rob=function(a){if(a.length==1)return a[0];let f=(l,r)=>{let x=0,y=0;for(let i=l;i<=r;i++)[x,y]=[y,Math.max(y,x+a[i])];return y};return Math.max(f(0,a.length-2),f(1,a.length-1));};
