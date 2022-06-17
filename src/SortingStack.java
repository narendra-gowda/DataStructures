import java.util.*;

public class SortingStack {
    public static void sortAsc(Stack<Integer> s){
        Stack<Integer> temp = new Stack<>();

//        temp.push(s.pop());

//        while (!s.isEmpty()){
//            int popped = s.pop();
//            if(popped < temp.peek()){      // For ascending order change to >
//                temp.push(popped);
//            } else {
//                while (!temp.isEmpty() && temp.peek() < popped){    // For ascending order change to >
//                    s.push(temp.pop());
//                }
//                temp.push(popped);
//            }
//        }
        while (!s.isEmpty()){
            int popped = s.pop();
            while (!temp.isEmpty() && temp.peek() > popped){
                s.push(temp.pop());
            }
                temp.push(popped);
        }
        System.out.println("Sorted Stack: "+ temp);
    }
    public static void main(String[] arg){
        Stack<Integer> mainStack = new Stack<>();

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        while(n-- >0){
            mainStack.push(input.nextInt());
        }
        sortAsc(mainStack);
    }
}
