package com.lagnada.demo.scalatra

import org.scalatra._
import java.net.URL
import scalate.ScalateSupport

/**
 * /page/{pageName} -> /WEB-INF/scalate/templates/{pageName}.scaml
 */
class DefaultPageFilter extends ScalatraFilter with ScalateSupport {

  notFound {
    // If no route matches, then try to render a Scaml template
    val templateBase = requestPath match {
      case s if s.endsWith("/") => s + "index"
      case s => s
    }
    val templatePath = "/WEB-INF/scalate/templates" + templateBase.substring("/page".length) + ".scaml"
    servletContext.getResource(templatePath) match {
      case url: URL =>
        contentType = "text/html"
        templateEngine.layout(templatePath)
      case _ =>
        filterChain.doFilter(request, response)
    }
  }
}
