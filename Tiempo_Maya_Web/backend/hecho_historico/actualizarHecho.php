<?php
session_start();
$ir_a = "/TIEMPO_MAYA_WEB/LineaDeTiempo.php";
$conexion; 
include_once('../sesion/conexionsql.php');

//$miImagen = base64_encode(file_get_contents($_FILES['imagen']['tmp_name']));
if ($conexion->connect_error) {
    die("Connection failed: " . $conexion->connect_error);
}
$idH = $_GET['idHecho'];

//guarda hecho historico
$sql1 = "UPDATE HechoHistorico SET fechaInicio = '".$_POST['fechaInicio'] ."', fechaFinalizacion= '". $_POST['fechaFin']."', titulo= '".$_POST['titulo'] ."', descripcion= '" . $_POST['decripcion'] . "' WHERE id=".$idH.";" ;
    if (!$conexion->query($sql1)) {
        echo "Falló 2: (" . $conexion->errno . ") " . $conexion->error;
    }

$//id = $_POST['idHecho'];

$idH = $_GET['idHecho'];

echo "<br><br>id: ".$_GET['idHecho']."<br><br>";

//guarda la edicion del hecho historico
$sql3 = "INSERT INTO Edicion (username, idHechoHistorico, fecha, creacion) VALUES ('" .$_SESSION['nombre']. "' , ".$_GET['idHecho']." ,'". date("Y-m-d"). "', '1')";
echo $sql3;

echo "<br><br>id: ".$idH."<br><br>";
if (!$conexion->query($sql3)) {
    //$ir_a = "../error.php";
    echo "Falló 3: (" . $conexion->errno . ") " . $conexion->error;
}else{
    header("location: ".$ir_a);
}




?>