import com.sona.movefile.user.User;

public class UserTest {
    public static void main(String[] args) {

        UserTest userLoginTest = new UserTest();
        userLoginTest.testUserLogin();
    }

    void testUserLogin() {
        User user=new User("sona855aa","5789");
        user.userRegister(user);
        boolean result = user.userLogin(user);
        Assert.equals(result, true);
    }
}