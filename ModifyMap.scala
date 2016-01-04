package gbbaspecttest

import scala.collection.JavaConversions._

object ModifyMap {

    def doIt(map : java.util.Map[java.lang.String, java.lang.Object],
             dest : java.util.HashMap[java.lang.String, java.lang.Object]) :
    		java.util.Map[java.lang.String, java.lang.Object] = {
      map.foreach(kv => dest.put(kv._1, kv._2))
      dest.put("Hello", "World")
      dest
    }
}
