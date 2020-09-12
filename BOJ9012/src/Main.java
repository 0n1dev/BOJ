import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
* 괄호
*/
public class Main {

    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int T = Integer.parseInt(br.readLine());

            for (int i = 0; i < T; i++) {
                String inputStr = br.readLine();
                if (validParenthesis(inputStr)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static boolean validParenthesis(String inputStr) {

        char[] charArr = inputStr.toCharArray();
        Stack<Character> st = new Stack<Character>();

        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] == '(') {
                st.push(charArr[i]);
            } else if (charArr[i] == ')') {

                if (!st.empty()) {
                    st.pop();
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        if (!st.empty()) {
            return false;
        }

        return true;
    }
}