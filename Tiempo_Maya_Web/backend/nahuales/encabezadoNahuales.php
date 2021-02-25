
    <section>
        <div class="navNahuales" >
            <div class="navleft" >
            <button onclick="location.href='backend/nahuales/desplazoNahuales.php?id_nahual=<?php echo $id_nahual ?>&tipo=1'" name="buttonIz" class="buttonIz"></button>
            </div>
            <?php 
                if($id_nahual == 1){
                    $sql1 = "SELECT n.*,r.*  FROM nahual n join rutaimagen r on (n.idImagen= r.id) WHERE n.id = 20 LIMIT 1;";
                    $resultado1 = $conexion->query($sql1);
                }else{
                    $sql1 = "SELECT n.*,r.*  FROM nahual n join rutaimagen r on (n.idImagen= r.id) WHERE n.id = ($id_nahual-1) LIMIT 1;";
                    $resultado1 = $conexion->query($sql1);
                }
            ?>
            <div class="nahuales1" id = "f111">
            <?php foreach ($resultado1 as $dato1): ?>
            <img src="<?php echo $dato1['dirWeb'] ?>" alt="MDN"  width="175" height="175" class="imagen1" >
            <?php endforeach; ?>
            </div>
            <?php 
                $sqlm = "SELECT n.*,r.*  FROM nahual n join rutaimagen r on (n.idImagen= r.id) WHERE n.id = $id_nahual LIMIT 1;";
                $resultadom = $conexion->query($sqlm);
                ?>
            <div class="nahuales2" >
            <?php foreach ($resultadom as $datom): ?>
            <img src="<?php echo $datom['dirWeb'] ?>" alt="MDN"  width="300" height="300" >
            <?php endforeach; ?>
            </div>
            <div class="nahuales3" >
            <?php 
                if($id_nahual == 20){
                    $sql2 = "SELECT n.*,r.*  FROM nahual n join rutaimagen r on (n.idImagen= r.id) WHERE n.id = 1 LIMIT 1;";
                    $resultado2 = $conexion->query($sql2);
                }else{
                    $sql2 = "SELECT n.*,r.*  FROM nahual n join rutaimagen r on (n.idImagen= r.id) WHERE n.id = ($id_nahual+1) LIMIT 1;";
                    $resultado2 = $conexion->query($sql2);
                }
                ?>
            <?php foreach ($resultado2 as $dato2): ?>
            <img src="<?php echo $dato2['dirWeb'] ?>" alt="MDN"  width="175" height="175" class="imagen1">
            <?php endforeach; ?>
            </div>
            <div class="navright" >
            <!-- <button onclick="location.href='iniciarSesion.php'?id_nahual=<?php/* echo $_POST['id_nahual']); */?>" name="button">Derecha</button> -->
            <button onclick="location.href='backend/nahuales/desplazoNahuales.php?id_nahual=<?php echo $id_nahual ?>&tipo=2'" name="buttonDr" class="buttonDr"></button>
            </div>
        </div>
    </section>
    