package cinema.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConstructorBinding
@ConfigurationProperties(prefix = "cinema")
public record CinemaProps (
        int totalRows,
        int totalColumns,
        int firstRows,
        Price price,
        String superSecret
) {
    public record Price (int high, int low) {}
}
