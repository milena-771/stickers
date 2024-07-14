package co.simplon.stickme.services;

import java.util.Collection;

import co.simplon.stickme.dtos.StickerCreateDto;
import co.simplon.stickme.dtos.StickerForUpdate;
import co.simplon.stickme.dtos.StickerUpdate;
import co.simplon.stickme.dtos.StickerView;

public interface StickerService {

    void create(StickerCreateDto inputs);

    Collection<StickerView> getAll();

    StickerView detail(Long id);

    void delete(Long id);

    StickerForUpdate forUpdate(Long id);

    void update(StickerUpdate inputs, Long id);

}
