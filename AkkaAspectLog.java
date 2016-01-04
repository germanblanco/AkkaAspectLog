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
      Object[] array = new Object[]{ModifyMap.doIt(m, new java.util.HashMap())};
      return jp.proceed(array);
  }
}
