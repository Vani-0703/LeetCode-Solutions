var maxEnvelopes=function(a){a.sort((x,y)=>x[0]-y[0]||y[1]-x[1]);let d=[];for(let [,h] of a){let l=0,r=d.length;while(l<r){let m=(l+r)>>1;if(d[m]<h)l=m+1;else r=m;}d[l]=h;}return d.length;};
