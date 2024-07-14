package co.simplon.stickme.services;

import java.util.Collection;

import org.springframework.stereotype.Service;

import co.simplon.stickme.dtos.SizeView;
import co.simplon.stickme.repositories.SizeRepository;

@Service
public class SizeServiceImpl implements SizeService {

    private SizeRepository sizes;

    public SizeServiceImpl(SizeRepository sizes) {
	this.sizes = sizes;
    }

    @Override
    public Collection<SizeView> getAllSizes() {
	return sizes.findAllProjectedBy();

    }

}
