package org.example.testcrud.controller.response;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ApiResponse <D> {
    private boolean status = false;
    private D body;
    private List<String> messages;

    {
        messages = new ArrayList<>();
    }
}
