package com.paulxu.rpc.client.protocol;

import com.paulxu.rpc.RpcRequest;
import com.paulxu.rpc.URL;

public interface Protocol {
    Object doRequest(RpcRequest request, URL url);
}
