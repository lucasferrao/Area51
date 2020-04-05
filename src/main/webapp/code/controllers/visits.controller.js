
const server = 'jdbc:mysql://remotemysql.com/YrTGCBVRUv?useSSL=false';
window.onload = function () {
    //calls function to update Visits
    const dataTableVisits =  document.getElementById("dataTableVisits")
    const renderVisits = async () => {
        let strHtml = `
    <thead>
    <tr>
    <th class='w-2'>#</th>
    <th>ID do Recluso</th>
    <th>Nome do Visitante</th>
    <th>Identificação do Visitante</th>
    <th>Hora de Entrada</th>
    <tbody>
    </tr>
    </thead>
    `
        const response = await fetch(server)
        const visits = await response.json()
        let i = 1
        for (const visit of visits){
            /* var ts = new Date(user.birthdate);*/
            strHtml += `
        <tr>
        <td>${i}</td>
        <td>${visit.id_recluse }</td>
        <td>${visit.visitor_name}</td>
        <td>${visit.id_visitor}</td>
        <td>${visit.nif }</td>
        </tr>
            `
            i++
        }
        strHtml += "</tbody>"
        dataTableVisits.innerHTML = strHtml
    }
    renderVisits()
}