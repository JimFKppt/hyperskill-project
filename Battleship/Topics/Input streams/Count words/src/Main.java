import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // start coding here
//        int charAsInt = reader.read();
//
//        if (charAsInt == -1) {
//            System.out.println(0);
//        } else {
//            String string = reader.readLine().trim();
//            String[] strings = string.split("\\s+");
//            System.out.println(strings.length);
//        }
        String input = reader.readLine().trim();

        reader.close();

        if (input.isEmpty()) {
            System.out.println(0);
        } else {
            String[] array = input.split("\\s+");
            System.out.println(array.length);
        }
    }
}