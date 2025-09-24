/*
 * @ (#) .java    1.0
 * Copyright (c)  IUH. All rights reserved.
 */
package iuh.fit.edu.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

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
public class NhaCungCap {
    @Id
    @Column(name = "MANCC")
    private Long maNhaCungCap;

    @Column(name = "TENNHACC")
    private String tenNhaCungCap;
    @Column(name = "DIACHI")
    private String diaChi;
    @Column(name = "SODIENTHOAI")
    private String soDienThoai;

    @OneToMany(mappedBy = "nhaCungCap")
    private List<DienThoai> dienThoais;


}
