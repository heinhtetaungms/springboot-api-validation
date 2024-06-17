package demo.album.jakarta.adapter.in.web.dto;

import java.math.BigDecimal;

public record CreateAlbumRequest(String title,
                                 String artist,
                                 BigDecimal price) {
}
