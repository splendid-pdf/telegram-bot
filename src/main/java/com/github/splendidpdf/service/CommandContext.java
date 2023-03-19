package com.github.splendidpdf.service;

import com.github.splendidpdf.utils.command.MainMenuCommand;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Service
public class CommandContext {

    private final Map<String, MainMenuCommand> menuMap = new HashMap<>();

    @Autowired
    public CommandContext(List<MainMenuCommand> menuMap) {
        menuMap.forEach(menu -> this.getMenuMap().put(menu.getCommandSyntax(), menu));
    }

    public MainMenuCommand retrieveMenu(String menuIdentifier) {
        return menuMap.get(menuIdentifier);
    }
}