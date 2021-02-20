<?php
 session_start();
 // Obtengo los datos cargados en el formulario de login.
 $email = $_POST['user'];
 $password = $_POST['password'];

  // Datos para conectar a la base de datos.
  $nombreServidor = "localhost";
  $nombreUsuario = "root";
  $passwordBaseDeDatos = "1234";
  $nombreBaseDeDatos = "calendariomaya";
 
  // Crear conexión con la base de datos.
  $conn = new mysqli($nombreServidor, $nombreUsuario, $passwordBaseDeDatos, $nombreBaseDeDatos);
  
  // Consulta segura para evitar inyecciones SQL.
     $result = mysqli_query($conn, "SELECT n.*,r.*  FROM nahual n join rutaimagen r on (n.idImagen= r.id) WHERE n.id = 1;");
     $usuario = $result->fetch_array(MYSQLI_ASSOC);    
     if(mysqli_num_rows($result )>0){
        $verRango = "SELECT * from Rol WHERE idRol= ".$usuario['rol'];
        $rangoRS = mysqli_query($conn, $verRango);
        $rango = $rangoRS->fetch_array(MYSQLI_ASSOC); 
        $usuario =  $result->fetch_array(MYSQLI_ASSOC);
        $_SESSION['nombre'] = $nombreUsuario;
        $_SESSION['rango'] = $rango['tipo'];
        // Guardo en la sesión el rango del usuario.
      
            header("Location: ../index.php"); 
      }else{
       
      }
    

?>