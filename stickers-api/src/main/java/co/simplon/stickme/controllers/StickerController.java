package co.simplon.stickme.controllers;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.stickme.dtos.StickerCreateDto;
import co.simplon.stickme.dtos.StickerForUpdate;
import co.simplon.stickme.dtos.StickerUpdate;
import co.simplon.stickme.dtos.StickerView;
import co.simplon.stickme.services.StickerService;

@RestController
@RequestMapping("/stickers")
@CrossOrigin
public class StickerController {

    private StickerService service;

    public StickerController(StickerService service) {
	this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void create(
	    @Valid @RequestBody StickerCreateDto inputs) {
	service.create(inputs);
    }

    @GetMapping
    public Collection<StickerView> getAll() {
	return service.getAll();
    }

    @GetMapping("/{id}")
    public StickerView detail(@PathVariable("id") Long id) {
	return service.detail(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
	service.delete(id);

    }

    @GetMapping("/{id}/for-update")
    public StickerForUpdate forUpdate(
	    @PathVariable("id") Long id) {
	return service.forUpdate(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody StickerUpdate inputs,
	    @PathVariable("id") Long id) {
	service.update(inputs, id);
    }

}
