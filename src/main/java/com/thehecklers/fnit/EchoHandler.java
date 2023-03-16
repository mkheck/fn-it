package com.thehecklers.fnit;

import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.HttpMethod;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.function.Function;

@Component
public class EchoHandler {
//public class EchoHandler extends FunctionInvoker<String, String> {

    @Autowired
    private Function<String, String> echo;

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

//        return handleRequest(newString, ctx);
        return echo.apply(newString);
    }
}