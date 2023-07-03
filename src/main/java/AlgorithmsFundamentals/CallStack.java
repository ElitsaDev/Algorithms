package AlgorithmsFundamentals.RecursionAndBacktracking;

public class CallStack {
    public static void main(String[] args) {
        System.out.print("(main");
        a();
        System.out.print(")");
    }

    private static void a() {
        System.out.print("(a");
        b();
        System.out.print(")");
    }

    private static void b() {
        System.out.print("(b");
        c();
        System.out.print(")");
    }

    private static void c() {
        System.out.print("(c");
        d();
        System.out.print(")");
    }

    private static void d() {
        System.out.print("(d)");
    }
}
