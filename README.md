
# **TradeXpert - CryptoTradingPlatform**

TradeXpert is a full-stack cryptocurrency trading platform where users can easily buy, sell, and trade digital currencies like Bitcoin and Ethereum. The platform provides real-time market data using the `**CoinGecko API**`, offering live price updates and market trends. For secure payments, it integrates `**Razorpay**`  gateways
The platform ensures high-level security with `**JWT-based authentication**`n, allowing users to safely manage their accounts. A chatbot, powered by the Gemini API, is available to assist with trading queries and quick information.
Also integrated the `**Gemini API to build a chatbot**` that assists users with quick information and trading queries.

The backend is built with Spring Boot, while the frontend uses React.js, delivering a smooth and responsive experience for trading, portfolio management, and payment processing.


# *Technology*

- SpringBoot
- Java 17
- React js
- javascript
- Tailwind css

# *Features*

- `AI chatbot`
- `RazorPay`
- `Stripe`
- `Real time data ( Coingecko API )`
- `Spring security ( JWT )`
- `wishlist`
- `wallet`
- `portfolio`
- `profile`
- `2 step verification`
- `money transfer`
- `transaction history`
- `Activity`
- `withdrawal`
- `logout`
- `Otp service`
- `real time graph`
- `Buy and sell`

# *Screenshots*

