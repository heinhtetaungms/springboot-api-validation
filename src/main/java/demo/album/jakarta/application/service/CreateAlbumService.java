package demo.album.jakarta.application.service;

import demo.album.jakarta.application.port.in.CreateAlbumUseCase;
import demo.album.jakarta.domain.Album;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
class CreateAlbumService implements CreateAlbumUseCase {

    @Override
    public UUID add(CreateAlbumCommand command) {
        // TODO: validate business rules

        // TODO: manipulate model state
        var album = Album.builder()
                .id(UUID.randomUUID())
                .title(command.getTitle())
                .artist(command.getArtist())
                .price(command.getPrice())
                .build();


        // TODO: return output
        return album.id();
    }
}
