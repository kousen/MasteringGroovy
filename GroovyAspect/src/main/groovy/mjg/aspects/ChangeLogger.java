package mjg.aspects;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class ChangeLogger {
    private Logger log = Logger.getLogger(ChangeLogger.class.getName());
    
    @Before("execution(void set*(*))")
    public void trackChange(JoinPoint jp) {
        String method = jp.getSignature().getName();
        Object newValue = jp.getArgs()[0];
        log.info(method + " about to change to " + 
            newValue + " on " + jp.getTarget());
    }
}
