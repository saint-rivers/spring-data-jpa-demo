package com.ksga.jpademo.model.response;


import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ApiResponse {

    @Data
    @AllArgsConstructor
    public static class SuccessMessage {
        private String message;
        private String status;
    }

    @Data
    @AllArgsConstructor
    public static class SuccessPayload<T> {
        private String message;
        private String status;
        private T payload;
    }

    @Data
    @AllArgsConstructor
    public static class Failure {
        private String message;
        private String status;
    }
}
