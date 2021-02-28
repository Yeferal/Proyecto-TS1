<?php

$fechaPivote = '2020-01-01'; //kej-17


echo $_POST['date'];
echo "<br>";
$fecha_actual = date("d-m-Y");
echo "fecha actual: ".$fecha_actual;
//sumo 1 día
echo "<br>";
echo date("d-m-Y",strtotime($fecha_actual."+ 1 days")); 
echo "<br>";
//resto 1 día
echo date("d-m-Y",strtotime($fecha_actual."- 1 days")); 
echo "<br>";
//resto 1 día
echo "tiempo obtenido: ";
$date1 = new DateTime("2020-01-01");

//$date2 = new DateTime("2020-03-10");

$date2 = new DateTime($_POST['date']);


$diff = $date1->diff($date2);
// this will output 4 days                           
$diferenciaDias = $diff->days;
echo $diferenciaDias .' days ';

while($diferenciaDias>20){
    $diferenciaDias = $diferenciaDias-20;
}
if($diferenciaDias==0){
    echo "El nahual es el mismo iq";
}else{
    $idNahual = 17;
    while($diferenciaDias>0){
        if($idNahual==20){
            $idNahual = 1;
        }else{
            $idNahual = $idNahual + 1;
        }
        //$idNahual = $diferenciaDias;
        $diferenciaDias = $diferenciaDias -1;
    }
    echo "El nahual es el mismo ". $idNahual;
}

header("location: /Tiempo_Maya_Web/nahuales.php?id_nahual=$idNahual&fechaSeleccion=".$_POST['date']);


?>