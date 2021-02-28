<?php

 session_start();
 $conexion; include_once('conexionSql.php');
 $sql_buscar = "SELECT count(username) existe FROM usuario WHERE username='".$_POST['usernameR']."';";
 $resultado = $conexion->query($sql_buscar);
 $valor;
 //echo $sql_buscar;
 foreach($resultado as $fila):
     $valor = $fila['existe'];
 endforeach;
    if($valor==0 || $valor==1){
        //echo "No existe el usuario: ".$_POST['usernameR'];
            // $sql_insertar = "CALL insertarUsuario('".$_POST['usernameR']."','".$_POST['passwordR']."','".
            //                 $_POST['emailR']."','".$_POST['nombreR']."','".$_POST['apellidoR']."','".
            //                 $_POST['fechaR']."','".$_POST['telefonoR']."');";
            $sql_actualizar = "UPDATE usuario SET ".
                            "username ='".$_POST['usernameR']."',password ='".$_POST['passwordR']."',email ='".
                            $_POST['emailR']."',nombre ='".$_POST['nombreR']."',apellido ='".$_POST['apellidoR']."',telefono ='".
                            $_POST['telefonoR']."' WHERE username='".$_SESSION['nombre']."';";

                            
                            if (!$conexion->query($sql_actualizar)) {
                                echo "Falló : (" . $conexion->errno . ") " . $conexion->error;
                            }
            $_SESSION['nombre'] = $_POST['usernameR'];
            $_SESSION['rango'] = "GUEST";
            header("Location: /TIEMPO_MAYA_WEB/editarPerfil.php"); 

            //echo "<br>Query====: ".$sql_actualizar;


        
    }else{
        //echo "existe el usuario: ".$_POST['usernameR'];
        echo '
        <head>
          <meta charset="utf-8">
          <meta name="viewport" content="width=device-width, initial-scale=1">
          <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
          <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
          <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
          <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        </head>
        <body>
          <div class="alert alert-success" role="alert"  style="margin-left:300px; margin-right:300px;">
              <h4 class="alert-heading">Ya existe un usuario</h4>
              <p> Se encuentra un usuario registrado como '.$_POST['usernameR'].'</p>
              <hr>
              <form class="form-horizontal" action="/TIEMPO_MAYA_WEB/editarPerfil.php" method="post">
                <input name="tupoUser"  value="'.$_POST['usernameR'].'" style="display: none;">
                <button type="submit" class="btn btn-danger btn-lg btn-block" id="boton">regresar</button>
              </form>
          </div> 
        </body>'; //si existe el usuario
    }




?>