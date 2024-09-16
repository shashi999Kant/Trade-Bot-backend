package com.shashi.service;



import com.shashi.model.User;
import com.shashi.model.Withdrawal;

import java.util.List;

public interface WithdrawalService {

    Withdrawal requestWithdrawal(Long amount, User user);
    Withdrawal procedWithdrawal(Long withdrawalId,boolean accept) throws Exception;
    List<Withdrawal> getUsersWithdrawalHistory(User user);
    List<Withdrawal> getAllWithdrawalRequest();
}
