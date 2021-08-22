package nio;

import org.junit.Assert;
import org.junit.Test;

public class OkHttpClientServiceTest {
    private String url = "http://localhost:8803";

    @Test
    public void testDoGet() {
        String result = nio.OkHttpClientService.doGet(url);
        Assert.assertEquals("hello,nio", result);
    }
}
