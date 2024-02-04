package org.enes.service;

import lombok.RequiredArgsConstructor;
import org.enes.entity.Model;
import org.enes.exception.ErrorType;
import org.enes.exception.TryMeAppException;
import org.enes.repository.ModelRepository;
import org.enes.utility.ICrudService;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ModelService implements ICrudService<Model,Long> {
    private final ModelRepository modelRepository;


    @Override
    public Model save(Model model) {
        Model model1 = modelRepository.save(model);

        if (model1 != null) {
            return model1;
        }
        throw new TryMeAppException(ErrorType.BAD_REQUEST);
    }

    @Override
    public Model update(Model model) {
        return modelRepository.save(model);
    }

    @Override
    public Iterable<Model> saveAll(Iterable<Model> t) {
        return modelRepository.saveAll(t);
    }

    @Override
    public void deleteById(Long aLong) {
        modelRepository.deleteById(aLong);
    }

    @Override
    public Optional<Model> findById(Long aLong) {
        Optional<Model> model = modelRepository.findById(aLong);
        if (model.isEmpty()) {
            throw new TryMeAppException(ErrorType.ENTITY_NOT_FOUND);
        }
        return model;
    }

    @Override
    public List<Model> findAll() {
        return modelRepository.findAll();
    }
}
