package config.annotation.read;

import config.annotation.DataBaseType;
import config.router.DataSourceRouterHolder;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ReadDataBaseAspect {

    @Around("@annotation(config.annotation.read.ReadDataBase)")
    public Object readDataBase(ProceedingJoinPoint joinPoint) throws Throwable {
        DataSourceRouterHolder.set(DataBaseType.read);
        Object proceed = joinPoint.proceed();
        DataSourceRouterHolder.clear();
        return proceed;
    }

}
