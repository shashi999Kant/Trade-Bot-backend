package com.shashi.service;


import com.shashi.model.Coin;
import com.shashi.model.User;
import com.shashi.model.Watchlist;

public interface WatchlistService {

    Watchlist findUserWatchlist(Long userId) throws Exception;

    Watchlist createWatchList(User user);

    Watchlist findById(Long id) throws Exception;

    Coin addItemToWatchlist(Coin coin, User user) throws Exception;
}
