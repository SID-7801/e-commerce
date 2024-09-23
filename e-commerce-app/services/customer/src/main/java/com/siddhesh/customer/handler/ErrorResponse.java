package com.siddhesh.customer.handler;

import java.util.Map;

public record ErrorResponse(Map<String, String> errors) {
}
