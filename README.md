# Telecom-recharge-or-wallet-transaction-Application

sys_service_types 
       ↑
       |
sys_product_profiles
       ↑
       |
itn_product_profile
       ↑
       |
itn_product_commissions

itn_channel_users ─────┬── itn_wallet
                       └── itn_transaction_header ──┬── itn_transaction_items
itn_subscribers ───────┘                             └── references itn_wallet

itn_thresholds_profiles ───┬── itn_thresholds_profile_dtls
                           └── itn_default_threshold

itn_service_charge_profile ─┬── itn_service_charge
                            └── itn_service_charge_details
itn_mnytfr_srvchrg ─────────┬── itn_mnytfr_srvchrg_dtls 


| Column                                                     | Type           | Key                  | Description                                |
| ---------------------------------------------------------- | -------------- | -------------------- | ------------------------------------------ |
| `wallet_id`                                                | `varchar(64)`  | **Primary Key (PK)** | Unique ID for each wallet                  |
| `user_id`                                                  | `varchar(20)`  | **Foreign Key (FK)** | Links to `itn_channel_users.user_id`       |
| `user_type`                                                | `varchar(20)`  |                      | Type of user (maybe agent, customer, etc.) |
| `msisdn`                                                   | `varchar(15)`  |                      | Mobile number                              |
| `wallet_type`                                              | `varchar(20)`  |                      | Type of wallet (e.g. prepaid/postpaid)     |
| `prev_balance`, `balance`, `net_credit`, `net_debit`       | `bigint`       |                      | Numeric fields for money tracking          |
| `last_transation_type`, `last_transation_id`               | `varchar`      |                      | Stores details of the latest transaction   |
| `status`                                                   | `varchar(2)`   |                      | Wallet status (active/inactive)            |
| `wallet_limit`                                             | `bigint`       |                      | Max allowed balance                        |
| `last_transation_on`, `first_transation_on`, `modified_on` | `datetime`     |                      | Timestamps for wallet activities           |
| `operator_Code`                                            | `varchar(100)` |                      | Possibly the telecom/operator ID           |

