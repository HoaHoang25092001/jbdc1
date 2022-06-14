/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Brand;
import models.BrandFacade;

/**
 *
 * @author PHT
 */
@WebServlet(name = "BrandController", urlPatterns = {"/brand"})
public class BrandController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //Xu ly yeu cau dua vao action
        String action = request.getAttribute("action").toString();
        switch (action) {
            case "index":
                //Xu ly
                index(request, response);
                break;
            case "create":
                //hiện form create để nhập dữ liệu (craete --submit--> save)
                create(request, response);
                break;
            case "save":
                //Lưu Toy vào dâtabase
                save(request, response);
                break;
            case "edit":
                //hiện form create để sửa dữ liệu (craete --submit--> update)
                edit(request, response);
                break;
            case "confirm":
                //hiện form để xác nhận việc xóa dữ liệu (craete --submit--> delete)
                confirm(request, response);
                break;
            case "delete":
                //Xóa toy trong database
                delete(request, response);
                break;
            case "update":
                //Cập nhật Toy vào dâtabase
                update(request, response);
                break;
            default:
                request.setAttribute("action", "error");
        }
        //Chon view de hien ket qua
        request.getRequestDispatcher("/WEB-INF/layouts/main.jsp").forward(request, response);
    }

    public void index(HttpServletRequest request, HttpServletResponse response) {
        //Xu ly
        BrandFacade bf = new BrandFacade();
        List<Brand> list = bf.readAll();
        request.setAttribute("list", list);
    }

    public void create(HttpServletRequest request, HttpServletResponse response) {
        //Xu ly
        BrandFacade bf = new BrandFacade();
        List<Brand> list = bf.readAll();
        request.setAttribute("list", list);
    }
    public void edit(HttpServletRequest request, HttpServletResponse response) {
        //Xu ly
        String id = request.getParameter("id");
        BrandFacade bf = new BrandFacade();
        Brand brand = bf.read(id);
        request.setAttribute("brand", brand);
    }
    public void confirm(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        request.setAttribute("id", id);
    }
    public void save(HttpServletRequest request, HttpServletResponse response) {
        try {
            String op = request.getParameter("op");
            if (op.equals("save")) {
                String id = request.getParameter("id");
                String name = request.getParameter("name");
                Brand brand = new Brand(id, name);
                BrandFacade bf = new BrandFacade();
                bf.create(brand);
            }
            //Quay ve view index (redirect to index view)
            index(request, response);
            request.setAttribute("action", "index");
        } catch (Exception ex) {
            Logger.getLogger(ToyController.class.getName()).log(Level.SEVERE, null, ex);
            //Chi hien lai view create va thong bao loi
            request.setAttribute("action", "create");
            request.setAttribute("errorMessage", "Invalid data.");
        }
    }
    public void delete(HttpServletRequest request, HttpServletResponse response) {
         try {
            String op = request.getParameter("op");
            if (op.equals("yes")) {
                String id = request.getParameter("id");
                BrandFacade bf = new BrandFacade();
                bf.delete(id);
            }
            //Quay ve view index (redirect to index view)
            index(request, response);
            request.setAttribute("action", "index");
        } catch (Exception ex) {
            Logger.getLogger(ToyController.class.getName()).log(Level.SEVERE, null, ex);
            //Cho hien lai view edit va thong bao loi
            request.setAttribute("action", "confirm");
            request.setAttribute("errorMessage", "Exception: "+ex.getMessage());
            //In thong tin loi chi tiet o phia server      
        }
    }
    public void update(HttpServletRequest request, HttpServletResponse response) {
        try {
            String op = request.getParameter("op");
            if (op.equals("update")) {
                String id = request.getParameter("id");
                String name = request.getParameter("name");
                Brand brand = new Brand(id, name);
                BrandFacade bf = new BrandFacade();
                bf.update(brand);
            }
            //Quay ve view index (redirect to index view)
            index(request, response);
            request.setAttribute("action", "index");
        } catch (Exception ex) {
            Logger.getLogger(ToyController.class.getName()).log(Level.SEVERE, null, ex);
            //Cho hien lai view edit va thong bao loi
            request.setAttribute("action", "edit");
            request.setAttribute("errorMessage", "Exception:"+ex.getMessage());
            //In thông tin lỗi chi tiết ở phía server
            ex.printStackTrace();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
