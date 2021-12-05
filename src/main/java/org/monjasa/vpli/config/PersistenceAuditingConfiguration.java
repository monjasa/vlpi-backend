package org.monjasa.vpli.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "principalEmailAuditorAware")
public class PersistenceAuditingConfiguration {

    @Value("${auditing.anonymous-principal}")
    private String anonymousPrincipal;

    @Bean
    public AuditorAware<String> principalEmailAuditorAware() {
        return () -> Optional.of(SecurityContextHolder.getContext().getAuthentication().getPrincipal())
                .filter(UserDetails.class::isInstance)
                .map(UserDetails.class::cast)
                .map(UserDetails::getUsername)
                .or(this::getAnonymousPrincipal);
    }

    public Optional<String> getAnonymousPrincipal() {
        return Optional.of(anonymousPrincipal);
    }
}
