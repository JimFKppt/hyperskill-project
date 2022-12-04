import java.util.ArrayList;
import java.util.List;

class Counter {

//    public static void main(String[] args) {
//        List<Integer> list1 = new ArrayList<>(List.of(9, 8, 4, 3, 2));
//        List<Integer> list2 = new ArrayList<>(List.of(1, 3, 3, 3));
//        System.out.println(checkTheSameNumberOfTimes(3, list1, list2));
//    }

    public static boolean checkTheSameNumberOfTimes(int elem, List<Integer> list1, List<Integer> list2) {
        // implement the method
        if (list1.contains(elem) && list2.contains(elem)) {
            int counter1 = 0;
            int counter2 = 0;
            for (Integer e : list1) {
                if (e == elem) {
                    counter1++;
                }
            }
            for (Integer e : list2) {
                if (e == elem) {
                    counter2++;
                }
            }
            return counter1 == counter2;
        }
        return false;
    }
}