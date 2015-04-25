/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import conta.ContaCorrenteRemote;
import entidade.ClienteRemote;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Emannuel
 */
@WebServlet(name = "BancoFrontController", urlPatterns = {"/BancoFrontController"})
public class BancoFrontController extends HttpServlet {

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
            throws ServletException, IOException, NamingException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String operation = (String)request.getAttribute("operation");
            System.out.println("---> " + operation);
            if (operation.equalsIgnoreCase("entrar")) {
                String agencia = request.getParameter("agencia");
                String conta   = request.getParameter("conta");
                if (this.entrar(agencia, conta)) {
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
                    rd.forward(request, response);
                } else {
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/tentarNovamente.jsp");
                    rd.forward(request, response);
                }
            } else if (operation.equalsIgnoreCase("login")) {
                String senha = request.getParameter("senha");
                if (this.login(senha)) {
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/pagamento.jsp");
                    rd.forward(request, response);
                }
            } else if (operation.equalsIgnoreCase("efetuarPagamento")) {
                String codigo = request.getParameter("codigo");
                String valor  = request.getParameter("valor");
                if (this.efetuarPagamento(codigo, valor)) {
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/pagamentoEfetuado.jsp");
                    rd.forward(request, response);
                }
            }
        }
    }

    public boolean entrar(String agencia, String conta) throws NamingException  {
        System.out.println("entrar:\n " + agencia + "\n" + conta);
        InitialContext ic = new InitialContext();
        ContaCorrenteRemote contaCorrente = (ContaCorrenteRemote)ic.lookup("conta.ContaCorrenteRemote");
        if (contaCorrente.autenticarConta(agencia, conta)) {
            return true;
        }
        return false;
    }
    
    public boolean login(String senha) {
        System.out.println("login!!!\n" + senha);
        return true;
    }
    
    public boolean efetuarPagamento(String codigo, String valor) {
        System.out.println("pagamento\n" + codigo + "\n" + valor);
        return true;
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
        try {
            processRequest(request, response);
        } catch (NamingException ex) {
            Logger.getLogger(BancoFrontController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (NamingException ex) {
            Logger.getLogger(BancoFrontController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
