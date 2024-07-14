package co.simplon.stickme.services;

import java.time.LocalDate;
import java.util.Collection;

import org.springframework.stereotype.Service;

import co.simplon.stickme.dtos.StickerCreateDto;
import co.simplon.stickme.dtos.StickerForUpdate;
import co.simplon.stickme.dtos.StickerUpdate;
import co.simplon.stickme.dtos.StickerView;
import co.simplon.stickme.entities.Aspect;
import co.simplon.stickme.entities.Size;
import co.simplon.stickme.entities.Sticker;
import co.simplon.stickme.repositories.AspectRepository;
import co.simplon.stickme.repositories.SizeRepository;
import co.simplon.stickme.repositories.StickerRepository;

@Service
public class StickerServiceImpl implements StickerService {

    private StickerRepository stickers;

    private SizeRepository sizes;

    private AspectRepository aspects;

    public StickerServiceImpl(StickerRepository stickers,
	    SizeRepository sizes,
	    AspectRepository aspects) {
	this.stickers = stickers;
	this.sizes = sizes;
	this.aspects = aspects;
    }

    @Override
    public void create(StickerCreateDto inputs) {
	Sticker sticker = new Sticker();
	sticker.setName(inputs.getName());
	sticker.setImageUrl(inputs.getImageUrl());
	Long sizeId = inputs.getSizeId();
	Size size = sizes.getReferenceById(sizeId);
	sticker.setSize(size);
	Long aspectId = inputs.getAspectId();
	Aspect aspect = aspects.getReferenceById(aspectId);
	sticker.setAspect(aspect);
	LocalDate createdAt = LocalDate.now();
	sticker.setCreatedAt(createdAt);
	sticker.setPrice(inputs.getPrice());
	sticker.setDescription(inputs.getDescription());
	this.stickers.save(sticker);
    }

    @Override
    public Collection<StickerView> getAll() {
	return stickers.findByOrderByPriceAsc(); // replace findAllProjectedBy() to have a projection in asc order on prices
    }

    @Override
    public StickerView detail(Long id) {
	return stickers.findProjectedDetailById(id);
    }

    @Override
    public void delete(Long id) {
	stickers.deleteById(id);
    }

    @Override
    public StickerForUpdate forUpdate(Long id) {
	return stickers.findProjectedById(id);
    }

    @Override
    public void update(StickerUpdate inputs, Long id) {
	Sticker entity = stickers.findById(id).get();
	entity.setName(inputs.getName());
	entity.setImageUrl(inputs.getImageUrl());
	Long sizeId = inputs.getSizeId();
	Size size = sizes.getReferenceById(sizeId);
	entity.setSize(size);
	Long aspectId = inputs.getAspectId();
	Aspect aspect = aspects.getReferenceById(aspectId);
	entity.setAspect(aspect);
	entity.setPrice(inputs.getPrice());
	entity.setDescription(inputs.getDescription());
	stickers.save(entity);

    }

}
