package com.github.splendidpdf.command;

public enum MainMenuCommand implements Command {
    CREATE_EVENT() {
        @Override
        public String getName() {
            return "Create event";
        }
    },
    EVENTS_CALENDAR {
        @Override
        public String getName() {
            return "Events calendar";
        }
    },

    MY_PROFILE {
        @Override
        public String getName() {
            return "My profile";
        }
    }

}


