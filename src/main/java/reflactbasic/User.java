package reflactbasic;

public class User extends UserSuperclass implements UserInterface{
    private String name;
    public int age;

    public User() {}

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void interfaceMethod() {
        System.out.println("实现接口的方法");
    }

    @Override
    public void superclassMethod() {
        System.out.println("继承父类的方法");
    }

    private void testPrivateMethod() {
        System.out.println("测试私有方法");
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
