package demo.album.jakarta.adapter.in.web;

import demo.album.jakarta.adapter.in.web.dto.CreateAlbumRequest;
import demo.album.jakarta.application.port.in.CreateAlbumUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static demo.album.jakarta.application.port.in.CreateAlbumUseCase.CreateAlbumCommand;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.ResponseEntity.created;
import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/jakarta/albums")
final class AlbumController {

    private final CreateAlbumUseCase createAlbumUseCase;

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    ResponseEntity<Void> create(@RequestBody CreateAlbumRequest request) {
        var command = CreateAlbumCommand.builder()
                .title(request.title())
                .artist(request.artist())
                .price(request.price())
                .build(); // validations are applied on build

        var albumId = createAlbumUseCase.add(command);

        return created(fromCurrentRequest().path("/{id}").build(albumId)).build();
    }

}
