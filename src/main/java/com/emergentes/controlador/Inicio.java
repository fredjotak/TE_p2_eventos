package com.emergentes.controlador;

import com.emergentes.dao.SeminarioDAO;
import com.emergentes.dao.SeminarioDAOimpl;
import com.emergentes.modelo.Seminario;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Inicio", urlPatterns = {"/Inicio"})
public class Inicio extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            SeminarioDAO dao = new SeminarioDAOimpl();
            int id ; // para recibir el id
            Seminario seminario = new Seminario(); // para gestionar registros
            String action = (request.getParameter("action") != null)? request.getParameter("action"): "view";
            switch(action) {
                case "add":
                    // Nuevo seminario
                    request.setAttribute("seminario", seminario);
                    request.getRequestDispatcher("frmseminario.jsp").forward(request, response);
                    break;
                case "edit":
                    // Para editar un seminario
                    id = Integer.parseInt(request.getParameter("id"));
                    seminario = dao.getById(id);
                    request.setAttribute("seminario", seminario);
                    request.getRequestDispatcher("frmseminario.jsp").forward(request, response);
                    break;
                case "delete":
                    // Para eliminar un seminario
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("Inicio");
                    break;
                default:
                    // Listar todos los seminarios
                    List<Seminario> lista = dao.getAll();
                    request.setAttribute("seminarios", lista);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                    break;
            }
        } catch (Exception e) {
            System.out.println("ERROR: "+e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SeminarioDAO dao = new SeminarioDAOimpl();
        int id = Integer.parseInt(request.getParameter("hdnId"));
        String titulo = request.getParameter("txtTitulo");
        String expositor = request.getParameter("txtExpositor");
        String fecha = request.getParameter("dateFecha");
        String hora = request.getParameter("timeHoraInicio") + " - " + request.getParameter("timeHoraFinal");
        int cupo = Integer.parseInt(request.getParameter("nroCupo"));
        
        Seminario seminario = new Seminario();
        seminario.setId(id);
        seminario.setTitulo(titulo);
        seminario.setExpositor(expositor);
        seminario.setFecha(fecha);
        seminario.setHora(hora);
        seminario.setCupo(cupo);
        
        if(id==0){ // 0 entonces nuevo seminario
            try {
                dao.insert(seminario);
                response.sendRedirect("Inicio");
            } catch (Exception e) {
                System.out.println("Error nuevo: "+e.getMessage());
            }
        } else { // actualizar un seminario
            try {
                dao.update(seminario);
                response.sendRedirect("Inicio");
            } catch (Exception e) {
                System.out.println("Error actualizar: "+e.getMessage());
            }
        }
    }

}