package org.example.dto.user.settings;

import jakarta.validation.constraints.Size;
import org.springframework.lang.Nullable;

public record SettingsDto(
        @Nullable
        Boolean isDarkTheme,
        @Nullable
        Boolean isSaveHistory,
        @Size(min = 1, max = 100, message = "nickname length could be from 1 to 100 symbols") String nickname
) {
}
