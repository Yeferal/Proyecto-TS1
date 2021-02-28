<?php
session_start();
$conexion; 
include_once('backend/sesion/conexionSql.php');
if(isset($_GET['isfecha'])){
  $id_nahual = $_GET['id_nahual'];
  $id_winal = $_GET['id_winal'];
  $id_cargador = $_GET['id_cargador'];
  $id_energia = $_GET['id_energia'];
  //echo "$id_nahual == $id_winal == $id_cargador";
  $sql_nahual =  "SELECT n.*,r.*  FROM nahual n join rutaimagen r on (n.idImagen= r.id) WHERE n.id=$id_nahual LIMIT 1;";
  $sql_winal =  "SELECT w.*,r.dirWeb FROM winal w JOIN rutaImagen r ON (w.idImagen=r.id) WHERE w.id=$id_winal LIMIT 1;";
  $sql_cargador =  "SELECT * FROM cargador WHERE id =$id_cargador LIMIT 1;";
  $sql_energia =  "SELECT * FROM energia WHERE id =$id_energia LIMIT 1;";
  $resultado1 = $conexion->query($sql_nahual);
  $objNahual = $resultado1->fetch_array(MYSQLI_ASSOC);   
  $resultado2 = $conexion->query($sql_winal);
  $objWinal = $resultado2->fetch_array(MYSQLI_ASSOC);
  $resultado3 = $conexion->query($sql_cargador);
  $objCargador = $resultado3->fetch_array(MYSQLI_ASSOC);
  $resultado4 = $conexion->query($sql_energia);
  $objEnergia = $resultado4->fetch_array(MYSQLI_ASSOC);
  //echo $sql_cargador;
}else{
  //echo "esta";
}

?>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>Tiempo Maya</title>
  <meta content="width=device-width, initial-scale=1.0" name="viewport">
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,700,700i|Poppins:300,400,500,700" rel="stylesheet">
  <link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://kit.fontawesome.com/e51fb510f5.js" crossorigin="anonymous"></script>
  <link href="lib/font-awesome/css/font-awesome.min.css" rel="stylesheet">
  <link href="lib/animate/animate.min.css" rel="stylesheet">
  <link href="css/Calendarios.css" rel="stylesheet">
  <link href="css/style.css" rel="stylesheet">
  <link href="css/navNahuales.css" rel="stylesheet">

</head>
<?php include "BarradeNavegacion.php" ?>
<body>

<section id="inicio">
<div class="inicio-container">

  <h1>Rueda Calendarica</h1>

  <div class="navNahuales" >
  <!-- <br><br> -->
      <div class="nahuales11" id = "f111">
      <?php if(isset($_GET['isfecha'])):?>
      <img src="<?php echo $objNahual['dirWeb'] ?>" alt="MDN"  width="175" height="175" class="imagen11" >
      <br><label for="InputPass" style="color:white">Dia: <?php echo $objNahual['nombre'] ?></label>
      <?php endif;?>
      </div> 
      <div class="nahuales21" >
      <?php if(isset($_GET['isfecha'])):?>
      <img src="<?php echo $objWinal['dirWeb'] ?>" alt="MDN"  width="175" height="175" class="imagen11" >
      <br><label for="InputPass" style="color:white">Winal: <?php echo $objWinal['nombre'] ?></label>
      <?php endif;?>    
      </div>
      <div class="nahuales31" >
      <?php if(isset($_GET['isfecha'])):?>
      <img src=".<?php echo $objCargador['rutaImagen'] ?>" alt="MDN"  width="175" height="175" class="imagen11" >
      <br><label for="InputPass" style="color:white" >Cargador: <?php echo $objCargador['nombre'] ?></label>
      <?php endif;?>    
      </div>  
      <div class="nahuales31" >
      <?php if(isset($_GET['isfecha'])):?>
      <img src=".<?php echo $objEnergia['dirWeb'] ?>" alt="MDN"  width="175" height="175" class="imagen11" >
      <br><label for="InputPass" style="color:white" >Energia: <?php echo $objEnergia['nombre'] ?></label>
      <?php endif;?>    
      </div>    
    </div>

  <form method="POST" action="backend/rueda_cal/ruedaCal.php">
            <div class="form-group mb-2">
              <label for="staticEmail2" class="sr-only text-dark" style="color:white">Ingresar fecha</label>
             
             
              <?php if(!isset($_GET['isfecha'])):?>
              <input type="date" style="color:white" class="form-control-plaintext text-dark border border-success" id="staticEmail2" name="date" required>
              <?php endif; ?>

              <?php if(isset($_GET['isfecha'])):?>
                <input type="date" style="color:white" class="form-control-plaintext text-dark border border-success" value='<?php echo $_GET['isfecha']; ?>' id="staticEmail2" name="date" required>
              <?php endif; ?>

            </div>
            <div class="form-group mb-2">
              <button type="submit" class="btn btn-outline-success btn-lg btn-block mb-2">Buscar</button>
            </div>
</form>

</body>