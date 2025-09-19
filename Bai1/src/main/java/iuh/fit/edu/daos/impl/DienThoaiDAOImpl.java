/*
 * @ (#) .java    1.0
 * Copyright (c)  IUH. All rights reserved.
 */
package iuh.fit.edu.daos.impl;

import iuh.fit.edu.entities.DienThoai;
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
public class DienThoaiDAOImpl implements iuh.fit.edu.daos.DienThoaiDAO {
    private EntityManager entityManager;

    @Override
    public List<DienThoai> findAll(){
        try {
            return entityManager.createQuery("Select n from DienThoai n", DienThoai.class)
                    .getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<DienThoai> findByMaNCC(Long id){
        String query = "select d " +
                "from DienThoai d " +
                "where d.nhaCungCap.maNhaCungCap = :id";
        try {
            return entityManager.createQuery(query, DienThoai.class)
                    .setParameter("id", id)
                    .getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
