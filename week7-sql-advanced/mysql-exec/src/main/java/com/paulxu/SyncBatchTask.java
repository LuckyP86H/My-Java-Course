package com.paulxu;

import com.paulxu.batch.JdbcOperation;

public class SyncBatchTask implements Runnable{
    @Override
    public void run() {
        JdbcOperation.batchInsertRows(100000);
    }
}
