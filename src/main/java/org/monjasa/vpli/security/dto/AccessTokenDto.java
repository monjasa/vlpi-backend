package org.monjasa.vpli.security.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Builder
public class AccessTokenDto {

    private String accessToken;

    private Instant issuedAt;

    private Long expiresIn;

}
