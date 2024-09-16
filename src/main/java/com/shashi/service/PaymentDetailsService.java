package com.shashi.service;


import com.shashi.model.PaymentDetails;
import com.shashi.model.User;

public interface PaymentDetailsService {
    public PaymentDetails addPaymentDetails(String accountNumber,
                                            String accountHolderName,
                                            String ifsc,
                                            String bankName,
                                            User user
    );

    public PaymentDetails getUsersPaymentDetails(User user);


}
