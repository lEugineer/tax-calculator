package com.eugineer.taxcalc.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ApiAccessLoggerAspect {
    protected final Logger log = LoggerFactory.getLogger( this.getClass() );

    @Before( "allApiCalls()" )
    public void logBeforeCall(JoinPoint jp) {
        StringBuilder sb = new StringBuilder(  );
        for (Object o : jp.getArgs()) {
            sb.append( o.toString() );
            sb.append( "\n" );
        }
        log.info(
            String.format( ":::::: API call: %s\n\twith args: %s ",
                    jp.getSignature().toShortString(),
                    sb.toString()
        ));
    }


    @Pointcut("execution(* com.eugineer.taxcalc.api.*Controller.*(..) )")
    private void allApiCalls(){}
}
