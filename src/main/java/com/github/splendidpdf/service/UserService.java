package com.github.splendidpdf.service;

import com.github.splendidpdf.exception.EntityAlreadyExistsException;
import com.github.splendidpdf.model.BotUser;
import com.github.splendidpdf.model.Role;
import com.github.splendidpdf.model.TimeZone;
import com.github.splendidpdf.repository.BotUserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.telegram.telegrambots.meta.api.objects.Location;
import org.telegram.telegrambots.meta.api.objects.User;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final BotUserRepository botUserRepository;

    @Transactional
    public void create(User telegramUser) throws EntityAlreadyExistsException {
        Optional<BotUser> storedUser = botUserRepository.findByTelegramId(telegramUser.getId());
        if (storedUser.isPresent()) {
            throw new EntityAlreadyExistsException();
        }
        BotUser botUser = BotUser.builder()
                .telegramId(telegramUser.getId())
                .username(telegramUser.getUserName())
                .timeZone(TimeZone.GMT3)
                .role(Role.NONE)
                .build();
        botUserRepository.save(botUser);
    }

    @Transactional
    public void updateLocation(User telegramUser, Location location) {
        Long telegramId = telegramUser.getId();
        BotUser botUser = botUserRepository.findByTelegramId(telegramId)
                .orElseThrow(() -> new EntityNotFoundException("User not found" + telegramId));
        botUser.setLongitude(location.getLongitude());
        botUser.setLatitude(location.getLatitude());
        botUserRepository.save(botUser);
    }

    @Transactional
    public void updateRole(User telegramUser, Role role) {
        Long telegramId = telegramUser.getId();
        BotUser botUser = botUserRepository.findByTelegramId(telegramId)
                .orElseThrow(() -> new EntityNotFoundException("User not found" + telegramId));
        botUser.setRole(role);
        botUserRepository.save(botUser);
    }

    public BotUser findByTelegramId(Long telegramId) {
        return botUserRepository.findByTelegramId(telegramId)
                .orElseThrow(() -> new EntityNotFoundException("User not found" + telegramId));
    }
}