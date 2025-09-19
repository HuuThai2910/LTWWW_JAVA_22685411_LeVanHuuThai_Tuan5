/*
 * @ (#) .java    1.0
 * Copyright (c)  IUH. All rights reserved.
 */
package iuh.fit.edu.daos.impl;

import iuh.fit.edu.daos.NhaCungCapDAO;
import iuh.fit.edu.entities.NhaCungCap;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;

import java.util.List;

/*
 * @description
 * @author: Huu Thai
 * @date:
 * @version: 1.0
 */
@AllArgsConstructor
public class NhaCungCapDAOImpl implements NhaCungCapDAO {
    private EntityManager entityManager;

    @Override
    public List<NhaCungCap> findAll(){
        try{
            return entityManager.createQuery("Select n from NhaCungCap n", NhaCungCap.class)
                    .getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
