package com.paulxu;

import com.paulxu.order.OrderServiceImpl;
import com.paulxu.order.domain.service.OrderService;
import com.paulxu.rpc.RequestResolver;
import com.paulxu.rpc.URL;
import com.paulxu.rpc.register.RegisterCenter;
import com.paulxu.rpc.register.ServiceRegister;
import com.paulxu.rpc.server.ServerSkeleton;
import com.paulxu.user.UserServiceImpl;
import com.paulxu.user.domain.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApplicationServer {

    private static Logger logger = LoggerFactory.getLogger(ApplicationServer.class);

    private static int port = 9010;

    public static void main(String[] args) {

         logger.warn("start register services...");
        RegisterCenter.registerService(UserService.class.getName(), new URL("localhost", port));
        RegisterCenter.registerService(OrderService.class.getName(), new URL("localhost", port));

          logger.warn("start register classes...");
        ServiceRegister.registerService(UserService.class.getName(), UserServiceImpl.class);
        ServiceRegister.registerService(OrderService.class.getName(), OrderServiceImpl.class);

        SpringApplication.run(ApplicationServer.class, args);
    }


    @Bean(value = "requestResolver")
    public RequestResolver getRequestResolver() {
        return new RpcRequestResolver();
    }

    @Bean(value = "serverSkeleton")
    public ServerSkeleton getServerSkeleton(@Autowired @Qualifier(value = "requestResolver") RequestResolver requestResolver) {
        return new ServerSkeleton(requestResolver);
    }
}
