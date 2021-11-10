<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/styleGlobal.css">
        <link rel="stylesheet" href="css/style.css">
        <title>
            <c:if test="${seminario.id==0}">Nuevo Seminario</c:if>
            <c:if test="${seminario.id!=0}">Editar Seminario</c:if>
        </title>
    </head>
    <body>
        <section>
            <div class="contenedor-formulario">
                <h1 class="formulario-titulo">
                    <c:if test="${seminario.id==0}">Nuevo Seminario</c:if>
                    <c:if test="${seminario.id!=0}">Editar Seminario</c:if>
                </h1>
                <div class="formulario-logo"><img src="css/imagen/exposicion.png" alt=""></div>
                <form action="Inicio" class="formulario fondo-azul" method="POST">
                    <div class="formulario-campos">
                        <input type="hidden" name="hdnId" value="${seminario.id}" />
                        <label for="txtTitulo">Titulo:</label>
                        <input type="text" id="txtTitulo" name="txtTitulo" required placeholder="Titulo del seminario" value="${seminario.titulo}" />
                        <br>
                        <label for="txtExpositor">Expositor:</label>
                        <input type="text" id="txtExpositor" name="txtExpositor" required placeholder="Expositor del seminario" value="${seminario.expositor}" />
                        <br>
                        <label for="dateFecha">Fecha:</label>
                        <input type="date" id="dateFecha" name="dateFecha" required placeholder="Fecha del seminario" value="${seminario.fecha}" />
                        <br>
                        <label for="timeHoraInicio">Hora de inicio:</label>
                        <input type="time" id="timeHoraInicio" name="timeHoraInicio" required value="${seminario.hora.split(" ")[0]}" />
                        <br>
                        <label for="timeHoraFinal">Hora de finalización:</label>
                        <input type="time" id="timeHoraFinal" name="timeHoraFinal" required  value="${seminario.hora.split(" ")[2]}" />
                        <br>
                        <label for="nroCupo">Cupo:</label>
                        <input type="number" id="nroCupo" name="nroCupo" required placeholder="Cupos disponibles del seminario" min="0" max="100000" step="1" value="${seminario.cupo}" />
                        <br>
                    </div>
                    <input class="boton fondo-naranja" type="submit" value='<c:if test="${seminario.id==0}">Registrar</c:if><c:if test="${seminario.id!=0}">Actualizar</c:if>'>
                </form>
            </div>
        </section>
        <footer>
            © 2021/11/09 - Todos los derechos reservados
        </footer>
    </body>
</html>
