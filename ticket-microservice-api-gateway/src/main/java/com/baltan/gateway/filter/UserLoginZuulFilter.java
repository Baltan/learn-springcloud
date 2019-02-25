package com.baltan.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Description:
 *
 * @author Baltan
 * @date 2019-02-08 15:08
 */
@Component
public class UserLoginZuulFilter extends ZuulFilter {
    @Override
    public String filterType() {
        /**
         * 返回过滤器类型，包括pre：请求在路由之前执行
         *                  post：在routing和error过滤器之后执行
         *                  error：处理请求发生错误时执行
         *                  routing：在路由请求时执行
         */
        return "pre";
    }

    @Override
    public int filterOrder() {
        /**
         * 定义过滤器执行顺序，数字越小优先级越高
         */
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        /**
         * 返回true，则该过滤器需要被执行
         */
        return true;
    }

    @Override
    public Object run() {
        /**
         * 过滤器具体业务逻辑
         */
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        String token = request.getParameter("token");
        if (StringUtils.isEmpty(token)) {
            requestContext.setSendZuulResponse(false); // 过滤该请求，不对其进行路由
            requestContext.setResponseStatusCode(401); // 设置状态响应码
            try {
                requestContext.getResponse().getWriter().write("请求参数中没有token参数");
            } catch (IOException e) {
            }
        }
        return null;
    }
}
