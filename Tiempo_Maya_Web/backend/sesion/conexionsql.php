<?php

  // Datos para conectar a la base de datos.
  $nombreServidor = "localhost";
  $nombreUsuario = "root";
  $passwordBaseDeDatos = "1234";
  $nombreBaseDeDatos = "calendariomaya";
 
  // Crear conexión con la base de datos.
  $conexion = new mysqli($nombreServidor, $nombreUsuario, $passwordBaseDeDatos, $nombreBaseDeDatos);
  
    

?>