![Screenshot (97)](https://github.com/user-attachments/assets/40154827-f8cf-4f5a-85df-8316af0b8f45)

![Screenshot (98)](https://github.com/user-attachments/assets/bc43e85e-d5f1-4640-bfc0-49a226a49335)

![Screenshot (100)](https://github.com/user-attachments/assets/abe47647-ae18-495a-ba0e-14b2b3dd2d2c)

![Screenshot (101)](https://github.com/user-attachments/assets/f45fdf9d-df20-44b8-b747-a40ff86aa22d)

<img width="351" alt="Screenshot 2024-09-16 123201" src="https://github.com/user-attachments/assets/10d8f102-ffd2-4393-be23-03f7dcc31eee">

<img width="738" alt="Screenshot 2024-09-16 123253" src="https://github.com/user-attachments/assets/2ff0344b-56d5-47bb-b7f9-bb7d7b673871">

![s2](https://github.com/user-attachments/assets/03b915e8-9c6e-4875-96d2-daa63f7b5a0b)

![s1](https://github.com/user-attachments/assets/6422e6c7-7180-4064-9815-ec0d720800a7)


# *Entities*

```
+---------------------+           +-----------------+
|       Users         |<--------->|    Wallets      |
|---------------------|           +-----------------+
| id                  |               ^            
| fullName            |               |
| email               |               |         
| ...                 |               |
+---------------------+               |
                                      |
+--------------------+            +-----------------+
|      Assets        |<---------->| WalletTransactions |
|--------------------|            +-----------------+
| id                 |
| quantity           |
| buy_price          |<---------->+-----------------+
| coin_id            |            |  Coins         |
| user_id            |            +-----------------+
+--------------------+            | id              |
                                  | symbol          |
+--------------------+            | ...             |
| Withdrawals        |<---------->+-----------------+
|--------------------|
| id                 |
| status             |
| amount             |
| user_id            |
| date               |
+--------------------+

+--------------------+
| Watchlists         |
|--------------------+
| id                 |
| user_id            |
+--------------------+
          |
          |
          v
+--------------------+
| Watchlist_Coins    |
|--------------------+
| watchlist_id       |
| coin_id            |
+--------------------+

+---------------------+           +---------------------+
|   VerificationCodes |<--------->|        Users        |
|---------------------|           +---------------------+
| id                  |
| otp                 |
| user_id             |
| email               |
| mobile              |
| verification_type   |
+---------------------+

+---------------------+           +---------------------+
|  TradingHistories   |<--------->|        Users        |
|---------------------|           +---------------------+
| id                  |
| selling_price       |
| buying_price        |
| coin_id             |
| user_id             |
+---------------------+

+---------------------+           +---------------------+
|    PaymentOrders    |<--------->|        Users        |
|---------------------|           +---------------------+
| id                  |
| amount              |
| status              |
| payment_method      |
| user_id             |
+---------------------+

+---------------------+           +---------------------+
|   PaymentDetails    |<--------->|        Users        |
|---------------------|           +---------------------+
| id                  |
| account_number      |
| account_holder_name |
| ifsc                |
| bank_name           |
| user_id             |
+---------------------+

+---------------------+           +---------------------+
|        Orders       |<--------->|        Users        |
|---------------------|           +---------------------+
| id                  |
| user_id             |
| order_type          |
| price               |
| timestamp           |
| status              |
| order_item_id       |
+---------------------+
          |
          |
          v
+---------------------+           +---------------------+
|      OrderItems     |<--------->|        Coins        |
|---------------------|           +---------------------+
| id                  |
| quantity            |
| coin_id             |
| buy_price           |
| sell_price          |
| order_id            |
+---------------------+

+---------------------+             +---------------------+
|    Notifications    | <---------> |        Users        |
|---------------------|             +---------------------+
| id                  |
| from_user_id        |
| to_user_id          |
| amount              |
| message             |
+---------------------+

+---------------------+           
|   MarketChartData   |
|---------------------|
| id                  |
| timestamp           |
| price               |
+---------------------+

+---------------------+           +---------------------+
| ForgotPasswordTokens|<--------->|        Users        |
|---------------------|           +---------------------+
| id                  |
| user_id             |
| otp                 |
| verification_type   |
| send_to             |
+---------------------+

```

# Database Tables

## Users Table

| Field                   | Type    |
|-------------------------|---------|
| id                      | bigint  |
| fullName                | varchar |
| email                   | varchar |
| mobile                  | varchar |
| password                | varchar |
| status                  | varchar |
| isVerified              | boolean |
| twoFactorAuth_enabled   | boolean |
| twoFactorAuth_sendTo    | varchar |
| picture                 | varchar |
| role                    | varchar |

## Coins Table

| Field                   | Type    |
|-------------------------|---------|
| id                      | varchar |
| symbol                  | varchar |
| name                    | varchar |
| image                   | varchar |
| current_price           | double  |
| market_cap              | bigint  |
| market_cap_rank         | int     |
| fully_diluted_valuation | bigint  |
| total_volume            | bigint  |
| high_24h                | double  |
| low_24h                 | double  |
| price_change_24h        | double  |
| price_change_percentage_24h | double  |
| market_cap_change_24h   | bigint  |
| market_cap_change_percentage_24h | double  |
| circulating_supply      | bigint  |
| total_supply            | bigint  |
| max_supply              | bigint  |
| ath                     | double  |
| ath_change_percentage   | double  |
| ath_date                | datetime|
| atl                     | double  |
| atl_change_percentage   | double  |
| atl_date                | datetime|
| roi                     | varchar |
| last_updated            | datetime|

## Assets Table

| Field     | Type    |
|-----------|---------|
| id        | bigint  |
| quantity  | double  |
| buy_price | double  |
| coin_id   | varchar |
| user_id   | bigint  |

## Withdrawals Table

| Field  | Type    |
|--------|---------|
| id     | bigint  |
| status | varchar |
| amount | bigint  |
| user_id| bigint  |
| date   | datetime|

## Watchlists Table

| Field   | Type    |
|---------|---------|
| id      | bigint  |
| user_id | bigint  |

## Watchlist_Coins Table

| Field         | Type    |
|---------------|---------|
| watchlist_id  | bigint  |
| coin_id       | varchar |

## WalletTransactions Table

| Field       | Type    |
|-------------|---------|
| id          | bigint  |
| wallet_id   | bigint  |
| type        | varchar |
| date        | datetime|
| transfer_id | varchar |
| purpose     | varchar |
| amount      | bigint  |

## Wallets Table

| Field   | Type      |
|---------|-----------|
| id      | bigint    |
| user_id | bigint    |
| balance | decimal   |

## VerificationCodes Table

| Field             | Type    |
|-------------------|---------|
| id                | bigint  |
| otp               | varchar |
| user_id           | bigint  |
| email             | varchar |
| mobile            | varchar |
| verification_type | varchar |

## TradingHistories Table

| Field         | Type    |
|---------------|---------|
| id            | bigint  |
| selling_price | double  |
| buying_price  | double  |
| coin_id       | varchar |
| user_id       | bigint  |

## PaymentOrders Table

| Field         | Type    |
|---------------|---------|
| id            | bigint  |
| amount        | bigint  |
| status        | varchar |
| payment_method| varchar |
| user_id       | bigint  |

## PaymentDetails Table

| Field               | Type    |
|---------------------|---------|
| id                  | bigint  |
| account_number      | varchar |
| account_holder_name | varchar |
| ifsc                | varchar |
| bank_name           | varchar |
| user_id             | bigint  |

## Orders Table

| Field        | Type      |
|--------------|-----------|
| id           | bigint    |
| user_id      | bigint    |
| order_type   | varchar   |
| price        | decimal   |
| timestamp    | datetime  |
| status       | varchar   |
| order_item_id| bigint    |

## OrderItems Table

| Field        | Type    |
|--------------|---------|
| id           | bigint  |
| quantity     | double  |
| coin_id      | varchar |
| buy_price    | double  |
| sell_price   | double  |
| order_id     | bigint  |

## Notifications Table

| Field        | Type    |
|--------------|---------|
| id           | bigint  |
| from_user_id | bigint  |
| to_user_id   | bigint  |
| amount       | bigint  |
| message      | varchar |

## MarketChartData Table

| Field        | Type    |
|--------------|---------|
| id           | bigint  |
| timestamp    | datetime|
| price        | double  |

## ForgotPasswordTokens Table

| Field             | Type    |
|-------------------|---------|
| id                | varchar |
| user_id           | bigint  |
| otp               | varchar |
| verification_type | varchar |
| send_to           | varchar |


 

