

package com.sagnf.medicinereminder.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String medicineName;
    private String slot; // BEFORE_BREAKFAST, AFTER_BREAKFAST etc
    private String time;
    private String date;
    private int days;
}

