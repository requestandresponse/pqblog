package com.fb.pqBlog.security.web.controller;

import com.fb.pqBlog.common.restult.CommonRestult;
import com.fb.pqBlog.security.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class SecurityController {

    private RequestCache requestCache = new HttpSessionRequestCache();

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Autowired
    private SecurityProperties securityProperties;

    @GetMapping("security/dispatcher")
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    public CommonRestult<String> dispatcher(HttpServletRequest request, HttpServletResponse response){
        System.out.println(securityProperties.getCode().getImage().getHeight());
        CommonRestult<String> restult = new CommonRestult<>();
        try {
            SavedRequest savedRequest = requestCache.getRequest(request, response);
            if(request != null){
                if(savedRequest.getRedirectUrl().endsWith(".html")){
                    redirectStrategy.sendRedirect(request,response,"");
                }
            }else {
                restult.setMessage("未授权");
            }
        } catch (IOException e) {
            restult.setMessage(e.getMessage());
        }
        return restult;
    }
}
