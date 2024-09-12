package com.colegio.rest.apirestcolegio.dto;

import java.util.List;

public record BaseResponse<T>(
        String Code,
        String Message,
        String MessageFriendly,
        T Response,
        List<T> ResponseList
) {
}
