import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ListA<String> listA = new ListA<>();
        listA.add("Apple");
        listA.add("Banana");
        System.out.println("ListA: " + listA);
        System.out.println("Get element at index 0 from ListA: " + listA.get(0));
        listA.remove(0);
        System.out.println("ListA after removal: " + listA);

        ListB<String> listB = new ListB<>();
        listB.add("Car");
        listB.add("Bus");
        listB.add(1, "Bike");
        System.out.println("ListB: " + listB);
        listB.set(1, "Motorcycle");
        System.out.println("ListB after set operation: " + listB);
        listB.addAll(Arrays.asList("Train", "Plane"));
        System.out.println("ListB after addAll operation: " + listB);

        SetC<Integer> setC = new SetC<>();
        setC.add(1);
        setC.add(2);
        setC.add(1);
        System.out.println("SetC: " + setC);
        System.out.println("SetC contains 1: " + setC.contains(1));
        System.out.println("SetC size: " + setC.size());
        setC.remove(1);
        System.out.println("SetC after removal: " + setC);
        setC.addAll(Arrays.asList(3, 4, 5));
        System.out.println("SetC after addAll operation: " + setC);
        System.out.println("SetC contains all elements from [3, 4]: " + setC.containsAll(Arrays.asList(3, 4)));
        setC.removeAll(Arrays.asList(4, 5));
        System.out.println("SetC after removeAll operation: " + setC);
    }
}
