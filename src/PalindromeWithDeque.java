import java.util.Deque;
import java.util.LinkedList;
import  java.util.Scanner;

public class PalindromeWithDeque {
    public static void main (String arg[]) {

        System.out.print("Enter the string: ");
        Scanner n = new Scanner(System.in);
        String word = n.nextLine();
        System.out.println("Palindrome? : "+ palindrome(word));
    }
    public static boolean palindrome(String word){
        Deque<Character> deq = new LinkedList<>();

        char[] chars = word.toCharArray();

        for(char ch : chars){
            deq.addLast(ch);
        }

        while (deq.size() > 1){
            if(deq.removeFirst() != deq.removeLast()){
                return false;
            }
        }
        return  true;
    }
}
