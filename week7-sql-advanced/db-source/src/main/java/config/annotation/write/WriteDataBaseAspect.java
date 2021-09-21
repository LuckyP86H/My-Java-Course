package config.annotation.write;

import config.annotation.DataBaseType;
import config.router.DataSourceRouterHolder;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class WriteDataBaseAspect {

    @Around("@annotation(config.annotation.write.WriteDataBase)")
    public Object writeDataBase(ProceedingJoinPoint joinPoint) throws Throwable {
        DataSourceRouterHolder.set(DataBaseType.write);
        Object proceed = joinPoint.proceed();
        DataSourceRouterHolder.clear();
        return proceed;
    }

}
