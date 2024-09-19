package org.globallogic.utils;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public final class Date {
    public static String dateNow() {
        return DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")
                .withZone(ZoneOffset.UTC)
                .format(LocalDateTime.now());
    }

    public Date() {}
}
