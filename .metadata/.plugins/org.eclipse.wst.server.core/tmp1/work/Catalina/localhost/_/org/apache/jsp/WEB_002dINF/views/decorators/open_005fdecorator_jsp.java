/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.73
 * Generated at: 2020-04-14 05:15:15 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.decorators;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class open_005fdecorator_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/views/include/open_footer.jsp", Long.valueOf(1586246085554L));
    _jspx_dependants.put("/WEB-INF/views/include/open_header.jsp", Long.valueOf(1586841068133L));
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fdecorator_005ftitle_0026_005fdefault_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fdecorator_005fhead_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fdecorator_005fbody_005fnobody;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fdecorator_005ftitle_0026_005fdefault_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fdecorator_005fhead_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fdecorator_005fbody_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fdecorator_005ftitle_0026_005fdefault_005fnobody.release();
    _005fjspx_005ftagPool_005fdecorator_005fhead_005fnobody.release();
    _005fjspx_005ftagPool_005fdecorator_005fbody_005fnobody.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!DOCTYPE html>\r\n");
      out.write("<!--\r\n");
      out.write("This is a starter template page. Use this page to start your new project from\r\n");
      out.write("scratch. This page gets rid of all links and provides the needed markup only.\r\n");
      out.write("-->\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("  <meta charset=\"utf-8\">\r\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("  <meta http-equiv=\"x-ua-compatible\" content=\"ie=edge\">\r\n");
      out.write("\r\n");
      out.write("  <title>");
      if (_jspx_meth_decorator_005ftitle_005f0(_jspx_page_context))
        return;
      out.write("</title>\r\n");
      out.write("\r\n");
      out.write("  <!-- Font Awesome Icons -->\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath());
      out.write("/resources/bootstrap/plugins/fontawesome-free/css/all.min.css\">\r\n");
      out.write("  <!-- Theme style -->\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath());
      out.write("/resources/bootstrap/dist/css/adminlte.min.css\">\r\n");
      out.write("  <!-- Google Font: Source Sans Pro -->\r\n");
      out.write("  <link href=\"https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700\" rel=\"stylesheet\">\r\n");
      out.write("  <!-- jQuery -->\r\n");
      out.write("  <script src=\"");
      out.print(request.getContextPath());
      out.write("/resources/bootstrap/plugins/jquery/jquery.min.js\"></script>\r\n");
      out.write("  \r\n");
      out.write("  ");
      if (_jspx_meth_decorator_005fhead_005f0(_jspx_page_context))
        return;
      out.write("</head>\r\n");
      out.write("<body class=\"hold-transition sidebar-mini\">");
      if (_jspx_meth_decorator_005fbody_005f0(_jspx_page_context))
        return;
      out.write("<!-- Bootstrap 4 -->\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath());
      out.write("/resources/bootstrap/plugins/bootstrap/js/bootstrap.bundle.min.js\"></script>\r\n");
      out.write("<!-- AdminLTE App -->\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath());
      out.write("/resources/bootstrap/dist/js/adminlte.min.js\"></script>\r\n");
      out.write("<!-- common.js -->\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath() );
      out.write("/resources/js/common.js\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_decorator_005ftitle_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  decorator:title
    com.opensymphony.module.sitemesh.taglib.decorator.TitleTag _jspx_th_decorator_005ftitle_005f0 = (com.opensymphony.module.sitemesh.taglib.decorator.TitleTag) _005fjspx_005ftagPool_005fdecorator_005ftitle_0026_005fdefault_005fnobody.get(com.opensymphony.module.sitemesh.taglib.decorator.TitleTag.class);
    try {
      _jspx_th_decorator_005ftitle_005f0.setPageContext(_jspx_page_context);
      _jspx_th_decorator_005ftitle_005f0.setParent(null);
      // /WEB-INF/views/include/open_header.jsp(18,9) name = default type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_decorator_005ftitle_005f0.setDefault("새 창");
      int _jspx_eval_decorator_005ftitle_005f0 = _jspx_th_decorator_005ftitle_005f0.doStartTag();
      if (_jspx_th_decorator_005ftitle_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } finally {
      _005fjspx_005ftagPool_005fdecorator_005ftitle_0026_005fdefault_005fnobody.reuse(_jspx_th_decorator_005ftitle_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_decorator_005fhead_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  decorator:head
    com.opensymphony.module.sitemesh.taglib.decorator.HeadTag _jspx_th_decorator_005fhead_005f0 = (com.opensymphony.module.sitemesh.taglib.decorator.HeadTag) _005fjspx_005ftagPool_005fdecorator_005fhead_005fnobody.get(com.opensymphony.module.sitemesh.taglib.decorator.HeadTag.class);
    try {
      _jspx_th_decorator_005fhead_005f0.setPageContext(_jspx_page_context);
      _jspx_th_decorator_005fhead_005f0.setParent(null);
      int _jspx_eval_decorator_005fhead_005f0 = _jspx_th_decorator_005fhead_005f0.doStartTag();
      if (_jspx_th_decorator_005fhead_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } finally {
      _005fjspx_005ftagPool_005fdecorator_005fhead_005fnobody.reuse(_jspx_th_decorator_005fhead_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_decorator_005fbody_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  decorator:body
    com.opensymphony.module.sitemesh.taglib.decorator.BodyTag _jspx_th_decorator_005fbody_005f0 = (com.opensymphony.module.sitemesh.taglib.decorator.BodyTag) _005fjspx_005ftagPool_005fdecorator_005fbody_005fnobody.get(com.opensymphony.module.sitemesh.taglib.decorator.BodyTag.class);
    try {
      _jspx_th_decorator_005fbody_005f0.setPageContext(_jspx_page_context);
      _jspx_th_decorator_005fbody_005f0.setParent(null);
      int _jspx_eval_decorator_005fbody_005f0 = _jspx_th_decorator_005fbody_005f0.doStartTag();
      if (_jspx_th_decorator_005fbody_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } finally {
      _005fjspx_005ftagPool_005fdecorator_005fbody_005fnobody.reuse(_jspx_th_decorator_005fbody_005f0);
    }
    return false;
  }
}
