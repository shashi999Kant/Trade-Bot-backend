package com.shashi.service;

import com.razorpay.RazorpayException;
import com.shashi.domain.PaymentMethod;
import com.shashi.model.PaymentOrder;
import com.shashi.model.User;
import com.shashi.response.PaymentResponse;
import com.stripe.exception.StripeException;


public interface PaymentService {

    PaymentOrder createOrder(User user, Long amount, PaymentMethod paymentMethod);

    PaymentOrder getPaymentOrderById(Long id) throws Exception;

    Boolean ProccedPaymentOrder (PaymentOrder paymentOrder,
                                 String paymentId) throws RazorpayException;

    PaymentResponse createRazorpayPaymentLink(User user,
                                              Long Amount,
                                              Long orderId) throws RazorpayException;

    PaymentResponse createStripePaymentLink(User user, Long Amount,
                                            Long orderId) throws StripeException;
}
