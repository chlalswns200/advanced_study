package hello.advanced.app.v5;

import hello.advanced.trace.callback.TraceCallback;
import hello.advanced.trace.callback.TraceTemplate;
import hello.advanced.trace.logtrace.LogTrace;
import hello.advanced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV5 {

    private final OrderServiceV5 orderServiceV5;
    private final TraceTemplate template;

    @GetMapping("/v5/request")
    public String request(@RequestParam("itemId") String itemId) {
        return template.excute("OrderController.request", new TraceCallback<>() {
            @Override
            public String call() {
                orderServiceV5.orderItem(itemId);
                return "ok";
            }
        });

    }

}
