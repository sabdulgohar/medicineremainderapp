package com.sagnf.medicinereminder.controller;

import com.sagnf.medicinereminder.entity.Medicine;
import com.sagnf.medicinereminder.service.MedicineService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicine")
@CrossOrigin
public class MedicineController {

    private final MedicineService service;

    public MedicineController(MedicineService service) {
        this.service = service;
    }

    @PostMapping
    public Medicine saveMedicine(@RequestBody Medicine medicine) {
        return service.saveMedicine(medicine);
    }

    @GetMapping
    public List<Medicine> getAllMedicines() {
        return service.getAllMedicines();
    }
}
