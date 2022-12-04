import java.util.*;

public class Main {

    static void changeList(List<String> list) {
        // write your code here
        // find the longest string
        String longestStr = null;
        int max = 0;
        for (String str : list) {
            int length = str.length();
            if (length > max) {
                max = length;
                longestStr = str;
            }
        }
        // replace all elements
        for (int i = 0; i < list.size(); i++) {
            list.set(i, longestStr);
        }
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        List<String> lst = Arrays.asList(s.split(" "));
        changeList(lst);
        lst.forEach(e -> System.out.print(e + " "));
    }
}