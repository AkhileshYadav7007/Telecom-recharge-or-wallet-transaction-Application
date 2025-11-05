package com.recharge.RechargeServices.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.Map;

@Component
public class MappingsLogger {
    //ye mapping ka log krne k liye hai
    private static final Logger log = LoggerFactory.getLogger(MappingsLogger.class);

    @Autowired
    private RequestMappingHandlerMapping handlerMapping;

    @EventListener(ApplicationReadyEvent.class)
    public void logMappings() {
        //ye sbhi registered request mappings ko log krta hai
        Map<RequestMappingInfo, ?> map = handlerMapping.getHandlerMethods();
        log.info("Registered Request Mappings (total={}):", map.size());
        for (RequestMappingInfo info : map.keySet()) {
            log.info(info.toString());
        }
    }
}

