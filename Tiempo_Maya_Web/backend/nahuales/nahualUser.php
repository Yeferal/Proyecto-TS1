<?php
$date1 = new DateTime("2020-01-01");

//$date2 = new DateTime("2020-03-10");

$date2 = new DateTime($usuario['nacimiento']);

$idNahual = 17;
$diff = $date1->diff($date2);
// this will output 4 days                           
$diferenciaDias = $diff->days;
//echo $diferenciaDias .' days ';

while($diferenciaDias>20){
    $diferenciaDias = $diferenciaDias-20;
}
if($diferenciaDias==0){
    //echo "El nahual es el mismo iq";
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
    // echo "El nahual es el mismo ". $idNahual;
}
$sql_nahual = "SELECT nombre FROM nahual WHERE id=$idNahual;";

$resultadoNahual = mysqli_query($conexion, $sql_nahual);
$usuarioNahual = $resultadoNahual->fetch_array(MYSQLI_ASSOC);    


?>