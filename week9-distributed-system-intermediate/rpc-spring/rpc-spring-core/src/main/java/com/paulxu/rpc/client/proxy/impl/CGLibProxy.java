package com.paulxu.rpc.client.proxy.impl;

import com.alibaba.fastjson.parser.ParserConfig;
import com.paulxu.rpc.RpcRequest;
import com.paulxu.rpc.URL;
import com.paulxu.rpc.client.loadbalance.LoadBalancer;
import com.paulxu.rpc.client.protocol.Protocol;
import com.paulxu.rpc.client.proxy.ProxyFactory;
import com.paulxu.rpc.exception.RpcException;
import com.paulxu.rpc.register.RegisterCenter;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

import java.util.List;

public class CGLibProxy implements ProxyFactory {

    /**
     * 支持fastjson反序列化
     */
    static {
        ParserConfig.getGlobalInstance().addAccept("com.paulxu");
    }

    private Protocol protocol;

    private LoadBalancer loadBalancer;

    public CGLibProxy(Protocol protocol, LoadBalancer loadBalancer) {
        this.protocol = protocol;
        this.loadBalancer = loadBalancer;
    }

    @Override
    public <T> T getProxy(Class serviceClass) throws RpcException {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(serviceClass);
        enhancer.setCallback((MethodInterceptor) (o, method, args, methodProxy) -> {
            String serviceClassName = serviceClass.getName();
            List<URL> urls = RegisterCenter.getUrls(serviceClass.getName());
            URL url = loadBalancer.select(urls);
            if (url == null) {
                return new RpcException("CREATE_SERVICE_000", String.format("Create service %s failed.", serviceClassName));
            }
            RpcRequest request = new RpcRequest()
                    .setClassName(serviceClass.getName())
                    .setMethodName(method.getName())
                    .setParameterTypes(method.getParameterTypes())
                    .setParameters(args);
            return protocol.doRequest(request, url);
        });
        return (T) enhancer.create();
    }
}
