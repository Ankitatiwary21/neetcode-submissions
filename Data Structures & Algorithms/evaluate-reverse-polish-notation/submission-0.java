class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st=new Stack<>();
        for(String i:tokens)
        {
           if(i.equals("+"))
           {
            int b=st.pop();
            int a=st.pop();
            st.push(a+b);
           }
           else if(i.equals("-"))
           {
            int b=st.pop();
            int a=st.pop();
            st.push(a-b);
           }
           else if(i.equals("*"))
           {
            int b=st.pop();
            int a=st.pop();
            st.push(a*b);
           }
           else if(i.equals("/"))
           {
            int b=st.pop();
            int a=st.pop();
            st.push(a/b);
           }
           else st.push(Integer.parseInt(i));
           }
            return st.pop();
    }
}
