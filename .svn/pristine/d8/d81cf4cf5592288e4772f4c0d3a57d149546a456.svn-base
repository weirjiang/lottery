package com.suryani.manage.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class UserOnlineInterceptor extends HandlerInterceptorAdapter {

    private CacheManager cacheManager;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String userId = request.getParameter("userId");
        if (!StringUtils.isBlank(userId)) {
            if (cacheManager.getCache("UserOnline").get(userId) == null) {
                cacheManager.getCache("UserOnline").put(userId, userId);
            }
        }
        return true;
    }

    @Autowired
    public void setCacheManager(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }
}
