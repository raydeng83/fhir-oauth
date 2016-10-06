//package com.ldeng.config;
//
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureException;
//import org.springframework.core.Ordered;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.GenericFilterBean;
//
//import javax.servlet.*;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// * Created by lede on 4/26/16.
// */
////@Component
////@Order(Ordered.HIGHEST_PRECEDENCE)
////class JwtFilter implements Filter {
////
////    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
////        HttpServletResponse response = (HttpServletResponse) res;
////        HttpServletRequest request = (HttpServletRequest) req;
////        response.setHeader("Access-Control-Allow-Origin", "*");
////        response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
////        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
////        response.setHeader("Access-Control-Max-Age", "3600");
////
////        if ("OPTIONS".equals(request.getMethod())) {
////            response.setStatus(HttpServletResponse.SC_OK);
////
////            chain.doFilter(req, res);
////
////        }
////    }
////
////    public void init(FilterConfig filterConfig) {}
////
////    public void destroy() {}
////
////}
//
//@Component
//@Order(Ordered.HIGHEST_PRECEDENCE)
//public class JwtFilter extends GenericFilterBean {
//
//
//    @Override
//    public void doFilter(final ServletRequest req,
//                         final ServletResponse res,
//                         final FilterChain chain) throws IOException, ServletException {
//
//        final HttpServletRequest request = (HttpServletRequest) req;
//        final HttpServletResponse response = (HttpServletResponse) res;
//
//        if ("OPTIONS".equals(request.getMethod())) {
//            response.setStatus(HttpServletResponse.SC_OK);
//
//            chain.doFilter(req, res);
//        }
//
//    }
//}
