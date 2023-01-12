<div id="modal" class="modal" onclick="closeFormOut(event)">
    <div id="modal-dialog" class="modal-dialog">
        <div class="modal-header">
            <h3>Agregar cliente</h3>
            <button class="btn btn-modal" onclick="closeForm()">
                <i class="bi bi-x-circle-fill"></i>
            </button>
        </div>
        <div class="modal-body">
            <form id="form" action="${ pageContext.request.contextPath }/ServletController?accion=insertar" method="post">
                <div class="form-control">
                    <label for="nombre">Nombre*</label>
                    <input name="nombre" type="text" required /> 
                </div>
                    
                <div class="form-control">
                    <label for="apellido">Apellido*</label>
                    <input name="apellido" type="text" required /> 
                </div>

                <div class="form-control">
                    <label for="email">Email*</label> 
                    <input name="email" type="email" required /> 
                </div>                

                <div class="form-control">
                    <label for="telefono">Telefono*</label>
                    <input name="telefono" type="tel" required /> 
                </div>                

                <div class="form-control">
                    <label for="saldo">Saldo*</label> 
                    <input name="saldo" type="number" required />
                </div>                
            </form>
        </div>
        <div class="modal-footer">
            <button class="btn btn-small" form="form" type="reset">Limpiar</button>
            <button class="btn btn-small" form="form" type="submit">Guardar</button>
        </div>
    </div>
</div>