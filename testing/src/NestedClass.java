public class NestedClass {

    public static String str;

    public static class StaticClass {
        void test() {
            str
        }
    }

    public static void main(String[] args) {
        System.out.println(NestedClass.str);
    }
}
