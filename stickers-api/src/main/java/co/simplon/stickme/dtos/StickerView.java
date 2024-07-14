package co.simplon.stickme.dtos;

import java.time.LocalDate;

public interface StickerView {

    Long getId();

    String getName();

    String getImageUrl();

    String getSizeName(); // Parcours graph d'objet Size Name

    String getAspectName(); // Parcours graph d'objet Size Name

    LocalDate getCreatedAt();

    float getPrice();

    String getDescription();

}
