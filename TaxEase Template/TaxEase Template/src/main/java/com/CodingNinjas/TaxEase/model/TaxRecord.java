package com.CodingNinjas.TaxEase.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Generated;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
    This is the entity class, complete this class by doing the following:

    a. Add the required annotations for making this class an entity.
    b. Add the required lombok annotations for getter, setter and constructors
 */
@Data
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaxRecord {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String taxYear;
    private int Income;
    private int deductions;
    private boolean isFilingApproved;

}
