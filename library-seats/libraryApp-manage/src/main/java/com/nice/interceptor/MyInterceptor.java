package com.nice.interceptor;

import com.alibaba.druid.support.json.JSONUtils;
import com.nice.service.RedisService;
import com.nice.service.WxUserService;
import com.nice.utils.DataResult;
import com.nice.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.json.JsonObject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @ClassName MyInterceptor
 * @Description: TODO
 * @Author wmj
 * @Date 2020/2/29
 * @Version V1.0
 **/
@Component
public class MyInterceptor implements  HandlerInterceptor {
    @Autowired
    private WxUserService wxUserService;
    @Autowired
    private RedisService redisService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

//        //设置允许跨域的配置
//        // 这里填写你允许进行跨域的主机ip（正式上线时可以动态配置具体允许的域名和IP）
//        response.setHeader("Access-Control-Allow-Origin", "*");
//        // 允许的访问方法
//        response.setHeader("Access-Control-Allow-Methods","POST, GET, PUT, OPTIONS, DELETE, PATCH");
//        // Access-Control-Max-Age 用于 CORS 相关配置的缓存
//        response.setHeader("Access-Control-Max-Age", "3600");
//        response.setHeader("Access-Control-Allow-Headers","token,Origin, X-Requested-With, Content-Type, Accept");
//
//        response.setCharacterEncoding("UTF-8");
//        response.setContentType("application/json; charset=utf-8");
            try{
                String token = request.getHeader("token");
                boolean equals = redisService.exists(token);
                if(equals){
                    int wxUserId = wxUserService.getWxUserId(token);
                    request.setAttribute("userId",wxUserId);
                    return equals;
                }
                else {
                    response.getWriter().write(JsonUtils.objectToJson(DataResult.fail(401,"token过期！！",null)));
                    return equals;
                }
            }catch (Exception e){
                response.getWriter().write(JsonUtils.objectToJson(DataResult.fail(401,"token过期！！",null)));
                return false;
            }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
