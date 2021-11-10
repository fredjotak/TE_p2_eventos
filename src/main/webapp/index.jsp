<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/styleGlobal.css">
        <link rel="stylesheet" href="css/style.css">
        <title>Seminarios</title>
    </head>
    <body>
        <section>
            <div class="info fondo-azul alerta">
                <h2 class="centro">Segundo Parcial TEM-742</h2>
                <p>
                    <b>Nombre:</b> Freddy Mamani Valencia <br>
                    <b>Carnet:</b> 6908916 
                </p>
            </div>
            <br /> <br />
            <h1 class="centro">Seminarios</h1>
            <p><a href="Inicio?action=add" class="boton boton-izq fondo-naranja ancho-200p">Nuevo seminario</a></p>
            <table class="tabla-uno">
                <tr>
                    <th>Id</th>
                    <th>Titulo</th>
                    <th>Expositor</th>
                    <th>Fecha</th>
                    <th>Hora</th>
                    <th>Cupos</th>
                    <th colspan="2">Acción</th>
                </tr><c:forEach var="item" items="${seminarios}">
                    <tr>
                        <td>${item.id}</td>
                        <td>${item.titulo}</td>
                        <td>${item.expositor}</td>
                        <td>${item.fecha}</td>
                        <td>${item.hora}</td>
                        <td>${item.cupo}</td>
                        <td><a class="color-azul" href="Inicio?action=edit&id=${item.id}">Editar</a></td>
                        <td><a class="color-rojo" href="Inicio?action=delete&id=${item.id}" onclick="return (confirm('¿Estas seguro de eliminar el seminario ${item.titulo}?'))">Eliminar</a></td>
                    </tr>
                </c:forEach>
            </table>
        </section>
        <footer>
            © 2021/11/09 - Todos los derechos reservados
        </footer>
    </body>
</html>
