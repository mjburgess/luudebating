package com.leedsdebatingunion

import javax.servlet.http.{
  HttpServlet, HttpServletRequest, HttpServletResponse
}


class TemplateServlet  extends HttpServlet {
  override def doGet(req : HttpServletRequest, resp : HttpServletResponse) {
    resp.setContentType("text/plain")
    resp.getWriter().print("Hello World: {{content}}")
  }
    
    override def doPost(req: HttpServletRequest, resp: HttpServletResponse) =
      resp.getWriter().print("posting not implemented!")
}