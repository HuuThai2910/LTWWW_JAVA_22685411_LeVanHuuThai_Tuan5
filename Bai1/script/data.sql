-- Bảng Nhà Cung Cấp
INSERT INTO NHACUNGCAP (MANCC, TENNHACC, DIACHI, SODIENTHOAI) VALUES
                                                                  (1, 'Công ty TNHH Samsung Việt Nam', 'Bắc Ninh', '0912345678'),
                                                                  (2, 'Công ty TNHH Apple Việt Nam', 'TP. Hồ Chí Minh', '0987654321'),
                                                                  (3, 'Công ty TNHH Oppo Việt Nam', 'Bình Dương', '0934567890'),
                                                                  (4, 'Công ty TNHH Xiaomi Việt Nam', 'Hà Nội', '0909090909'),
                                                                  (5, 'Công ty TNHH Vivo Việt Nam', 'Đà Nẵng', '0977777777');

-- Bảng Điện Thoại (6 dữ liệu, Samsung có 2 máy)
INSERT INTO DIENTHOAI (MADT, TENDT, NAMSANXUAT, CAUHINH, MANCC, HINHANH) VALUES
                                                                             (1, 'Samsung Galaxy S23', 2023, 'Snapdragon 8 Gen 2, 8GB RAM, 256GB ROM', 1, 's23.jpg'),
                                                                             (2, 'Samsung Galaxy Z Fold 5', 2023, 'Snapdragon 8 Gen 2, 12GB RAM, 512GB ROM', 1, 'zfold5.jpg'),
                                                                             (3, 'iPhone 15 Pro Max', 2023, 'Apple A17 Pro, 8GB RAM, 256GB ROM', 2, 'iphone15promax.jpg'),
                                                                             (4, 'Oppo Reno10', 2023, 'Snapdragon 778G, 12GB RAM, 256GB ROM', 2, 'reno10.jpg'),
                                                                             (5, 'Xiaomi 13T Pro', 2023, 'Dimensity 9200+, 12GB RAM, 512GB ROM', 4, 's23.jpg'),
                                                                             (6, 'Vivo V29', 2023, 'Snapdragon 778G, 8GB RAM, 128GB ROM', 5, 'iphone15promax.jpg');
