package com.cloud.springbootserverless.functions;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.cloud.springbootserverless.dto.Email;
import com.cloud.springbootserverless.service.EmailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@Configuration
public class ServerlessFunctions {

    private final EmailService emailService;

    public ServerlessFunctions(EmailService emailService) {
        this.emailService = emailService;
    }

    @Bean
    public Function<APIGatewayProxyRequestEvent, String> addEmail() {
        return apiGatewayProxyRequestEvent -> {
            String body = apiGatewayProxyRequestEvent.getBody();
            String input = body != null && !(body.length() < 1) ?
                    body : null;
            return input == null ||
                    !apiGatewayProxyRequestEvent.getHttpMethod().equalsIgnoreCase("POST")
                    ? "Invalid Input/Invalid HTTP Method" : emailService.addEmail(input);
        };
    }

    @Bean
    public Function<APIGatewayProxyRequestEvent, List<Email>> getEmailList() {
        return (apiGatewayProxyRequestEvent) -> {
            return !apiGatewayProxyRequestEvent.getHttpMethod().equalsIgnoreCase("GET")
                    ? new ArrayList<>() :
                    emailService.getEmailList();
        };
    }

    @Bean
    public Function<APIGatewayProxyRequestEvent, List<Email>> getEmailById() {
        return apiGatewayProxyRequestEvent -> {
            String input = apiGatewayProxyRequestEvent.getQueryStringParameters() != null &&
                    apiGatewayProxyRequestEvent.getQueryStringParameters().containsKey("input") ?
                    apiGatewayProxyRequestEvent.getQueryStringParameters().get("input") : null;
            return input != null &&
                    apiGatewayProxyRequestEvent.getHttpMethod().equalsIgnoreCase("GET")
                    ? emailService.getEmailByEmailId(input) : new ArrayList<>();
        };
    }

    @Bean
    public Function<APIGatewayProxyRequestEvent, String> uppercase() {

        return value -> {
            String input = value.getQueryStringParameters() != null &&
                    value.getQueryStringParameters().containsKey("input") ?
                    value.getQueryStringParameters().get("input") : null;
            return input == null ? "Invalid Query Parameter" : input.toUpperCase();
        };

    }

    @Bean
    public Function<APIGatewayProxyRequestEvent, String> lowercase() {

        return value -> {
            String input = value.getQueryStringParameters() != null &&
                    value.getQueryStringParameters().containsKey("input") ?
                    value.getQueryStringParameters().get("input") : null;
            return input == null ? "Invalid Query Parameter" : input.toLowerCase();
        };

    }

    @Bean
    public Function<APIGatewayProxyRequestEvent, String> reverse() {

        return value -> {
            String input = value.getQueryStringParameters() != null &&
                    value.getQueryStringParameters().containsKey("input") ?
                    value.getQueryStringParameters().get("input") : null;
            return input == null ? "Invalid Query Parameter" : input.transform(string -> {
                char[] strArr = string.toCharArray();
                String res = "";
                for (int i = strArr.length - 1; i >= 0; i--) {
                    res += (char) strArr[i];
                }
                return res;
            });
        };

    }

}
