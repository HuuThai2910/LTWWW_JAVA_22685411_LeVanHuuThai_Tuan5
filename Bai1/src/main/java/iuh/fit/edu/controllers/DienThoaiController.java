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
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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
    }
    private void handleShowListDienThoai(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try(EntityManager entityManager = EntityManagerFactoryUtil.getEntityManager()) {
            DienThoaiDAO dienThoaiDAO = new DienThoaiDAOImpl(entityManager);
            NhaCungCapDAO nhaCungCapDAO = new NhaCungCapDAOImpl(entityManager);
            List<NhaCungCap> nhaCungCaps = nhaCungCapDAO.findAll();
            List<DienThoai> dienThoais = null;
            String maNhaCungCap = req.getParameter("maNCC");
            if("-1".equals(maNhaCungCap))
                dienThoais = dienThoaiDAO.findAll();
            else
                dienThoais = dienThoaiDAO.findByMaNCC(Long.parseLong(maNhaCungCap));
            req.setAttribute("dienThoais", dienThoais);
            req.setAttribute("nhaCungCaps", nhaCungCaps);
            req.getRequestDispatcher("views/dienthoai/list.jsp").forward(req, resp);
        }
    }
}
