package com.mobic.labs.server.resource;

import com.mobic.labs.core.MarketData;
import com.mobic.labs.core.MarketDataRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

/**
 * @author SAJITH
 */
@Slf4j
@Controller
public class MarketResource {

    @MessageMapping("stock")
    public Mono<MarketData> currentMarketData(MarketDataRequest marketDataRequest) {
        log.info("Received the request {}", marketDataRequest.getStock());
        return Mono.just(new MarketData(1, "GNETXT", "1.167"));
    }

}
