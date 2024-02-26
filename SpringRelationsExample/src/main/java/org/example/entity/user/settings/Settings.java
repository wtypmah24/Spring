package org.example.entity.user.settings;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Settings {
    @Column(name = "is_dark_theme", columnDefinition = "boolean default false")
    private boolean isDarkTheme;
    @Column(name = "is_save_history", columnDefinition = "boolean default false")
    private boolean isSaveHistory;
    @Column(name = "nickname")
    private String nickname;
}
