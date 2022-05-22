package org.hellofalcon.turing;

import java.util.Comparator;

/**
 * @author chugang.cg
 * @create - 2022/5/5.
 */
public class JavaTest {
    public static void main(String[] args) {
        Subclass s1 = new Subclass();
        s1.foo();

//        Super s = new Subclass();
//        s.foo();
//
//        Comparator
    }
}


class Super {
    private void foo() {
        System.out.println("Super");
    }
}

class Subclass extends Super {
    public void foo() {
        System.out.println("subclass");
    }
}