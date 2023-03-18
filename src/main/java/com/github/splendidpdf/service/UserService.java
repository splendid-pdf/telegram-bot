package com.github.splendidpdf.service;

import com.github.splendidpdf.model.BotUser;
import com.github.splendidpdf.model.Role;
import com.github.splendidpdf.model.TimeZone;
import com.github.splendidpdf.repository.BotUserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Location;
import org.telegram.telegrambots.meta.api.objects.User;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final BotUserRepository botUserRepository;

    public void create(User telegramUser) throws Exception {
        Optional<BotUser> storedUser = botUserRepository.findByTelegramId(telegramUser.getId());
        if(storedUser.isPresent()) {
           throw new Exception("User already exist");
        }
        BotUser botUser = BotUser.builder()
                .telegramId(telegramUser.getId())
                .username(telegramUser.getUserName())
                .timeZone(TimeZone.GMT3)
                .role(Role.NONE)
                .build();
        botUserRepository.save(botUser);
    }

    public void updateLocation(User telegramUser, Location location) {
        Long telegramId = telegramUser.getId();
        BotUser botUser = botUserRepository.findByTelegramId(telegramId)
                .orElseThrow(()-> new EntityNotFoundException("not found" + telegramId));
        botUser.setLongitude(location.getLongitude());
        botUser.setLatitude(location.getLatitude());
        botUserRepository.save(botUser);
    }

    public void updateRole(User telegramUser){

    }
}
