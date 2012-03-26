package com.leedsdebatingunion
import javax.servlet.http.{
  HttpServletRequest => Request, HttpServletResponse => Response
}

import net.liftweb.json.JsonAST._
import net.liftweb.json.JsonDSL._

object LduAction {
	def apiTest(endpoint: String, parameters: List[String])(req: Request, resp: Response) {
	    val json = ("request" -> 
	    				("endpoint" -> endpoint) ~ 
						("parameters" -> parameters.mkString(",")) ~
						("location" -> req.getRequestURL.toString))
    				
	    resp.setContentType("text/plain")
	    resp.getWriter().print(compact(render(json)))
	}
	
	def rankResults(endpoint: String, parameters: List[String])(req: Request, resp: Response) {
		def round(x: Double): Double = MetricalList.round(x, 2)
	  
	  val competitor = Competitor(parameters(0).toDouble, parameters(1).toDouble, parameters(2).toDouble, parameters(3).toInt, parameters(4).toInt);
		val json = ("rank" -> 
	    				("score" -> round(competitor.rank)) ~
						("bracket" -> scala.math.round(((competitor.rank - 70)/0.5))) ~
						("merit" -> round(competitor.merit)) ~
						("goodness" -> round(competitor.goodness)) ~
						("data" -> parameters.mkString(" ")))
    				
	    resp.setContentType("text/plain")
	    resp.getWriter().print(compact(render(json)))
	}
	
	def default(endpoint: String, parameters: List[String])(req: Request, resp: Response) {
	    val json = ("error" -> "no such action exists")
		resp.setContentType("text/plain")
	    resp.getWriter().print(compact(render(json)))
	}
	
	def apply(endpoint: String, parameters: List[String]): (Request, Response) => Unit = endpoint match {
	  case "dynamic.api_test" 	=> apiTest(endpoint, parameters)
	  case "dynamic.rank" 		=> rankResults(endpoint, parameters)
	  case _ 					=> default(endpoint, parameters)
	}
}
