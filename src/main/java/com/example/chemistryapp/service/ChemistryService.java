package com.example.chemistryapp.service;

import com.example.chemistryapp.entity.ChemistryEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

@Stateless
public class ChemistryService {

    protected EntityManager entityManager = Persistence.createEntityManagerFactory("default").createEntityManager();

    public List<ChemistryEntity> getAllChemistry(){
        return entityManager.createNativeQuery("select * from CHEMISTRY_ENTITY", ChemistryEntity.class).getResultList();
    };

    public ChemistryEntity getChemistry(Long exId){
       return (ChemistryEntity) entityManager
               .createNativeQuery("select * from CHEMISTRY_ENTITY WHERE id = :id", ChemistryEntity.class)
               .setParameter("id", exId)
               .getSingleResult();
    }
}
