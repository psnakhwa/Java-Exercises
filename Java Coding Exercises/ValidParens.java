//valid parentheses

public class ValidParens {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        char c;
        for(int i=0;i<s.length();i++){
            c = s.charAt(i);
            if(c=='{' || c=='(' || c=='[')  st.push(c);
            else if (!st.isEmpty() && c==')' && st.peek()=='(') st.pop(); 
            else if (!st.isEmpty() && c=='}' && st.peek()=='{')  st.pop();
            else if (!st.isEmpty() && c==']' && st.peek()=='[') st.pop();
            else return false;
            
        }
        return st.isEmpty();
        
    }
}