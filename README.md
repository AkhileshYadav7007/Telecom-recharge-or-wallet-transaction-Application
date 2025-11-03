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
