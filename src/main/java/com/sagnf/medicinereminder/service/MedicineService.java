package com.sagnf.medicinereminder.service;

import com.sagnf.medicinereminder.entity.Medicine;
import com.sagnf.medicinereminder.repository.MedicineRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineService {

    private final MedicineRepository repository;

    public MedicineService(MedicineRepository repository) {
        this.repository = repository;
    }

    public Medicine saveMedicine(Medicine medicine) {
        return repository.save(medicine);
    }

    public List<Medicine> getAllMedicines() {
        return repository.findAll();
    }
}
