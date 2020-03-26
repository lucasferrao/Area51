const server = 'jdbc:mysql://remotemysql.com/YrTGCBVRUv?useSSL=false';
window.onload = function () {
    //calls function to update Alerts
    const dataTableHistoricoOcorrencias=  document.getElementById("dataTableHistoricoOcorrencias")
    const renderHistoricoOcorrencias = async () => {
        let strHtml = `
    <thead>
    <tr>
    <th class='w-2'>#</th>
    <th>Dia</th>
    <th>Hora</th>
    <th>Assunto</th>
    <th>Ficheiro</th>
    <tbody>
    </tr>
    </thead>
    `
        const response = await fetch(server)
        const historicoOcorrencias = await response.json()
        let i = 1
        for (const historicoOcorrencia of historicoOcorrencias){
            /* var ts = new Date(user.birthdate);*/
            strHtml += `
        <tr>

        <td>${i}</td>
        <td>${alert. id_alert} </td>
        <td>${alert.alert_type}</td>
        <td>${alert.id_device }</td>
        <td>${alert.alert_date}</td>
        <td>${alert.alert_hour}</td>
        <td>${alert.id_officer}</td>
        
        </tr>
            `
            i++
        }
        strHtml += "</tbody>"
        dataTableAlerts.innerHTML = strHtml
    }
    renderAlerts()
}