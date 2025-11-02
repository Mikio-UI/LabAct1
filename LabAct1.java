
import java.util.Scanner;

public class LabAct1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input a binary string: ");
        String input = sc.nextLine().trim();

        if (isAccepted(input)) {
            System.out.println("Output: Accepted");
        } else {
            System.out.println("Output: Rejected");
        }

        sc.close();
    }

    public static boolean isAccepted(String str) {
        // DFA States: q0 = 0, q1 = 1, q2 = 2 (accept state)
        int state = 0;

        for (char ch : str.toCharArray()) {
            if (ch != '0' && ch != '1') {
                System.out.println("Invalid input! Only 0s and 1s are allowed.");
                return false;
            }

            switch (state) {
                case 0: // q0 (start)
                    if (ch == '0')
                        state = 1; // go to q1
                    else
                        state = 0; // stay in q0
                    break;

                case 1: // q1
                    if (ch == '0')
                        state = 1; // stay in q1
                    else
                        state = 2; // go to q2
                    break;

                case 2: // q2
                    if (ch == '0')
                        state = 1; // go to q1
                    else
                        state = 0; // go to q0
                    break;
            }
        }

        // q2 is the accept state
        return state == 2;
    }
}
 {
    
}
