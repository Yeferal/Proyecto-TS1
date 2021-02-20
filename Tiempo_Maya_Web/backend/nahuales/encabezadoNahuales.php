<!-- <!DOCTYPE html>
<html lang="en"> -->

<!-- <body> -->
    <section>
        <div class="navNahuales" >
            <div class="navleft" >
            <button onclick="location.href='nahuales.php?id_nahual=<?php echo $id_nahual ?>&tipo=1'" name="button">Izquierda</button>
            </div>
            <?php 
                if($id_nahual == 1){
                    $sql1 = "SELECT n.*,r.*  FROM nahual n join rutaimagen r on (n.idImagen= r.id) WHERE n.id = 20;";
                    $resultado1 = $conexion->query($sql1);
                }else{
                    $sql1 = "SELECT n.*,r.*  FROM nahual n join rutaimagen r on (n.idImagen= r.id) WHERE n.id = ($id_nahual-1);";
                    $resultado1 = $conexion->query($sql1);
                }
                
            
            
            ?>
            <div class="nahuales1" >
            <img src="../src/gui/nahuales/20 tzi.png" alt="MDN"  width="175" height="175" >
            </div>

            <div class="nahuales2" >
            <img src="../src/gui/nahuales/1 batz.png" alt="MDN"  width="300" height="300" >
            </div>

            <div class="nahuales3" >
            <img src="../src/gui/nahuales/2 e.png" alt="MDN"  width="175" height="175" >
            </div>
                <?php 
                if($id_nahual == 20){
                    $sql2 = "SELECT n.*,r.*  FROM nahual n join rutaimagen r on (n.idImagen= r.id) WHERE n.id = 1;";
                    $resultado2 = $conexion->query($sql2);
                }else{
                    $sql2 = "SELECT n.*,r.*  FROM nahual n join rutaimagen r on (n.idImagen= r.id) WHERE n.id = ($id_nahual+1);";
                    $resultado2 = $conexion->query($sql2);
                }
                
                
                ?>


            <div class="navright" >
            <!-- <button onclick="location.href='iniciarSesion.php'?id_nahual=<?php/* echo $_POST['id_nahual']); */?>" name="button">Derecha</button> -->
            <button onclick="location.href='nahuales.php?id_nahual=<?php echo $id_nahual ?>&tipo=2'" name="button">Derecha</button>
            </div>
        </div>
    </section>
<!-- </body>
</html> -->