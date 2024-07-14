package co.simplon.stickme.controllers;

import java.util.Collection;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.stickme.dtos.SizeView;
import co.simplon.stickme.services.SizeService;

@RestController
@RequestMapping("/sizes")
@CrossOrigin
public class SizeController {

    private SizeService service;

    public SizeController(SizeService service) {
	this.service = service;
    }

    @GetMapping
    public Collection<SizeView> getAllSizes() {
	return service.getAllSizes();
    }
}
