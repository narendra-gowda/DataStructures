import java.util.*;

public class StackWithTwoQueues {
    public static void push(Queue<Integer> mainQ, Scanner in){
        System.out.println("Enter no.of elements to be pushed: ");
        int numOfElements = in.nextInt();

        System.out.println("Enter the element to push: ");

        while(numOfElements-- > 0){
            int element = in.nextInt();
            int i = 1;
            mainQ.add(element);
            while(mainQ.size() - i > 0) {
                mainQ.add(mainQ.remove());
                i++;
            }
        }
        System.out.println("Updated stack: "+mainQ);
    }
    public static void pop(Queue<Integer> mainQ){
        System.out.println("Popped: "+mainQ.remove());
        System.out.println("Your stack looks like: "+mainQ);
    }

    public static Queue<Integer> storeInStackFormat(Queue<Integer> mainQ){
        Queue<Integer> tempQ = new LinkedList<>();

        while(!mainQ.isEmpty()){
            int i = 1;
            while (mainQ.size() - i > 0){
                mainQ.add(mainQ.remove());
                i++;
            }
            tempQ.add(mainQ.remove());
        }
        return tempQ;
    }
    public static void main(String[] args){
        Queue<Integer> mainQ = new LinkedList<>();

        Scanner in = new Scanner(System.in);
        System.out.print("Enter size of stack: ");
        int size = in.nextInt();
        System.out.println("Enter elements of stack: ");
        while(size -- > 0){
            int elements = in.nextInt();
            mainQ.add(elements);
        }
        mainQ = storeInStackFormat(mainQ);
        System.out.println("Your Stack: "+ mainQ);

        System.out.println("What operation would you like to perform?");
        System.out.println("1 - push, 2 - pop, 3 - peek, 4 - size");
        int operation = in.nextInt();

        switch (operation){
            case 1: push(mainQ, in);
                    break;
            case 2: pop(mainQ);
                    break;
            case 3: System.out.println("Peek: "+mainQ.peek());
                    break;
            case 4: System.out.println("Size: "+mainQ.size());
                    break;
            default: System.out.println("Invalid Operation");
                    break;
        }

    }
}
