package com.foody.apigateway.filter;


import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.function.HandlerFilterFunction;
import org.springframework.web.servlet.function.ServerResponse;

public class ValidationFilter {

    public static HandlerFilterFunction<ServerResponse, ServerResponse> validationFilter(){
        return (request, next) -> {

            String token = request.servletRequest().getHeader("Authorization");

            if (token == null || !token.startsWith("Bearer")) {
                return ServerResponse.status(HttpStatus.BAD_REQUEST).build();
            }

            DecodedJWT authToken = JWT.decode(token.replace("Bearer ", ""));

            if ("MODERATOR".equals(authToken.getClaim("role").asString())) {
                return next.handle(request);
            }

            Long pathId = Long.valueOf(request.pathVariable("id"));

            if (pathId.equals(authToken.getClaim("userId").asLong())) {
                return next.handle(request);
            }

            return ServerResponse.status(HttpStatus.UNAUTHORIZED).build();
        };
    }
}
