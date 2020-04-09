
// const server = 'jdbc:mysql://remotemysql.com/YrTGCBVRUv?useSSL=false';
// window.onload = function () {
//     //calls function to update Visits
//     const dataTableVisitsRecluse =  document.getElementById("dataTableVisitsRecluse")
//     const renderVisitsRecluse = async () => {
//         let strHtml = `
//     <thead>
//     <tr>
//     <th class='w-2'>#</th>
//     <th>Recluso</th>
//     <th>Nome do Visitante</th>
//     <th>Identificação do Visitante</th>
//     <th>Data</th>
//     <th>Hora de Entrada</th>
//     <th>Hora de Saída</th>
//     <tbody>
//     </tr>
//     </thead>
//     `
//         const response = await fetch(server)
//         const visitsRecluse = await response.json()
//         let i = 1
//         for (const visitRecluse of visitsRecluse){
//             /* var ts = new Date(user.birthdate);*/
//             strHtml += `
//         <tr>
//
//         <td>${i}</td>
//         <td>${visitRecluse.id_recluse }</td>
//         <td>${visitRecluse.id_visit} </td>
//         <td>${visitRecluse.id_visitor}</td>
//         <td>${visitRecluse.visit_date }</td>
//         <td>${visitRecluse.checkin }</td>
//         <td>${visitRecluse.checkout}</td>
//         </tr>
//             `
//             i++
//         }
//         strHtml += "</tbody>"
//         dataTableVisitsRecluse.innerHTML = strHtml
//     }
//     renderVisitsRecluse()
// }




const serverVisitsRecluse = '/Area51/visitsperRecluse';
$(document).ready(function() {
    $('.dataTables_paginate').addClass("btn-group datatable-pagination");
    $('.dataTables_paginate > a').wrapInner('<span />');
    $('.dataTables_paginate > a:first-child').append('<i class="icon-chevron-left shaded"></i>');
    $('.dataTables_paginate > a:last-child').append('<i class="icon-chevron-right shaded"></i>');

    let urlParams = new URLSearchParams(window.location.search);
    let recluseId = urlParams.has('id') ? urlParams.get('id') : 1;

    $("#dataTableVisitsRecluse").dataTable({
        "ajax": {
            "url": serverVisitsRecluse + "?id=" + recluseId,
            "type": "GET",
            "dataSrc": ""
        }
    });
});