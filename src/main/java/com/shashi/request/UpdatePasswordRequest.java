package com.shashi.request;


import com.shashi.domain.VerificationType;
import lombok.Data;

@Data
public class UpdatePasswordRequest {
    private String sendTo;
    private VerificationType verificationType;
}
