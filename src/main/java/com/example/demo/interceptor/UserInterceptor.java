package com.example.demo.interceptor;

import com.example.demo.common.util.JwtUtil;
import com.example.demo.common.vo.ResultMap;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import jdk.nashorn.internal.ir.ObjectNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author Sun
 * @date 2018/5/31
 */
@Slf4j
@Component
public class UserInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setCharacterEncoding("utf-8");
        String jwt = request.getHeader("Authorization");
        System.out.println(jwt);
        //token不存在
        if (jwt == null || jwt.isEmpty()) {
            responseMessage(response, response.getWriter(), ResultMap.error(501, "登录过期请重新登录"));
            return false;
        } else {
            try {
                Claims claims = JwtUtil.parseJwt(jwt);
                request.setAttribute("id", claims.getSubject());
                return true;
            } catch (Exception e) {
                log.warn(e.toString());
                responseMessage(response, response.getWriter(), ResultMap.error(501, "登录过期请重新登录"));
                return false;
            }
        }
    }

    private void responseMessage(HttpServletResponse response, PrintWriter out, ResultMap result) throws JsonProcessingException {
        response.setContentType("application/json; charset=utf-8");
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(result);
        out.print(json);
        out.flush();
        out.close();
    }
}
