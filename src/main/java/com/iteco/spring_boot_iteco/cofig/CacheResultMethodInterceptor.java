package com.iteco.spring_boot_iteco.cofig;

import com.iteco.spring_boot_iteco.home_worke.CacheResult;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.core.annotation.AnnotationUtils;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CacheResultMethodInterceptor{
    private static final Map<String, Map<MethodArgs,Object>> CACHE = new ConcurrentHashMap<>();

    public Object invoke(MethodInvocation invocation) throws Throwable {
        final Method method = invocation.getMethod();
        boolean isAnnotationMethod = method.isAnnotationPresent(CacheResult.class);
        if (!isAnnotationMethod){
            for (Method declaredMethod : invocation.getThis().getClass().getDeclaredMethods()){
                if (method.getName().equals(declaredMethod.getName()) &&
                        AnnotationUtils.findAnnotation(declaredMethod, CacheResult.class) != null){
                    isAnnotationMethod = true;
                    break;
                }
            }
        }
        if (isAnnotationMethod){
            log.info("Method: {} annotated @CacheResult", method.getName());
            Map<MethodArgs, Object> methodArgsObjectMap = CACHE.get(method.getName());
            if (methodArgsObjectMap != null){
                log.info("Method: {} has cache. Cache: {}", method.getName(), methodArgsObjectMap);
                final MethodArgs methodArgs = getMethodArgs(invocation.getArguments());
                log.info("Check cache result by method with args: {}({})", method.getName(), invocation.getArguments());
                Object result = methodArgsObjectMap.get(methodArgs);
                if (result != null){
                    log.info("Return from cache: {}({}), result: {}", method.getName(), invocation.getArguments(),result);
                    return result;
                } else {
                    log.info("Call original method and record result into cache");
                    result = invocation.proceed();
                    methodArgsObjectMap.put(methodArgs, result);
                    return result;
                }
            }else {
                log.info("Method: {} not cache.", method.getName());
                Object result = invocation.proceed();
                methodArgsObjectMap = new ConcurrentHashMap<>();
                methodArgsObjectMap.put(
                        getMethodArgs(invocation.getArguments()),
                        result
                );
                CACHE.put(method.getName(), methodArgsObjectMap);
                return result;
            }
        }
    }
}
