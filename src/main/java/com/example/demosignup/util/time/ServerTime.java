package com.example.demosignup.util.time;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;

public final class ServerTime {
    public static OffsetDateTime now() {
        return OffsetDateTime.now(ZoneId.of("Asia/Seoul"));
    }

    public static LocalDateTime nowAsLocalDateTime() {
        return now().toLocalDateTime();
    }
}
