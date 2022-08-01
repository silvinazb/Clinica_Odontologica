window.addEventListener('load', function () {
    (function(){

      const url = '/turnos';
      const settings = {
        method: 'GET'
      }

      fetch(url,settings)
      .then(response => response.json())
      .then(data => {

         for(turno of data){

            var table = document.getElementById("oturnoTable");
            var turnoRow =table.insertRow();
            let tr_id = 'tr_' + turno.id;
           turnoRow.id = tr_id;

            let updateLink ='<a id=\"a_update_'+turno.id+'\"'+
            ' href=\"#\" onclick=\"findBy('+turno.id+')\"'+
            ' class=\"text-primary font-weight-bold\">Modificar</a>';

            let deleteLink ='<a id=\"a_delete_'+turno.id+'\"'+
            ' href=\"#\" onclick=\"deleteBy('+oturno.id+')\"'+
            ' class=\"text-danger font-weight-bold\">Borrar</a>';


            turnoRow.innerHTML =
                    '<td class=\"text-center\">'+updateLink+'</td>' +
                    '<td class=\"td_id text-center\">' + turno.id + '</td>' +
                    '<td class=\"td_odontologo text-center\">' + turno.odontologo.nombre + '</td>' +
                    '<td class=\"td_paciente text-center\">' + turno.paciente.nombre + '</td>' +
                    '<td class=\"td_fecha text-center\">' + turno.fecha + '</td>' +
                    '<td class=\"text-center\">'+deleteLink+'</td>';

        };

    })
    })

    (function(){
      let pathname = window.location.pathname;
      if (pathname == "/get_all_turno.html") {
          document.querySelector(".nav .nav-item a:last").addClass("active");}
    });
});
