package net.mem.my_organisation.services.impl;

import net.mem.my_organisation.model.Position;
import net.mem.my_organisation.repository.PositionRepository;
import net.mem.my_organisation.services.PositionService;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PositionServiceImpl implements PositionService {

    private final PositionRepository positionRepository;

    public PositionServiceImpl(PositionRepository repository) {
        positionRepository = repository;
    }

    @Override
    public Collection<Position> getAllPositions() {
        return positionRepository.findAll();
    }
}
