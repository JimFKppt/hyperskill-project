import java.util.Calendar;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String primitiveDate = scanner.nextLine();
        String[] formatedDate = primitiveDate.split("-");
        System.out.printf("%s/%s/%s", formatedDate[1], formatedDate[2], formatedDate[0]);

//        String[] date = primitiveDate.split("-");
//
//        int year = Integer.parseInt(date[0]);
//        int month = Integer.parseInt(date[1]);
//        int day = Integer.parseInt(date[2]);
//
//        Calendar calendar = Calendar.getInstance();
//
//        calendar.set(year, month, day);
//
//        year = calendar.get(Calendar.YEAR);
//        month = calendar.get(Calendar.MONTH);
//        day = calendar.get(Calendar.DAY_OF_MONTH);
//
//        System.out.printf("%d/%d/%d",month,day,year);
    }
}