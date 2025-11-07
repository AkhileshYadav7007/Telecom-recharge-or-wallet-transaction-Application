package com.recharge.RechargeServices.service;

import com.recharge.RechargeServices.entity.ChannelUser;
import com.recharge.RechargeServices.entity.Wallet;
import com.recharge.RechargeServices.repository.ChannelUserRepository;
import com.recharge.RechargeServices.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

@Component
public class DataLoader implements CommandLineRunner {
    // This class loads initial test data into the database at application startup

    private final ChannelUserRepository userRepository;
    private final WalletRepository walletRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public DataLoader(ChannelUserRepository userRepository, WalletRepository walletRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.walletRepository = walletRepository;
        this.passwordEncoder = passwordEncoder;
        // Constructor injection of repositories and password encoder
    }

    @Override
    public void run(String... args) throws Exception {
        //create for root user if not exists
        String testUserId = "root";
        if (userRepository.findById(testUserId).isEmpty()) {
            ChannelUser user = new ChannelUser();
            user.setUserId(testUserId);
            user.setUserName("root ");
            user.setPassword(passwordEncoder.encode("229009"));
            user.setFirstName("Root");
            user.setLastName("User");
            user.setMsisdn("0000000000");
            user.setStatus("ACTIVE");
            user.setModifiedOn(LocalDateTime.now());
            userRepository.save(user);
        }

        // create a wallet for root
        if (walletRepository.findByUserId(testUserId).stream().findFirst().isEmpty()) {
            Wallet w = new Wallet();
            w.setWalletId("W" + new Date().getTime());
            w.setUserId(testUserId);
            w.setBalance(1000L);
            w.setStatus("A");
            walletRepository.save(w);
        }

        String testUserId2 = "USER2";
        if (userRepository.findById(testUserId2).isEmpty()) {
            ChannelUser user = new ChannelUser();
            user.setUserId(testUserId2);
            user.setUserName("user2");
            user.setPassword(passwordEncoder.encode("password"));
            user.setFirstName("Test");
            user.setLastName("User 2");
            user.setMsisdn("0000000001");
            user.setStatus("ACTIVE");
            user.setModifiedOn(LocalDateTime.now());
            userRepository.save(user);
        }

        // create a wallet for USER2
        if (walletRepository.findByUserId(testUserId2).stream().findFirst().isEmpty()) {
            Wallet w = new Wallet();
            w.setWalletId("W" + new Date().getTime());
            w.setUserId(testUserId2);
            w.setBalance(500L);
            w.setStatus("A");
            walletRepository.save(w);
        }
    }
}
