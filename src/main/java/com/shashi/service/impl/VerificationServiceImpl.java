package com.shashi.service.impl;


import com.shashi.domain.VerificationType;
import com.shashi.model.User;
import com.shashi.model.VerificationCode;
import com.shashi.repository.VerificationRepository;
import com.shashi.service.VerificationService;
import com.shashi.utils.OtpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VerificationServiceImpl implements VerificationService {

    @Autowired
    private VerificationRepository verificationRepository;

    @Override
    public VerificationCode sendVerificationOTP(User user, VerificationType verificationType) {

        VerificationCode existingCode = verificationRepository.findByUserId(user.getId());
        if (existingCode != null) {
            verificationRepository.delete(existingCode); // Delete the existing OTP if any
        }

        VerificationCode verificationCode = new VerificationCode();

        verificationCode.setOtp(OtpUtils.generateOTP());
        verificationCode.setUser(user);
        verificationCode.setVerificationType(verificationType);

        return verificationRepository.save(verificationCode);
    }

    @Override
    public VerificationCode findVerificationById(Long id) throws Exception {
        Optional<VerificationCode> verificationCodeOption=verificationRepository.findById(id);
        if(verificationCodeOption.isEmpty()){
            throw new Exception("verification not found");
        }
        return verificationCodeOption.get();
    }

    @Override
    public VerificationCode findUsersVerification(User user) throws Exception {
        return verificationRepository.findByUserId(user.getId());
    }

    @Override
    public Boolean VerifyOtp(String opt, VerificationCode verificationCode) {
        return opt.equals(verificationCode.getOtp());
    }

    @Override
    public void deleteVerification(VerificationCode verificationCode) {
        verificationRepository.delete(verificationCode);
    }


}
