<?php

  if(!isset($_POST['id_nahual'])){
    $id_nahual = 1;
  }else{
    $id_nahual = $_POST['id_nahual'];
  }
  // Datos para conectar a la base de datos.
  $nombreServidor = "localhost";
  $nombreUsuario = "root";
  $passwordBaseDeDatos = "1234";
  $nombreBaseDeDatos = "calendariomaya";
 

  // Crear conexión con la base de datos.
  $conexion = new mysqli($nombreServidor, $nombreUsuario, $passwordBaseDeDatos, $nombreBaseDeDatos);
  $sql = "SELECT n.*,r.*  FROM nahual n join rutaimagen r on (n.idImagen= r.id) WHERE n.id = 1;";
  $resultado = $conexion->query($sql);
  
  
  
  //$result = mysqli_query($conn, "SELECT n.*,r.*  FROM nahual n join rutaimagen r on (n.idImagen= r.id) WHERE n.id = 1;");
  //$usuario = $result->fetch_array(MYSQLI_ASSOC);  
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,700,700i|Poppins:300,400,500,700" rel="stylesheet">
    <link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="lib/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href="lib/animate/animate.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <link href="css/navNahuales.css" rel="stylesheet">
    <title>Nahuales</title>
</head>
<body>




<section id="nav_nahuales">
<?php include_once "backend/nahuales/encabezadoNahuales.php" ?>
</section>

<?php foreach ($resultado as $fila): ?>
  <p><?php echo $fila['id'] ?></p>
  <p><?php echo $fila['nombre'] ?></p>
  <p><?php echo $fila['significado'] ?></p>
  <p><?php echo $fila['descripcion'] ?></p>
  <p>POST: <?php echo $id_nahual ?></p>

<?php endforeach; ?>

<?php 
/*
  switch($id_nahual){
    case 1:
     // echo "<section id=\"e\">";
      php include_once 'backend/nahuales/e.php';
      
      break;
    case 2:
      echo "<section id=\"e\">";
      php include_once 'backend/nahuales/e.php';
      
      break;
    
    
}
*/

?>

<section id="batz">
  <?php include_once "backend/nahuales/batz.php" ?>
</section>
<section id="e">
  <?php include_once 'backend/nahuales/e.php'; ?>
</section>
<section id="aj">
  <?php include_once 'backend/nahuales/aj.php' ?>
</section>
<section id="ix">
  <?php include_once 'backend/nahuales/ix.php'?>
</section>
<section id="tzikin">
  <?php include_once 'backend/nahuales/tzikin.php'?>
</section>
<section id="ajmaq">
  <?php include_once 'backend/nahuales/ajmaq.php'?>
</section>
<section id="noj">
  <?php include_once 'backend/nahuales/noj.php'; ?>
</section>
<section id="tijax">
  <?php include_once 'backend/nahuales/tijax.php'; ?>
</section>
<section id="kawoq">
  <?php include_once 'backend/nahuales/kawoq.php'; ?>
</section>
<section id="ajpu">
  <?php include_once 'backend/nahuales/ajpu.php'; ?>
</section>
<section id="imox">
  <?php include_once 'backend/nahuales/imox.php'; ?>
</section>
<section id="iq">
  <?php include_once 'backend/nahuales/iq.php'; ?>
</section>
<section id="aqabal">
  <?php include_once 'backend/nahuales/aqabal.php'; ?>
</section>
<section id="kat">
  <?php include_once 'backend/nahuales/kat.php'; ?>
</section>
<section id="kan">
  <?php include_once 'backend/nahuales/kan.php'; ?>
</section>
<section id="kame">
  <?php include_once 'backend/nahuales/kame.php'; ?>
</section>
<section id="kej">
  <?php include_once 'backend/nahuales/kej.php'; ?>
</section>
<section id="qanil">
  <?php include_once 'backend/nahuales/qanil.php'; ?>
</section>
<section id="toj">
  <?php include_once 'backend/nahuales/toj.php'; ?>
</section>
<section id="tzi">
  <?php include_once 'backend/nahuales/tzi.php'; ?>
</section>

</body>