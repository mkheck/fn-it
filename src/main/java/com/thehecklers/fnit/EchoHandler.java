package com.thehecklers.fnit;

import com.microsoft.azure.functions.*;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import org.springframework.cloud.function.adapter.azure.FunctionInvoker;

import java.util.Optional;

public class EchoHandler extends FunctionInvoker<String, String> {
    @FunctionName("echo")
//    public HttpResponseMessage handleItRoy(@HttpTrigger(name = "req",
    public String handleItRoy(@HttpTrigger(name = "req",
            methods = {HttpMethod.GET, HttpMethod.POST},
            authLevel = AuthorizationLevel.ANONYMOUS) final HttpRequestMessage<Optional<String>> request,
                                           ExecutionContext ctx) {
        String newString = request.getBody().orElse("Brand new String");
//        return request.createResponseBuilder(HttpStatus.OK)
//                .body(handleRequest(newString, ctx))
//                .header("Content-type", "application/json")
//                .build();
        return handleRequest(newString, ctx);

    }
}