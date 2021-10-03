/*
import com.paulxu.rpc.client.ClientStub;
import com.paulxu.user.domain.entity.User;
import com.paulxu.user.domain.service.UserService;
import org.junit.Assert;
import org.junit.Test;

public class ClientITest {

    private String host = "127.0.0.1";

    private int port = 9010;

    @Test
    public void testUser() {
        UserService userService = (UserService) ClientStub.createService(UserService.class, host, port);
        User user = userService.getById(123);
        Assert.assertEquals("paulxu", user.getName());
    }
}
*/
