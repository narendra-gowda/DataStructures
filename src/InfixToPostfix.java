import java.util.Scanner;
import java.util.Stack;

public class InfixToPostfix {
    public static int getPrecedence(char operator){
        if(operator == '+' || operator == '-'){
            return 1;
        } else if (operator == '*' || operator == '/') {
            return 2;
        } else if (operator == '^') {
            return 3;
        } else {
            return -1;
        }
    }
    public static void main(String arg[]){
        Stack<Character> s = new Stack<Character>();
        Scanner in = new Scanner(System.in);
        System.out.print("Enter expression: ");
        String exp = in.nextLine();
        String answer = "";
        char[] chars = exp.toCharArray();
        for(char ch : chars){
            if(Character.isLetterOrDigit(ch)){
                answer += ch;
            } else if (ch == '(') {
                s.push(ch);
            } else if (ch == ')') {
                while (!s.isEmpty() && s.peek() != '('){
                    answer += s.pop();
                }
                s.pop();
            } else {
                while (!s.isEmpty() && getPrecedence(ch) <= getPrecedence(s.peek())){
                    answer += s.pop();
                }
                s.push(ch);
            }
        }
        while (!s.isEmpty()) {
            answer += s.pop();
        }
        System.out.println(answer);
    }
}

   /** Iterate through the infix expression

        If the element is an operand then add it to the answer.

        Else if the element is ‘(’ then push that to the stack

        Else if the element is ‘)’ then pop the element from the stack and add to the answer until the popped element is ‘(’

        Else if the element is an operator then

        if precedence of the top of the stack is less than the precedence of the element or if the stack is empty, push that element to stack.

        Otherwise pop the operator from the stack and add to the answer until the precedence of the element is less than or equal to the precedence of the top of the stack.

        Repeat step1 till you reach the end of the given infix expression.

        If the stack is not empty then pop the stack and add to the answer until the stack becomes empty.
**/
