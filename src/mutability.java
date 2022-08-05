import static org.springframework.test.util.AssertionErrors.assertEquals;

public class mutability {
    public static void main(String[] args){
        String name = "baeldung";
        String newName = name.replace("dung", "----");

        assertEquals("dsa","baeldung", name);
        assertEquals("dsa","bael----", newName);

    }
}
