package com.github.splendidpdf.repository;

import com.github.splendidpdf.model.BotUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BotUserRepository extends JpaRepository<BotUser, Long> {

    Optional<BotUser> findByTelegramId(Long telegramId);

}