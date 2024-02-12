package com.app.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

@RestController
public class HeaderController {
    @GetMapping("/headers")
    public ResponseEntity<?> headers(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String, String> headers = new HashMap<>();
        Iterator<String> inner = request.getHeaderNames().asIterator();
        inner.forEachRemaining(hName -> headers.put(hName, request.getHeader(hName)));
        if (headers.size() < 3) {
            try {
                response.sendError(400, "Need more headers");
                return ResponseEntity.badRequest().body("Need more headers");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        if (Objects.equals(headers.get("x-error-result"), "true")) {
            try {
                response.sendError(500, "get your error");
                return ResponseEntity.badRequest().body("get your error");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        String redirectPath = headers.get("x-forward-path");
        if (redirectPath != null && !redirectPath.isBlank()) {
            response.sendRedirect(redirectPath);
            return null;
        }
        return ResponseEntity.ok().body(headers);
    }
}