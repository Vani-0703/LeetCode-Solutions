var canPartition=function(a){let s=a.reduce((x,y)=>x+y,0);if(s%2)return false;let d=new Set([0]);for(let x of a)for(let v of [...d])if(v+x<=s/2)d.add(v+x);return d.has(s/2);};
