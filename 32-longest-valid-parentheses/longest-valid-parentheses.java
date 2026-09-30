class Solution {
    public int longestValidParentheses(String s) {
        Deque<Integer> st=new ArrayDeque<>();
        st.push(-1);
        int max=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='(') st.push(i);
            else{
                st.pop();
                if(st.isEmpty()){
                    st.push(i);
                }
                else{
                    int curr_len=i-st.peek();
                    max=Math.max(curr_len,max);
                }
            }
        }return max;
        
    }
}