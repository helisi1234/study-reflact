package reflactannotation.useannotation;

@MyAnnotation(getValue = "MyAnnotation on class")
public class UserMyAnnotation {

    @MyAnnotation(getValue = "MyAnnotation on field")
    public String name;

    @MyAnnotation(getValue = "MyAnnotation on method")
    public void testMethod() {
    }

    @MyAnnotation()
    public void testDefaultMethod() {
    }
}
