package com.paulxu.rpc.client.loadbalance.impl;

import com.paulxu.rpc.URL;
import com.paulxu.rpc.client.loadbalance.LoadBalancer;

import java.util.List;
import java.util.Random;

/**
 * 随机获取服务地址
 */
public class RandomLoadBalancer implements LoadBalancer {

    @Override
    public URL select(List<URL> urls) {
        if (urls == null || urls.isEmpty()) {
            return null;
        }
        Random random = new Random();
        int index = random.nextInt(urls.size());
        return urls.get(index);
    }
}
