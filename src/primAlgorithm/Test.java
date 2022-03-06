package primAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Test {
    HashMap<String, List<String>> test1 = new HashMap<>();

    public void test1() {
        List<String> hello = new ArrayList<>();
        test1.put("test1", new ArrayList<>(Arrays.asList("no", "hello1")));
        hello = test1.get("test1");
        hello.add("hi");
        System.out.println(test1.get("test1"));
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.test1();
    }
}
