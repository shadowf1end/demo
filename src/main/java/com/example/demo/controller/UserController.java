package com.example.demo.controller;

import com.example.demo.common.service.UserService;
import com.example.demo.common.vo.ResultMap;
import com.example.demo.entity.User;
import me.chanjar.weixin.common.bean.WxJsapiSignature;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    private final WxMpService wxMpService;
    private final UserService userService;

    @Autowired
    public UserController(WxMpService wxMpService, UserService userService) {
        this.wxMpService = wxMpService;
        this.userService = userService;
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ResultMap login(String code) throws WxErrorException {
        WxMpOAuth2AccessToken wxMpOAuth2AccessToken = wxMpService.oauth2getAccessToken(code);
        String openId = wxMpOAuth2AccessToken.getOpenId();
        User user = userService.findByOpenId(openId);
        if (user == null) {
            user = new User();
            user.setOpenId(openId);
        }
        WxJsapiSignature wxJsapiSignature = wxMpService.createJsapiSignature("ohmez.com/index.html");
        return ResultMap.ok().put("data", wxJsapiSignature);
    }
}
