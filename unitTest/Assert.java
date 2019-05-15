import java.util.Objects;

public class Assert {
    public static void equals(Object result, Object expected) {
        if (!Objects.equals(result, expected)) {
            throw new AssertionError("Expected result was - " + expected + " ,but was - " + result);
        }
    }
}
