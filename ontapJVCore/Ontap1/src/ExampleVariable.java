public class ExampleVariable {
    static int staticVar = 100;
    int instanceVar = 200;
    public void method(){
        int localVar = 50;
        System.out.println(localVar);
        System.out.println(instanceVar);
        System.out.println(staticVar);
    }
    public static void main(String[] args) {
        ExampleVariable obj = new ExampleVariable();
        obj.method();
    }
}
