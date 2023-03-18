package com.github.splendidpdf.command;

public enum EventCommand implements Command {

    EDIT_NAME() {
        @Override
        public String getName() {
            return "Edit name";
        }
    },

    EDIT_DESCRIPTION() {
        @Override
        public String getName() {
            return "Edit description";
        }
    },

    EDIT_DATE() {
        @Override
        public String getName() {
            return "Edit date";
        }
    }


}
