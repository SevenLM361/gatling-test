package com.research.simulation

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class BasicSimulation extends Simulation{

  val url = "http://computer-database.gatling.io"
  val accept_header = "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8"
  val lang_header = "en-US,en;q=0.5"
  val encoding_header = "gzip, deflate"
  val user_agent_header = "Mozilla/5.0 (Windows NT 5.1; rv:31.0) Gecko/20100101 Firefox/31.0"

  val name = "BasicSimulation"

  val httpProtocol = http.baseUrl(url).acceptHeader(accept_header).doNotTrackHeader("1")
    .acceptLanguageHeader(lang_header).acceptEncodingHeader(encoding_header).userAgentHeader(user_agent_header)

  val scn = scenario(name).exec(http("request_1").get("/")).pause(5)

  setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)

}
