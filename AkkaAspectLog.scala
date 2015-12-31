package gbbaspecttest

import org.aspectj.lang.JoinPoint
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Before
import org.aspectj.lang.annotation.Pointcut

import net.logstash.logback.marker.Markers
import net.logstash.logback.marker.LogstashMarker

import java.util.Map
import java.util.HashMap

@Aspect
class AkkaAspectLog {

  /*
      @Pointcut(value = "execution ( * "
              + "net.logstash.logback.marker.Markers.appendEntries(..)) "
              + "&& args(map)",
              argNames = "map")
      public void appendEntriesPointcut(Object map) {}

      @Around(value = "appendEntriesPointcut(map)", argNames = "jp,map")
      public Object appendEntriesHit(ProceedingJoinPoint jp, Object map) throws Throwable {
          Map m_in = (Map<String, Object>)map;
          HashMap m_out = new HashMap<String, Object>();
          m_out.put("new_message", "Hello World!");
          System.out.println(m_in.values());
          for (Object entry : m_in.) {
              System.out.println(entry.getClass());
          }
          Object[] array = new Object[]{m_out};
          return jp.proceed(array);
      }
  */

    @Pointcut(value = "execution (net.logstash.logback.marker.LogstashMarker "
                                     + "net.logstash.logback.marker.Markers.appendEntries(map)) "
                                     + "&& args(map)",
              argNames = "map")
    def appendEntriesPointcut(map : java.lang.Object) {}

    @Before(value = "appendEntriesPointcut(map)", argNames = "jp,map")
    def appendEntriesHit(jp : JoinPoint, map : java.lang.Object) {
      println("Hit Append Entries pointcut.")
    }

    @Pointcut(value = "execution (* getLogger(..))")
    def loggerInfoPointcut() {}

    @Before(value = "loggerInfoPointcut()")
    def loggerInfoHit() {
      println("Hit Logger Info pointcut.")
    }

    @Pointcut(value = "execution (* hello(..))")
    def helloPointcut() {}

    @Before(value = "helloPointcut()")
    def helloHit() {
      println("Hit hello pointcut.")
    }
}
