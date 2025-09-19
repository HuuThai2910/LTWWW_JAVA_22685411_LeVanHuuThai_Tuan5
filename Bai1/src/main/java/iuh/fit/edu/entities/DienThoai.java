/*
 * @ (#) .java    1.0
 * Copyright (c)  IUH. All rights reserved.
 */
package iuh.fit.edu.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 * @description
 * @author: Huu Thai
 * @date:
 * @version: 1.0
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DienThoai {
    @Id
    @Column(name = "MADT")
    private Long maDienThoai;

    @Column(name = "TENDT")
    private String tenDienThoai;
    @Column(name = "NAMSANXUAT")
    private int namSanXuat;
    @Column(name = "CAUHINH")
    private String cauHinh;

    @Column(name = "HINHANH")
    private String hinhAnh;

    @ManyToOne
    @JoinColumn(name = "MANCC")
    private NhaCungCap nhaCungCap;
}
