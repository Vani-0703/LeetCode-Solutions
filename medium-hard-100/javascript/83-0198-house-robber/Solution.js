var rob=function(a){let x=0,y=0;for(let v of a)[x,y]=[y,Math.max(y,x+v)];return y;};
