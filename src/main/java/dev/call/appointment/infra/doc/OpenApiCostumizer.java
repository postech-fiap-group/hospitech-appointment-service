package dev.call.appointment.infra.doc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

//@Configuration
//public class OpenApiCustomizer {
//
//    @Bean
//    public OpenApiCustomizer customizeSecurityForPublicPaths() {
//        return openApi -> {
//            List<String> publicPaths = List.of("/auth", "/auth/login");
//
//            openApi.getPaths().forEach((path, pathItem) -> {
//                if (publicPaths.contains(path)) {
//                    if (pathItem.getPost() != null) {
//                        pathItem.getPost().setSecurity(List.of()); // força "security": []
//                    }
//                }
//            });
//        };
//    }
//}