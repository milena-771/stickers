package co.simplon.stickme.dtos;

public class StickerUpdate {

    private String name;

    private String imageUrl;

    private float price;

    private Long sizeId;

    private Long aspectId;

    private String description;

    public StickerUpdate() {
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

    public float getPrice() {
	return price;
    }

    public void setPrice(float price) {
	this.price = price;
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

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    @Override
    public String toString() {
	return " {name=" + name + ", imageUrl=" + imageUrl
		+ ", price=" + price + ", sizeId=" + sizeId
		+ ", aspectId=" + aspectId
		+ ", description=" + description + "}";
    }

}
