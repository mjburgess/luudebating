package com.leedsdebatingunion

import javax.servlet.http.{
  HttpServlet, HttpServletRequest, HttpServletResponse
}

class ViewServlet extends HttpServlet
{
  //    Eudc.example().foreach(resp.getWriter().print(_))
  override def doGet(req : HttpServletRequest, resp : HttpServletResponse) {
    val (endpoint, params) = query(req);
    val action = LduAction(endpoint.mkString, params);
    
    action(req, resp)
  }
    
    override def doPost(req: HttpServletRequest, resp: HttpServletResponse) =
      resp.getWriter().print("posting not implemented!")
      
    def query(req: HttpServletRequest): (List[String], List[String]) = {
      val query = req.getRequestURI.toString.split("/")
      val endpoint = if(query.length > 3)  query.slice(3, 4).toList		       else List("/")
      val params   = if(query.length >= 4) query.slice(4, query.length).toList else Nil
      
      (endpoint, params)
    }
}