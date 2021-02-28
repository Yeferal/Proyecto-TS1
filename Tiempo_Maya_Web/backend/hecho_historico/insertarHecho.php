<?php
session_start();
$ir_a = "/TIEMPO_MAYA_WEB/LineaDeTiempo.php"; 
//$conexion = new mysqli("servidor","usuario","clave","bd")
$conexion; 
include_once('../sesion/conexionsql.php');
if ($conexion->connect_error) {
    die("Connection failed: " . $conexion->connect_error);
}

//guarda hecho historico
$sql1 = "INSERT INTO HechoHistorico (fechaInicio, fechaFinalizacion, titulo, descripcion) VALUES ('" . $_POST['fechaInicio'] . "' , '" . $_POST['fechaFin'] . "',
    '" . $_POST['titulo'] . "', '" . $_POST['decripcion'] . "')";
    if (!$conexion->query($sql1)) {
        echo "Falló 2: (" . $conexion->errno . ") " . $conexion->error;
    }

//selecciona el id del hecho historico guardado antes
$rs = mysqli_query($conexion, "SELECT MAX(id) as id FROM HechoHistorico");
$id = $rs->fetch_array(MYSQLI_ASSOC);

//asigna la categoria del hecho historico 
$sql2 = "INSERT INTO Categorizar VALUES (" . $id['id'] . " , " . $_POST['categoria'].")";
if (!$conexion->query($sql2)) {
    //$ir_a = "../error.php";
    echo "Falló 2: (" . $conexion->errno . ") " . $conexion->error;
}
$nombreUser = $_SESSION['nombre'];
//guarda la edicion del hecho historico
$sql3 = "INSERT INTO Edicion (username, idHechoHistorico, fecha, creacion) VALUES ('$nombreUser' , " . $id['id'] . ",
'". date("Y-m-d"). "', '1')";
echo $sql3;
if (!$conexion->query($sql3)) {
    $ir_a = "../error.php";
    echo "Falló 3: (" . $conexion->errno . ") " . $conexion->error;
}else{
    header("location: ".$ir_a);
}




?>