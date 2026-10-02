import java.util.*;

class BadStack extends ArrayList<Integer> {
    void push(int x) {
        add(x);
    }

    int pop() {
        return remove(size() - 1);
    }
}

class GoodStack {
    private List<Integer> items = new ArrayList<>();

    void push(int x) {
        items.add(x);
    }

    int pop() {
        return items.remove(items.size() - 1);
    }
}

public class BadInheritanceDemo {
    public static void main(String[] args) {
        BadStack bad = new BadStack();
        bad.push(1);
        bad.push(2);
        bad.add(0, 99);
        System.out.println(bad);
        GoodStack good = new GoodStack();
        good.push(1);
        good.push(2);
        System.out.println(good.pop());
    }
}
