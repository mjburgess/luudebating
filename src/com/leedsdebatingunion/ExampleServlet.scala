package com.leedsdebatingunion

import javax.servlet.http.{
  HttpServlet, HttpServletRequest, HttpServletResponse
}

class ExampleServlet extends HttpServlet
{
  override def doGet(req : HttpServletRequest, resp : HttpServletResponse) {
    resp.setContentType("text/plain")
    Eudc.example().foreach(resp.getWriter().print(_))
  }
    
    override def doPost(req: HttpServletRequest, resp: HttpServletResponse) =
      resp.getWriter().print("posting not implemented!")
}