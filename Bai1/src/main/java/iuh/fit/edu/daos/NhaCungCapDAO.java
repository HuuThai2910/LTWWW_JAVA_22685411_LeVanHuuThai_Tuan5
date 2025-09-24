/*
 * @ (#) .java    1.0
 * Copyright (c)  IUH. All rights reserved.
 */
package iuh.fit.edu.daos;/*
 * @description
 * @author: Huu Thai
 * @date:
 * @version: 1.0
 */

import iuh.fit.edu.entities.NhaCungCap;

import java.util.List;

public interface NhaCungCapDAO {
    List<NhaCungCap> findAll();

    NhaCungCap findById(Long id);

    List<NhaCungCap> findByKeyword(String keyword);
}
