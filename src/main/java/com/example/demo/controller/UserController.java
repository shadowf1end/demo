package com.example.demo.controller;

import com.example.demo.common.util.JwtUtil;
import com.example.demo.entity.Number;
import com.example.demo.service.NumberService;
import com.example.demo.service.UserService;
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

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("user")
public class UserController {

    private final WxMpService wxMpService;
    private final UserService userService;
    private final NumberService numberService;

    @Autowired
    public UserController(WxMpService wxMpService, UserService userService, NumberService numberService) {
        this.wxMpService = wxMpService;
        this.userService = userService;
        this.numberService = numberService;
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
        userService.save(user);
        WxJsapiSignature wxJsapiSignature = wxMpService.createJsapiSignature("ohmez.com/index.html");
        return ResultMap.ok().put("sign", wxJsapiSignature).put("token", JwtUtil.generateJwt(user.getId()));
    }

    @RequestMapping(value = "share", method = RequestMethod.GET)
    public ResultMap share(HttpServletRequest request) {
        Integer id = (Integer) request.getAttribute("id");
        User user = userService.find(id);
        Number number = numberService.findFirst().get(0);
        user.setPoints(user.getPoints() + number.getSharePoint());
        userService.save(user);
        return ResultMap.ok();
    }
}
