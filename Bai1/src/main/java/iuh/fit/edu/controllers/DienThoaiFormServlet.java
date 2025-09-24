/*
 * @ (#) .java    1.0
 * Copyright (c)  IUH. All rights reserved.
 */
package iuh.fit.edu.controllers;

import iuh.fit.edu.daos.DienThoaiDAO;
import iuh.fit.edu.daos.NhaCungCapDAO;
import iuh.fit.edu.daos.impl.DienThoaiDAOImpl;
import iuh.fit.edu.daos.impl.NhaCungCapDAOImpl;
import iuh.fit.edu.entities.DienThoai;
import iuh.fit.edu.entities.NhaCungCap;
import iuh.fit.edu.utils.EntityManagerFactoryUtil;
import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import jakarta.validation.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Set;

/*
 * @description
 * @author: Huu Thai
 * @date:
 * @version: 1.0
 */
@WebServlet(name = "dienThoaiFormServlet", urlPatterns = {"/add-dt", "/add-dt*"})
@MultipartConfig
public class DienThoaiFormServlet extends HttpServlet {
    private String uploadPathToSource;
    private String uploadPathToTarget;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        // 1. Source path
        uploadPathToSource = "C:/IUH/Nam4/LTWWW/LTWWW_JAVA_22685411_LeVanHuuThai_Tuan5/Bai1/src/main/webapp/images";
        File uploadPathToSourceDir = new File(uploadPathToSource);
        if (!uploadPathToSourceDir.exists()) {
            uploadPathToSourceDir.mkdirs();
        }

        // 2. Target path
        uploadPathToTarget = this.getServletContext().getRealPath("/images");

        File uploadPathToTargetDir = new File(uploadPathToTarget);
        if (!uploadPathToTargetDir.exists()) {
            uploadPathToTargetDir.mkdirs();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try(EntityManager entityManager = EntityManagerFactoryUtil.getEntityManager()){
            NhaCungCapDAOImpl nhaCungCapDAO = new NhaCungCapDAOImpl(entityManager);
            List<NhaCungCap> nhaCungCaps = nhaCungCapDAO.findAll();
            req.setAttribute("nhaCungCaps", nhaCungCaps);
            req.getRequestDispatcher("views/dienthoai/DienThoaiForm.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try(EntityManager entityManager = EntityManagerFactoryUtil.getEntityManager()) {
            DienThoaiDAO dienThoaiDAO = new DienThoaiDAOImpl(entityManager);
            NhaCungCapDAO nhaCungCapDAO = new NhaCungCapDAOImpl(entityManager);
            List<NhaCungCap> nhaCungCaps = nhaCungCapDAO.findAll();
            DienThoai newDienThoai = new DienThoai();
            String maDienThoai = req.getParameter("maDienThoai");
            if(!maDienThoai.isBlank()){
                newDienThoai.setMaDienThoai(Long.parseLong(maDienThoai));
            }
            newDienThoai.setTenDienThoai(req.getParameter("tenDienThoai"));
            String namSanXuat = req.getParameter("namSanXuat");
            if(!namSanXuat.isBlank()){
                newDienThoai.setNamSanXuat(Integer.parseInt(namSanXuat));
            }
            newDienThoai.setCauHinh(req.getParameter("cauHinh"));

            newDienThoai.setNhaCungCap(nhaCungCapDAO.findById(Long.parseLong(req.getParameter("maNhaCungCap"))));
            Part filePart = req.getPart("hinhAnh");
            String hinhAnh = "";
            if (filePart != null && filePart.getSubmittedFileName()
                    != null && !filePart.getSubmittedFileName().isEmpty()) {
                hinhAnh = filePart.getSubmittedFileName();
            }
            newDienThoai.setHinhAnh(hinhAnh);
            ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
            Validator validator = validatorFactory.getValidator();
            Set<ConstraintViolation<DienThoai>> violations = validator.validate(newDienThoai);
            if(!violations.isEmpty()){
                req.setAttribute("errors", violations);
                req.setAttribute("newDienThoai", newDienThoai);
                req.setAttribute("nhaCungCaps", nhaCungCaps);
                req.getRequestDispatcher("views/dienthoai/DienThoaiForm.jsp").forward(req, resp);
            }
            if(dienThoaiDAO.save(newDienThoai)){
                byte[] imageBytes = null;
                try (InputStream input = filePart.getInputStream()) {
                    imageBytes = input.readAllBytes();
                }
                Files.write(Paths.get(uploadPathToSource, hinhAnh), imageBytes, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
                Files.write(Paths.get(uploadPathToTarget, hinhAnh), imageBytes, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
                resp.sendRedirect(req.getContextPath() + "/dienthoais?action=list");
            }

        }
    }
}
