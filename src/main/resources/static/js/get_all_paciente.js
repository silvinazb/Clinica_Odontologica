window.addEventListener('load', function () {
    (function(){

      const url = '/pacientes';
      const settings = {
        method: 'GET'
      }

      fetch(url,settings)
      .then(response => response.json())
      .then(data => {

         for(paciente of data){

            var table = document.getElementById("pacienteTable");
            var pacienteRow =table.insertRow();
            let tr_id = 'tr_' + paciente.id;
            pacienteRow.id = tr_id;

            let updateLink ='<a id=\"a_update_'+paciente.id+'\"'+
            ' href=\"#\" onclick=\"findBy('+paciente.id+')\"'+
            ' class=\"text-primary font-weight-bold\">Modificar</a>';

            let deleteLink ='<a id=\"a_delete_'+paciente.id+'\"'+
            ' href=\"#\" onclick=\"deleteBy('+paciente.id+')\"'+
            ' class=\"text-danger font-weight-bold\">Borrar</a>';


            pacienteRow.innerHTML =
                    '<td class=\"text-center\">'+updateLink+'</td>' +
                    '<td class=\"td_id text-center\">' + paciente.id + '</td>' +
                    '<td class=\"td_nombre text-center\">' + paciente.nombre.toUpperCase() + '</td>' +
                    '<td class=\"td_apellido text-center\">' + paciente.apellido.toUpperCase() + '</td>' +
                    '<td class=\"td_dni text-center\">' + paciente.dni + '</td>' +
                    '<td class=\"td_fechaAlta text-center\">' + paciente.fechaAlta + '</td>' +
                    '<td class=\"td_calle text-center\">' + paciente.domicilio.calle.toUpperCase() + '</td>' +
                    '<td class=\"td_numero text-center\">' + paciente.domicilio.numero + '</td>' +
                    '<td class=\"td_localidad text-center\">' + paciente.domicilio.localidad.toUpperCase() + '</td>' +
                    '<td class=\"td_provincia text-center\">' + paciente.domicilio.provincia.toUpperCase() + '</td>' +
                    '<td class=\"text-center\">'+deleteLink+'</td>';

        };

    })
    })

    (function(){
      let pathname = window.location.pathname;
      if (pathname == "/get_all_paciente.html") {
          document.querySelector(".nav .nav-item a:last").addClass("active");}
    });
});
