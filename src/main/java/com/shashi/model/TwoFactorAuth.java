package com.shashi.model;

import com.shashi.domain.VerificationType;
import lombok.Data;

@Data
public class TwoFactorAuth {

    private boolean isEnabled = false;
    private VerificationType sendTo;
}
