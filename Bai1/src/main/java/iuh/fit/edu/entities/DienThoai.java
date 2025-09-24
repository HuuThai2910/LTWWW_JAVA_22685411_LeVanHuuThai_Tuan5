/*
 * @ (#) .java    1.0
 * Copyright (c)  IUH. All rights reserved.
 */
package iuh.fit.edu.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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
    @NotNull(message = "Mã điện thoại không được để trống")
    private Long maDienThoai;

    @Column(name = "TENDT")
    @NotBlank(message = "Tên điện thoại không được để trống")
    private String tenDienThoai;
    @NotNull
    @Min(value = 1000, message = "Năm sản xuất phải có 4 chữ số")
    @Max(value = 9999, message = "Năm sản xuất phải có 4 chữ số")
    @Column(name = "NAMSANXUAT")
    private int namSanXuat;

    @Pattern(regexp = "^.{1,255}$", message = "Thông tin cấu hình không được vượt quá 255 ký tự")
    @Column(name = "CAUHINH")
    private String cauHinh;
    
    @Column(name = "HINHANH")
    @Pattern(regexp="([^\\s]+(\\.(?i)(jpg|jpeg|png))$)", message="Ảnh chỉ chấp nhận jpg, jpeg, png")
    private String hinhAnh;

    @ManyToOne
    @JoinColumn(name = "MANCC")
    private NhaCungCap nhaCungCap;
}
