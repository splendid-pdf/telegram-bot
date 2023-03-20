package com.github.splendidpdf.utils.command.impl;

import com.github.splendidpdf.command.MainMenu;
import com.github.splendidpdf.model.Event;
import com.github.splendidpdf.utils.command.MainMenuCommand;
import com.github.splendidpdf.utils.keyboard.inline.EventInlineKeyboard;
import com.github.splendidpdf.utils.keyboard.inline.ProjectInlineKeyboard;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
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
    public SendMessage execute(String chatId, Object object) {
        Event event = (Event) object;
        return SendMessage
                .builder()
                .chatId(chatId)
                .parseMode(ParseMode.HTML)
                .text(String.format("""
                                    Event name:
                                    %s
                                    Event description:
                                    %s
                                    Event date: %s
                                    """,
                        event.getName(),
                        event.getDescription(),
                        event.getLocalDateTime()))
                .replyMarkup(eventInlineKeyboard.createInlineKeyboardMarkup(event.getId()))
                .build();

    }
}
