<?php

session_start();
  $conexion; include_once('backend/sesion/conexionSql.php');

  if(!isset($_GET['id_nahual'])){
    $id_nahual = 1;
  }else{
    $id_nahual = $_GET['id_nahual'];
  }
  if($id_nahual<1 || $id_nahual>20){
    $id_nahual = 1;
  }

  $sql = "SELECT n.*,r.*  FROM nahual n join rutaimagen r on (n.idImagen= r.id) WHERE n.id = $id_nahual;";
  $resultado = $conexion->query($sql);
  
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
<style>
        .main-container{
            width: 50%; 
            margin: 100px  auto;
            padding: 20px 20px 60px;
            -webkit-box-shadow: 13px 10px 5px -4px rgba(0,0,0,0.75);
            -moz-box-shadow: 13px 10px 5px -4px rgba(0,0,0,0.75);
            box-shadow: 13px 10px 5px -4px rgba(0,0,0,0.75);
            background: gray;
            color:white;
        }
        body{
        background: url("./img/fondo.png") ;
        background-size: cover;
        }
        .nav-menu > li > a:before {
        background-color: black;
        }
    </style>
<div>
  <header id="header">
    <?php include 'BarradeNavegacion.php'; ?>>
  </header>
</div>
<div class="main-container">
<div>
  <section id="nav_nahuales">
    <?php include_once "backend/nahuales/encabezadoNahuales.php" ?>
  </section>
</div>

<div>
  <section id="fecha_nahuales">
    <?php include_once "backend/nahuales/fechaNahual.php" ?>
  </section>
</div>

<?php foreach ($resultado as $fila): ?>
<?php echo "</section>"; ?>
<div>
  <h3 class="section-title" style="  color: #2dc997;"><?php echo $fila['nombre'] ?></h3>


<?php echo $fila['texto_web'] ?>
<?php endforeach; ?>
</div>
</body>