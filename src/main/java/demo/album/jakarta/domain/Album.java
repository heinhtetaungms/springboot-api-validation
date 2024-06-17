package demo.album.jakarta.domain;

import lombok.Builder;

import java.math.BigDecimal;
import java.util.UUID;

@Builder
public record Album(UUID id,
                    String title,
                    String artist,
                    BigDecimal price) {
}
