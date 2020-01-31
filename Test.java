import javax.management.BadStringOperationException;
import javax.naming.OperationNotSupportedException;
import java.util.Scanner;


public class Test {
    private static boolean check(String s) throws NumberFormatException {
        try {
            int n = Integer.parseInt(s);
            boolean flag = (1 <= n && n <= 10) ? true : false;
            if (flag) return true;
            else return false;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        String l = "", oper = "", r = "";
        String str = scan.nextLine();
        String Str[];
        try {
            Str = str.split(" ");
            if (Str.length != 3) {
                throw new NumberFormatException();
            }
            l = Str[0]; oper = Str[1]; r = Str[2];
        }
        catch(ArithmeticException e) {
            e.getMessage();
        }
        if (check(l) != check(r)) {
            throw new NumberFormatException();
        }
        else if (!(oper.equals("+") || oper.equals("-") || oper.equals("*") || oper.equals("/"))) {
            try {
                throw new OperationNotSupportedException();
            } catch (OperationNotSupportedException e) {
                e.printStackTrace();
            }
        }
        else if (check(l) && check(r)) {
            int result = 0;
            result = (oper.equals("+")) ? Integer.parseInt(l) + Integer.parseInt(r) : result;
            result = (oper.equals("-")) ? Integer.parseInt(l) - Integer.parseInt(r) : result;
            result = (oper.equals("*")) ? Integer.parseInt(l) * Integer.parseInt(r) : result;
            result = (oper.equals("/")) ? Integer.parseInt(l) / Integer.parseInt(r) : result;
            System.out.println (result);
        }
        else {
            try {
                Rome L_ = new Rome (l);
                Rome R_ = new Rome (r);
            }
            catch (NumberFormatException e) {
                e.getMessage();
            }
            Rome L = new Rome (l);
            Rome R = new Rome (r);
            if (1 > L.value() || L.value() > 10 || 1 > R.value() || R.value() > 10) {
                throw new NumberFormatException();
            }
            int result = 0;
            result = (oper.equals("+")) ? (L.value() + R.value()) : result;
            result = (oper.equals("-")) ? (L.value() - R.value()) : result;
            result = (oper.equals("*")) ? (L.value() * R.value()) : result;
            result = (oper.equals("/")) ? (L.value() / R.value()) : result;
            try {
                Rome res = new Rome (result);
                System.out.println (res.key());
            }
            catch (ArithmeticException e) {
               e.getMessage();
            }
        }
    }
}
