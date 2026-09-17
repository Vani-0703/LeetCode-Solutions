import java.util.*;

/**
 * 100 curated LeetCode solutions / reference implementations.
 * Java 17. Methods are named p001 ... p100 to keep all examples in one file.
 */
public class LeetCode100 {
    static class ListNode { int val; ListNode next; ListNode(){} ListNode(int v){val=v;} ListNode(int v,ListNode n){val=v;next=n;} }
    static class TreeNode { int val; TreeNode left,right; TreeNode(int v){val=v;} }

    // 1 Two Sum
    static int[] p001(int[] a,int t){Map<Integer,Integer> m=new HashMap<>();for(int i=0;i<a.length;i++){int x=t-a[i];if(m.containsKey(x))return new int[]{m.get(x),i};m.put(a[i],i);}return new int[0];}
    // 2 Add Two Numbers
    static ListNode p002(ListNode a,ListNode b){ListNode d=new ListNode(0),c=d;int carry=0;while(a!=null||b!=null||carry>0){int s=carry+(a==null?0:a.val)+(b==null?0:b.val);c.next=new ListNode(s%10);c=c.next;carry=s/10;if(a!=null)a=a.next;if(b!=null)b=b.next;}return d.next;}
    // 3 Longest Substring Without Repeating Characters
    static int p003(String s){int[] last=new int[128];Arrays.fill(last,-1);int l=0,r=0;for(int i=0;i<s.length();i++){l=Math.max(l,last[s.charAt(i)]+1);last[s.charAt(i)]=i;r=Math.max(r,i-l+1);}return r;}
    // 4 Median of Two Sorted Arrays
    static double p004(int[] a,int[] b){if(a.length>b.length)return p004(b,a);int m=a.length,n=b.length,lo=0,hi=m;while(lo<=hi){int i=(lo+hi)/2,j=(m+n+1)/2-i;int al=i==0?Integer.MIN_VALUE:a[i-1],ar=i==m?Integer.MAX_VALUE:a[i],bl=j==0?Integer.MIN_VALUE:b[j-1],br=j==n?Integer.MAX_VALUE:b[j];if(al<=br&&bl<=ar)return((m+n)%2==1)?Math.max(al,bl):(Math.max(al,bl)+Math.min(ar,br))/2.0;if(al>br)hi=i-1;else lo=i+1;}return 0;}
    // 5 Longest Palindromic Substring
    static String p005(String s){if(s.length()<2)return s;int st=0,en=0;for(int i=0;i<s.length();i++){int a=expand(s,i,i),b=expand(s,i,i+1),len=Math.max(a,b);if(len>en-st+1){st=i-(len-1)/2;en=i+len/2;}}return s.substring(st,en+1);}static int expand(String s,int l,int r){while(l>=0&&r<s.length()&&s.charAt(l)==s.charAt(r)){l--;r++;}return r-l-1;}
    // 6 Zigzag Conversion
    static String p006(String s,int rows){if(rows==1||rows>=s.length())return s;StringBuilder[] z=new StringBuilder[rows];for(int i=0;i<rows;i++)z[i]=new StringBuilder();int r=0,d=1;for(char c:s.toCharArray()){z[r].append(c);if(r==0)d=1;if(r==rows-1)d=-1;r+=d;}StringBuilder x=new StringBuilder();for(StringBuilder q:z)x.append(q);return x.toString();}
    // 7 Reverse Integer
    static int p007(int x){long r=0;while(x!=0){r=r*10+x%10;x/=10;}return r<Integer.MIN_VALUE||r>Integer.MAX_VALUE?0:(int)r;}
    // 8 String to Integer
    static int p008(String s){int i=0,n=s.length();while(i<n&&s.charAt(i)==' ')i++;int sign=1;if(i<n&&(s.charAt(i)=='+'||s.charAt(i)=='-')){if(s.charAt(i++)=='-')sign=-1;}long r=0;while(i<n&&Character.isDigit(s.charAt(i))){r=r*10+s.charAt(i++)-'0';if(sign*r>Integer.MAX_VALUE)return Integer.MAX_VALUE;if(sign*r<Integer.MIN_VALUE)return Integer.MIN_VALUE;}return(int)(sign*r);}
    // 9 Palindrome Number
    static boolean p009(int x){if(x<0)return false;int y=x,r=0;while(y>0){r=r*10+y%10;y/=10;}return r==x;}
    // 10 Regular Expression Matching
    static boolean p010(String s,String p){Boolean[][] m=new Boolean[s.length()+1][p.length()+1];return re(s,p,0,0,m);}static boolean re(String s,String p,int i,int j,Boolean[][]m){if(j==p.length())return i==s.length();if(m[i][j]!=null)return m[i][j];boolean f=i<s.length()&&(p.charAt(j)=='.'||p.charAt(j)==s.charAt(i));boolean a=j+1<p.length()&&p.charAt(j+1)=='*';return m[i][j]=a&&(re(s,p,i,j+2)||(f&&re(s,p,i+1,j)))||f&&re(s,p,i+1,j+1);}
    // 11 Container With Most Water
    static int p011(int[] h){int l=0,r=h.length-1,b=0;while(l<r){b=Math.max(b,Math.min(h[l],h[r])*(r-l));if(h[l]<h[r])l++;else r--;}return b;}
    // 12 Integer to Roman
    static String p012(int n){int[] v={1000,900,500,400,100,90,50,40,10,9,5,4,1};String[] z={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};StringBuilder s=new StringBuilder();for(int i=0;i<v.length;i++)while(n>=v[i]){n-=v[i];s.append(z[i]);}return s.toString();}
    // 13 Roman to Integer
    static int p013(String s){Map<Character,Integer>m=Map.of('I',1,'V',5,'X',10,'L',50,'C',100,'D',500,'M',1000);int r=0;for(int i=0;i<s.length();i++)r+=i+1<s.length()&&m.get(s.charAt(i))<m.get(s.charAt(i+1))?-m.get(s.charAt(i)):m.get(s.charAt(i));return r;}
    // 14 Longest Common Prefix
    static String p014(String[] a){if(a.length==0)return "";String x=a[0];for(int i=1;i<a.length;i++)while(!a[i].startsWith(x))x=x.substring(0,x.length()-1);return x;}
    // 15 3Sum
    static List<List<Integer>> p015(int[] a){Arrays.sort(a);List<List<Integer>>r=new ArrayList<>();for(int i=0;i<a.length-2;i++){if(i>0&&a[i]==a[i-1])continue;int l=i+1,h=a.length-1;while(l<h){int s=a[i]+a[l]+a[h];if(s==0){r.add(List.of(a[i],a[l],a[h]));while(l<h&&a[l]==a[l+1])l++;while(l<h&&a[h]==a[h-1])h--;l++;h--;}else if(s<0)l++;else h--;}}return r;}
    // 16 3Sum Closest
    static int p016(int[] a,int t){Arrays.sort(a);int best=a[0]+a[1]+a[2];for(int i=0;i<a.length-2;i++){int l=i+1,r=a.length-1;while(l<r){int s=a[i]+a[l]+a[r];if(Math.abs(s-t)<Math.abs(best-t))best=s;if(s<t)l++;else if(s>t)r--;else return s;}}return best;}
    // 17 Letter Combinations of a Phone Number
    static List<String> p017(String s){String[]d={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};List<String>r=new ArrayList<>();if(!s.isEmpty())phone(s,0,new StringBuilder(),r,d);return r;}static void phone(String s,int i,StringBuilder b,List<String>r,String[]d){if(i==s.length()){r.add(b.toString());return;}for(char c:d[s.charAt(i)-'0'].toCharArray()){b.append(c);phone(s,i+1,b,r,d);b.deleteCharAt(b.length()-1);}}
    // 18 4Sum
    static List<List<Integer>> p018(int[]a,int t){Arrays.sort(a);List<List<Integer>>r=new ArrayList<>();for(int i=0;i<a.length-3;i++){if(i>0&&a[i]==a[i-1])continue;for(int j=i+1;j<a.length-2;j++){if(j>i+1&&a[j]==a[j-1])continue;int l=j+1,h=a.length-1;while(l<h){long s=(long)a[i]+a[j]+a[l]+a[h];if(s==t){r.add(List.of(a[i],a[j],a[l],a[h]));while(l<h&&a[l]==a[l+1])l++;while(l<h&&a[h]==a[h-1])h--;l++;h--;}else if(s<t)l++;else h--;}}}return r;}
    // 19 Remove Nth Node From End
    static ListNode p019(ListNode h,int n){ListNode d=new ListNode(0,h),a=d,b=d;for(int i=0;i<n;i++)b=b.next;while(b.next!=null){a=a.next;b=b.next;}a.next=a.next.next;return d.next;}
    // 20 Valid Parentheses
    static boolean p020(String s){Deque<Character>q=new ArrayDeque<>();for(char c:s.toCharArray()){if(c=='('||c=='['||c=='{')q.push(c);else if(q.isEmpty()||c==')'&&q.pop()!='('||c==']'&&q.pop()!='['||c=='}'&&q.pop()!='{')return false;}return q.isEmpty();}
    // 21 Merge Two Sorted Lists
    static ListNode p021(ListNode a,ListNode b){ListNode d=new ListNode(),c=d;while(a!=null&&b!=null){if(a.val<b.val){c.next=a;a=a.next;}else{c.next=b;b=b.next;}c=c.next;}c.next=a!=null?a:b;return d.next;}
    // 22 Generate Parentheses
    static List<String> p022(int n){List<String>r=new ArrayList<>();gp(n,0,0,new StringBuilder(),r);return r;}static void gp(int n,int o,int c,StringBuilder b,List<String>r){if(b.length()==2*n){r.add(b.toString());return;}if(o<n){b.append('(');gp(n,o+1,c,b,r);b.deleteCharAt(b.length()-1);}if(c<o){b.append(')');gp(n,o,c+1,b,r);b.deleteCharAt(b.length()-1);}}
    // 23 Merge k Sorted Lists
    static ListNode p023(ListNode[]a){PriorityQueue<ListNode>q=new PriorityQueue<>(Comparator.comparingInt(x->x.val));for(ListNode n:a)if(n!=null)q.add(n);ListNode d=new ListNode(),c=d;while(!q.isEmpty()){ListNode n=q.poll();c.next=n;c=c.next;if(n.next!=null)q.add(n.next);}return d.next;}
    // 24 Swap Nodes in Pairs
    static ListNode p024(ListNode h){ListNode d=new ListNode(0,h);for(ListNode p=d;p.next!=null&&p.next.next!=null;p=p.next.next){ListNode a=p.next,b=a.next;a.next=b.next;b.next=a;p.next=b;}return d.next;}
    // 25 Reverse Nodes in k-Group
    static ListNode p025(ListNode h,int k){ListNode d=new ListNode(0,h),g=d;while(true){ListNode e=g;for(int i=0;i<k&&e!=null;i++)e=e.next;if(e==null)break;ListNode n=g.next,cur=n.next;for(int i=1;i<k;i++){n.next=cur.next;cur.next=g.next;g.next=cur;cur=n.next;}g=n;}return d.next;}
    // 26 Remove Duplicates from Sorted Array
    static int p026(int[]a){if(a.length==0)return 0;int k=1;for(int i=1;i<a.length;i++)if(a[i]!=a[k-1])a[k++]=a[i];return k;}
    // 27 Remove Element
    static int p027(int[]a,int v){int k=0;for(int x:a)if(x!=v)a[k++]=x;return k;}
    // 28 Find Index of First Occurrence
    static int p028(String h,String n){return h.indexOf(n);}
    // 29 Divide Two Integers
    static int p029(int a,int b){if(a==Integer.MIN_VALUE&&b==-1)return Integer.MAX_VALUE;long x=Math.abs((long)a),y=Math.abs((long)b),r=0;while(x>=y){long q=y,k=1;while((q<<1)<=x){q<<=1;k<<=1;}x-=q;r+=k;}return(int)(((a<0)^(b<0))?-r:r);}
    // 30 Substring with Concatenation of All Words
    static List<Integer> p030(String s,String[]w){List<Integer>r=new ArrayList<>();if(w.length==0)return r;int L=w[0].length(),need=w.length*L;Map<String,Integer>base=new HashMap<>();for(String x:w)base.merge(x,1,Integer::sum);for(int st=0;st<L;st++){int l=st,c=0;Map<String,Integer>m=new HashMap<>();for(int j=st;j+L<=s.length();j+=L){String x=s.substring(j,j+L);if(!base.containsKey(x)){m.clear();c=0;l=j+L;continue;}m.merge(x,1,Integer::sum);c++;while(m.get(x)>base.get(x)){String y=s.substring(l,l+L);m.merge(y,-1,Integer::sum);l+=L;c--;}if(c==w.length){r.add(l);String y=s.substring(l,l+L);m.merge(y,-1,Integer::sum);l+=L;c--;}}}return r;}
    // 31 Next Permutation
    static void p031(int[]a){int i=a.length-2;while(i>=0&&a[i]>=a[i+1])i--;if(i>=0){int j=a.length-1;while(a[j]<=a[i])j--;int t=a[i];a[i]=a[j];a[j]=t;}for(int l=i+1,r=a.length-1;l<r;l++,r--){int t=a[l];a[l]=a[r];a[r]=t;}}
    // 32 Longest Valid Parentheses
    static int p032(String s){Deque<Integer>q=new ArrayDeque<>();q.push(-1);int b=0;for(int i=0;i<s.length();i++){if(s.charAt(i)=='(')q.push(i);else{q.pop();if(q.isEmpty())q.push(i);else b=Math.max(b,i-q.peek());}}return b;}
    // 33 Search in Rotated Sorted Array
    static int p033(int[]a,int t){int l=0,r=a.length-1;while(l<=r){int m=(l+r)>>>1;if(a[m]==t)return m;if(a[l]<=a[m]){if(a[l]<=t&&t<a[m])r=m-1;else l=m+1;}else{if(a[m]<t&&t<=a[r])l=m+1;else r=m-1;}}return -1;}
    // 34 Find First and Last Position
    static int[] p034(int[]a,int t){int l=lb(a,t),r=lb(a,t+1)-1;return l<a.length&&a[l]==t?new int[]{l,r}:new int[]{-1,-1};}static int lb(int[]a,int t){int l=0,r=a.length;while(l<r){int m=(l+r)>>>1;if(a[m]<t)l=m+1;else r=m;}return l;}
    // 35 Search Insert Position
    static int p035(int[]a,int t){return lb(a,t);}
    // 36 Valid Sudoku
    static boolean p036(char[][]b){for(int i=0;i<9;i++){boolean[]r=new boolean[9],c=new boolean[9];for(int j=0;j<9;j++){if(b[i][j]!='.'&&(r[b[i][j]-'1']||((r[b[i][j]-'1']=true))))return false;if(b[j][i]!='.'&&(c[b[j][i]-'1']||((c[b[j][i]-'1']=true))))return false;}}for(int x=0;x<9;x+=3)for(int y=0;y<9;y+=3){boolean[]z=new boolean[9];for(int i=x;i<x+3;i++)for(int j=y;j<y+3;j++)if(b[i][j]!='.'&&(z[b[i][j]-'1']||((z[b[i][j]-'1']=true))))return false;}return true;}
    // 37 Sudoku Solver
    static void p037(char[][]b){solveSudoku(b);}static boolean solveSudoku(char[][]b){for(int i=0;i<9;i++)for(int j=0;j<9;j++)if(b[i][j]=='.')for(char c='1';c<='9';c++)if(ok(b,i,j,c)){b[i][j]=c;if(solveSudoku(b))return true;b[i][j]='.';}else{}for(char[]r:b)for(char c:r)if(c=='.')return false;return true;}static boolean ok(char[][]b,int r,int c,char x){for(int i=0;i<9;i++)if(b[r][i]==x||b[i][c]==x||b[r/3*3+i/3][c/3*3+i%3]==x)return false;return true;}
    // 38 Count and Say
    static String p038(int n){String s="1";for(int k=1;k<n;k++){StringBuilder b=new StringBuilder();for(int i=0;i<s.length();){int j=i;while(j<s.length()&&s.charAt(j)==s.charAt(i))j++;b.append(j-i).append(s.charAt(i));i=j;}s=b.toString();}return s;}
    // 39 Combination Sum
    static List<List<Integer>> p039(int[]a,int t){Arrays.sort(a);List<List<Integer>>r=new ArrayList<>();cs(a,t,0,new ArrayList<>(),r);return r;}static void cs(int[]a,int t,int st,List<Integer>q,List<List<Integer>>r){if(t==0){r.add(new ArrayList<>(q));return;}for(int i=st;i<a.length&&a[i]<=t;i++){q.add(a[i]);cs(a,t-a[i],i,q,r);q.remove(q.size()-1);}}
    // 40 Combination Sum II
    static List<List<Integer>> p040(int[]a,int t){Arrays.sort(a);List<List<Integer>>r=new ArrayList<>();cs2(a,t,0,new ArrayList<>(),r);return r;}static void cs2(int[]a,int t,int st,List<Integer>q,List<List<Integer>>r){if(t==0){r.add(new ArrayList<>(q));return;}for(int i=st;i<a.length&&a[i]<=t;i++){if(i>st&&a[i]==a[i-1])continue;q.add(a[i]);cs2(a,t-a[i],i+1,q,r);q.remove(q.size()-1);}}
    // 41 First Missing Positive
    static int p041(int[]a){for(int i=0;i<a.length;i++)while(a[i]>0&&a[i]<=a.length&&a[a[i]-1]!=a[i]){int t=a[i];a[i]=a[t-1];a[t-1]=t;}for(int i=0;i<a.length;i++)if(a[i]!=i+1)return i+1;return a.length+1;}
    // 42 Trapping Rain Water
    static int p042(int[]a){int l=0,r=a.length-1,ml=0,mr=0,res=0;while(l<r){if(a[l]<a[r]){ml=Math.max(ml,a[l]);res+=ml-a[l++];}else{mr=Math.max(mr,a[r]);res+=mr-a[r--];}}return res;}
    // 43 Multiply Strings
    static String p043(String a,String b){if(a.equals("0")||b.equals("0"))return "0";int[]v=new int[a.length()+b.length()];for(int i=a.length()-1;i>=0;i--)for(int j=b.length()-1;j>=0;j--){int k=i+j+1,x=(a.charAt(i)-'0')*(b.charAt(j)-'0')+v[k];v[k]=x%10;v[k-1]+=x/10;}StringBuilder s=new StringBuilder();int i=0;while(i<v.length&&v[i]==0)i++;while(i<v.length)s.append(v[i++]);return s.toString();}
    // 44 Wildcard Matching
    static boolean p044(String s,String p){boolean[]d=new boolean[p.length()+1];d[0]=true;for(int j=1;j<=p.length();j++)d[j]=d[j-1]&&p.charAt(j-1)=='*';for(int i=1;i<=s.length();i++){boolean prev=d[0];d[0]=false;for(int j=1;j<=p.length();j++){boolean old=d[j];d[j]=p.charAt(j-1)=='*'?d[j-1]:((p.charAt(j-1)=='?'||p.charAt(j-1)==s.charAt(i-1))&&prev);prev=old;}}return d[p.length()];}
    // 45 Jump Game II
    static int p045(int[]a){int end=0,far=0,j=0;for(int i=0;i<a.length-1;i++){far=Math.max(far,i+a[i]);if(i==end){j++;end=far;}}return j;}
    // 46 Permutations
    static List<List<Integer>> p046(int[]a){List<List<Integer>>r=new ArrayList<>();perm(a,0,r);return r;}static void perm(int[]a,int i,List<List<Integer>>r){if(i==a.length){List<Integer>x=new ArrayList<>();for(int v:a)x.add(v);r.add(x);return;}for(int j=i;j<a.length;j++){int t=a[i];a[i]=a[j];a[j]=t;perm(a,i+1,r);t=a[i];a[i]=a[j];a[j]=t;}}
    // 47 Permutations II
    static List<List<Integer>> p047(int[]a){Arrays.sort(a);List<List<Integer>>r=new ArrayList<>();p47(a,new boolean[a.length],new ArrayList<>(),r);return r;}static void p47(int[]a,boolean[]u,List<Integer>q,List<List<Integer>>r){if(q.size()==a.length){r.add(new ArrayList<>(q));return;}for(int i=0;i<a.length;i++){if(u[i]||(i>0&&a[i]==a[i-1]&&!u[i-1]))continue;u[i]=true;q.add(a[i]);p47(a,u,q,r);q.remove(q.size()-1);u[i]=false;}}
    // 48 Rotate Image
    static void p048(int[][]a){int n=a.length;for(int i=0;i<n;i++)for(int j=i;j<n;j++){int t=a[i][j];a[i][j]=a[j][i];a[j][i]=t;}for(int[]r:a)for(int l=0,h=n-1;l<h;l++,h--){int t=r[l];r[l]=r[h];r[h]=t;}}
    // 49 Group Anagrams
    static List<List<String>> p049(String[]a){Map<String,List<String>>m=new HashMap<>();for(String s:a){char[]c=s.toCharArray();Arrays.sort(c);m.computeIfAbsent(new String(c),k->new ArrayList<>()).add(s);}return new ArrayList<>(m.values());}
    // 50 Pow(x,n)
    static double p050(double x,int n){long e=n;double r=1;if(e<0){x=1/x;e=-e;}while(e>0){if((e&1)==1)r*=x;x*=x;e>>=1;}return r;}
    // 51 N-Queens
    static List<List<String>> p051(int n){List<List<String>>r=new ArrayList<>();int[]q=new int[n];Arrays.fill(q,-1);nq(0,n,q,r);return r;}static void nq(int row,int n,int[]q,List<List<String>>r){if(row==n){List<String>x=new ArrayList<>();for(int v:q){char[]c=new char[n];Arrays.fill(c,'.');c[v]='Q';x.add(new String(c));}r.add(x);return;}for(int c=0;c<n;c++){boolean ok=true;for(int i=0;i<row;i++)if(q[i]==c||Math.abs(q[i]-c)==row-i){ok=false;break;}if(ok){q[row]=c;nq(row+1,n,q,r);q[row]=-1;}}}
    // 52 N-Queens II
    static int p052(int n){return n==0?1:nq2(0,n,0,0,0);}static int nq2(int r,int n,int col,int d1,int d2){if(r==n)return 1;int ans=0,mask=(1<<n)-1,avail=mask&~(col|d1|d2);while(avail!=0){int bit=avail&-avail;avail-=bit;ans+=nq2(r+1,n,col|bit,(d1|bit)<<1,(d2|bit)>>1);}return ans;}
    // 53 Maximum Subarray
    static int p053(int[]a){int cur=a[0],best=a[0];for(int i=1;i<a.length;i++){cur=Math.max(a[i],cur+a[i]);best=Math.max(best,cur);}return best;}
    // 54 Spiral Matrix
    static List<Integer> p054(int[][]a){List<Integer>r=new ArrayList<>();int t=0,b=a.length-1,l=0,h=a[0].length-1;while(t<=b&&l<=h){for(int j=l;j<=h;j++)r.add(a[t][j]);t++;for(int i=t;i<=b;i++)r.add(a[i][h]);h--;if(t<=b)for(int j=h;j>=l;j--)r.add(a[b][j]);b--;if(l<=h)for(int i=b;i>=t;i--)r.add(a[i][l]);l++;}return r;}
    // 55 Jump Game
    static boolean p055(int[]a){int far=0;for(int i=0;i<a.length;i++){if(i>far)return false;far=Math.max(far,i+a[i]);}return true;}
    // 56 Merge Intervals
    static int[][] p056(int[][]a){if(a.length==0)return a;Arrays.sort(a,Comparator.comparingInt(x->x[0]));List<int[]>r=new ArrayList<>();int s=a[0][0],e=a[0][1];for(int i=1;i<a.length;i++){if(a[i][0]<=e)e=Math.max(e,a[i][1]);else{r.add(new int[]{s,e});s=a[i][0];e=a[i][1];}}r.add(new int[]{s,e});return r.toArray(new int[0][]);}
    // 57 Insert Interval
    static int[][] p057(int[][]a,int[]n){List<int[]>r=new ArrayList<>();int i=0;while(i<a.length&&a[i][1]<n[0])r.add(a[i++]);while(i<a.length&&a[i][0]<=n[1]){n[0]=Math.min(n[0],a[i][0]);n[1]=Math.max(n[1],a[i++][1]);}r.add(n);while(i<a.length)r.add(a[i++]);return r.toArray(new int[0][]);}
    // 58 Length of Last Word
    static int p058(String s){int i=s.length()-1;while(i>=0&&s.charAt(i)==' ')i--;int n=0;while(i>=0&&s.charAt(i)!=' '){n++;i--;}return n;}
    // 59 Spiral Matrix II
    static int[][] p059(int n){int[][]a=new int[n][n];int v=1,t=0,b=n-1,l=0,r=n-1;while(t<=b){for(int j=l;j<=r;j++)a[t][j]=v++;t++;for(int i=t;i<=b;i++)a[i][r]=v++;r--;if(t<=b)for(int j=r;j>=l;j--)a[b][j]=v++;b--;if(l<=r)for(int i=b;i>=t;i--)a[i][l]=v++;l++;}return a;}
    // 60 Permutation Sequence
    static String p060(int n,int k){List<Integer>a=new ArrayList<>();for(int i=1;i<=n;i++)a.add(i);k--;int[]f=new int[n];f[0]=1;for(int i=1;i<n;i++)f[i]=f[i-1]*i;StringBuilder s=new StringBuilder();for(int i=n;i>=1;i--){int x=k/f[i-1];k%=f[i-1];s.append(a.remove(x));}return s.toString();}
    // 61 Rotate List
    static ListNode p061(ListNode h,int k){if(h==null||h.next==null)return h;int n=1;ListNode t=h;while(t.next!=null){t=t.next;n++;}k%=n;if(k==0)return h;t.next=h;for(int i=0;i<n-k;i++)t=t.next;ListNode r=t.next;t.next=null;return r;}
    // 62 Unique Paths
    static int p062(int m,int n){long x=1;for(int i=1;i<n;i++)x=x*(m-1+i)/i;return(int)x;}
    // 63 Unique Paths II
    static int p063(int[][]g){int n=g[0].length;int[]d=new int[n];d[0]=1;for(int[]r:g)for(int j=0;j<n;j++)if(r[j]==1)d[j]=0;else if(j>0)d[j]+=d[j-1];return d[n-1];}
    // 64 Minimum Path Sum
    static int p064(int[][]g){for(int i=0;i<g.length;i++)for(int j=0;j<g[0].length;j++)if(i+j>0)g[i][j]+=Math.min(i>0?g[i-1][j]:Integer.MAX_VALUE,j>0?g[i][j-1]:Integer.MAX_VALUE);return g[g.length-1][g[0].length-1];}
    // 65 Valid Number
    static boolean p065(String s){s=s.trim();try{if(s.isEmpty()||s.matches(".*[fFdD]$"))return false;Double.parseDouble(s);return s.matches("[+-]?(?:(?:\\d+\\.?\\d*)|(?:\\.\\d+))(?:[eE][+-]?\\d+)?");}catch(Exception e){return false;}}
    // 66 Plus One
    static int[] p066(int[]a){for(int i=a.length-1;i>=0;i--)if(++a[i]<10)return a;int[]r=new int[a.length+1];r[0]=1;return r;}
    // 67 Add Binary
    static String p067(String a,String b){StringBuilder s=new StringBuilder();int i=a.length()-1,j=b.length()-1,c=0;while(i>=0||j>=0||c>0){int x=i>=0?a.charAt(i--)-'0':0,y=j>=0?b.charAt(j--)-'0':0,z=x+y+c;s.append(z%2);c=z/2;}return s.reverse().toString();}
    // 68 Text Justification
    static List<String> p068(String[]w,int mw){List<String>r=new ArrayList<>();for(int i=0;i<w.length;){int j=i,len=0;while(j<w.length&&len+w[j].length()+(j-i)<=mw){len+=w[j++].length();}int gaps=j-i-1;StringBuilder s=new StringBuilder();if(j==w.length||gaps==0){for(int k=i;k<j;k++){if(k>i)s.append(' ');s.append(w[k]);}while(s.length()<mw)s.append(' ');}else{int spaces=(mw-len)/gaps,extra=(mw-len)%gaps;for(int k=i;k<j;k++){if(k>i){s.append(" ".repeat(spaces+(k-i<=extra?1:0)));}s.append(w[k]);}}r.add(s.toString());i=j;}return r;}
    // 69 Sqrt(x)
    static int p069(int x){if(x<2)return x;long l=1,r=x/2;while(l<=r){long m=(l+r)/2;if(m*m==x)return(int)m;if(m*m<x)l=m+1;else r=m-1;}return(int)r;}
    // 70 Climbing Stairs
    static int p070(int n){int a=1,b=1;for(int i=0;i<n;i++){int t=a;a=b;b+=t;}return a;}
    // 71 Simplify Path
    static String p071(String s){Deque<String>q=new ArrayDeque<>();for(String x:s.split("/")){if(x.isEmpty()||x.equals("."))continue;if(x.equals("..")){if(!q.isEmpty())q.pop();}else q.push(x);}StringBuilder r=new StringBuilder();for(String x:q)r.insert(0,"/"+x);return r.length()==0?"/":r.toString();}
    // 72 Edit Distance
    static int p072(String a,String b){int[]d=new int[b.length()+1];for(int j=0;j<=b.length();j++)d[j]=j;for(int i=1;i<=a.length();i++){int prev=d[0];d[0]=i;for(int j=1;j<=b.length();j++){int old=d[j];d[j]=a.charAt(i-1)==b.charAt(j-1)?prev:1+Math.min(prev,Math.min(d[j],d[j-1]));prev=old;}}return d[b.length()];}
    // 73 Set Matrix Zeroes
    static void p073(int[][]a){int m=a.length,n=a[0].length;boolean r=false,c=false;for(int i=0;i<m;i++)for(int j=0;j<n;j++)if(a[i][j]==0){if(i==0)r=true;if(j==0)c=true;a[i][0]=a[0][j]=0;}for(int i=1;i<m;i++)for(int j=1;j<n;j++)if(a[i][0]==0||a[0][j]==0)a[i][j]=0;if(r)Arrays.fill(a[0],0);if(c)for(int[]x:a)x[0]=0;}
    // 74 Search a 2D Matrix
    static boolean p074(int[][]a,int t){int m=a.length,n=a[0].length,l=0,r=m*n-1;while(l<=r){int x=(l+r)>>>1,v=a[x/n][x%n];if(v==t)return true;if(v<t)l=x+1;else r=x-1;}return false;}
    // 75 Sort Colors
    static void p075(int[]a){int l=0,m=0,r=a.length-1;while(m<=r){if(a[m]==0){int t=a[l];a[l++]=a[m];a[m++]=t;}else if(a[m]==2){int t=a[r];a[r--]=a[m];a[m]=t;}else m++;}}
    // 76 Minimum Window Substring
    static String p076(String s,String t){int[]c=new int[128];for(char x:t.toCharArray())c[x]++;int need=t.length(),l=0,bs=0,bl=Integer.MAX_VALUE;for(int r=0;r<s.length();r++){if(c[s.charAt(r)]-->0)need--;while(need==0){if(r-l+1<bl){bl=r-l+1;bs=l;}if(++c[s.charAt(l++)]>0)need++;}}return bl==Integer.MAX_VALUE?"":s.substring(bs,bs+bl);}
    // 77 Combinations
    static List<List<Integer>> p077(int n,int k){List<List<Integer>>r=new ArrayList<>();comb(1,n,k,new ArrayList<>(),r);return r;}static void comb(int st,int n,int k,List<Integer>q,List<List<Integer>>r){if(q.size()==k){r.add(new ArrayList<>(q));return;}for(int i=st;i<=n;i++){q.add(i);comb(i+1,n,k,q,r);q.remove(q.size()-1);}}
    // 78 Subsets
    static List<List<Integer>> p078(int[]a){List<List<Integer>>r=new ArrayList<>();r.add(new ArrayList<>());for(int x:a){int z=r.size();for(int i=0;i<z;i++){List<Integer>q=new ArrayList<>(r.get(i));q.add(x);r.add(q);}}return r;}
    // 79 Word Search
    static boolean p079(char[][]b,String w){for(int i=0;i<b.length;i++)for(int j=0;j<b[0].length;j++)if(ws(b,w,i,j,0))return true;return false;}static boolean ws(char[][]b,String w,int i,int j,int k){if(k==w.length())return true;if(i<0||j<0||i==b.length||j==b[0].length||b[i][j]!=w.charAt(k))return false;char c=b[i][j];b[i][j]='#';boolean z=ws(b,w,i+1,j,k+1)||ws(b,w,i-1,j,k+1)||ws(b,w,i,j+1,k+1)||ws(b,w,i,j-1,k+1);b[i][j]=c;return z;}
    // 80 Remove Duplicates from Sorted Array II
    static int p080(int[]a){int k=0;for(int x:a)if(k<2||x!=a[k-2])a[k++]=x;return k;}
    // 81 Search in Rotated Sorted Array II
    static boolean p081(int[]a,int t){int l=0,r=a.length-1;while(l<=r){int m=(l+r)>>>1;if(a[m]==t)return true;if(a[l]==a[m]&&a[m]==a[r]){l++;r--;continue;}if(a[l]<=a[m]){if(a[l]<=t&&t<a[m])r=m-1;else l=m+1;}else{if(a[m]<t&&t<=a[r])l=m+1;else r=m-1;}}return false;}
    // 82 Remove Duplicates from Sorted List II
    static ListNode p082(ListNode h){ListNode d=new ListNode(0,h),p=d;while(h!=null){if(h.next!=null&&h.val==h.next.val){int v=h.val;while(h!=null&&h.val==v)h=h.next;p.next=h;}else{p=h;h=h.next;}}return d.next;}
    // 83 Remove Duplicates from Sorted List
    static ListNode p083(ListNode h){for(ListNode p=h;p!=null&&p.next!=null;)if(p.val==p.next.val)p.next=p.next.next;else p=p.next;return h;}
    // 84 Largest Rectangle in Histogram
    static int p084(int[]a){Deque<Integer>q=new ArrayDeque<>();int b=0;for(int i=0;i<=a.length;i++){int h=i==a.length?0:a[i];while(!q.isEmpty()&&a[q.peek()]>=h){int x=q.pop(),l=q.isEmpty()?-1:q.peek();b=Math.max(b,a[x]*(i-l-1));}q.push(i);}return b;}
    // 85 Maximal Rectangle
    static int p085(char[][]a){if(a.length==0)return 0;int[]h=new int[a[0].length];int b=0;for(char[]r:a){for(int j=0;j<h.length;j++)h[j]=r[j]=='1'?h[j]+1:0;b=Math.max(b,p084(h));}return b;}
    // 86 Partition List
    static ListNode p086(ListNode h,int x){ListNode a=new ListNode(),b=new ListNode(),p=a,q=b;while(h!=null){if(h.val<x){p.next=h;p=p.next;}else{q.next=h;q=q.next;}h=h.next;}q.next=null;p.next=b.next;return a.next;}
    // 87 Scramble String
    static boolean p087(String s,String t){Map<String,Boolean>m=new HashMap<>();return scr(s,t,m);}static boolean scr(String s,String t,Map<String,Boolean>m){String key=s+"#"+t;if(m.containsKey(key))return m.get(key);if(s.equals(t))return true;if(s.length()!=t.length())return false;int[]c=new int[26];for(int i=0;i<s.length();i++){c[s.charAt(i)-'a']++;c[t.charAt(i)-'a']--;}for(int x:c)if(x!=0)return m.put(key,false);for(int i=1;i<s.length();i++)if(scr(s.substring(0,i),t.substring(0,i),m)&&scr(s.substring(i),t.substring(i),m)||scr(s.substring(0,i),t.substring(t.length()-i),m)&&scr(s.substring(i),t.substring(0,t.length()-i),m))return m.put(key,true);return m.put(key,false);}
    // 88 Merge Sorted Array
    static void p088(int[]a,int m,int[]b,int n){int i=m-1,j=n-1,k=m+n-1;while(j>=0)a[k--]=i>=0&&a[i]>b[j]?a[i--]:b[j--];}
    // 89 Gray Code
    static List<Integer> p089(int n){List<Integer>r=new ArrayList<>();for(int i=0;i<(1<<n);i++)r.add(i^(i>>1));return r;}
    // 90 Subsets II
    static List<List<Integer>> p090(int[]a){Arrays.sort(a);List<List<Integer>>r=new ArrayList<>();r.add(new ArrayList<>());int st=0;for(int i=0;i<a.length;i++){int z=r.size();st=i>0&&a[i]==a[i-1]?st:0;for(int j=st;j<z;j++){List<Integer>q=new ArrayList<>(r.get(j));q.add(a[i]);r.add(q);}st=z;}return r;}
    // 91 Decode Ways
    static int p091(String s){if(s.isEmpty()||s.charAt(0)=='0')return 0;int a=1,b=1;for(int i=1;i<s.length();i++){int c=s.charAt(i)=='0'?0:b;if(s.charAt(i-1)=='1'||s.charAt(i-1)=='2'&&s.charAt(i)<='6')c+=a;a=b;b=c;}return b;}
    // 92 Reverse Linked List II
    static ListNode p092(ListNode h,int l,int r){ListNode d=new ListNode(0,h),p=d;for(int i=1;i<l;i++)p=p.next;ListNode c=p.next;for(int i=0;i<r-l;i++){ListNode x=c.next;c.next=x.next;x.next=p.next;p.next=x;}return d.next;}
    // 93 Restore IP Addresses
    static List<String> p093(String s){List<String>r=new ArrayList<>();ip(s,0,new ArrayList<>(),r);return r;}static void ip(String s,int st,List<String>q,List<String>r){if(q.size()==4){if(st==s.length())r.add(String.join(".",q));return;}for(int e=st;e<Math.min(s.length(),st+3);e++){String x=s.substring(st,e+1);if((x.length()>1&&x.charAt(0)=='0')||Integer.parseInt(x)>255)break;q.add(x);ip(s,e+1,q,r);q.remove(q.size()-1);}}
    // 94 Binary Tree Inorder Traversal
    static List<Integer> p094(TreeNode root){List<Integer>r=new ArrayList<>();Deque<TreeNode>q=new ArrayDeque<>();while(root!=null||!q.isEmpty()){while(root!=null){q.push(root);root=root.left;}root=q.pop();r.add(root.val);root=root.right;}return r;}
    // 95 Unique Binary Search Trees II
    static List<TreeNode> p095(int n){return trees(1,n);}static List<TreeNode> trees(int l,int r){List<TreeNode>x=new ArrayList<>();if(l>r){x.add(null);return x;}for(int i=l;i<=r;i++)for(TreeNode a:trees(l,i-1))for(TreeNode b:trees(i+1,r)){TreeNode q=new TreeNode(i);q.left=a;q.right=b;x.add(q);}return x;}
    // 96 Unique Binary Search Trees
    static int p096(int n){long c=1;for(int i=0;i<n;i++)c=c*2*(2L*i+1)/(i+2);return(int)c;}
    // 97 Interleaving String
    static boolean p097(String a,String b,String c){if(a.length()+b.length()!=c.length())return false;boolean[]d=new boolean[b.length()+1];d[0]=true;for(int j=1;j<=b.length();j++)d[j]=d[j-1]&&b.charAt(j-1)==c.charAt(j-1);for(int i=1;i<=a.length();i++)for(int j=0;j<=b.length();j++){boolean x=d[j]&&a.charAt(i-1)==c.charAt(i+j-1);if(j>0)d[j]=d[j]&&b.charAt(j-1)==c.charAt(i+j-1)||x;else d[j]=x;}return d[b.length()];}
    // 98 Validate Binary Search Tree
    static boolean p098(TreeNode r){return bst(r,Long.MIN_VALUE,Long.MAX_VALUE);}static boolean bst(TreeNode r,long l,long h){return r==null||r.val>l&&r.val<h&&bst(r.left,l,r.val)&&bst(r.right,r.val,h);}
    // 99 Recover Binary Search Tree
    static void p099(TreeNode r){TreeNode[]bad=new TreeNode[2],prev=new TreeNode[]{null};rec(r,prev,bad);int t=bad[0].val;bad[0].val=bad[1].val;bad[1].val=t;}static void rec(TreeNode r,TreeNode[]p,TreeNode[]b){if(r==null)return;rec(r.left,p,b);if(p[0]!=null&&p[0].val>r.val){if(b[0]==null)b[0]=p[0];b[1]=r;}p[0]=r;rec(r.right,p,b);}
    // 100 Same Tree
    static boolean p100(TreeNode a,TreeNode b){return a==b||a!=null&&b!=null&&a.val==b.val&&p100(a.left,b.left)&&p100(a.right,b.right);}
}
