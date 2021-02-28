<section id="sabernahual">
  <div class="container">
    <div class="row about-container">
      <div class="col-lg-12 ">
        <div class="section-header">
          <h3 class="section-title" style="  color: #2dc997;">¿Que nahual caé en esta fecha?</h3>
        </div>
        <div class="container">
          <form method="POST" action="backend/nahuales/encontrarFecha.php">
            <div class="form-group mb-2">
              <label for="staticEmail2" class="sr-only text-dark">Ingresar fecha</label>
             
             
              <?php if(!isset($_GET['fechaSeleccion'])): ?>
              <input type="date" class="form-control-plaintext text-dark border border-success" id="staticEmail2" name="date" required>
              <?php endif; ?>

              <?php if(isset($_GET['fechaSeleccion'])): ?>
              <input type="date" class="form-control-plaintext text-dark border border-success" value="<?php echo $_GET['fechaSeleccion']; ?>" id="staticEmail2" name="date" required>
              <?php endif; ?>

            </div>
            <div class="form-group mb-2">
              <button type="submit" class="btn btn-outline-success btn-lg btn-block mb-2">Buscar</button>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
  <hr>
  <hr>
</section>