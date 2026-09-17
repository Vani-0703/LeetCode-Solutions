var minCameraCover=function(root){let ans=0;function f(n){if(!n)return 1;let l=f(n.left),r=f(n.right);if(l==0||r==0){ans++;return 2;}return l==2||r==2?1:0;}return f(root)==0?ans+1:ans;};
