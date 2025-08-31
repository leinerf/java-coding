import java.util.HashMap;
import java.util.Stack;

class Solution {
    public boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> closeToOpen = new HashMap<>();
        closeToOpen.put(']', '[');
        closeToOpen.put('}', '{');
        closeToOpen.put(')', '(');
        for(char c: s.toCharArray()){
            if(closeToOpen.containsKey(c)){
                if(!stack.isEmpty() && stack.peek() == closeToOpen.get(c)){
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isValid("[]"));
        System.out.println(sol.isValid("([{}])"));
    }
}
