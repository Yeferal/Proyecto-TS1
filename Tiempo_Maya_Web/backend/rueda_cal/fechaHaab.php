<?php
session_start();
$conexion; 
include_once('../sesion/conexionSql.php');

$fechaSeleeccion = '2021-02-27';
$fechaSeleeccion = $_POST['date'];

$dia = date('d',strtotime($fechaSeleeccion));
$mes = date('m',strtotime($fechaSeleeccion));
$anio = date('y',strtotime($fechaSeleeccion));

$fecha = "2020-".$mes."-".$dia;
echo "<br>"."DATE parseado: ".$fecha;
$sql = "SELECT * FROM calendariohaab WHERE fecha='".$fecha."'";
echo "<br>".$sql;
$resultado = $conexion->query($sql);
$fechaEncontrada = $resultado->fetch_array(MYSQLI_ASSOC);

echo "<br>".' ID: '.$fechaEncontrada['id'];
echo "<br>".' Nahual: '.$fechaEncontrada['nahual'];
echo "<br>".' Winal: '.$fechaEncontrada['winal'];
$winal = $fechaEncontrada['winal'];
echo "<br>".' Winal: '.$winal;
//cargador
$cargador = 1;
if($anio < 2020){
    for($i = 0; $i < (2020-$anio); $i++){
        if($cargador == 4){
            $cargador = 1;
        }else{
            $cargador++;
        }
    }
}

$sql = "SELECT * FROM cargador WHERE id='".$cargador."'";
echo "<br>".$sql;
$resultado = $conexion->query($sql);
$cargadorEncontrado = $resultado->fetch_array(MYSQLI_ASSOC);

$parametros = "isfecha=$fechaSeleeccion&id_nahual=".$fechaEncontrada['nahual']."&id_winal=$winal&id_cargador=$cargador";

header("location: /Tiempo_Maya_Web/calendarioHaab.php?$parametros");


?>