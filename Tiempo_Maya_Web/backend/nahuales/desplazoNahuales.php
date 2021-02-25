<?php

$id_nahual = $_GET['id_nahual'];
$tipo = $_GET['tipo'];
$id_nahual_nuevo;

if($tipo==1){
    if($id_nahual==1){
        $id_nahual_nuevo = 20;
    }else{
        $id_nahual_nuevo = $id_nahual - 1;
    }
}elseif($tipo==2){
    if($id_nahual==20){
        $id_nahual_nuevo = 1;
    }else{
        $id_nahual_nuevo = $id_nahual + 1;
    }
}else{
    $id_nahual_nuevo = 1;
    //echo "no tra nada";
}

 header("location: /Tiempo_Maya_Web/nahuales.php?id_nahual=$id_nahual_nuevo");
//echo "si tra nada";



?>