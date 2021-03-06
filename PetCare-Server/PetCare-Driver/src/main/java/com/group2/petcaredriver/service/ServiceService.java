package com.group2.petcaredriver.service;

import com.group2.petcaredriver.entity.BaseService;
import com.group2.petcaredriver.repository.BaseServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ServiceService {
    @Autowired
    BaseServiceRepository baseServiceRepository;

    public List<BaseService> getAllServices() {
        return baseServiceRepository.findAll();
    }

    public BaseService createNewService(final BaseService baseService) {
        if (baseService.getId() != null) {
            Optional<BaseService> optionalExistedIdService = baseServiceRepository.findById(baseService.getId());
            if (optionalExistedIdService.isPresent() && optionalExistedIdService.get() != null) {
                throw new IllegalArgumentException("Service with same Id existed!");
            }
        }

        Optional<List<BaseService>> optionalExistedCodeService = baseServiceRepository.findBaseServicesByCode(baseService.getCode());
        if (optionalExistedCodeService.isPresent() && optionalExistedCodeService.get().size() > 0) {
            throw new IllegalArgumentException("Service with same Code existed!");
        }

        return baseServiceRepository.save(baseService);
    }

    public void deleteService(final BaseService baseService) {
        Optional<BaseService> optionalExistedIdService = baseServiceRepository.findById(baseService.getId());
        if (!optionalExistedIdService.isPresent() || optionalExistedIdService.get() == null) {
            throw new IllegalArgumentException("No service existed!");
        }

        baseServiceRepository.delete(baseService);
    }

    public BaseService updateService(final BaseService baseService) {
        Optional<BaseService> optionalExistedIdService = baseServiceRepository.findById(baseService.getId());
        if (!optionalExistedIdService.isPresent() || optionalExistedIdService.get() == null) {
            throw new IllegalArgumentException("No service existed!");
        }

        return baseServiceRepository.save(baseService);
    }
}
