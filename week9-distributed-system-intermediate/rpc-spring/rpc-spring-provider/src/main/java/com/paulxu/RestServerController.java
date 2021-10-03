package com.paulxu;

import com.paulxu.rpc.RpcRequest;
import com.paulxu.rpc.RpcResponse;
import com.paulxu.rpc.server.ServerSkeleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestServerController {

    @Autowired
    private ServerSkeleton serverSkeleton;

    @PostMapping("/")
    public RpcResponse invokeService(@RequestBody RpcRequest rpcRequest) {
        return serverSkeleton.process(rpcRequest);
    }

}
