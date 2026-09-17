var longestValidParentheses=function(s){let st=[-1],ans=0;for(let i=0;i<s.length;i++){if(s[i]=='(')st.push(i);else{st.pop();if(!st.length)st.push(i);else ans=Math.max(ans,i-st.at(-1));}}return ans;};
