package gbbaspecttest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import net.logstash.logback.marker.Markers;
import net.logstash.logback.marker.LogstashMarker;

import java.util.Map;

@Aspect
public class AkkaAspectLog {

    @Pointcut(value = "execution ( * "
            + "net.logstash.logback.marker.Markers.appendEntries(..)) "
            + "&& args(map)",
            argNames = "map")
    public void appendEntriesPointcut(Object map) {}

    @Around(value = "appendEntriesPointcut(map)", argNames = "jp,map")
    public Object appendEntriesHit(ProceedingJoinPoint jp, Object map) throws Throwable {
        Map m = (Map<String, Object>)map;
 //       m.put("new_message", "Hello World!");
        Object[] array = new Object[]{map};
        return jp.proceed(array);
    }
/*
  @Pointcut(value = "execution (net.logstash.logback.marker.LogstashMarker "
                                   + "net.logstash.logback.marker.Markers.appendEntries(map)) "
                                   + "&& args(map)",
            argNames = "map")
  public void appendEntriesPointcut(Object map) {}

  @Before(value = "appendEntriesPointcut(map)", argNames = "jp,map")
  public void appendEntriesHit(JoinPoint jp, Object map) {
    System.out.println("Hit Append Entries pointcut.");
  }

  @Pointcut(value = "execution (* getLogger(..))")
  public void loggerInfoPointcut() {}

  @Before(value = "loggerInfoPointcut()")
  public void loggerInfoHit() {
    System.out.println("Hit Logger Info pointcut.");
  }

  @Pointcut(value = "execution (* hello(..))")
  public void helloPointcut() {}

  @Before(value = "helloPointcut()")
  public void helloHit() {
    System.out.println("Hit hello pointcut.");
  }
*/
}
