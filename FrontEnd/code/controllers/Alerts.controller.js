
const server = 'jdbc:mysql://remotemysql.com/YrTGCBVRUv?useSSL=false';
window.onload = function () {
    //calls function to update Alerts
    const dataTableAlerts=  document.getElementById("dataTableAlerts")
    const renderAlerts = async () => {
        let strHtml = `
    <thead>
    <tr>

    <th class='w-2'>#</th>
    <th>Tipo de Alerta</th>
    <th>Dispositivo do Alerta</th>
    <th>Dia do Alerta</th>
    <th>Hora do Alerta</th>
    <th>Ocorrência</th>
    <tbody>
    </tr>
    </thead>
    `
        const response = await fetch(server)
        const alerts = await response.json()
        let i = 1
        for (const alert of alerts){
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