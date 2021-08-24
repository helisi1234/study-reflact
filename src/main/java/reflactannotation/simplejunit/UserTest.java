package reflactannotation.simplejunit;

public class UserTest {

    @MyBefore
    public void init() {
        System.out.println("初始化");
    }

    @MyTest
    public void save() {
        System.out.println("save");
    }

    @MyTest
    public void delete() {
        System.out.println("delete");
    }

    @MyAfter
    public void destory() {
        System.out.println("销毁");
    }
}
