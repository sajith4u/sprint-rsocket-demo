package com.mobic.labs.client.resource;

import com.mobic.labs.core.MarketData;
import com.mobic.labs.core.MarketDataRequest;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author SAJITH
 */
@RestController
public class StockController {

    private final RSocketRequester rSocketRequester;

    @Autowired
    public StockController(RSocketRequester rSocketRequester) {
        this.rSocketRequester = rSocketRequester;
    }

    @GetMapping(value = "/current/{stock}")
    public Publisher<MarketData> current(@PathVariable("stock") String stock) {
        return rSocketRequester
                .route("stock")
                .data(new MarketDataRequest(stock))
                .retrieveMono(MarketData.class);
    }
}
