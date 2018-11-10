package com.example.demo.config;

import me.chanjar.weixin.mp.api.WxMpConfigStorage;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WeChatConfig {
    @Value("${weChat.appId}")
    private String appId;
    @Value("${weChat.secret}")
    private String secret;

    public WeChatConfig() {
    }

    @Bean
    public WxMpInMemoryConfigStorage wxMpConfigStorage() {
        WxMpInMemoryConfigStorage wxMpConfigStorage = new WxMpInMemoryConfigStorage();
        wxMpConfigStorage.setAppId(this.appId);
        wxMpConfigStorage.setSecret(this.secret);
        return wxMpConfigStorage;
    }

    @Bean
    public WxMpService wxMpService(WxMpConfigStorage wxMpConfigStorage) {
        WxMpService wxMpService = new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(wxMpConfigStorage);
        return wxMpService;
    }
}
