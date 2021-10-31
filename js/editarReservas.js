/**
 * Invoca peticion WS GET con parametro (id) para recuperar información del registro
 * y pintar información en el formulario de edición
 */
function editarRegistro(llaveRegistro) {
    //crea un objeto javascript
    let datos = {
        id: llaveRegistro
    }
    console.log("sakjdhasd")
    console.log(datos.id)

    //convierte el objeto javascript a json antes de agregarlo a los datos de la petición
    let datosPeticion = JSON.stringify(datos);

    $.ajax({
        // la URL para la petición (url: "url al recurso o endpoint")
        url: "http://localhost:8080/api/Reservation/all",

        // la información a enviar
        // (también es posible utilizar una cadena de datos)
        //si el metodo del servicio recibe datos, es necesario definir el parametro adicional
        //data: datosPeticion,

        // especifica el tipo de petición http: POST, GET, PUT, DELETE
        type: 'GET',

        contentType: "application/JSON",

        // el tipo de información que se espera de respuesta
        dataType: 'json',

        // código a ejecutar si la petición es satisfactoria;
        // la respuesta es pasada como argumento a la función
        success: function (respuesta) {
            //escribe en la consola del desarrollador para efectos de depuración
            console.log(respuesta);
            $("#mensajes").show(1000);
            $("#mensajes").html("Información recuperada...");
            $("#mensajes").hide(1000);
            editarRespuesta(respuesta, llaveRegistro);
            activaEditar();
            armaListaCabañas(respuesta);
            armaListaClientes(respuesta);
        },

        // código a ejecutar si la petición falla;
        // son pasados como argumentos a la función
        // el objeto de la petición en crudo y código de estatus de la petición
        error: function (xhr, status) {
            $("#mensajes").show(1000);
            $("#mensajes").html("Error peticion PUT..." + status);
            //$("#mensajes").hide(1000);
        }
    });
}

function activaEditar(){
    $("#nuevo").show(500);
    $("#startDate").focus();
    $("#editar").hide();
    $("#nuevoRegistro").hide(500)
    $("#listado").hide(500);
    listarClientes();
    listarCabañas();
}

function armaListaClientes(items) {
    $("#listado").html("");
    $("#listado").show(500);
    //define variable javascript con la definicion inicial de la tabla, la primera fila y los
    //encabezados o títulos de la tabla
    var lista = ` <option value="">--Selecciona un Cliente--</option>`;
                  
    //recorre el arreglo de 'items' y construye dinamicamente la fila de datos de la tabla
    for (var i=0; i < items.length; i++) {
        lista +=`<option value="${items[i].idClient}">${items[i].name}</option>`;
    }

    //accede al elemento con id 'listado' y adiciona la tabla de datos a su html
    $("#client").html(lista);
}

function listarClientes() {
    $.ajax({
        // la URL para la petición (url: "url al recurso o endpoint")
        url: "http://localhost:8080/api/Client/all",
        
        // la información a enviar
        // (también es posible utilizar una cadena de datos)
        //si el metodo del servicio recibe datos, es necesario definir el parametro adicional
        //data : { id : 1, ...},

        // especifica el tipo de petición http: POST, GET, PUT, DELETE
        type: 'GET',

        // el tipo de información que se espera de respuesta
        dataType: 'json',

        // código a ejecutar si la petición es satisfactoria;
        // la respuesta es pasada como argumento a la función
        success: function (respuesta) {
            //escribe en la consola del desarrollador para efectos de depuración
            //console.log(respuesta);

            //recibe el arreglo 'items' de la respuesta a la petición
            armaListaClientes(respuesta);
        },

        // código a ejecutar si la petición falla;
        // son pasados como argumentos a la función
        // el objeto de la petición en crudo y código de estatus de la petición
        error: function (xhr, status) {
            $("#mensajes").html("Ocurrio un problema al ejecutar la petición..." + status);
            //$("#mensajes").hide(1000);
        },

        // código a ejecutar sin importar si la petición falló o no
        complete: function (xhr, status) {
            $("#mensajes").html("Obteniendo listado de bicis...");
            $("#mensajes").hide(1000);
        }
    });
}

function editarRespuesta(items, llaveRegistro) {
   /*  console.log("Se ejcuto editarRespuesta...")
    console.log(llaveRegistro)
    console.log(items[0].startDate)
    //$("#idEdit").val(items[0].id); */
    /* items[llaveRegistro].devolutionDate).substr(0,10)
    items[llaveRegistro].startDate).substr(0, 10)
    items[llaveRegistro].client.name
    items[llaveRegistro].cabin.name */
    $("#startDate").val();
    $("#devolutionDate").val();
    $("#client").val("Editar cliente"); 
    $("#cabin").val("Editar cabaña");
     
}

function armaListaCabañas(items) {
    $("#listado").html("");
    $("#listado").show(500);
    //define variable javascript con la definicion inicial de la tabla, la primera fila y los
    //encabezados o títulos de la tabla
    var lista = ` <option value="">--Selecciona un Cabaña--</option>`;
                  
    //recorre el arreglo de 'items' y construye dinamicamente la fila de datos de la tabla
    for (var i=0; i < items.length; i++) {
        lista +=`<option value="${items[i].id}">${items[i].name}</option>`;
    }

    //accede al elemento con id 'listado' y adiciona la tabla de datos a su html
    $("#cabin").html(lista);
}

function listarCabañas() {
    $.ajax({
        // la URL para la petición (url: "url al recurso o endpoint")
        url: "http://localhost:8080/api/Cabin/all",
        
        // la información a enviar
        // (también es posible utilizar una cadena de datos)
        //si el metodo del servicio recibe datos, es necesario definir el parametro adicional
        //data : { id : 1, ...},

        // especifica el tipo de petición http: POST, GET, PUT, DELETE
        type: 'GET',

        // el tipo de información que se espera de respuesta
        dataType: 'json',

        // código a ejecutar si la petición es satisfactoria;
        // la respuesta es pasada como argumento a la función
        success: function (respuesta) {
            //escribe en la consola del desarrollador para efectos de depuración
            //console.log(respuesta);

            //recibe el arreglo 'items' de la respuesta a la petición
            armaListaCabañas(respuesta);
        },

        // código a ejecutar si la petición falla;
        // son pasados como argumentos a la función
        // el objeto de la petición en crudo y código de estatus de la petición
        error: function (xhr, status) {
            $("#mensajes").html("Ocurrio un problema al ejecutar la petición..." + status);
            //$("#mensajes").hide(1000);
        },

        // código a ejecutar sin importar si la petición falló o no
        complete: function (xhr, status) {
            $("#mensajes").html("Obteniendo listado de cabañas...");
            $("#mensajes").hide(1000);
        }
    });
}