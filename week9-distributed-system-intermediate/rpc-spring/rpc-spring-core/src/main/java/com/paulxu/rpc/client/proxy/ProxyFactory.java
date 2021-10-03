package com.paulxu.rpc.client.proxy;

import com.paulxu.rpc.exception.RpcException;

public interface ProxyFactory {

    <T> T getProxy(Class serviceClass) throws RpcException;
}
