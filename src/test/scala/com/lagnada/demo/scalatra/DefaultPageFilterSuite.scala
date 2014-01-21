package com.lagnada.demo.scalatra

import org.scalatra.test.scalatest._

import org.junit.runner.RunWith
import org.scalatest.matchers._
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner]) // makes test run with Maven Surefire
class DefaultPageFilterSuite extends ScalatraFunSuite with ShouldMatchers {
  addFilter(classOf[DefaultPageFilter], "/*")

  test("GET / returns status 200") {
    get("/") {
      status should equal(200)
    }
    get("/page/welcome") {
      status should equal(200)
    }
  }

  test("GET / returns status 404") {
    get("/non-existing-page") {
      status should equal(404)
    }
  }

}
