package com.shashi.service;


import com.shashi.model.CoinDTO;
import com.shashi.response.ApiResponse;

public interface ChatBotService {
    ApiResponse getCoinDetails(String coinName);

    CoinDTO getCoinByName(String coinName);

    String simpleChat(String prompt);
}
