package org.example.testcrud.controller.response;

import lombok.Data;

import java.util.List;

@Data
public class ApiResponse <D> {
    boolean status = false;
    D body;
    List<String> messages;
}
