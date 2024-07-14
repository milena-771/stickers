package co.simplon.stickme.controllers;

import java.util.Collection;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.stickme.dtos.AspectView;
import co.simplon.stickme.services.AspectService;

@RestController
@RequestMapping("/aspects")
@CrossOrigin
public class AspectController {

    private AspectService service;

    public AspectController(AspectService service) {
	this.service = service;
    }

    @GetMapping
    public Collection<AspectView> getAllAspects() {
	return service.getAllAspects();
    }

}
