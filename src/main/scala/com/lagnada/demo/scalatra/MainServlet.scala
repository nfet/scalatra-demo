package com.lagnada.demo.scalatra

import org.scalatra.ScalatraServlet

class MainServlet extends ScalatraServlet {
  get("/") {
    <html>
      <body>
        <h1>Hello, world! (MainServlet)</h1>
        Saying hello to Scalatra from Maven.
        <div style="margin-top: 20px;">
          <b>Pages</b>
          <div>
            <a href="page/welcome">Welcome (Scalate)</a> <br/>
            <a href="json-page">JSON Page</a>
          </div>
        </div>
      </body>
    </html>
  }

  get("/json-page") {
    "{ \"msg\":\"json response\"}"
  }
}