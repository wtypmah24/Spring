package org.example.entity.user.verification;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.entity.user.User;

@Entity
@Table(name = "user_verification_data")
@Data
@NoArgsConstructor
public class UserVerificationData {
    @Id
    @Column(name = "user_id")
    private long userId;

    @Column(name = "photo")
    private String photo;

    @Column(name = "voice_sample")
    private String voiceSample;

    @Column(name = "bio_data")
    private String bioData;

    @Column(name = "is_verified")
    private boolean isVerified;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private User user;
}
