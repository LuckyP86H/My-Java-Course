package config.router;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class RoutingDataSource extends AbstractRoutingDataSource {
    /**
     * 选择使用的数据源
     *
     * @return 数据源名称
     */
    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceRouterHolder.getClientDatabase().toString();
    }
}
