<?php
session_start();
$ir_a = "/TIEMPO_MAYA_WEB/LineaDeTiempo.php";
$conexion; 
include_once('../sesion/conexionsql.php');

if ($conexion->connect_error) {
    die("Connection failed: " . $conexion->connect_error);
}

$idH = $_GET['idHecho'];

echo $idH. ": IDhECHO";

$sql3 = "DELETE FROM hechohistorico WHERE id = ".$idH.";";

if (!$conexion->query($sql3)) {
    //$ir_a = "../error.php";
    echo "<br>".$sql3."<br>";
    echo "Falló 3: (" . $conexion->errno . ") " . $conexion->error;
}else{
    header("location: ".$ir_a);
}

