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
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;
import java.util.List;

/*
 * @description
 * @author: Huu Thai
 * @date:
 * @version: 1.0
 */
@WebServlet(name = "dienThoaiController", urlPatterns = {"/dienthoais", "/dienthoais*"})
public class DienThoaiController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action == null)
            action = "";
        if(action.equals("list"))
            handleShowListDienThoai(req, resp);
        else
            handlShowListNhaCungCap(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try(EntityManager entityManager = EntityManagerFactoryUtil.getEntityManager()) {
            NhaCungCapDAO nhaCungCapDAO = new NhaCungCapDAOImpl(entityManager);
            String keyword = req.getParameter("keyword");
            if(keyword != null && !keyword.trim().isEmpty()){
                List<NhaCungCap> nhaCungCaps = nhaCungCapDAO.findByKeyword(keyword);
                req.setAttribute("nhaCungCaps", nhaCungCaps);
                req.setAttribute("keyword", keyword);
                req.getRequestDispatcher("views/nhacungcap/DanhSachNhaCungCap.jsp").forward(req, resp);
            }
        }
    }


    private void handleShowListDienThoai(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try(EntityManager entityManager = EntityManagerFactoryUtil.getEntityManager()) {
            DienThoaiDAO dienThoaiDAO = new DienThoaiDAOImpl(entityManager);
            NhaCungCapDAO nhaCungCapDAO = new NhaCungCapDAOImpl(entityManager);
            List<NhaCungCap> nhaCungCaps = nhaCungCapDAO.findAll();
            List<DienThoai> dienThoais = null;
            String maNhaCungCap = req.getParameter("maNCC");
            if(maNhaCungCap == null ||"-1".equals(maNhaCungCap))
                dienThoais = dienThoaiDAO.findAll();
            else
                dienThoais = dienThoaiDAO.findByMaNCC(Long.parseLong(maNhaCungCap));
            req.setAttribute("dienThoais", dienThoais);
            req.setAttribute("nhaCungCaps", nhaCungCaps);
            req.getRequestDispatcher("/views/dienthoai/DanhSachDienThoaiNCC.jsp").forward(req, resp);
        }
    }
    private void handlShowListNhaCungCap(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try(EntityManager entityManager = EntityManagerFactoryUtil.getEntityManager()) {
            NhaCungCapDAO nhaCungCapDAO = new NhaCungCapDAOImpl(entityManager);
            List<NhaCungCap> nhaCungCaps = nhaCungCapDAO.findAll();
            req.setAttribute("nhaCungCaps", nhaCungCaps);
            req.getRequestDispatcher("views/nhacungcap/DanhSachNhaCungCap.jsp").forward(req, resp);
        }
    }
}
