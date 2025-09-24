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

import iuh.fit.edu.entities.DienThoai;

import java.util.List;

public interface DienThoaiDAO {
    List<DienThoai> findAll();

    List<DienThoai> findByMaNCC(Long id);

    boolean save(DienThoai dienThoai);

    boolean update(DienThoai dienThoai);

    boolean delete(Long maDienThoai);

    DienThoai findById(Long id);
}
