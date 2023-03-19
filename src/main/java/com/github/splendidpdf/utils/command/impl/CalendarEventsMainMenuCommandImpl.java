package com.github.splendidpdf.utils.command.impl;

import com.github.splendidpdf.command.MainMenu;
import com.github.splendidpdf.utils.command.MainMenuCommand;
import com.github.splendidpdf.utils.keyboard.inline.EventInlineKeyboard;
import com.github.splendidpdf.utils.keyboard.inline.ProjectInlineKeyboard;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CalendarEventsMainMenuCommandImpl implements MainMenuCommand {

    private final EventInlineKeyboard eventInlineKeyboard;
    @Override
    public String getCommandSyntax() {
        return MainMenu.EVENTS_CALENDAR.getName();
    }

    @Override
    public List<SendMessage> execute(List<SendMessage> sendMessages) {
        sendMessages.forEach(sendMessage -> sendMessage.setReplyMarkup(eventInlineKeyboard.getInlineKeyboardMarkup()));
        return sendMessages;
    }
}
