import java.util.Scanner;
import java.util.Stack;

public class EvaluationOfPostfix{
    public static int performOperation(int top, int bottom, char operator){
        int result = 0;
        switch(operator){
            case '*': result = bottom * top;
                        break;
            case '/': result = bottom / top;
                        break;
            case '+': result = bottom + top;
                        break;
            case '-': result = bottom - top;
                        break;
        }
        return result;
    }

    public static void main(String arg[]) {
        Stack<Integer> s = new Stack<Integer>();
        Scanner in = new Scanner(System.in);

        String exp = in.nextLine();
        //Write your code here
        for(char c : exp.toCharArray()){
            if(Character.isDigit(c)){
                s.push(Character.getNumericValue(c));
            }else {
                int top = s.pop();
                int bottom = s.pop();
                s.push(performOperation(top, bottom, c));
            }
        }
        if(!s.isEmpty()){
            System.out.println(s.pop());
        }
    }
}

