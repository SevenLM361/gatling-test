package com.research

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class RecordedSimulation extends Simulation {

	val httpProtocol = http
		.baseUrl("http://computer-database.gatling.io")
		.disableAutoReferer
		.acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9")
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("zh-CN,zh;q=0.9,ja;q=0.8,en;q=0.7")
		.upgradeInsecureRequestsHeader("1")
		.userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.88 Safari/537.36")

	val headers_0 = Map(
		"Proxy-Connection" -> "keep-alive",
		"Referer" -> "http://computer-database.gatling.io/computers/6")

	val headers_1 = Map(
		"Proxy-Connection" -> "keep-alive",
		"Referer" -> "http://computer-database.gatling.io/computers")

	val headers_2 = Map(
		"Proxy-Connection" -> "keep-alive",
		"Referer" -> "http://computer-database.gatling.io/computers?f=macbook")

	val headers_3 = Map(
		"Proxy-Connection" -> "keep-alive",
		"Referer" -> "http://computer-database.gatling.io/computers?f=macbook+rad")

	val headers_4 = Map(
		"Proxy-Connection" -> "keep-alive",
		"Referer" -> "http://computer-database.gatling.io/computers?f=rad")

	val headers_6 = Map(
		"Origin" -> "http://computer-database.gatling.io",
		"Proxy-Connection" -> "keep-alive",
		"Referer" -> "http://computer-database.gatling.io/computers/6")



	val scn = scenario("RecordedSimulation")
		.exec(http("request_0")
			.get("/computers")
			.headers(headers_0))
		.pause(1)
		.exec(http("request_1")
			.get("/computers?f=macbook")
			.headers(headers_1))
		.pause(1)
		.exec(http("request_2")
			.get("/computers?f=macbook+rad")
			.headers(headers_2))
		.pause(1)
		.exec(http("request_3")
			.get("/computers?f=rad")
			.headers(headers_3))
		.pause(1)
		.exec(http("request_4")
			.get("/computers?f=macbook")
			.headers(headers_4))
		.pause(1)
		.exec(http("request_5")
			.get("/computers/6")
			.headers(headers_2))
		.pause(1)
		.exec(http("request_6")
			.post("/computers/6/delete")
			.headers(headers_6))
		.pause(1)
		.exec(http("request_7")
			.get("/computers?f=macbook")
			.headers(headers_1))

	setUp(scn.inject(rampUsers(100) during (20 seconds))).protocols(httpProtocol)
}