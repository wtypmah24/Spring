package org.example.congrats;

public enum Holiday {
    HAPPY_BIRTHDAY("Happy B-Day! %s"),
    MARCH_8("Dear, %s, happy women's day!"),
    NEW_YEAR("%s, happy new year!"),
    INDEPENDENCE_DAY("Happy independence day, %s");

    private final String congratulation;

    Holiday(String congratulation) {
        this.congratulation = congratulation;
    }

    public String getCongratulation() {
        return congratulation;
    }
}
