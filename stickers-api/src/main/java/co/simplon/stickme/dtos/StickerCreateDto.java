package co.simplon.stickme.dtos;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class StickerCreateDto {

    @NotBlank
    private String name;

    @NotBlank
    private String imageUrl;

    @NotNull
    private Long sizeId;

    @NotNull
    private Long aspectId;

    @NotNull
    @DecimalMin(value = "0.01", inclusive = true)
    @DecimalMax(value = "100.00", inclusive = true)
    private float price;

    @NotBlank
    private String description;

    public StickerCreateDto() {
	super();
	// TODO Auto-generated constructor stub
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getImageUrl() {
	return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
	this.imageUrl = imageUrl;
    }

    public Long getSizeId() {
	return sizeId;
    }

    public void setSizeId(Long sizeId) {
	this.sizeId = sizeId;
    }

    public Long getAspectId() {
	return aspectId;
    }

    public void setAspectId(Long aspectId) {
	this.aspectId = aspectId;
    }

    public float getPrice() {
	return price;
    }

    public void setPrice(float price) {
	this.price = price;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    @Override
    public String toString() {
	return "StickerCreateDto [name=" + name
		+ ", imageUrl=" + imageUrl + ", sizeId="
		+ sizeId + ", aspectId=" + aspectId
		+ ", price=" + price + ", description="
		+ description + "]";
    }

}
