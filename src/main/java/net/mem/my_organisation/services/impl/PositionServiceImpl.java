package net.mem.my_organisation.services.impl;

import net.mem.my_organisation.model.Position;
import net.mem.my_organisation.repository.PositionRepository;
import net.mem.my_organisation.services.PositionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PositionServiceImpl implements PositionService {

    private final PositionRepository positionRepository;

    public PositionServiceImpl(PositionRepository repository) {
        positionRepository = repository;
    }

    @Override
    //public Collection<Position> getAllPositions() {
        //return positionRepository.findAll();
    public Collection <String> getAllPositions() {
        List<Position> positions = positionRepository.findAll();
        return positions.stream().map(Position::getPosition_name).collect(Collectors.toCollection(() -> new ArrayList<>()));
    }
}
