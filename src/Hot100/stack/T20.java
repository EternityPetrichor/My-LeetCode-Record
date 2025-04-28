package Hot100.stack;

import java.util.Deque;
import java.util.LinkedList;

public class T20 {
    public static void main(String[] args) {
        String s = "()";
        System.out.println(isValid(s));
    }

    public static boolean isValid1(String s){
        Deque<Character> deque = new LinkedList<>();
        char[] chars = s.toCharArray();
        for (char c : chars){
            switch (c){
                case ')':
                    if (deque.isEmpty() || deque.pop() != '(')
                        return false;
                    break;
                case '}':
                    if (deque.isEmpty() || deque.pop() != '{')
                        return false;
                    break;
                case ']':
                    if (deque.isEmpty() || deque.pop() != '[')
                        return false;
                    break;
                default:deque.push(c);
            }
        }
        return deque.isEmpty();
    }

    /*
    *   bool isValid(string s) {
        char stack[10000];
        int top=0;
        for(char c:s){
            if(c=='{'||c=='('||c=='['){
                stack[top++]=c;
            }else{
                if(!top)return false;
                bool flag=true;
                switch(c){
                    case '}':flag=stack[top-1]=='{';break;
                    case ']':flag=stack[top-1]=='[';break;
                    case ')':flag=stack[top-1]=='(';break;
                }
                if(!flag)return false;
                --top;
            }
        }
        return top==0;
    }*/

    public static boolean isValid(String s) {
        Deque<Character> deque = new LinkedList<>();
        char[] chars = s.toCharArray();
        for (char c : chars){
            if (c == '(' || c == '{' || c == '[')
                deque.push(c);
            else if (deque.isEmpty())
                return false;
            else {
                char top = deque.pop();
                if (!((c==')'&&top=='(') || (c=='}'&&top=='{') || (c==']'&&top=='[')))
                    return false;
            }
        }
        return deque.isEmpty();
    }
}
