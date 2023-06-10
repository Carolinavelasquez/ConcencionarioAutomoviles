<%-- 
    Document   : listar
    Created on : 9/07/2019, 11:01:32 AM
    Author     : redes
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Empleados"%>
<%@page import="dao.DaoEmpleado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>

        <div class="container">
            <h1>Empleados</h1>
            <a class="btn btn-success" href="ControladorEmpleado?accion=add">Agregar Tipo Cuenta</a>
            <br>
            <br>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>Codigo Empleado</th>
                        <th>Nombre</th>
                        <th>Apellido</th>
                        <th>Tel. Movil</th>
                        <th>Contraseña</th>
                        <th>Direccion</th>
                        <th>Correo</th>
                        <th>Acciones</th>


                    </tr>
                </thead>
                <%
                    DaoEmpleado dao = new DaoEmpleado();
                    List<Empleados> list = dao.listEmpleado();
                    Iterator<Empleados> iter = list.iterator();
                    Empleados tipo = null;
                    while (iter.hasNext()) {
                        tipo = iter.next();


                %>
                <tbody>
                    <tr>
                        <td><%= tipo.getCodigo()%></td>
                        <td><%= tipo.getNombre()%></td>
                        <td><%= tipo.getApellido()%></td>
                        <td><%= tipo.getMovil()%></td>
                        <td><%= tipo.getPass()%></td>
                        <td><%= tipo.getDireccion()%></td>
                        <td><%= tipo.getCorreo()%></td>
                        <td>
                            <a class="btn btn-warning" href="ControladorEmpleado?accion=editar&id=<%= tipo.getCodigo()%>">Editar</a>
                            <a class="btn btn-danger" href="ControladorEmpleado?accion=eliminar&id=<%= tipo.getCodigo()%>">Remover</a>
                        </td
                    </tr>
                    <%}%>
                </tbody>
            </table>

        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
    </body>
</html>
