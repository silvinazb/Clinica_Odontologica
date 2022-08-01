window.addEventListener('load', function () {
    (function(){

      const url = '/odontologos';
      const settings = {
        method: 'GET'
      }

      fetch(url,settings)
      .then(response => response.json())
      .then(data => {

         for(odontologo of data){

            var table = document.getElementById("odontologoTable");
            var odontologoRow =table.insertRow();
            let tr_id = 'tr_' + odontologo.id;
            odontologoRow.id = tr_id;

            let updateLink ='<a id=\"a_update_'+odontologo.id+'\"'+
            ' href=\"#\" onclick=\"findBy('+odontologo.id+')\"'+
            ' class=\"text-primary font-weight-bold\">Modificar</a>';

            let deleteLink ='<a id=\"a_delete_'+odontologo.id+'\"'+
            ' href=\"#\" onclick=\"deleteBy('+odontologo.id+')\"'+
            ' class=\"text-danger font-weight-bold\">Borrar</a>';


            odontologoRow.innerHTML =
                    '<td class=\"text-center\">'+updateLink+'</td>' +
                    '<td class=\"td_id text-center\">' + odontologo.id + '</td>' +
                    '<td class=\"td_nombre text-center\">' + odontologo.nombre.toUpperCase() + '</td>' +
                    '<td class=\"td_apellido text-center\">' + odontologo.apellido.toUpperCase() + '</td>' +
                    '<td class=\"td_matricula text-center\">' + odontologo.matricula + '</td>' +
                    '<td class=\"text-center\">'+deleteLink+'</td>';

        };

    })
    })

    (function(){
      let pathname = window.location.pathname;
      if (pathname == "/get_all_odontologo.html") {
          document.querySelector(".nav .nav-item a:last").addClass("active");}
    });
});
