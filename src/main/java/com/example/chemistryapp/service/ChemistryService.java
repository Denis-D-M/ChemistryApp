package com.example.chemistryapp.service;

import com.example.chemistryapp.entity.ChemistryEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.Transactional;
import java.util.List;

@Stateless
public class ChemistryService {

    private final EntityManager entityManager = Persistence.createEntityManagerFactory("default").createEntityManager();

    public List<ChemistryEntity> getAllChemistry(){
        entityManager.clear();
        return entityManager.createQuery("select ec from CHEMISTRY_ENTITY ec").getResultList();
    };

    public ChemistryEntity getChemistry(Long exId){
       return (ChemistryEntity) entityManager
               .createNativeQuery("select * from CHEMISTRY_ENTITY WHERE id = :id", ChemistryEntity.class)
               .setParameter("id", exId)
               .getSingleResult();
    }
    @Transactional
    public void addChemistry(Long exId, String exLabel){
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager
                .createNativeQuery("insert into CHEMISTRY_ENTITY VALUES (:id, :label)", ChemistryEntity.class)
                .setParameter("id", exId)
                .setParameter("label", exLabel)
                .executeUpdate();
        transaction.commit();
    }

    @Transactional
    public void editChemistry(Long exId, String exLabel){
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager
                .createNativeQuery("update CHEMISTRY_ENTITY set id = :id, name = :label where id = :id", ChemistryEntity.class)
                .setParameter("id", exId)
                .setParameter("label", exLabel)
                .executeUpdate();
        transaction.commit();
    }
}
